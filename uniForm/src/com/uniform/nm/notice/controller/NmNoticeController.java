package com.uniform.nm.notice.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.uniform.common.utils.ChaebunUtil;
import com.uniform.common.utils.PagingUtil;
import com.uniform.nm.notice.service.NmNoticeService;
import com.uniform.nm.notice.vo.NmNoticeVO;

@Controller
@RequestMapping("/nm")
public class NmNoticeController {
	
	private Logger logger = Logger.getLogger(NmNoticeController.class);
	
	@Autowired
	private NmNoticeService nmNoticeService;
	
	 @Autowired
	 private PlatformTransactionManager platformTransactionManager;
	
	@RequestMapping("/goNoticeList")
	public ModelAndView goNoticeList(@ModelAttribute NmNoticeVO nnvo){
		logger.info("goNoticeList 호출 성공");
		
		PagingUtil.setPageN(nnvo);
		
		List<NmNoticeVO> list = nmNoticeService.noticeList(nnvo);
		System.out.println("사이즈 확인 >> : " + list.size());
		
		int total = nmNoticeService.listCnt(nnvo);
		
		int count = total - (Integer.parseInt(nnvo.getPage())-1)*10;
		
		int page = Integer.parseInt(nnvo.getPage());
		
		NmNoticeVO searchVO = new NmNoticeVO();
		searchVO.setStartDate(nnvo.getStartDate());
		searchVO.setEndDate(nnvo.getEndDate());
		searchVO.setSearchFilter(nnvo.getSearchFilter());
		searchVO.setKeyword(nnvo.getKeyword());
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("noticeList",list);
		mav.addObject("total",total);
		mav.addObject("count",count);
		mav.addObject("page",page);
		mav.addObject("searchVO",searchVO);
		mav.setViewName("nm/noticeList");
		
		return mav;
	}// end of goNoticeList() 함수
	
	@RequestMapping("/goInsertNotice")
	public ModelAndView goInsertNotice(){
		logger.info("goInsertNotice 호출 성공");
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("nm/insertNotice");
		
		return mav;
	}// end of goInsertNotice() 함수
	
