package com.uniform.bm.board.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.uniform.bm.board.service.BmBoardService;
import com.uniform.bm.board.vo.BmBoardVO;
import com.uniform.common.info.service.CommonInfoService;
import com.uniform.common.utils.ChaebunUtil;
import com.uniform.common.utils.PagingUtil;
import com.uniform.em.common.vo.EmCommonVO;
import com.uniform.nm.notice.service.NmNoticeService;
import com.uniform.nm.notice.vo.NmNoticeVO;

@Controller
@RequestMapping("/board")
public class BmBoardController {
	// 로그
	private Logger logger = Logger.getLogger(BmBoardController.class);
		
	// 서비스
	@Autowired
	private BmBoardService bmBoardService;
	
	@Autowired
	private NmNoticeService nmNoticeService;
	
	@Autowired
	private CommonInfoService commonInfoService;
	
	// 글목록(selectAll) 구현 =================================
	@RequestMapping(value="/boardList")
	public ModelAndView boardList(@ModelAttribute BmBoardVO bbvo,HttpServletRequest request){
		logger.info("글목록 구현 컨트롤러 호출 성공! >>> 글목록 페이지로 이동");
		logger.info("조건 조회용 데이터 확인 >>> bm_category : " + bbvo.getBm_category());
		logger.info("조건 검색용 데이터 확인 >>> startDate - endDate : "
										+ bbvo.getStartDate() + " - " + bbvo.getEndDate());
		logger.info("키워드 검색용 데이터 확인 >>> searchFilter : " + bbvo.getSearchFilter()
										 + ", keyword : " + bbvo.getKeyword());
		
		// 전체 레코드수
		PagingUtil.setPage(bbvo);
		int total = bmBoardService.paging(bbvo);
		
		logger.info("total : " + total);
		
		// 글번호 재설정
		int count = total - (Integer.parseInt(bbvo.getPage())-1)*10;
		logger.info("count : " + count);
		
		List<BmBoardVO> boardList = bmBoardService.boardList(bbvo);
		int nCntBoardList = boardList.size();
		logger.info("조회된 전체 게시글 갯수 >>> nCntBoardList : " + nCntBoardList);
		
		List<NmNoticeVO> nList = nmNoticeService.miniNotice();
		
		HttpSession hs = request.getSession();
		String i_no = (String)hs.getAttribute("i_no");
		
		EmCommonVO ecvo = new EmCommonVO();
		ecvo.setI_no(i_no);
		ecvo = commonInfoService.miniInfo(ecvo);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("ecvo",ecvo);
		mav.addObject("nList",nList);
		mav.addObject("boardList", boardList);
		mav.addObject("curPage",bbvo.getPage());
		mav.addObject("total", total + "");
		mav.addObject("count", count);
		// 조건 조회 후 리프레쉬 된 페이지에 설정 유지용 데이터
		mav.addObject("bbvo", bbvo);

		mav.setViewName("bm/boardList");
		
		return mav;
	}
	
	// 글상세보기 구현 ========================================
	@RequestMapping(value="/boardDetail")
	public ModelAndView boardDetail(@ModelAttribute BmBoardVO bbvo,HttpServletRequest request){
		logger.info("상세보기 구현 컨트롤러 시작 >>> 등록완료 후 상세보기 페이지로 이동");
		logger.info("데이터 확인 >>> bm_no : " + bbvo.getBm_no() + ", i_no : " + bbvo.getI_no());
		// 조건 데이터 확인(bm_category, startDate, endDate, searchFilter, keyword, page)
		BmBoardVO.printVO(bbvo);
		
		// 조회수 카운트 올리기
		int nCntViewCount = bmBoardService.viewCount(bbvo);
		logger.info("조회수 카운트 올리기 1이면 성공 >>> nCntViewCount : " + nCntViewCount + ", bm_view : " + bbvo.getBm_view());
		
		String bm_likeyyn = "";
		// 추천여부 조회 후 바인딩
		List<BmBoardVO> boardLikeyYNList = bmBoardService.boardLikeyYN(bbvo);
		if(boardLikeyYNList.size()==1){
			
			bm_likeyyn = boardLikeyYNList.get(0).getBm_likeyyn();
			logger.info("1 >>> likeyyn : " + bm_likeyyn);
		}else if(boardLikeyYNList.size()==0){
			bm_likeyyn = "N";
			logger.info("0 >>> likeyyn : " + bm_likeyyn);
		}
		bbvo.setBm_likeyyn(bm_likeyyn);
		
		// 상세보기 데이터
		List<BmBoardVO> boardDetailList = bmBoardService.boardDetail(bbvo);
		int nCntDetailList = boardDetailList.size();
		logger.info("조회 게시글 갯수 >>> nCntDetailList : " + nCntDetailList);
		
		logger.info("----------------------1111 >>> likeyyn : " + boardDetailList.get(0).getBm_likeyyn());
		
		HttpSession hs = request.getSession();
		String i_no = (String)hs.getAttribute("i_no");
		
		EmCommonVO ecvo = new EmCommonVO();
		ecvo.setI_no(i_no);
		ecvo = commonInfoService.miniInfo(ecvo);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("ecvo",ecvo);
		mav.addObject("boardDetailList", boardDetailList);
		// 조건 데이터 글목록 페이지로 보내기
		mav.addObject("bbvo", bbvo);
		mav.setViewName("bm/boardDetail");
		return mav;
	}
	
