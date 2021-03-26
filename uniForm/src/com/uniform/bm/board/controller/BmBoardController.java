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
	// �α�
	private Logger logger = Logger.getLogger(BmBoardController.class);
		
	// ����
	@Autowired
	private BmBoardService bmBoardService;
	
	@Autowired
	private NmNoticeService nmNoticeService;
	
	@Autowired
	private CommonInfoService commonInfoService;
	
	// �۸��(selectAll) ���� =================================
	@RequestMapping(value="/boardList")
	public ModelAndView boardList(@ModelAttribute BmBoardVO bbvo,HttpServletRequest request){
		logger.info("�۸�� ���� ��Ʈ�ѷ� ȣ�� ����! >>> �۸�� �������� �̵�");
		logger.info("���� ��ȸ�� ������ Ȯ�� >>> bm_category : " + bbvo.getBm_category());
		logger.info("���� �˻��� ������ Ȯ�� >>> startDate - endDate : "
										+ bbvo.getStartDate() + " - " + bbvo.getEndDate());
		logger.info("Ű���� �˻��� ������ Ȯ�� >>> searchFilter : " + bbvo.getSearchFilter()
										 + ", keyword : " + bbvo.getKeyword());
		
		// ��ü ���ڵ��
		PagingUtil.setPage(bbvo);
		int total = bmBoardService.paging(bbvo);
		
		logger.info("total : " + total);
		
		// �۹�ȣ �缳��
		int count = total - (Integer.parseInt(bbvo.getPage())-1)*10;
		logger.info("count : " + count);
		
		List<BmBoardVO> boardList = bmBoardService.boardList(bbvo);
		int nCntBoardList = boardList.size();
		logger.info("��ȸ�� ��ü �Խñ� ���� >>> nCntBoardList : " + nCntBoardList);
		
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
		// ���� ��ȸ �� �������� �� �������� ���� ������ ������
		mav.addObject("bbvo", bbvo);

		mav.setViewName("bm/boardList");
		
		return mav;
	}
	
	// �ۻ󼼺��� ���� ========================================
	@RequestMapping(value="/boardDetail")
	public ModelAndView boardDetail(@ModelAttribute BmBoardVO bbvo,HttpServletRequest request){
		logger.info("�󼼺��� ���� ��Ʈ�ѷ� ���� >>> ��ϿϷ� �� �󼼺��� �������� �̵�");
		logger.info("������ Ȯ�� >>> bm_no : " + bbvo.getBm_no() + ", i_no : " + bbvo.getI_no());
		// ���� ������ Ȯ��(bm_category, startDate, endDate, searchFilter, keyword, page)
		BmBoardVO.printVO(bbvo);
		
		// ��ȸ�� ī��Ʈ �ø���
		int nCntViewCount = bmBoardService.viewCount(bbvo);
		logger.info("��ȸ�� ī��Ʈ �ø��� 1�̸� ���� >>> nCntViewCount : " + nCntViewCount + ", bm_view : " + bbvo.getBm_view());
		
		String bm_likeyyn = "";
		// ��õ���� ��ȸ �� ���ε�
		List<BmBoardVO> boardLikeyYNList = bmBoardService.boardLikeyYN(bbvo);
		if(boardLikeyYNList.size()==1){
			
			bm_likeyyn = boardLikeyYNList.get(0).getBm_likeyyn();
			logger.info("1 >>> likeyyn : " + bm_likeyyn);
		}else if(boardLikeyYNList.size()==0){
			bm_likeyyn = "N";
			logger.info("0 >>> likeyyn : " + bm_likeyyn);
		}
		bbvo.setBm_likeyyn(bm_likeyyn);
		
		// �󼼺��� ������
		List<BmBoardVO> boardDetailList = bmBoardService.boardDetail(bbvo);
		int nCntDetailList = boardDetailList.size();
		logger.info("��ȸ �Խñ� ���� >>> nCntDetailList : " + nCntDetailList);
		
		logger.info("----------------------1111 >>> likeyyn : " + boardDetailList.get(0).getBm_likeyyn());
		
		HttpSession hs = request.getSession();
		String i_no = (String)hs.getAttribute("i_no");
		
		EmCommonVO ecvo = new EmCommonVO();
		ecvo.setI_no(i_no);
		ecvo = commonInfoService.miniInfo(ecvo);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("ecvo",ecvo);
		mav.addObject("boardDetailList", boardDetailList);
		// ���� ������ �۸�� �������� ������
		mav.addObject("bbvo", bbvo);
		mav.setViewName("bm/boardDetail");
		return mav;
	}
	
	// �۾����� ��� ===========================================
	@RequestMapping(value="/insertForm")
	public ModelAndView insertForm(@ModelAttribute BmBoardVO bbvo){
		logger.info("�۾����� ��� ��Ʈ�ѷ� ���� >>> �۾��� �������� �̵�");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("bm/insertForm");
		return mav;
	}
	
	// �۾���(insert)���� ============================
	@RequestMapping(value="/boardInsert")
	public String boardInsert(HttpServletRequest request, Model model){
		logger.info("�۾��� ���� ��Ʈ�ѷ� ���� >>> ��ϿϷ� �� �󼼺��� �������� �̵�");
	
		// ���� ���ε� ����
		int size = 10*1024*1024;
//		String path = "C:/SWork/java142_luna_pmUniform/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/uniformPM/bm/uploadStorage";
		String path = "C:/Users/�̻���/Desktop/java142Uniform/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/uniForm/bm/uploadStorage";
		String[] type = {"jpg","png","gif","psd","tiff","jpeg"};
		
		String bm_no = "";
		
		BmBoardVO bbvo = new BmBoardVO();
		
		try{
			MultipartRequest multi = new MultipartRequest(request,path,size,"UTF-8",new DefaultFileRenamePolicy());			
			
			// �۹�ȣ ä�� ���뿡 �ֱ�
			BmBoardVO boardNum = bmBoardService.boardNum();
			bm_no = ChaebunUtil.bmChaebun(boardNum.getBm_no());
			logger.info("bm_no : " + bm_no);
			
			String i_no = multi.getParameter("i_no");
			String bm_category = multi.getParameter("bm_category");
			logger.info("---------22--������ Ȯ�� bm_category: " + bm_category);
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
					// �̹��� Ȯ���� ���� ����
					if(name.substring(name.indexOf(".")+1).toLowerCase().equals(type[j])){
						bbvo.setBm_image("/bm/uploadStorage/" + name);
						break;
					}
					// �� �� Ȯ���� ���� ���� 
					if(j==type.length-1){
						bbvo.setBm_file(name);
					} // end of if					
				} // end of for				
			} // end of for
				
		}catch(Exception e){
			logger.info("������ >>> : " + e.getMessage());
		}
		
		// db �ٳ���� �� insert ���� ����
		int nCntInsert = bmBoardService.boardInsert(bbvo);
		
		if(nCntInsert == 1){
			logger.info("insert ���� >>> nCntInsert : " + nCntInsert);
		}else{
			logger.info("insert ���� >>> nCntInsert : " + nCntInsert);
		}
		
		String url = "/board/boardDetail.uni?bm_no=" + bm_no;
		return "redirect:" + url;
	}	

	// ÷������ �ٿ�ε� ���� ============================
	@RequestMapping(value="/boardFileDownload")
	public ModelAndView boardFileDownload(@ModelAttribute BmBoardVO bbvo){
		logger.info("÷������ �ٿ�ε� ��Ʈ�ѷ� ���� >>> �ٿ�ε� ������ �������� �̵�");
		
		
		String path = "C:/SWork/java142_luna_pmUniform/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/uniformPM/bm/uploadStorage";
		
		
		String bm_file = bbvo.getBm_file();
		logger.info("�ٿ�ε� �� ���ϸ� >>> bm_file : " + bm_file);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("bm_file", bm_file);
		mav.addObject("path", path);
		mav.setViewName("bm/fileDownload");
		return mav;
	}
	
	// �ۼ����� ��� ===========================================
	@RequestMapping(value="/updateForm")
	public ModelAndView updateForm(@ModelAttribute BmBoardVO bbvo,HttpServletRequest request){
		logger.info("�ۼ����� ��� ��Ʈ�ѷ� ���� >>> �ۼ��� �������� �̵�");

		// �������� �ѷ��� ����ȸ ������
		List<BmBoardVO> boardDetailList = bmBoardService.boardDetail(bbvo);
		int nCntDetailList = boardDetailList.size();
		logger.info("��ȸ �Խñ� ���� >>> nCntDetailList : " + nCntDetailList);
		
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
	
	// �ۼ���(update)���� ============================
	@RequestMapping(value="/boardUpdate")
	public String boardUpdate(@ModelAttribute BmBoardVO bbvo,
											  HttpServletRequest request,
											  Model model){
		logger.info("�ۼ��� ���� ��Ʈ�ѷ� ���� >>> ��ϿϷ� �� �󼼺��� �������� �̵�");
		String bm_no = "";

		// ���� ���ε� ����
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
					// �̹��� Ȯ���� ���� ����
					if(name.substring(name.indexOf(".")+1).toLowerCase().equals(type[j])){
						bbvo.setBm_image("/bm/uploadStorage/" + name);
						
						File f = new File(path + multi.getParameter("old_img"));
						boolean delete = f.delete();
						logger.info("���� �̹��� ���� ����? >>> delete : " + delete);
						break;
					}
					// �� �� Ȯ���� ���� ���� 
					if(j==type.length-1){
						bbvo.setBm_file(name);
						
						File f = new File(path + multi.getParameter("old_file"));
						boolean delete = f.delete();
						logger.info("���� ÷������ ���� ����? >>> delete : " + delete);
					} // end of if					
				} // end of for				
			} // end of for
				
		}catch(Exception e){
			logger.info("������ >>> : " + e.getMessage());
		}
		
		// db �ٳ���� �� insert ���� ����
		int nCntUpdate = bmBoardService.boardUpdate(bbvo);
		
		if(nCntUpdate == 1){
			logger.info("insert ���� >>> nCntUpdate : " + nCntUpdate);
		}else{
			logger.info("insert ���� >>> nCntUpdate : " + nCntUpdate);
		}
		
		String url = "/board/boardDetail.uni?bm_no=" + bm_no;
		return "redirect:" + url;
	}
	
	// �ۻ���(delete)���� ============================
	@RequestMapping(value="/boardDelete")
	public String boardDelete(@ModelAttribute BmBoardVO bbvo){
		logger.info("�ۻ��� ���� ��Ʈ�ѷ� ���� >>> �����Ϸ� �� �۸�� �������� �̵�");
		logger.info("������ Ȯ�� >>> bm_no : " + bbvo.getBm_no() + ", i_no : " + bbvo.getI_no());
		
		// ���� ���ε� ����
		String path = "C:/SWork/java142_luna_pmUniform/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/uniformPM/bm/uploadStorage";
		
		int nCntDelete = bmBoardService.boardDelete(bbvo);
		
		// �Խñ� ���� ���� �� ������ �ִ� �̹��� �� ÷������ ����
		if(nCntDelete == 1){
			logger.info("���� ���� nCntDelete : " + nCntDelete);
			// ���� �̹��� ����
			String bm_image = bbvo.getBm_image();
			File imgFile = new File(path + bm_image);
			boolean deleteImg = imgFile.delete();
			logger.info("���� �̹��� ���� ����? >>> deleteImg : " + deleteImg);
			
			// ���� ÷������ ����
			String bm_file = bbvo.getBm_file();		
			File file = new File(path + bm_file);
			boolean deleteFile = file.delete();
			logger.info("���� ÷������ ���� ����? >>> deleteFile : " + deleteFile);
		}else{
			logger.info("���� ���� nCntDelete : " + nCntDelete);
		}
				
		String url = "/board/boardList.uni";
		return "redirect:" + url;
	}
	
	// �Խñ���õ ON/OFF ���� ================================
	@ResponseBody
	@RequestMapping(value="/boardLikey", produces="application/json; charset=utf-8")
	public Map boardLikey(@ModelAttribute BmBoardVO bbvo){
		logger.info("�Խñ���õ ���� ��Ʈ�ѷ� ���� >>> ��õ�Ϸ� �� �󼼺��� �������� �̵�");
		logger.info("������ Ȯ�� >>> bm_no : " + bbvo.getBm_no() + ", i_no : " + bbvo.getI_no());
		
		String boardLikeyYN = ""; 
		String boardLikeyResult = "";
				
		// 1. ���ƿ� ���� ��ȸ ��
		List<BmBoardVO> boardLikeyYNList = bmBoardService.boardLikeyYN(bbvo);
		int nCntBoardLikeyYN = boardLikeyYNList.size();
		logger.info("nCntBoardLikeyYN : " + nCntBoardLikeyYN);
		
		// 2-1. 0���� ��� => INSERT �ϱ�
		if(nCntBoardLikeyYN==0){
			logger.info("0���� ��� insert �ϱ� if�� ����!");
			
			int nCntBoardLikeyInsert = bmBoardService.boardLikeyInsert(bbvo);
			
			if(nCntBoardLikeyInsert==1){
				logger.info("��õ ���� nCntBoardLikeyInsert : " + nCntBoardLikeyInsert);
				// ��õ�� ī��Ʈ �ø���
				int nCntBoardLikeyUp = bmBoardService.boardLikeyUp(bbvo);
				if(nCntBoardLikeyUp == 1){
					logger.info("��õ�� ī��Ʈ �ø��� ����");
					boardLikeyResult = "��õ�Ǿ����ϴ�.";
				}else{
					logger.info("��õ�� ī��Ʈ �ø��� ����");
				}
			}else{
				logger.info("��õ ���� nCntBoardLikeyInsert : " + nCntBoardLikeyInsert);
				boardLikeyResult = "��õ�� �����߽��ϴ�. ��� �� �ٽ� �õ����ּ���.";
			}
			
		}else if(nCntBoardLikeyYN==1){
			BmBoardVO boardLikeyYNVO = boardLikeyYNList.get(0);
			boardLikeyYN = boardLikeyYNVO.getBm_likeyyn();
			logger.info("���� ���ƿ� ���� boardLikeyYN : " + boardLikeyYN);

			// 2-2. ���ƿ� ���� ��ȸ ��� 1���̸鼭, ���� 'N'�� ��� => 'Y'�� �����ϱ�
			if(boardLikeyYN.equals("N")){
				logger.info("���ƿ� ��� ���� -> ���ƿ�� ����");	
				
				int nCntBoardLikeyON = bmBoardService.boardLikeyON(bbvo);
				
				if(nCntBoardLikeyON==1){
					logger.info("��õ ���� nCntBoardLikeyON : " + nCntBoardLikeyON);
					// ��õ�� ī��Ʈ �ø���
					int nCntBoardLikeyUp = bmBoardService.boardLikeyUp(bbvo);
					if(nCntBoardLikeyUp == 1){
						logger.info("��õ�� ī��Ʈ �ø��� ����");
						boardLikeyResult = "��õ�Ǿ����ϴ�.";
					}else{
						logger.info("��õ�� ī��Ʈ �ø��� ����");
					}
				}else{
					logger.info("��õ ���� nCntBoardLikeyON : " + nCntBoardLikeyON);
					boardLikeyResult = "��õ�� �����߽��ϴ�. ��� �� �ٽ� �õ����ּ���.";
				}
			} // end of N -> Y
			// 2-3. ���ƿ� ���� ��ȸ ��� 1���̸鼭, ���� 'Y'�� ��� => 'N'���� �����ϱ�
			if(boardLikeyYN.equals("Y")){
				logger.info("���ƿ� ���� -> ��ҷ� ����");
				
				int nCntBoardLikeyOFF = bmBoardService.boardLikeyOFF(bbvo);
				
				if(nCntBoardLikeyOFF==1){
					logger.info("��õ��� ���� nCntBoardLikeyOFF : " + nCntBoardLikeyOFF);
					// ��õ�� ī��Ʈ ������
					int nCntBoardLikeyDown = bmBoardService.boardLikeyDown(bbvo);
					if(nCntBoardLikeyDown == 1){
						logger.info("��õ�� ī��Ʈ ������ ����");
						boardLikeyResult = "��õ�� ��ҵǾ����ϴ�.";
					}else{
						logger.info("��õ�� ī��Ʈ ������ ����");
					}
					
				}else{
					logger.info("��õ��� ���� nCntBoardLikeyOFF : " + nCntBoardLikeyOFF);
					boardLikeyResult = "��õ��ҿ� �����߽��ϴ�. ��� �� �ٽ� �õ����ּ���.";
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
	
	// �Խñ۽�ũ�� ON/OFF ���� ================================
	@ResponseBody
	@RequestMapping(value="/boardScrap",produces="application/json; charset=utf-8")
	public Map boardScrap(@ModelAttribute BmBoardVO bbvo){
		logger.info("�Խñ۽�ũ�� ���� ��Ʈ�ѷ� ���� >>> ��ũ���Ϸ� �� �󼼺��� �������� �̵�");
		logger.info("������ Ȯ�� >>> bm_no : " + bbvo.getBm_no() + ", i_no : " + bbvo.getI_no());
		
		String bm_no = bbvo.getBm_no();
		String i_no = bbvo.getI_no();
		
		String boardScrapYN = ""; 
		String boardScrapResult = "";
		
		// �Խñ� ��ũ��ä��
		BmBoardVO scrapNumVO = bmBoardService.scrapNum();
		String sc_no = ChaebunUtil.bmScrapChaebun(scrapNumVO.getSc_no());
		bbvo.setSc_no(sc_no);
				
		// 1. ��ũ�� ���� ��ȸ ��
		List<BmBoardVO> boardScrapYNList = bmBoardService.boardScrapYN(bbvo);
		int nCntBoardScrapYN = boardScrapYNList.size();
		logger.info("nCntBoardScrapYN : " + nCntBoardScrapYN);
		
		// 2-1. 0���� ��� => INSERT �ϱ�
		if(nCntBoardScrapYN==0){
			logger.info("0���� ��� insert �ϱ� if�� ����!");
			
			int nCntBoardScrapInsert = bmBoardService.boardScrapInsert(bbvo);
			
			if(nCntBoardScrapInsert==1){
				logger.info("��ũ�� ���� nCntBoardScrapInsert : " + nCntBoardScrapInsert);
				// ��ũ�� ī��Ʈ �ø���
				int nCntBoardScrapUp = bmBoardService.boardScrapUp(bbvo);
				if(nCntBoardScrapUp == 1){
					logger.info("��ũ�� ī��Ʈ �ø��� ����");
					boardScrapResult = "��ũ�� �Ǿ����ϴ�.";
				}else{
					logger.info("��ũ�� ī��Ʈ �ø��� ����");
				}
			}else{
				logger.info("��ũ�� ���� nCntBoardScrapInsert : " + nCntBoardScrapInsert);
				boardScrapResult = "��ũ���� �����߽��ϴ�. ��� �� �ٽ� �õ����ּ���.";
			}
			
		}else if(nCntBoardScrapYN==1){
			BmBoardVO boardScrapYNVO = boardScrapYNList.get(0);
			boardScrapYN = boardScrapYNVO.getBm_scrapyn();
			logger.info("���� ��ũ�� ���� boardScrapYN : " + boardScrapYN);

			// 2-2. ��ũ�� ���� ��ȸ ��� 1���̸鼭, ���� 'N'�� ��� => 'Y'�� �����ϱ�
			if(boardScrapYN.equals("N")){
				logger.info("��ũ�� ��� ���� -> ��ũ�����·� ����");	
				
				int nCntBoardScrapON = bmBoardService.boardScrapON(bbvo);
				
				if(nCntBoardScrapON==1){
					logger.info("��ũ�� ���� nCntBoardScrapON : " + nCntBoardScrapON);
					// ��ũ�� ī��Ʈ �ø���
					int nCntBoardScrapUp = bmBoardService.boardScrapUp(bbvo);
					if(nCntBoardScrapUp == 1){
						logger.info("��ũ�� ī��Ʈ �ø��� ����");
						boardScrapResult = "��ũ�� �Ǿ����ϴ�.";
					}else{
						logger.info("��ũ�� ī��Ʈ �ø��� ����");
					}
				}else{
					logger.info("��ũ�� ���� nCntBoardScrapON : " + nCntBoardScrapON);
					boardScrapResult = "��ũ���� �����߽��ϴ�. ��� �� �ٽ� �õ����ּ���.";
				}
			} // end of N -> Y
			// 2-3. ��ũ�� ���� ��ȸ ��� 1���̸鼭, ���� 'Y'�� ��� => 'N'���� �����ϱ�
			if(boardScrapYN.equals("Y")){
				logger.info("��ũ�� ���� -> ��ҷ� ����");
				
				int nCntBoardScrapOFF = bmBoardService.boardScrapOFF(bbvo);
				
				if(nCntBoardScrapOFF==1){
					logger.info("��ũ����� ���� nCntBoardScrapOFF : " + nCntBoardScrapOFF);
					// ��ũ�� ī��Ʈ ������
					int nCntBoardScrapDown = bmBoardService.boardScrapDown(bbvo);
					if(nCntBoardScrapDown == 1){
						logger.info("��ũ�� ī��Ʈ ������ ����");
						boardScrapResult = "��ũ���� ��ҵǾ����ϴ�.";
					}else{
						logger.info("��ũ�� ī��Ʈ ������ ����");
					}
					
				}else{
					logger.info("��ũ����� ���� nCntBoardScrapOFF : " + nCntBoardScrapOFF);
					boardScrapResult = "��ũ����ҿ� �����߽��ϴ�. ��� �� �ٽ� �õ����ּ���.";
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
	
	// ��ũ�������� ���� =========================================
	@RequestMapping(value="/boardScrapList")
	public ModelAndView boardScrapList(@ModelAttribute BmBoardVO bbvo,HttpServletRequest request){
		logger.info("��ũ�������� ���� ��Ʈ�ѷ� ȣ�� ����! >>> �۸�� �������� �̵�");
		logger.info("���� ��ȸ�� ������ Ȯ�� >>> bm_category : " + bbvo.getBm_category());
		logger.info("���� �˻��� ������ Ȯ�� >>> startDate - endDate : "
										+ bbvo.getStartDate() + " - " + bbvo.getEndDate());
		logger.info("Ű���� �˻��� ������ Ȯ�� >>> searchFilter : " + bbvo.getSearchFilter()
										 + ", keyword : " + bbvo.getKeyword());
		
		// ��ü ���ڵ��
		PagingUtil.setPage(bbvo);
		int total = bmBoardService.pagingScrap(bbvo);
		
		logger.info("total : " + total);
		
		// �۹�ȣ �缳��
		int count = total - (Integer.parseInt(bbvo.getPage())-1)*10;
		logger.info("count : " + count);
		
		List<BmBoardVO> boardScrapList = bmBoardService.boardScrapList(bbvo);
		int nCntBoardScrapList = boardScrapList.size();
		logger.info("��ȸ�� ��ũ�������� �Խñ� ���� >>> nCntBoardScrapList : " + nCntBoardScrapList);
		
		
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
		// ���� ��ȸ �� �������� �� �������� ���� ������ ������
		mav.addObject("bbvo", bbvo);

		mav.setViewName("bm/boardScrapList");
		
		return mav;
	}
	
	// ��ũ�������� üũ�ڽ��� ��ũ�� ��� ���� =========================================
	@ResponseBody
	@RequestMapping(value="/scrapOff",produces="application/text; charset=utf-8")
	public String scrapOff(@ModelAttribute BmBoardVO bbvo){
		logger.info("scrapOff ȣ�� ����");
		
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
			result = "����";
		}else{
			result = "�� �� ���� ������ ���� �߽��ϴ�. ���� �ּ���";
		}
		
		return result;
	}// end of scrapOff() �Լ�
	
	// �������� ������ ���� =========================================
	@RequestMapping(value="/boardMyList")
	public ModelAndView boardMyList(@ModelAttribute BmBoardVO bbvo){
		logger.info("�������� ���� ��Ʈ�ѷ� ȣ�� ����! >>> �۸�� �������� �̵�");
		
		// ��ü ���ڵ��
		PagingUtil.setPage(bbvo);
		int total = bmBoardService.pagingMyList(bbvo);
		
		logger.info("total : " + total);
		
		// �۹�ȣ �缳��
		int count = total - (Integer.parseInt(bbvo.getPage())-1)*10;
		logger.info("count : " + count);
		
		List<BmBoardVO> boardMyList = bmBoardService.boardMyList(bbvo);
		int nCntBoardMyList = boardMyList.size();
		logger.info("��ȸ�� �������� �Խñ� ���� >>> nCntBoardMyList : " + nCntBoardMyList);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardMyList", boardMyList);
		mav.addObject("curPage",bbvo.getPage());
		mav.addObject("total", total + "");
		mav.addObject("count", count);
		// ���� ��ȸ �� �������� �� �������� ���� ������ ������
		mav.addObject("bbvo", bbvo);
		mav.setViewName("bm/boardMyList");
		
		return mav;
	}
	
} // end of ��Ʈ�ѷ