	@RequestMapping("/insertNotice")
	public String insertNotice(HttpServletRequest request){
		logger.info("insertNotice 호출 성공");
		
		// 파일 업로드 변수
		int size = 10*1024*1024;
//		String path = "C:/Users/이상훈/Desktop/20200315_java142_luna_pmUniform/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/uniformPM/nm/uploadStorage";
//		String path = "C:/Users/bitcamp/Desktop/20200315_java142_luna_pmUniform/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/uniformPM";
		String path = "C:/SWork/java142_luna_pmUniform/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/uniformPM/bm/uploadStorage";
		String[] type = {"jpg","png","gif","psd","tiff","jpeg"};
		
		String nm_no = "";
		String url = "";
		
		nm_no = nmNoticeService.nmChaebun().getNm_no();
		
		nm_no = ChaebunUtil.nmNoticeChaebun(nm_no);
		
		NmNoticeVO nnvo = new NmNoticeVO();
		
		nnvo.setNm_no(nm_no);
		
		try{
			MultipartRequest multi = new MultipartRequest(request,path,size,"UTF-8",new DefaultFileRenamePolicy());
		
			String i_no = multi.getParameter("i_no");
			String nm_category = multi.getParameter("nm_category");
			String nm_subject = multi.getParameter("nm_subject");
			String nm_context = multi.getParameter("nm_context");
			
			nnvo.setI_no(i_no);
			nnvo.setNm_category(nm_category);
			nnvo.setNm_subject(nm_subject);
			nnvo.setNm_context(nm_context);
			
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
						nnvo.setNm_image("/nm/uploadStorage/" + name);
						break;
					}
					// 그 외 확장자 파일 셋팅 
					if(j==type.length-1){
						nnvo.setNm_file(name);
					} // end of if					
				} // end of for				
			} // end of for
		}catch(Exception e){
			System.out.println("에러났다 >>> : " + e.getMessage());
			nnvo.setNm_image("");
			nnvo.setNm_file("");
		}
			int cnt = nmNoticeService.insertNotice(nnvo);
			
			if(cnt==1){
				logger.info("insert 성공");
				url = "/nm/goNoticeDetail.uni?nm_no=" + nm_no;
			}else{
				logger.info("insert 실패");
				url = "/nm/goNoticeList.uni";
			}	
		
		return "redirect:" + url;
	}// end of insertNotice() 함수
	
	@RequestMapping("/goNoticeDetail")
	public ModelAndView goNoticeDetail(@ModelAttribute NmNoticeVO nnvo){
		logger.info("goNoticeDetail 호출 성공");
		
		NmNoticeVO detailVO = nmNoticeService.detailNotice(nnvo);
		
		System.out.println("확인점 >> : " + detailVO.getNm_no() + " : " + detailVO.getNm_file());
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("detailVO",detailVO);
		mav.setViewName("nm/detailNotice");
		
		return mav;
	}// end of goNoticeDetail() 함수
	
	@ResponseBody
	@RequestMapping(value="/deleteNotice",produces="application/text; charset=utf-8")
	public String deleteNotice(@ModelAttribute NmNoticeVO nnvo){
		logger.info("deleteNotice 호출 성공");
		TransactionStatus status=this.platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
		
		String result = "";
		String[] arrayNo = nnvo.getNm_no().split(",");
		int addCnt = 0;
		
		try{
			for(int i=0;i<arrayNo.length;i++){
				nnvo.setNm_no(arrayNo[i]);
				int cnt = nmNoticeService.deleteNotice(nnvo);
				addCnt = addCnt + cnt;
			}
		}catch(Exception e){
			System.out.println("에러났다 >>> : " + e.getMessage());
		}
		
		if(addCnt==arrayNo.length){
			result = "성공";
			platformTransactionManager.commit(status);
		}else{
			result = "알 수 없는 이유로 실패 했습니다. 문의 주세요";
			platformTransactionManager.rollback(status);
		}
		
		return result;
	}// end of deleteNotice() 함수
	
	@RequestMapping("/goUpdateNotice")
	public ModelAndView goUpdateNotice(@ModelAttribute NmNoticeVO nnvo){
		logger.info("goUpdateNotice 호출 성공");
		
		NmNoticeVO updateVO = nmNoticeService.detailNotice(nnvo);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("updateVO",updateVO);
		mav.setViewName("nm/updateNotice");
		
		return mav;
	}// end of goUpdateNotice() 함수
	
	// 첨부파일 다운로드 구현 ============================
	@RequestMapping(value="/nmFileDownload")
	public ModelAndView nmFileDownload(@ModelAttribute NmNoticeVO nnvo){
		logger.info("첨부파일 다운로드 컨트롤러 시작 >>> 다운로드 진행중 페이지로 이동");
		
		
//		String path = "C:/Users/이상훈/Desktop/20200315_java142_luna_pmUniform/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/uniformPM/nm/uploadStorage";
		String path = "C:/Users/bitcamp/Desktop/20200315_java142_luna_pmUniform/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/uniformPM";		
		
		String nm_file = nnvo.getNm_file();
		logger.info("다운로드 할 파일명 >>> nm_file : " + nm_file);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("bm_file", nm_file);
		mav.addObject("path", path);
		mav.setViewName("bm/fileDownload");
		
		return mav;
	}// end of 파일 다운로드
	
	@ResponseBody
	@RequestMapping(value="/updateIF",produces="application/json; charset=utf-8")
	public Map updateIF(HttpServletRequest request){
		logger.info("updateIF 호출 성공");
		
		int size = 10*1024*1024;
//		String path = "C:/Users/이상훈/Desktop/20200315_java142_luna_pmUniform/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/uniformPM/nm/uploadStorage";
		String path = "C:/Users/bitcamp/Desktop/20200315_java142_luna_pmUniform/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/uniformPM";
		String[] type = {"jpg","png","gif","psd","tiff","jpeg"};
		
		Map<String,String> m = new HashMap<String,String>();
		
		String img = "";
		String filename = "";
		
		try{
			MultipartRequest multi = new MultipartRequest(request,path,size,"UTF-8",new DefaultFileRenamePolicy());
			
			Enumeration<String> et = multi.getFileNames();
			
			List<String> list = new ArrayList<String>();
			
			while(et.hasMoreElements()){
				String file = et.nextElement();
				if(multi.getFilesystemName(file)!=null&&multi.getFilesystemName(file)!=""){
					list.add(multi.getFilesystemName(file));
				}
			}
			
			for(int i=0;i<list.size();i++){
				String name = list.get(i);				
				for(int j=0;j<type.length;j++){
					// 이미지 확장자 파일 셋팅
					if(name!=null&&name!=""){
						if(name.substring(name.indexOf(".")+1).toLowerCase().equals(type[j])){
							img = "/nm/uploadStorage/" + name;
							break;
						}
					
						// 그 외 확장자 파일 셋팅 
						if(j==type.length-1){
							filename = name;
						} // end of if
					}	
				} // end of for				
			} // end of for
			
			if(img==null||img==""){
				img = multi.getParameter("old_img");
			}
			
			if(filename==null||filename==""){
				filename = multi.getParameter("old_file");
			}
			
			m.put("img", img);
			m.put("file", filename);
		}catch(Exception e){
			System.out.println("에러났다 >>> : " + e.getMessage());
		}
		
		return m;
	}// end of updateIF() 함수
	
	@RequestMapping("/updateNotice")
	public String updateNotice(@ModelAttribute NmNoticeVO nnvo){
		logger.info("updateNotice 호출 성공");
		
		System.out.println("일단 확인 >> : " + nnvo.getNm_context() + " : " + nnvo.getNm_no());
		
		int cnt = nmNoticeService.updateNotice(nnvo);
		
		if(cnt==1){
			logger.info("업데이트 성공");
		}else{
			logger.info("업데이트 실패");
		}
		
		String url = "/nm/goNoticeDetail.uni?nm_no=" + nnvo.getNm_no();
		return "redirect:" + url;
	}// end of updateNotice() 함수
	
	@ResponseBody
	@RequestMapping(value="/updateView",produces="application/text; charset=utf-8")
	public String updateView(@ModelAttribute NmNoticeVO nnvo){
		logger.info("updateView 호출 성공");
		
		int cnt = nmNoticeService.updateView(nnvo);
		String result = "";
		
		if(cnt==1){
			result = "성공";
		}else{
			result = "실패 했습니다.";
		}
		return result;
	}// end of updateView() 함수

}// end of NmNoticeController class