	// 글쓰기폼 출력 ===========================================
	@RequestMapping(value="/insertForm")
	public ModelAndView insertForm(@ModelAttribute BmBoardVO bbvo){
		logger.info("글쓰기폼 출력 컨트롤러 시작 >>> 글쓰기 페이지로 이동");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("bm/insertForm");
		return mav;
	}
	
	// 글쓰기(insert)구현 ============================
	@RequestMapping(value="/boardInsert")
	public String boardInsert(HttpServletRequest request, Model model){
		logger.info("글쓰기 구현 컨트롤러 시작 >>> 등록완료 후 상세보기 페이지로 이동");
	
		// 파일 업로드 변수
		int size = 10*1024*1024;
//		String path = "C:/SWork/java142_luna_pmUniform/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/uniformPM/bm/uploadStorage";
		String path = "C:/Users/이상훈/Desktop/java142Uniform/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/uniForm/bm/uploadStorage";
		String[] type = {"jpg","png","gif","psd","tiff","jpeg"};
		
		String bm_no = "";
		
		BmBoardVO bbvo = new BmBoardVO();
		
		try{
			MultipartRequest multi = new MultipartRequest(request,path,size,"UTF-8",new DefaultFileRenamePolicy());			
			
			// 글번호 채번 깡통에 넣기
			BmBoardVO boardNum = bmBoardService.boardNum();
			bm_no = ChaebunUtil.bmChaebun(boardNum.getBm_no());
			logger.info("bm_no : " + bm_no);
			
			String i_no = multi.getParameter("i_no");
			String bm_category = multi.getParameter("bm_category");
			logger.info("---------22--데이터 확인 bm_category: " + bm_category);
			String bm_subject = multi.getParameter("bm_subject");
			String bm_context = multi.getParameter("bm_context");

			bbvo.setBm_no(bm_no);
			bbvo.setI_no(i_no);
			bbvo.setBm_category(bm_category);
			bbvo.setBm_subject(bm_subject);
			bbvo.setBm_context(bm_context);
			
			Enumeration<String> et = multi.getFileNames();
			
			List<String> list = new ArrayList<String>();
			
			while(et.hasMoreElements()){
				String file = et.nextElement();
				list.add(multi.getFilesystemName(file));
			}
			
			for(int i=0;i<list.size();i++){
				String name = list.get(i);				
				for(int j=0;j<type.length;j++){
					// 이미지 확장자 파일 셋팅
					if(name.substring(name.indexOf(".")+1).toLowerCase().equals(type[j])){
						bbvo.setBm_image("/bm/uploadStorage/" + name);
						break;
					}
					// 그 외 확장자 파일 셋팅 
					if(j==type.length-1){
						bbvo.setBm_file(name);
					} // end of if					
				} // end of for				
			} // end of for
				
		}catch(Exception e){
			logger.info("에러가 >>> : " + e.getMessage());
		}
		
		// db 다녀오기 및 insert 성공 갯수
		int nCntInsert = bmBoardService.boardInsert(bbvo);
		
		if(nCntInsert == 1){
			logger.info("insert 성공 >>> nCntInsert : " + nCntInsert);
		}else{
			logger.info("insert 실패 >>> nCntInsert : " + nCntInsert);
		}
		
		String url = "/board/boardDetail.uni?bm_no=" + bm_no;
		return "redirect:" + url;
	}	

	// 첨부파일 다운로드 구현 ============================
	@RequestMapping(value="/boardFileDownload")
	public ModelAndView boardFileDownload(@ModelAttribute BmBoardVO bbvo){
		logger.info("첨부파일 다운로드 컨트롤러 시작 >>> 다운로드 진행중 페이지로 이동");
		
		
		String path = "C:/SWork/java142_luna_pmUniform/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/uniformPM/bm/uploadStorage";
		
		
		String bm_file = bbvo.getBm_file();
		logger.info("다운로드 할 파일명 >>> bm_file : " + bm_file);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("bm_file", bm_file);
		mav.addObject("path", path);
		mav.setViewName("bm/fileDownload");
		return mav;
	}
	
	// 글수정폼 출력 ===========================================
	@RequestMapping(value="/updateForm")
	public ModelAndView updateForm(@ModelAttribute BmBoardVO bbvo,HttpServletRequest request){
		logger.info("글수정폼 출력 컨트롤러 시작 >>> 글수정 페이지로 이동");

		// 수정폼에 뿌려줄 상세조회 데이터
		List<BmBoardVO> boardDetailList = bmBoardService.boardDetail(bbvo);
		int nCntDetailList = boardDetailList.size();
		logger.info("조회 게시글 갯수 >>> nCntDetailList : " + nCntDetailList);
		
		HttpSession hs = request.getSession();
		String i_no = (String)hs.getAttribute("i_no");
		
		EmCommonVO ecvo = new EmCommonVO();
		ecvo.setI_no(i_no);
		ecvo = commonInfoService.miniInfo(ecvo);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("ecvo",ecvo);
		mav.setViewName("bm/updateForm");
		mav.addObject("boardDetailList", boardDetailList);
		return mav;
	}
	
	// 글수정(update)구현 ============================
	@RequestMapping(value="/boardUpdate")
	public String boardUpdate(@ModelAttribute BmBoardVO bbvo,
											  HttpServletRequest request,
											  Model model){
		logger.info("글수정 구현 컨트롤러 시작 >>> 등록완료 후 상세보기 페이지로 이동");
		String bm_no = "";

		// 파일 업로드 변수
		int size = 10*1024*1024;
		String path = "C:/SWork/java142_luna_pmUniform/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/uniformPM/bm/uploadStorage";
		String[] type = {"jpg","png","gif","psd","tiff","jpeg"};
		
		try{
			MultipartRequest multi = new MultipartRequest(request,path,size,"UTF-8",new DefaultFileRenamePolicy());			
			
			bm_no = multi.getParameter("bm_no");			
			String i_no = multi.getParameter("i_no");
			String bm_category = multi.getParameter("bm_category");
			String bm_subject = multi.getParameter("bm_subject");
			String bm_context = multi.getParameter("bm_context");

			bbvo.setBm_no(bm_no);
			bbvo.setI_no(i_no);
			bbvo.setBm_category(bm_category);
			bbvo.setBm_subject(bm_subject);
			bbvo.setBm_context(bm_context);
			
			Enumeration<String> et = multi.getFileNames();
			
			List<String> list = new ArrayList<String>();
			
			while(et.hasMoreElements()){
				String file = et.nextElement();
				list.add(multi.getFilesystemName(file));
			}
			
			for(int i=0;i<list.size();i++){
				String name = list.get(i);				
				for(int j=0;j<type.length;j++){
					// 이미지 확장자 파일 셋팅
					if(name.substring(name.indexOf(".")+1).toLowerCase().equals(type[j])){
						bbvo.setBm_image("/bm/uploadStorage/" + name);
						
						File f = new File(path + multi.getParameter("old_img"));
						boolean delete = f.delete();
						logger.info("기존 이미지 삭제 성공? >>> delete : " + delete);
						break;
					}
					// 그 외 확장자 파일 셋팅 
					if(j==type.length-1){
						bbvo.setBm_file(name);
						
						File f = new File(path + multi.getParameter("old_file"));
						boolean delete = f.delete();
						logger.info("기존 첨부파일 삭제 성공? >>> delete : " + delete);
					} // end of if					
				} // end of for				
			} // end of for
				
		}catch(Exception e){
			logger.info("에러가 >>> : " + e.getMessage());
		}
		
		// db 다녀오기 및 insert 성공 갯수
		int nCntUpdate = bmBoardService.boardUpdate(bbvo);
		
		if(nCntUpdate == 1){
			logger.info("insert 성공 >>> nCntUpdate : " + nCntUpdate);
		}else{
			logger.info("insert 실패 >>> nCntUpdate : " + nCntUpdate);
		}
		
		String url = "/board/boardDetail.uni?bm_no=" + bm_no;
		return "redirect:" + url;
	}
	
	// 글삭제(delete)구현 ============================
	@RequestMapping(value="/boardDelete")
	public String boardDelete(@ModelAttribute BmBoardVO bbvo){
		logger.info("글삭제 구현 컨트롤러 시작 >>> 삭제완료 후 글목록 페이지로 이동");
		logger.info("데이터 확인 >>> bm_no : " + bbvo.getBm_no() + ", i_no : " + bbvo.getI_no());
		
		// 파일 업로드 변수
		String path = "C:/SWork/java142_luna_pmUniform/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/uniformPM/bm/uploadStorage";
		
		int nCntDelete = bmBoardService.boardDelete(bbvo);
		
		// 게시글 삭제 성공 시 서버에 있는 이미지 및 첨부파일 삭제
		if(nCntDelete == 1){
			logger.info("삭제 성공 nCntDelete : " + nCntDelete);
			// 기존 이미지 삭제
			String bm_image = bbvo.getBm_image();
			File imgFile = new File(path + bm_image);
			boolean deleteImg = imgFile.delete();
			logger.info("기존 이미지 삭제 성공? >>> deleteImg : " + deleteImg);
			
			// 기존 첨부파일 삭제
			String bm_file = bbvo.getBm_file();		
			File file = new File(path + bm_file);
			boolean deleteFile = file.delete();
			logger.info("기존 첨부파일 삭제 성공? >>> deleteFile : " + deleteFile);
		}else{
			logger.info("삭제 실패 nCntDelete : " + nCntDelete);
		}
				
		String url = "/board/boardList.uni";
		return "redirect:" + url;
	}
	
	// 게시글추천 ON/OFF 구현 ================================
	@ResponseBody
	@RequestMapping(value="/boardLikey", produces="application/json; charset=utf-8")
	public Map boardLikey(@ModelAttribute BmBoardVO bbvo){
		logger.info("게시글추천 구현 컨트롤러 시작 >>> 추천완료 후 상세보기 페이지로 이동");
		logger.info("데이터 확인 >>> bm_no : " + bbvo.getBm_no() + ", i_no : " + bbvo.getI_no());
		
		String boardLikeyYN = ""; 
		String boardLikeyResult = "";
				
		// 1. 좋아요 여부 조회 후
		List<BmBoardVO> boardLikeyYNList = bmBoardService.boardLikeyYN(bbvo);
		int nCntBoardLikeyYN = boardLikeyYNList.size();
		logger.info("nCntBoardLikeyYN : " + nCntBoardLikeyYN);
		
		// 2-1. 0건일 경우 => INSERT 하기
		if(nCntBoardLikeyYN==0){
			logger.info("0건일 경우 insert 하기 if문 진입!");
			
			int nCntBoardLikeyInsert = bmBoardService.boardLikeyInsert(bbvo);
			
			if(nCntBoardLikeyInsert==1){
				logger.info("추천 성공 nCntBoardLikeyInsert : " + nCntBoardLikeyInsert);
				// 추천수 카운트 올리기
				int nCntBoardLikeyUp = bmBoardService.boardLikeyUp(bbvo);
				if(nCntBoardLikeyUp == 1){
					logger.info("추천수 카운트 올리기 성공");
					boardLikeyResult = "추천되었습니다.";
				}else{
					logger.info("추천수 카운트 올리기 실패");
				}
			}else{
				logger.info("추천 실패 nCntBoardLikeyInsert : " + nCntBoardLikeyInsert);
				boardLikeyResult = "추천에 실패했습니다. 잠시 후 다시 시도해주세요.";
			}
			
		}else if(nCntBoardLikeyYN==1){
			BmBoardVO boardLikeyYNVO = boardLikeyYNList.get(0);
			boardLikeyYN = boardLikeyYNVO.getBm_likeyyn();
			logger.info("현재 좋아요 여부 boardLikeyYN : " + boardLikeyYN);

			// 2-2. 좋아요 여부 조회 결과 1건이면서, 값이 'N'일 경우 => 'Y'로 변경하기
			if(boardLikeyYN.equals("N")){
				logger.info("좋아요 취소 상태 -> 좋아요로 변경");	
				
				int nCntBoardLikeyON = bmBoardService.boardLikeyON(bbvo);
				
				if(nCntBoardLikeyON==1){
					logger.info("추천 성공 nCntBoardLikeyON : " + nCntBoardLikeyON);
					// 추천수 카운트 올리기
					int nCntBoardLikeyUp = bmBoardService.boardLikeyUp(bbvo);
					if(nCntBoardLikeyUp == 1){
						logger.info("추천수 카운트 올리기 성공");
						boardLikeyResult = "추천되었습니다.";
					}else{
						logger.info("추천수 카운트 올리기 실패");
					}
				}else{
					logger.info("추천 실패 nCntBoardLikeyON : " + nCntBoardLikeyON);
					boardLikeyResult = "추천에 실패했습니다. 잠시 후 다시 시도해주세요.";
				}
			} // end of N -> Y
			// 2-3. 좋아요 여부 조회 결과 1건이면서, 값이 'Y'일 경우 => 'N'으로 변경하기
			if(boardLikeyYN.equals("Y")){
				logger.info("좋아요 상태 -> 취소로 변경");
				
				int nCntBoardLikeyOFF = bmBoardService.boardLikeyOFF(bbvo);
				
				if(nCntBoardLikeyOFF==1){
					logger.info("추천취소 성공 nCntBoardLikeyOFF : " + nCntBoardLikeyOFF);
					// 추천수 카운트 내리기
					int nCntBoardLikeyDown = bmBoardService.boardLikeyDown(bbvo);
					if(nCntBoardLikeyDown == 1){
						logger.info("추천수 카운트 내리기 성공");
						boardLikeyResult = "추천이 취소되었습니다.";
					}else{
						logger.info("추천수 카운트 내리기 실패");
					}
					
				}else{
					logger.info("추천취소 실패 nCntBoardLikeyOFF : " + nCntBoardLikeyOFF);
					boardLikeyResult = "추천취소에 실패했습니다. 잠시 후 다시 시도해주세요.";
				}
			}
		}
		
		List<BmBoardVO> boardDetailList = bmBoardService.boardDetail(bbvo);
		BmBoardVO getVO = boardDetailList.get(0);
		
		Map<String,String> m = new HashMap<String,String>();
		
		m.put("result", boardLikeyResult);
		m.put("cnt", getVO.getBm_likey());
		
		return m;
	}
	
	// 게시글스크랩 ON/OFF 구현 ================================
	@ResponseBody
	@RequestMapping(value="/boardScrap",produces="application/json; charset=utf-8")
	public Map boardScrap(@ModelAttribute BmBoardVO bbvo){
		logger.info("게시글스크랩 구현 컨트롤러 시작 >>> 스크랩완료 후 상세보기 페이지로 이동");
		logger.info("데이터 확인 >>> bm_no : " + bbvo.getBm_no() + ", i_no : " + bbvo.getI_no());
		
		String bm_no = bbvo.getBm_no();
		String i_no = bbvo.getI_no();
		
		String boardScrapYN = ""; 
		String boardScrapResult = "";
		
		// 게시글 스크랩채번
		BmBoardVO scrapNumVO = bmBoardService.scrapNum();
		String sc_no = ChaebunUtil.bmScrapChaebun(scrapNumVO.getSc_no());
		bbvo.setSc_no(sc_no);
				
		// 1. 스크랩 여부 조회 후
		List<BmBoardVO> boardScrapYNList = bmBoardService.boardScrapYN(bbvo);
		int nCntBoardScrapYN = boardScrapYNList.size();
		logger.info("nCntBoardScrapYN : " + nCntBoardScrapYN);
		
		// 2-1. 0건일 경우 => INSERT 하기
		if(nCntBoardScrapYN==0){
			logger.info("0건일 경우 insert 하기 if문 진입!");
			
			int nCntBoardScrapInsert = bmBoardService.boardScrapInsert(bbvo);
			
			if(nCntBoardScrapInsert==1){
				logger.info("스크랩 성공 nCntBoardScrapInsert : " + nCntBoardScrapInsert);
				// 스크랩 카운트 올리기
				int nCntBoardScrapUp = bmBoardService.boardScrapUp(bbvo);
				if(nCntBoardScrapUp == 1){
					logger.info("스크랩 카운트 올리기 성공");
					boardScrapResult = "스크랩 되었습니다.";
				}else{
					logger.info("스크랩 카운트 올리기 실패");
				}
			}else{
				logger.info("스크랩 실패 nCntBoardScrapInsert : " + nCntBoardScrapInsert);
				boardScrapResult = "스크랩에 실패했습니다. 잠시 후 다시 시도해주세요.";
			}
			
		}else if(nCntBoardScrapYN==1){
			BmBoardVO boardScrapYNVO = boardScrapYNList.get(0);
			boardScrapYN = boardScrapYNVO.getBm_scrapyn();
			logger.info("현재 스크랩 여부 boardScrapYN : " + boardScrapYN);

			// 2-2. 스크랩 여부 조회 결과 1건이면서, 값이 'N'일 경우 => 'Y'로 변경하기
			if(boardScrapYN.equals("N")){
				logger.info("스크랩 취소 상태 -> 스크랩상태로 변경");	
				
				int nCntBoardScrapON = bmBoardService.boardScrapON(bbvo);
				
				if(nCntBoardScrapON==1){
					logger.info("스크랩 성공 nCntBoardScrapON : " + nCntBoardScrapON);
					// 스크랩 카운트 올리기
					int nCntBoardScrapUp = bmBoardService.boardScrapUp(bbvo);
					if(nCntBoardScrapUp == 1){
						logger.info("스크랩 카운트 올리기 성공");
						boardScrapResult = "스크랩 되었습니다.";
					}else{
						logger.info("스크랩 카운트 올리기 실패");
					}
				}else{
					logger.info("스크랩 실패 nCntBoardScrapON : " + nCntBoardScrapON);
					boardScrapResult = "스크랩에 실패했습니다. 잠시 후 다시 시도해주세요.";
				}
			} // end of N -> Y
			// 2-3. 스크랩 여부 조회 결과 1건이면서, 값이 'Y'일 경우 => 'N'으로 변경하기
			if(boardScrapYN.equals("Y")){
				logger.info("스크랩 상태 -> 취소로 변경");
				
				int nCntBoardScrapOFF = bmBoardService.boardScrapOFF(bbvo);
				
				if(nCntBoardScrapOFF==1){
					logger.info("스크랩취소 성공 nCntBoardScrapOFF : " + nCntBoardScrapOFF);
					// 스크랩 카운트 내리기
					int nCntBoardScrapDown = bmBoardService.boardScrapDown(bbvo);
					if(nCntBoardScrapDown == 1){
						logger.info("스크랩 카운트 내리기 성공");
						boardScrapResult = "스크랩이 취소되었습니다.";
					}else{
						logger.info("스크랩 카운트 내리기 실패");
					}
					
				}else{
					logger.info("스크랩취소 실패 nCntBoardScrapOFF : " + nCntBoardScrapOFF);
					boardScrapResult = "스크랩취소에 실패했습니다. 잠시 후 다시 시도해주세요.";
				}
			} // end of Y -> N
		} // end of scrapYN
		
		List<BmBoardVO> boardDetailList = bmBoardService.boardDetail(bbvo);
		BmBoardVO getVO = boardDetailList.get(0);
		
		Map<String,String> m = new HashMap<String,String>();
		m.put("result", boardScrapResult);
		m.put("cnt", getVO.getBm_scrap());
//		mav.setViewName("bm/boardDetail");
//		String url = "/board/boardDetail.uni?bm_no=" + bm_no + "&i_no=" + i_no;
		return m;
	}
	
	// 스크랩보관함 구현 =========================================
	@RequestMapping(value="/boardScrapList")
	public ModelAndView boardScrapList(@ModelAttribute BmBoardVO bbvo,HttpServletRequest request){
		logger.info("스크랩보관함 구현 컨트롤러 호출 성공! >>> 글목록 페이지로 이동");
		logger.info("조건 조회용 데이터 확인 >>> bm_category : " + bbvo.getBm_category());
		logger.info("조건 검색용 데이터 확인 >>> startDate - endDate : "
										+ bbvo.getStartDate() + " - " + bbvo.getEndDate());
		logger.info("키워드 검색용 데이터 확인 >>> searchFilter : " + bbvo.getSearchFilter()
										 + ", keyword : " + bbvo.getKeyword());
		
		// 전체 레코드수
		PagingUtil.setPage(bbvo);
		int total = bmBoardService.pagingScrap(bbvo);
		
		logger.info("total : " + total);
		
		// 글번호 재설정
		int count = total - (Integer.parseInt(bbvo.getPage())-1)*10;
		logger.info("count : " + count);
		
		List<BmBoardVO> boardScrapList = bmBoardService.boardScrapList(bbvo);
		int nCntBoardScrapList = boardScrapList.size();
		logger.info("조회된 스크랩보관함 게시글 갯수 >>> nCntBoardScrapList : " + nCntBoardScrapList);
		
		
		HttpSession hs = request.getSession();
		String i_no = (String)hs.getAttribute("i_no");
		
		EmCommonVO ecvo = new EmCommonVO();
		ecvo.setI_no(i_no);
		ecvo = commonInfoService.miniInfo(ecvo);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("ecvo",ecvo);
		mav.addObject("boardScrapList", boardScrapList);
		mav.addObject("curPage",bbvo.getPage());
		mav.addObject("total", total + "");
		mav.addObject("count", count);
		// 조건 조회 후 리프레쉬 된 페이지에 설정 유지용 데이터
		mav.addObject("bbvo", bbvo);

		mav.setViewName("bm/boardScrapList");
		
		return mav;
	}
	
	// 스크랩보관함 체크박스로 스크랩 취소 구현 =========================================
	@ResponseBody
	@RequestMapping(value="/scrapOff",produces="application/text; charset=utf-8")
	public String scrapOff(@ModelAttribute BmBoardVO bbvo){
		logger.info("scrapOff 호출 성공");
		
		String result = "";
		String[] arrayNo = bbvo.getBm_no().split(",");
		int addCnt = 0;
		
		for(int i=0;i<arrayNo.length;i++){
			bbvo.setBm_no(arrayNo[i]);
			int cnt = bmBoardService.scrapOff(bbvo);
			
			if(cnt!=2){
				break;
			}
			addCnt = addCnt + cnt;
		}
		
		if(addCnt==arrayNo.length*2){
			result = "성공";
		}else{
			result = "알 수 없는 이유로 실패 했습니다. 문의 주세요";
		}
		
		return result;
	}// end of scrapOff() 함수
	
	// 내가쓴글 보관함 구현 =========================================
	@RequestMapping(value="/boardMyList")
	public ModelAndView boardMyList(@ModelAttribute BmBoardVO bbvo){
		logger.info("내가쓴글 구현 컨트롤러 호출 성공! >>> 글목록 페이지로 이동");
		
		// 전체 레코드수
		PagingUtil.setPage(bbvo);
		int total = bmBoardService.pagingMyList(bbvo);
		
		logger.info("total : " + total);
		
		// 글번호 재설정
		int count = total - (Integer.parseInt(bbvo.getPage())-1)*10;
		logger.info("count : " + count);
		
		List<BmBoardVO> boardMyList = bmBoardService.boardMyList(bbvo);
		int nCntBoardMyList = boardMyList.size();
		logger.info("조회된 내가쓴글 게시글 갯수 >>> nCntBoardMyList : " + nCntBoardMyList);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardMyList", boardMyList);
		mav.addObject("curPage",bbvo.getPage());
		mav.addObject("total", total + "");
		mav.addObject("count", count);
		// 조건 조회 후 리프레쉬 된 페이지에 설정 유지용 데이터
		mav.addObject("bbvo", bbvo);
		mav.setViewName("bm/boardMyList");
		
		return mav;
	}
	
} // end of 컨트롤러
