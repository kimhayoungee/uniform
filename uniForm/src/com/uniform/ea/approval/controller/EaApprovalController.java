package com.uniform.ea.approval.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.uniform.common.info.service.CommonInfoService;
import com.uniform.common.info.vo.CommonCodeVO;
import com.uniform.common.info.vo.CommonInfoVO;
import com.uniform.common.utils.FileUtil;
import com.uniform.common.utils.SessionUtil;
import com.uniform.ea.approval.service.EaApprovalService;
import com.uniform.ea.approval.vo.EaApprovalVO;
import com.uniform.ea.approval.vo.EaDocumentVO;
import com.uniform.ea.approval.vo.EaGianVO;
import com.uniform.ea.approval.vo.EaLineVO;
import com.uniform.ea.approval.vo.EaPoomVO;
import com.uniform.ea.approval.vo.EaUploadboardVO;
import com.uniform.ea.approval.vo.EaVacationVO;
import com.uniform.ea.approval.vo.PageVO;
import com.uniform.ea.approval.vo.UploadPageVO;
import com.uniform.ea.common.Chaebun;
import com.uniform.ea.common.GetDate;
import com.uniform.em.common.vo.EmCommonVO;

@Controller
@RequestMapping("/ea")
public class EaApprovalController {
	Logger logger = Logger.getLogger(EaApprovalController.class);
	
	private static final String CONTEXT_PATH = "ea";
	
	@Autowired
	private EaApprovalService eaApprovalService; 
	
	@Autowired
	private CommonInfoService commonInfoService;
	
	final static String FILEPATH =  "D:/00.BITCAMP/java142_Luna/.metadata/"
		  	+ ".plugins/org.eclipse.wst.server.core/tmp1/webapps/uploads";
	final static String DOWNLOADPATH = "files/";
	
	//전자결재메인으로 이동
	@RequestMapping("/goEaMain")
	public ModelAndView goEaMain(HttpServletRequest req){
		logger.info("컨트롤러 goEaMain()함수 시작");
		//b가 있으면 reload()하기 위해 받아옴
		
		String i_no = (String)req.getSession().getAttribute("i_no");
		EaDocumentVO edvo = new EaDocumentVO();
		edvo.setDo_writerno(i_no);
		edvo.setDo_aprno(i_no);
		
		EmCommonVO ecvo = new EmCommonVO();
		ecvo.setI_no(i_no);
		ecvo = commonInfoService.miniInfo(ecvo);

		PageVO pvo = new PageVO();
		//내가작성
		pvo.setDo_writerno(i_no);
		//내가결재
		pvo.setDo_aprno(i_no);
		pvo.setPageSize(10);
		pvo.setCurPage(1);
		
		List<PageVO> inglist = eaApprovalService.eaIngSelect(pvo);
		List<PageVO> toList = eaApprovalService.toApSelect(pvo);
		List<PageVO> reList = eaApprovalService.returnSelect(pvo);
		List<PageVO> finList = eaApprovalService.finSelect(pvo);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("ingList", inglist);
		mav.addObject("toList", toList);
		mav.addObject("reList", reList);
		mav.addObject("finList", finList);
		mav.addObject("ecvo",ecvo);
		//리다이렉트용
		mav.setViewName(CONTEXT_PATH + "/eaMain");
		return mav;
	}
	
	//menu 결재할 문서 이동
	@RequestMapping("/goMenuTo")
	public ModelAndView goMenuTo(@ModelAttribute PageVO param,HttpServletRequest req){
		logger.info("컨트롤러 goMenuTo()함수 시작");
		
		String i_no = (String)req.getSession().getAttribute("i_no");
		
		PageVO pvo = new PageVO();
		pvo.setDo_aprno(i_no);
		pvo.setPageSize(10);
		
		int curPage = param.getCurPage();
		if(curPage==0){

			pvo.setCurPage(1);
 
		}else{

			pvo.setCurPage(curPage);

		}

		//날짜 검색
		if(param.getDate1()==null && param.getDate2()==null){
			pvo.setDate1(GetDate.getFromDate());
			pvo.setDate2(GetDate.getToday());
		}else{
			pvo.setDate1(param.getDate1());
			pvo.setDate2(param.getDate2());			
		}			
		
		//작성자 이름으로 검색
		pvo.setDo_writer(param.getDo_writer());
		
		//종류별 정렬 do_type
		pvo.setDo_type(param.getDo_type());
		
		//상태별 정렬 ea_stateno
		pvo.setEa_stateno(param.getEa_stateno());
		
		List<PageVO> toList = eaApprovalService.toApSelect(pvo);
		
		ModelAndView mav = new ModelAndView();
		if(param.getDo_type()!=null&&param.getDo_type().length()>0){
			mav.addObject("type", param.getDo_type());
		} 
		if(param.getEa_stateno()!=null&&param.getEa_stateno().length()>0){
			mav.addObject("state", param.getEa_stateno());
		} 
		if(param.getDate1()==null && param.getDate2()==null){
			mav.addObject("date1", GetDate.getFromDate());
			mav.addObject("date2", GetDate.getToday());
		}else{
			mav.addObject("date1", param.getDate1());
			mav.addObject("date2", param.getDate2());
		}	
		if(param.getDo_writer()!=null&&param.getDo_writer().length()>0){
			mav.addObject("writer", param.getDo_writer());
		}
		mav.addObject("toList", toList);
		mav.setViewName(CONTEXT_PATH + "/menuTo");
		return mav;
	}	
	
	//menu 반려함 이동
	@RequestMapping("/goMenuRe")
	public ModelAndView goMenuRe(@ModelAttribute PageVO param
								 ,HttpServletRequest req){
		logger.info("컨트롤러 goMenuRe()함수 시작");
		
		String i_no = (String)req.getSession().getAttribute("i_no");

		PageVO pvo = new PageVO();
		pvo.setDo_writerno(i_no);
		pvo.setPageSize(10);
		
		int curPage = param.getCurPage();
		if(curPage==0){

			pvo.setCurPage(1);
 
		}else{

			pvo.setCurPage(curPage);

		}

		//날짜 검색
		if(param.getDate1()==null && param.getDate2()==null){
			pvo.setDate1(GetDate.getFromDate());
			pvo.setDate2(GetDate.getToday());
		}else{
			pvo.setDate1(param.getDate1());
			pvo.setDate2(param.getDate2());			
		}		
		
		//종류별 정렬 do_type
		pvo.setDo_type(param.getDo_type());
		
		List<PageVO> reList = eaApprovalService.returnSelect(pvo);
		
		ModelAndView mav = new ModelAndView();
		if(param.getDo_type()!=null&&param.getDo_type().length()>0){
			mav.addObject("type", param.getDo_type());   
		} 	
		if(param.getDate1()==null && param.getDate2()==null){
			mav.addObject("date1", GetDate.getFromDate());
			mav.addObject("date2", GetDate.getToday());
		}else{
			mav.addObject("date1", param.getDate1());
			mav.addObject("date2", param.getDate2());
		}		
		mav.addObject("reList", reList);
		mav.setViewName(CONTEXT_PATH + "/menuRe");
		return mav;
	}	
	
	//menu 결재중 문서 이동
	@RequestMapping("/goMenuIng")
	public ModelAndView goMenuIng(@ModelAttribute PageVO param
								  ,HttpServletRequest req){
		logger.info("컨트롤러 goMenuIng()함수 시작");

		String i_no = (String)req.getSession().getAttribute("i_no");
		
		PageVO pvo = new PageVO();
		pvo.setDo_writerno(i_no);
		pvo.setPageSize(10);	
		
		int curPage = param.getCurPage();
		
		if(curPage==0){

			pvo.setCurPage(1);
 
		}else{

			pvo.setCurPage(curPage);

		}
		
		//날짜 검색
		if(param.getDate1()==null && param.getDate2()==null){
			pvo.setDate1(GetDate.getFromDate());
			pvo.setDate2(GetDate.getToday());
		}else{
			pvo.setDate1(param.getDate1());
			pvo.setDate2(param.getDate2());			
		}
		
		//종류별 정렬 do_type
		pvo.setDo_type(param.getDo_type());
		
		//상태별 정렬 ea_stateno
		pvo.setEa_stateno(param.getEa_stateno());

		List<PageVO> inglist = eaApprovalService.eaIngSelect(pvo);
		
		ModelAndView mav = new ModelAndView();

		if(param.getDo_type()!=null&&param.getDo_type().length()>0){
			mav.addObject("type", param.getDo_type());
		} 
		if(param.getEa_stateno()!=null&&param.getEa_stateno().length()>0){
			mav.addObject("state", param.getEa_stateno());
		} 
		if(param.getDate1()==null && param.getDate2()==null){
			mav.addObject("date1", GetDate.getFromDate());
			mav.addObject("date2", GetDate.getToday());
		}else{
			mav.addObject("date1", param.getDate1());
			mav.addObject("date2", param.getDate2());
		}
		mav.addObject("inglist", inglist);
		mav.setViewName(CONTEXT_PATH + "/menuIng");
		return mav;
	}	
	
	//menu 완료함 이동
	@RequestMapping("/goMenuFin")
	public ModelAndView goMenuFin(@ModelAttribute PageVO param
								  ,HttpServletRequest req){
		logger.info("컨트롤러 goMenuFin()함수 시작");
		
		String i_no = (String)req.getSession().getAttribute("i_no");

		PageVO pvo = new PageVO();
		pvo.setDo_writerno(i_no);
		pvo.setPageSize(10);
		
		int curPage = param.getCurPage();
		
		if(curPage==0){

			pvo.setCurPage(1);
 
		}else{

			pvo.setCurPage(curPage);

		}
		
		//날짜 검색
		if(param.getDate1()==null && param.getDate2()==null){
			pvo.setDate1(GetDate.getFromDate());
			pvo.setDate2(GetDate.getToday());
		}else{
			pvo.setDate1(param.getDate1());
			pvo.setDate2(param.getDate2());			
		}
		
		//종류별 정렬 do_type
		pvo.setDo_type(param.getDo_type());

		List<PageVO> finList = eaApprovalService.finSelect(pvo);
		
		ModelAndView mav = new ModelAndView();
		if(param.getDo_type()!=null&&param.getDo_type().length()>0){
			mav.addObject("type", param.getDo_type());
		} 	
		if(param.getDate1()==null && param.getDate2()==null){
			mav.addObject("date1", GetDate.getFromDate());
			mav.addObject("date2", GetDate.getToday());
		}else{
			mav.addObject("date1", param.getDate1());
			mav.addObject("date2", param.getDate2());
		}		
		mav.addObject("finList", finList);
		mav.setViewName(CONTEXT_PATH + "/menuFin");
		return mav;
	}
	
	//menu 결재한 문서 
	@RequestMapping("/goMenuEd")
	public ModelAndView goMenuEd(@ModelAttribute PageVO param
								 ,HttpServletRequest req){
		logger.info("컨트롤러 goMenuEd()함수 시작");
		System.out.println("두라잇 " + param.getDo_writer());
		String i_no = (String)req.getSession().getAttribute("i_no");
		
		PageVO pvo = new PageVO();
		pvo.setEa_aprno(i_no);
		pvo.setPageSize(10);
		
		int curPage = param.getCurPage();
		
		if(curPage==0){

			pvo.setCurPage(1);
 
		}else{

			pvo.setCurPage(curPage);

		}

		//날짜 검색
		if(param.getDate1()==null && param.getDate2()==null){
			pvo.setDate1(GetDate.getFromDate());
			pvo.setDate2(GetDate.getToday());
		}else{
			pvo.setDate1(param.getDate1());
			pvo.setDate2(param.getDate2());			
		}		

		//작성자 이름으로 검색
		pvo.setDo_writer(param.getDo_writer());
		
		//종류별 정렬 do_type
		pvo.setDo_type(param.getDo_type());		
		
		//상태별 정렬 ea_stateno
		pvo.setEa_stateno(param.getEa_stateno());
		
		List<PageVO> edList = eaApprovalService.edSelect(pvo);
		
		ModelAndView mav = new ModelAndView();
		if(param.getDo_type()!=null&&param.getDo_type().length()>0){
			mav.addObject("type", param.getDo_type());
		} 
		if(param.getEa_stateno()!=null&&param.getEa_stateno().length()>0){
			mav.addObject("state", param.getEa_stateno());
		} 
		if(param.getDate1()==null && param.getDate2()==null){
			mav.addObject("date1", GetDate.getFromDate());
			mav.addObject("date2", GetDate.getToday());
		}else{
			mav.addObject("date1", param.getDate1());
			mav.addObject("date2", param.getDate2());
		}	
		if(param.getDo_writer()!=null&&param.getDo_writer().length()>0){
			mav.addObject("writer", param.getDo_writer());
		}	
		mav.addObject("edList", edList);
		mav.setViewName(CONTEXT_PATH + "/menuEd");
		return mav;
	}	
	
	//전결 메인에서 기안서 팝업창으로 이동
	@RequestMapping("/goGianPop")
	public ModelAndView goGianPop(){
		logger.info("컨트롤러 goGianPop()함수 시작");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(CONTEXT_PATH + "/gianPop");
		return mav;
	} //end of goGianPop()
	
	//기안 팝업창에서 기안서 작성창으로 이동 
	@RequestMapping("/goGianWrite")
	public ModelAndView goGianWrite(@RequestParam("ea_linename") String ea_linename 
								   ,HttpServletRequest req){
		logger.info("컨트롤러 goGianWrite(ea_linename)함수 시작");
		logger.info("확인 : " + ea_linename );
		
		ModelAndView mav = new ModelAndView();
		if(ea_linename!=null&&ea_linename.length()>0){
			
			EmCommonVO ecvo = new EmCommonVO();
			
			//오늘날짜 조회
			String today = eaApprovalService.today();
			mav.addObject("today", today);
			
			//작성자 팀, 이름 조회
			String i_no = (String)req.getSession().getAttribute("i_no");
			CommonInfoVO civo = new CommonInfoVO();
			civo.setI_no(i_no);
			List<EmCommonVO> list = eaApprovalService.writerSelect(civo);
			mav.addObject("emvo", list);
			
			ecvo.setI_no(i_no);
			
			ecvo = commonInfoService.miniInfo(ecvo);
			mav.addObject("ecvo",ecvo);
			
			//양식
			mav.addObject("do_type", "기안");			
			mav.addObject("ea_linename", ea_linename);
			mav.setViewName(CONTEXT_PATH + "/gianWrite");
		}
		
		return mav;
	} //end of goGianWrite(ea_linename)

	//결재선 팝업
	@RequestMapping("/goLinePop")
	public ModelAndView goLinePop(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName(CONTEXT_PATH + "/linePop");
		return mav;
	}
	
	//결재선 총장 처 조회
	@ResponseBody
	@RequestMapping("/deptSelect")
	public HashMap<String, List> deptSelect(){
		logger.info("컨트롤러 deptSelect()함수 시작");
		
		//총장 조회
		List<CommonInfoVO> iList = eaApprovalService.presidentSelect();
		
		//처 조회
		List<CommonCodeVO> deptList = eaApprovalService.deptSelect();
		for(int i=0;i<deptList.size();i++){
			CommonCodeVO ccvo = deptList.get(i);
			System.out.println("포문확인(처) : " + ccvo.getCode_detail());
		}
		
		HashMap<String, List> hmap = new HashMap<String, List>();
		hmap.put("president", iList);
		hmap.put("dept", deptList);
		return hmap;
	}
	
	//결재선 팀 조회
	@ResponseBody
	@RequestMapping("/teamSelect")
	public HashMap<String, List> teamSelect(String dept){
		logger.info("컨트롤러 teamSelect(dept)함수 시작");
		logger.info("dept 확인 : " + dept);
		
		CommonCodeVO ccvo = new CommonCodeVO();
		ccvo.setCode_detail(dept);
		
		//처장 조회
		List<CommonInfoVO> iList = eaApprovalService.deptLeaderSelect(ccvo);
		
		//팀 조회
		List<CommonCodeVO> teamList = eaApprovalService.teamSelect(ccvo);
		for(int i=0;i<teamList.size();i++){
			CommonCodeVO cvo = teamList.get(i);
			System.out.println("포문확인(팀) : " + cvo.getCode_detail());
		}
		
		HashMap<String, List> hmap = new HashMap<String, List>();
		hmap.put("deptLeader", iList);
		hmap.put("team", teamList);
		
		return hmap;
	}
	
	//결재선 팀장 조회
	@ResponseBody
	@RequestMapping("/teamLeaderSelect")
	public List<CommonInfoVO> teamLeaderSelect(String team){
		logger.info("컨트롤러 teamLeaderSelect(team)함수 시작");
		logger.info("team 확인 : " + team);
		
		CommonCodeVO ccvo = new CommonCodeVO();
		ccvo.setCode_detail(team);
		
		//팀장 조회
		List<CommonInfoVO> iList = eaApprovalService.teamLeaderSelect(ccvo);
		//String i_namekr = iList.get(0).getI_nameKr();
		//String i_no = iList.get(0).getI_no();
		//System.out.println("팀장 확인 : " + i_namekr + " " + i_no);
		
		return iList;
	}
	
	//기안서 작성 파일 업로드
	@ResponseBody
	@RequestMapping(value="/fileUpload", produces="html/text; charset=utf-8")
	public String fileUpload(HttpServletRequest req){
		logger.info("컨트롤러 fileUpload(req)");
		String result = "";
		String file = "";
		//파일업로드
		try{
			
			String upload = "/ea/files/";
			
			file = FileUtil.fileUpload(req, upload);
		
			//egvo.setGi_attach(file);
			if(file!=null&& file.length()>0){
				result = "성공";
				logger.info("ㅇ" + result);
				System.out.println("파일 : " + file);
			}
			
		}catch(Exception e){
			logger.info("파일업로드 에러 : " + e.getMessage());
		} //try-catch
		
		
		return file;
	}
	
	//기안서 작성 
	@ResponseBody
	@RequestMapping(value="/gianFormInsert", produces="application/text; charset=utf-8")
	public String gianFormInsert(@ModelAttribute EaGianVO param
								 ,HttpServletRequest req){
		logger.info("컨트롤러 gianFormInsert(param)");
		logger.info("req 확인 : " + req.getParameter("gi_title") + " " + req.getParameter("ea_line1"));
		logger.info("param확인 : " + param.getDo_title() + " " + param.getEa_line1());
		int doc_result = 0;
		int gi_result = 0;
		int ea_result = 0;
		int line_result = 0;
		
		EaApprovalVO eavo = new EaApprovalVO();
		String i_no = (String)req.getSession().getAttribute("i_no");
		
		//기안서 채번
		List<EaGianVO> gianChList = eaApprovalService.gianChaebun();
		String gianCh = Chaebun.gianChaebun(gianChList);
		logger.info("기안서채번확인 : " + gianCh);
		//결재선 채번
		List<EaLineVO> lineChList = eaApprovalService.lineChaebun();
		String lineCh = Chaebun.eaLineChaebun(lineChList);
		logger.info("결재선채번확인 : " + lineCh);
		//결재 채번
		List<EaApprovalVO> eaChList = eaApprovalService.eaChaebun();
		String eaCh = Chaebun.eaChaebun(eaChList);
		logger.info("결재채번확인 : " + eaCh);
		
		//기안서테이블 insert setting
		param.setGi_docno(gianCh);
		param.setGi_writerno(i_no);
		//결재선테이블 insert setting
		param.setEa_lineno(lineCh);		
		//문서테이블 insert setting
		param.setDo_docno(gianCh);
		param.setDo_type(param.getDo_type());
		param.setDo_writerno(i_no);
		param.setDo_writer(param.getGi_writer());
		param.setDo_title(param.getGi_title());
		param.setDo_lineno(lineCh);
		param.setDo_aprno(param.getEa_line1());
		//결재테이블 insert setting
		eavo.setEa_no(eaCh);
		eavo.setEa_docno(gianCh);
		eavo.setEa_lineno(lineCh);
		eavo.setEa_aprno(i_no);
		eavo.setEa_stateno("71");
		
		System.out.println("setting완료");
		

		//insert 
		try{
			System.out.println("한글 " + param.getGi_data());
			//기안서테이블 insert
			gi_result = eaApprovalService.gianInsert(param);
			if(gi_result==1){
				logger.info("기안서 테이블 insert 성공");
			}
			if(gi_result==0){
				logger.info("기안서 테이블 insert 실패");
			}
			
			//결재선테이블 insert
			line_result = eaApprovalService.lineInsert(param);
			if(line_result==1){
				logger.info("결재선테이블 insert 성공");
			}
			if(line_result==0){
				logger.info("결재선테이블 insert 실패");
			}
			
			//문서테이블 insert
			doc_result = eaApprovalService.documentInsert(param);
			if(doc_result==1){
				logger.info("문서테이블 insert 성공");
			}
			if(doc_result==0){
				logger.info("문서테이블 insert 실패");
			}
			
			//결재테이블 insert
			ea_result = eaApprovalService.ea1Insert(eavo);
			if(doc_result==1){
				logger.info("문서테이블 insert 성공");
			}
			if(doc_result==0){
				logger.info("문서테이블 insert 실패");
			}


		}catch(Exception e){
			
			logger.info("인서트 트랜잭션 에러 : " + e.getMessage());
			
		}
		boolean b = doc_result==1 && gi_result==1 && ea_result==1 && line_result==1;

		return "성공";
	} //end of gianFormInsert()
	
	//파일 다운로드
	@RequestMapping("/download")
	public ModelAndView download(@RequestParam String file){
		logger.info("컨트롤러 download()함수 시작");
		
		ModelAndView mav = new ModelAndView();
		
		if(file!=null){
			mav.addObject("file", file);
			mav.setViewName(CONTEXT_PATH + "/eadownload");
		}
		
		return mav;
	}
	
	//문서 삭제
	@RequestMapping("/docDelete")
	public ModelAndView gianDelete(@ModelAttribute EaDocumentVO param
								   ,HttpServletRequest req){
		logger.info("컨트롤러 docDelete()함수 시작");
		
		int result = eaApprovalService.docDelete(param);
		
		if(result==1){
			logger.info("삭제 성공");
		}else{
			logger.info("삭제 실패");
		}
		
		RedirectView rdv = new RedirectView("/ea/goEaMain.uni");
		rdv.setContextRelative(true);
		ModelAndView mav = new ModelAndView(rdv);
		return mav;
	}
	
	//기안서 결재할 문서 상세
	@RequestMapping("/giToSelect")
	public ModelAndView giToSelect(@ModelAttribute EaDocumentVO param
			  					   ,HttpServletRequest req){
		logger.info("컨트롤러 giToSelect(param)함수 시작");
		
		//히스토리 의견 조회
		List<EaApprovalVO> hList = eaApprovalService.historyComment(param);
		
		//최종결재 의견 조회
		List<EaApprovalVO> eList = eaApprovalService.detailEaSelect(param);
		
		String do_aprno = (String)req.getSession().getAttribute("i_no");
		param.setDo_aprno(do_aprno);
		
		List<EaGianVO> list = eaApprovalService.giDetailSelect(param);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("toList", list);
		mav.addObject("eList", eList);
		mav.addObject("hList", hList);
		mav.setViewName(CONTEXT_PATH + "/gianToDetail");
		return mav;
	}
	
	//결재의견 팝업
	@RequestMapping("/goCommentPop")
	public ModelAndView goCommentPop(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName(CONTEXT_PATH + "/commentPop");
		return mav;
	}
	
	//결재
	@ResponseBody
	@RequestMapping(value="/approval", produces="application/text; charset=utf-8")
	public String approval(@ModelAttribute EaApprovalVO param
						   ,HttpServletRequest req){
		logger.info("컨트롤러 approval(param)함수 시작");
		
		//히스토리 insert
		int iResult = eaApprovalService.historyInsert(param);
		if(iResult==1){
			logger.info("히스토리 insert 성공");
		}else{
			logger.info("히스토리 insert 실패");
		} 
		
		//결재 채번
		List<EaApprovalVO> eaChList = eaApprovalService.eaChaebun();
		String eaCh = Chaebun.eaChaebun(eaChList);
		
		String ea_aprno = (String)req.getSession().getAttribute("i_no");
		//서명조회
		EmCommonVO ecvo = new EmCommonVO();
		ecvo.setI_no(ea_aprno);
		List<EmCommonVO> signL = eaApprovalService.signSelect(ecvo);
		String mySign="";
		for(int i=0;i<signL.size();i++){
			EmCommonVO ec = signL.get(i);
			mySign = ec.getEm_sign();
		}
		
		String state = param.getEa_stateno();
		logger.info("결재상태코드 : " + state); 
		
		//setting
		EaDocumentVO edvo = new EaDocumentVO();
		
		System.out.println("문서번호 : " + param.getEa_docno());
		edvo.setDo_docno(param.getEa_docno());
		param.setEa_no(eaCh);
		param.setEa_aprno(ea_aprno);
		
		String ea_line2 = "";
		String ea_line3 = "";
		
		//다음결재자 조회
		if(state.equals("72") || state.equals("73")){
			List<EaLineVO> nlist = eaApprovalService.nextApr(param);
			
			for(int j=0;j<nlist.size();j++){
				EaLineVO elvo = nlist.get(j);
				ea_line2 = elvo.getEa_line2();
				ea_line3 = elvo.getEa_line3();
			}
			//System.out.println("결재라인23" +ea_line2+" " + ea_line3 );
		}
		
		//히스토리 서명 조회
		if(!state.equals("71")){
			List<EaApprovalVO> sList = eaApprovalService.signHistory(param);
			String sign1 = "";
			String sign2 = "";
			if(!state.equals("72")){
				if(sList.size()>0){
					for(int j=0;j<sList.size();j++){
						EaApprovalVO eavo = sList.get(j);
						if(eavo.getEa_sign1()!=null && eavo.getEa_sign1()!="") sign1 = eavo.getEa_sign1();
						if(eavo.getEa_sign2()!=null && eavo.getEa_sign2()!="") sign2 = eavo.getEa_sign2();
					}
				}
			}
			
			
			//결재상태에 따라 서명, 다음결재자 setting
			if(state.equals("72")){ 
				logger.info("72 여기?");
				param.setEa_sign1(mySign);
			}
			if(state.equals("73")){
				logger.info("73 여기?");
				//sign1 히스토리에서 조회해와서 셋 
				param.setEa_sign1(sign1);
				param.setEa_sign2(mySign);
			}
			if(state.equals("74")){
				//sign1
				param.setEa_sign1(sign1);
				param.setEa_sign2(mySign);
			}
			if(state.equals("76")){
				logger.info("76 여기?");
				//sign1,2
				param.setEa_sign1(sign1);
				param.setEa_sign2(sign2);
				param.setEa_sign3(mySign);
			}
			if(state.equals("77")){
				if(sign1!=null&& sign1!="") param.setEa_sign1(sign1);
				if(sign2!=null&& sign2!="") param.setEa_sign2(sign2);
			}
		}

		if(state.equals("72")){
			edvo.setDo_aprno(ea_line2);
		}
		if(state.equals("73")){
			edvo.setDo_aprno(ea_line3);
		}
		if(state.equals("74")){
			edvo.setDo_aprno("");
		}
		if(state.equals("76")){
			edvo.setDo_aprno("");
		}
		if(state.equals("77")){
			edvo.setDo_aprno("");
		}
		
		
		//결재 update
		int uResult = eaApprovalService.eaUpdate(param);
		if(uResult==1){
			logger.info("결재 update 성공");
		}else{
			logger.info("결재 update 실패");
		} 
		
		//문서함 다음결재자 update
		int nResult = eaApprovalService.aprUpdate(edvo);
		if(nResult==1){
			logger.info("다음결재자 update 성공");
		}else{
			logger.info("다음결재자 update 실패");
		} 
		
		String r = "";
		boolean b = uResult==1 && nResult==1;
		if(b) r = "성공";
		else r = "실패";
		return r;
	}
	
	//기안서 상세보기
	@RequestMapping("/giDetailSelect")
	public ModelAndView detailSelect(@ModelAttribute EaDocumentVO param
				 				     ,HttpServletRequest req){
		//히스토리 의견 조회
		List<EaApprovalVO> hList = eaApprovalService.historyComment(param);
		
		//최종결재 의견 조회
		List<EaApprovalVO> eList = eaApprovalService.detailEaSelect(param);
		
		//기안서 내용 상세조회 
		String do_writerno = (String)req.getSession().getAttribute("i_no");
		param.setDo_writerno(do_writerno);
		List<EaGianVO> list = eaApprovalService.giDetailSelect(param);
		
		EmCommonVO ecvo = new EmCommonVO();
		
		ecvo.setI_no(do_writerno);
		ecvo = commonInfoService.miniInfo(ecvo);

		ModelAndView mav = new ModelAndView();
		mav.addObject("ecvo",ecvo);
		mav.addObject("list", list);
		mav.addObject("eList", eList);
		mav.addObject("hList", hList);
		mav.setViewName(CONTEXT_PATH + "/gianDetail");
		return mav;
	}
	
	//기안서 끝
	
	//메인에서 휴가계작성창 이동
	@RequestMapping("/goVacaWrite")
	public ModelAndView goVacaWrite(@RequestParam String ea_linename
									,HttpServletRequest req){
		logger.info("컨트롤러 goVacaWrite()함수 시작");
		ModelAndView mav = new ModelAndView();
		
		if(ea_linename!=null&&ea_linename.length()>0){
			
			//오늘날짜 조회
			String today = eaApprovalService.today();
			mav.addObject("va_insertdate", today);
			
			//작성자 팀, 이름 조회
			String i_no = (String)req.getSession().getAttribute("i_no");
			CommonInfoVO civo = new CommonInfoVO();
			civo.setI_no(i_no);
			List<EmCommonVO> list = eaApprovalService.writerSelect(civo);
			mav.addObject("emvo", list);
			
			//양식
			mav.addObject("do_type", "휴가계");			
			mav.addObject("ea_linename", ea_linename);
			mav.setViewName(CONTEXT_PATH + "/vacaWrite");
		}
		
		return mav;
	}
	
	//휴가계 insert
	@ResponseBody
	@RequestMapping(value="/vacaInsert", produces="application/text; charset=utf-8")
	public String vacaInsert(@ModelAttribute EaVacationVO param
								   ,HttpServletRequest req){
		logger.info("컨트롤러 vacaInsert()함수 시작");
		int doc_result = 0;
		int va_result = 0;
		int ea_result = 0;
		int line_result = 0;
		
		EaApprovalVO eavo = new EaApprovalVO();
		String i_no = (String)req.getSession().getAttribute("i_no");
		
		//휴가계 채번
		List<EaVacationVO> vacaChList = eaApprovalService.vacaChaebun();
		String vacaCh = Chaebun.vacaChaebun(vacaChList);
		logger.info("휴가계채번확인 : " + vacaCh);
		//결재선 채번
		List<EaLineVO> lineChList = eaApprovalService.lineChaebun();
		String lineCh = Chaebun.eaLineChaebun(lineChList);
		logger.info("결재선채번확인 : " + lineCh);
		//결재 채번
		List<EaApprovalVO> eaChList = eaApprovalService.eaChaebun();
		String eaCh = Chaebun.eaChaebun(eaChList);
		logger.info("결재채번확인 : " + eaCh);
		
		//기안서테이블 insert setting
		param.setVa_docno(vacaCh);
		param.setVa_writerno(i_no);
		//결재선테이블 insert setting
		param.setEa_lineno(lineCh);		
		//문서테이블 insert setting
		param.setDo_docno(vacaCh);
		param.setDo_type(param.getDo_type());
		param.setDo_writerno(i_no);
		param.setDo_writer(param.getVa_writer());
		param.setDo_title(param.getVa_title());
		param.setDo_insertdate(param.getVa_insertdate());
		param.setDo_lineno(lineCh);
		param.setDo_aprno(param.getEa_line1());
		//결재테이블 insert setting
		eavo.setEa_no(eaCh);
		eavo.setEa_docno(vacaCh);
		eavo.setEa_lineno(lineCh);
		eavo.setEa_aprno(i_no);
		eavo.setEa_stateno("71");
		//eavo.setEa_date(param.getGi_insertdate());
		
		System.out.println("setting완료");

		//insert 
		try{
			
			//기안서테이블 insert
			va_result = eaApprovalService.vacaInsert(param);
			if(va_result==1){
				logger.info("휴가계 테이블 insert 성공");
			}
			if(va_result==0){
				logger.info("휴가계 테이블 insert 실패");
			}
			
			//결재선테이블 insert
			line_result = eaApprovalService.lineInsert(param);
			if(line_result==1){
				logger.info("결재선테이블 insert 성공");
			}
			if(line_result==0){
				logger.info("결재선테이블 insert 실패");
			}
			
			//문서테이블 insert
			doc_result = eaApprovalService.documentInsert(param);
			if(doc_result==1){
				logger.info("문서테이블 insert 성공");
			}
			if(doc_result==0){
				logger.info("문서테이블 insert 실패");
			}
			
			//결재테이블 insert
			ea_result = eaApprovalService.ea1Insert(eavo);
			if(doc_result==1){
				logger.info("문서테이블 insert 성공");
			}
			if(doc_result==0){
				logger.info("문서테이블 insert 실패");
			}
			System.out.println("ts1");
			System.out.println("ts2");

		}catch(Exception e){
			
			logger.info("인서트 트랜잭션 에러 : " + e.getMessage());
			
		}
		boolean b = doc_result==1 && va_result==1 && ea_result==1 && line_result==1;

		return "성공";		
		
	} //end of vacaInsert() 
	
	//휴가계 상세조회
	@RequestMapping("/vaDetailSelect")
	public ModelAndView vaDetailSelect(@ModelAttribute EaDocumentVO param
				 				       ,HttpServletRequest req){
		//히스토리 의견 조회
		List<EaApprovalVO> hList = eaApprovalService.historyComment(param);
		
		//최종결재 의견 조회
		List<EaApprovalVO> eList = eaApprovalService.detailEaSelect(param);
		
		//휴가계 내용 상세조회 
		String do_writerno = (String)req.getSession().getAttribute("i_no");
		param.setDo_writerno(do_writerno);
		List<EaVacationVO> list = eaApprovalService.vaDetailSelect(param);

		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.addObject("eList", eList);
		mav.addObject("hList", hList);
		mav.setViewName(CONTEXT_PATH + "/vacaDetail");
		return mav;
	}
	
	//기안서 결재할 문서 상세
	@RequestMapping("/vaToSelect")
	public ModelAndView vaToSelect(@ModelAttribute EaDocumentVO param
			  					  ,HttpServletRequest req){
		logger.info("컨트롤러 vaToSelect(param)함수 시작");
		
		//히스토리 의견 조회
		List<EaApprovalVO> hList = eaApprovalService.historyComment(param);
		
		//최종결재 의견 조회
		List<EaApprovalVO> eList = eaApprovalService.detailEaSelect(param);
		
		String do_aprno = (String)req.getSession().getAttribute("i_no");
		param.setDo_aprno(do_aprno);
		
		List<EaVacationVO> list = eaApprovalService.vaDetailSelect(param);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("toList", list);
		mav.addObject("eList", eList);
		mav.addObject("hList", hList);
		mav.setViewName(CONTEXT_PATH + "/vacaToDetail");
		return mav;
	}	
	
	 //결재라인 팝업창으로  
    @RequestMapping("/goEalinePop")
    public ModelAndView goEalinePop(){
       logger.info("컨트롤러 goEalinePop()함수 시작");
       ModelAndView mav = new ModelAndView();
       mav.setViewName(CONTEXT_PATH + "/eaTreeLine");
       return mav;
    } //end of goEalinePop()	
    
	 //업로드게시판으로 
	   @RequestMapping("/goUploadList")
	   public ModelAndView goUploadList(HttpServletRequest req, @ModelAttribute UploadPageVO param){
	      logger.info("컨트롤러 goUploadList()함수 시작");
	      ModelAndView mav = new ModelAndView();
	      
	      String i_no = (String)req.getSession().getAttribute("i_no");
	      String curPage = (String)req.getParameter("curPage");
	      
	      int i=0;
	      if(curPage != null){
	    	  i = Integer.parseInt(curPage);
	    	 
	      }else{
	    	 i=1;
	      }
	      param.setCurPage(i);		      
	
	      List<UploadPageVO> list = eaApprovalService.uploadSelect(param);
	      
	      mav.addObject("list", list);
		  mav.addObject("i_no", i_no);
	      mav.setViewName(CONTEXT_PATH + "/eaFileBoardList");
	      return mav;
	   } //end of goUpload()  
	   
	   
		 //업로드게시판 글쓰기
	   @RequestMapping("/goUpload")
	   public ModelAndView goUpload(HttpServletRequest req, @ModelAttribute EaUploadboardVO param){
	      logger.info("컨트롤러 goUpload()함수 시작");
	      ModelAndView mav = new ModelAndView();
	      String i_no = (String)req.getSession().getAttribute("i_no");
	      mav.addObject("i_no",i_no);
	      mav.setViewName(CONTEXT_PATH + "/eaFileBoard");
	      return mav;
	   } //end of goEalinePop()	
	   
		 //업로드게시판 디테일
	   @RequestMapping("/goUploadDetail")
	   public ModelAndView goUploadDetail(HttpServletRequest req, @ModelAttribute EaUploadboardVO param){
		   logger.info("컨트롤러 goUploadDetail()함수 시작");
		   
		   ModelAndView mav = new ModelAndView();
		   String i_no = (String)req.getSession().getAttribute("i_no");
		   
		   List<EaUploadboardVO> list = eaApprovalService.uploadSelectOne(param);
		      
		   mav.addObject("list", list);
		   mav.addObject("i_no", i_no);
		   mav.setViewName(CONTEXT_PATH + "/eaFileBoardDetail");
		   
		   return mav;
	   }	   
	   
	   @ResponseBody
	   @RequestMapping(value="/eaLine/{i_nameKr}.uni")
	   public ResponseEntity<String> eaLine(@PathVariable("i_nameKr") String i_nameKr){
		   logger.info("컨트롤러 eaLine() 함수시작");
		   
		   ResponseEntity<String> entity = null;
		   String result = "";
		   CommonInfoVO cvo = new CommonInfoVO();
		   cvo.setI_nameKr(i_nameKr);
		   
		   logger.info("i_nameKr >>> : " + cvo.getI_nameKr());
		   
		   try{
			   List<CommonInfoVO> aList = 	eaApprovalService.eaLine(cvo);
			   result = aList.get(0).getI_no();
			   entity = new ResponseEntity<String>(result, HttpStatus.OK); 
			   
		   }catch(Exception e){
			   e.printStackTrace();
			   entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST); 
		   }
		   return entity;
	   }//end of eaLine()
	   
	   
		//품의서 팝업창으로 
	   @RequestMapping("/goPoomPop")
	   public ModelAndView goPoomPop(){
	      logger.info("컨트롤러 goPoomPop()함수 시작");
	      ModelAndView mav = new ModelAndView();
	      mav.setViewName(CONTEXT_PATH + "/poomPop");
	      return mav;
	   } //end of goPoomPop()	  
	   
		 //품위서 작성창으로 이동 
	   @RequestMapping("/goPoomWrite")
	   public ModelAndView goPoomWrite(HttpServletRequest req
			   						,@RequestParam("ea_linename") String ea_linename){
	      logger.info("컨트롤러 goPoomWrite()함수 시작");
	      logger.info("확인 : " + ea_linename);
	      
	      ModelAndView mav = new ModelAndView();
	      String i_no = (String)req.getSession().getAttribute("i_no");
	      
	      EmCommonVO ecvo = new EmCommonVO();
	      ecvo.setI_no(i_no);
	      ecvo = commonInfoService.miniInfo(ecvo);
	      
	      mav.addObject("ecvo",ecvo);
	      mav.addObject("i_no", i_no);
	      mav.setViewName(CONTEXT_PATH + "/poomWrite");
	      	      
	      return mav;
	   } //end of goPoomWrite	 
	   
	   
	   //품위서 작성창(전결)으로 이동 
	   @RequestMapping("/goPoomWriteF")
	   public ModelAndView goPoomWriteF(HttpServletRequest req
			   						,@RequestParam("ea_linename") String ea_linename){
	      logger.info("컨트롤러 goPoomWrite()함수 시작");
	      logger.info("확인 : " + ea_linename);
	      
	      ModelAndView mav = new ModelAndView();
	      String i_no = (String)req.getSession().getAttribute("i_no");
	      mav.addObject("i_no", i_no);
	      mav.setViewName(CONTEXT_PATH + "/poomWriteF");
	      	      
	      return mav;
	   } //end of goPoomWriteF	   
	   
	   //품의서작성 
	   @RequestMapping("/poomFormInsert")
	   public String poomFormInsert(HttpServletRequest req, @ModelAttribute EaPoomVO param)
			   throws ServletException, IOException{
	      logger.info("컨트롤러 poomFormInsert()시작");
	      logger.info("확인 : " + param.getPo_title() + " " + param.getPo_data());
	      
	      req.setCharacterEncoding("UTF-8");
	      String uploadPath = "D:/00.BITCAMP/java142_Luna/.metadata/"
						  	+ ".plugins/org.eclipse.wst.server.core/tmp1/webapps/uploads";
	      int size = 10*1024*1024;
	      int result = 0;	      
	      
	      String i_no=(String)req.getSession().getAttribute("i_no");
	      
	      String po_docno = "";
	      String po_team = "";
	      String po_writerno = "";	      
	      String po_writer = "";
	      String po_title = "";
	      String po_data = "";
	      String file1 = "";
	      String po_attach = "";
	      String po_deleteyn = "";
	      String po_insertdate = "";
	      String po_updatedate = "";
	      
	      String ea_lineno = "";
	      String ea_linename = "";
	      String ea_line1 = "";
	      String ea_line2 = "";
	      String ea_line3 = "";
	      	      
	      String do_docno = "";
	      String do_type = "";
	      String do_writerno = "";
	      String do_writer = "";
	      String do_title = "";
	      String do_insertdate = "";
	      String do_deleteyn = "";
	      String do_lineno = "";
	      String do_aprno = "";
	      
	      String ea_no = "";
	      String ea_docno = "";
	      String ea_aprno = "";
	      String ea_stateno = "";
	      String ea_sign1 = "";
	      String ea_sign2 = "";
	      String ea_sign3 = "";
	      String ea_comment = "";
	      String ea_date = "";
	      
	      
	      MultipartRequest mr = new MultipartRequest(req, uploadPath, size, "UTF-8"
	    		  ,new DefaultFileRenamePolicy());
	      
	      List<EaPoomVO> chList = eaApprovalService.poomChaebun();
	      List<EaLineVO> chLine = eaApprovalService.lineChaebun();
	      List<EaDocumentVO> chDoc = eaApprovalService.documentChaebun();
	      List<EaApprovalVO> chEa = eaApprovalService.eaChaebun();
	      
	      String poCh = Chaebun.poomChaebun(chList);
	      String lineCh = Chaebun.lineChaebun(chLine);
	      String docCh = Chaebun.documentChaebun(chDoc);
	      String eaCh = Chaebun.eaChaebun(chEa);
	      
	      po_team = mr.getParameter("po_team");
	      po_writerno = mr.getParameter(i_no);
	      po_writer = mr.getParameter("po_writer");
	      po_title = mr.getParameter("po_title");
	      po_data = mr.getParameter("po_data");
	      Enumeration file = mr.getFileNames();
	      file1 = (String)file.nextElement();
	      po_attach = mr.getFilesystemName(file1);
	      po_deleteyn = mr.getParameter("po_deleteyn");
	      po_insertdate = mr.getParameter("po_insertdate");
	      po_updatedate = mr.getParameter("po_updatedate");
	      
	      ea_linename = mr.getParameter("ea_linename");
	      ea_line1 = mr.getParameter("ea_line1");
	      ea_line2 = mr.getParameter("ea_line2");
	      ea_line3 = mr.getParameter("ea_line3");
	      
	      
	      logger.info("입력내용" + poCh + " : " + po_team + " : " + po_writerno + " : " + po_writer + " : " 
	    		  	+ po_title + " : " + po_data + " : " + file1 + " : " + po_attach + " : " + po_insertdate);
	      
	      logger.info("입력내용" + lineCh + " : " + ea_linename + " : " + ea_line1 + " : " + ea_line2 + " : " + ea_line3);
	      
//	      logger.info("입력내용" + docCh + " : " + do_type + " : " + do_writerno + " : " + do_writer + " : " + do_title
//	    		  	+ " : " + do_insertdate + " : " + do_deleteyn + " : " + do_lineno + " : " + do_aprno);
//	      
//	      logger.info("입력내용" + eaCh + " : " + ea_docno + " : " + ea_lineno + " : " + ea_stateno + " : " + ea_date);
	      
	      param.setEa_lineno(Chaebun.lineChaebun(chLine));
	      param.setEa_linename(ea_linename);
	      param.setEa_line1(ea_line1);
	      param.setEa_line2(ea_line2);
	      param.setEa_line3(ea_line3);
	      
	      
	      param.setEa_no(Chaebun.eaChaebun(chEa));
	      param.setEa_docno(Chaebun.poomChaebun(chList));
	      param.setEa_aprno(i_no);
	      param.setEa_stateno("71");
	      	      	      
	      param.setDo_docno(Chaebun.poomChaebun(chList));
	      param.setDo_type(ea_linename);
	      param.setDo_writerno(i_no);
	      param.setDo_writer(po_writer);
	      param.setDo_title(po_title);
	      param.setDo_insertdate(po_insertdate);
	      param.setDo_deleteyn(do_deleteyn);
	      param.setDo_aprno(ea_line1);
	      
	      param.setPo_docno(Chaebun.poomChaebun(chList));
	      param.setPo_team(po_team);
	      param.setPo_writerno(i_no);
	      param.setPo_writer(po_writer);
	      param.setPo_title(po_title);
	      param.setPo_data(po_data);
	      param.setPo_attach(po_attach);
	      param.setPo_insertdate(po_insertdate);
	      
	      param.setDo_lineno(Chaebun.lineChaebun(chLine));
	      	      
	      result = eaApprovalService.poomFormInsert(param);
	      result = eaApprovalService.eaLineInsert(param);
	      result = eaApprovalService.eaDocumentInsert(param);
	      result = eaApprovalService.eaEaInsert(param);
	      
	      
	      return "redirect:goEaMain.uni";
	   } //end of poomFormInsert()
	   
	   
	   @RequestMapping("/poDetailSelect")
	   public ModelAndView poDetailSelect(HttpServletRequest req, @ModelAttribute EaPoomVO param){
		   logger.info("poDetailSelect()함수 시작");
		   
		 //품의서 내용 상세조회 
			String do_writerno = (String)req.getSession().getAttribute("i_no");
			param.setDo_writerno(do_writerno);
			List<EaPoomVO> list = eaApprovalService.poDetailSelect(param);

			ModelAndView mav = new ModelAndView();
			mav.addObject("EaPoomVO", list);
			mav.setViewName(CONTEXT_PATH + "/poomDetail");
			return mav;		   
	   }// end	 
	   
	   // 결재할 문서 SELECT
	   @RequestMapping("/poToSelect")
	   public ModelAndView poToSelect(HttpServletRequest req, @ModelAttribute EaPoomVO param){
		   logger.info("컨트롤러 poToSelect()함수 시작");
		   
		   
		   ModelAndView mav = new ModelAndView();
		   String i_no = (String)req.getSession().getAttribute("i_no");
		   EmCommonVO evo = new EmCommonVO();
		   evo.setI_no(i_no);

		   
		   List<EaPoomVO> poom = eaApprovalService.poomSelect(param);
		   List<EaApprovalVO> ea = eaApprovalService.poEaSelect(param);
		   List<EaLineVO> line = eaApprovalService.poLineSelect(param);
		   List<EaDocumentVO> doc = eaApprovalService.poDocumentSelect(param);
		   List<EmCommonVO> signL = eaApprovalService.signSelect(evo);
		   
		   EaPoomVO pvo = null;
		   EaLineVO lvo = null;
		   EaDocumentVO dvo = null;
		   EaApprovalVO avo = null;
		   
		   String sign = "";
		   for(int k=0;k<signL.size();k++){
			   EmCommonVO e = signL.get(k);
			   sign = e.getEm_sign();
		   }
		   if(poom != null && poom.size()>0){
			   for(int i=0; i<poom.size(); i++) {
				   pvo = new EaPoomVO();
				   pvo = poom.get(i);
			   }
		   }
		   if(line != null && line.size()>0){
			   for(int i=0; i<line.size(); i++) {
				   lvo = new EaLineVO();
				   lvo = line.get(i);
			   }
		   }
		   if(doc != null && doc.size()>0){
			   for(int i=0; i<doc.size(); i++) {
				   dvo = new EaDocumentVO();
				   dvo = doc.get(i);
			   }
		   }
		   if(ea != null && ea.size()>0){
			   for(int i=0; i<ea.size(); i++) {
				   avo = new EaApprovalVO();
				   avo = ea.get(i);
			   }
		   }
		   if(true){
			   mav.addObject("EaPoomVO", poom);
			   mav.addObject("EaLineVO", line);
			   mav.addObject("EaDocumentVO", doc);
			   mav.addObject("EaApprovalVO", ea);
			   mav.addObject("sign", sign);
		   }
		   
		   mav.addObject("i_no", i_no);
		   mav.setViewName(CONTEXT_PATH + "/poomDetail");
		      
		   return mav;		   
	   }// end 
	   
		 //파일다운로드
		@RequestMapping(value="/poomDownload")
		public ModelAndView poomDownload(@RequestParam String file){
			logger.info("컨트롤러  poomDownload() 함수 시작 >>> " + file);
				
			ModelAndView mav = new ModelAndView();
			
			if(file != null){
				mav.addObject("file", file);
			}
			mav.setViewName(CONTEXT_PATH + "/eadownload");
				
			return mav;
		}// end
		
		//품의 결재승인
		@RequestMapping(value="/poomSign")
		public String poomSign(HttpServletRequest req, @ModelAttribute EaApprovalVO param){
			logger.info("컨트롤러 poomSign()함수 시작");									
			   
			   
			   int result = eaApprovalService.historyInsert(param);
			   
			   List<EaApprovalVO> eaChList = eaApprovalService.eaChaebun();
			   String eaCh = Chaebun.eaChaebun(eaChList);

			   String ea_aprno = (String)req.getSession().getAttribute("i_no");
			   	   
			   EmCommonVO evo = new EmCommonVO();
			   evo.setI_no(ea_aprno);
			   List<EmCommonVO> signL = eaApprovalService.signSelect(evo);
			   			   
			   String sign = "";
			   for(int k=0;k<signL.size();k++){
				   EmCommonVO e = signL.get(k);
				   sign = e.getEm_sign();
			   }
			   
			   String state = param.getEa_stateno();
			   logger.info("결재상태코드 : " + state);
			   
			   
			   EaDocumentVO dvo = new EaDocumentVO();
			   dvo.setDo_docno(param.getEa_docno());
			   param.setEa_no(eaCh);
			   param.setEa_aprno(ea_aprno);
			   
			   String ea_line2 = "";
			   String ea_line3 = "";
			   
			   if(state.equals("72") || state.equals("73")){
				   List<EaLineVO> nlist = eaApprovalService.nextApr(param);
				   
				   for(int j=0; j<nlist.size(); j++){
					   EaLineVO elvo = nlist.get(j);
					   ea_line2 = elvo.getEa_line2();
					   ea_line3 = elvo.getEa_line3();
				   }
				   System.out.println("다음결재라인 : > " + ea_line2 + ea_line3);
			   }
			   
			   List<EaApprovalVO> sList = eaApprovalService.signHistory(param);
			   String sign1 = "";
			   String sign2 = "";
			   System.out.println("state : >> " + state);
			   if(!state.equals("72")){
				   for(int j=0; j<sList.size(); j++){
					   EaApprovalVO eavo = sList.get(j);
					   if(eavo !=null){
						   sign1 = eavo.getEa_sign1();
						   sign2 = eavo.getEa_sign2();
					   }
					   System.out.println("eavo : >> " + eavo);					   
				   }
			   }			   
			   if(state.equals("72")){
				   param.setEa_sign1(sign);
				   dvo.setDo_aprno(ea_line2);
			   }
			   if(state.equals("73")){
				   param.setEa_sign1(sign1);
				   param.setEa_sign2(sign);
				   dvo.setDo_aprno(ea_line3);
			   }
			   if(state.equals("74")){
				   param.setEa_sign1(sign1);
				   param.setEa_sign2(sign);
				   dvo.setDo_aprno("");
			   }
			   if(state.equals("76")){
				   param.setEa_sign1(sign1);
				   param.setEa_sign2(sign2);
				   param.setEa_sign3(sign);
				   dvo.setDo_aprno("");
			   }
			   if(state.equals("77")){
				   param.setEa_sign1(sign1);
				   param.setEa_sign2(sign2);
				   dvo.setDo_aprno("");
			   }
		
					
//			if(ea_sign1 != null && ea_sign2 != null){
//				ea_sign3 = sign;
//			}
//			if(ea_sign1 != null && ea_sign2 == null){
//				ea_sign2 = sign;
//			}
//			if(ea_sign1 == null && ea_sign2 == null && ea_sign3 == null){
//				ea_sign1 = sign;
//			}
//						
//			if(ea_stateno == "71"){
//				ea_stateno = "72";
//			}
//			if(ea_stateno == "72" && ea_linename == "품의"){
//				ea_stateno = "73";
//			}
//			if(ea_stateno == "72" && ea_linename == "품의전결"){
//				ea_stateno = "74";
//			}
//			if(ea_stateno == "73"){
//				ea_stateno = "76";
//			}
				
				
//			if (ea_aprno == ea_line1){
//				dvo.setDo_aprno(ea_line2);
//			}
//			if (ea_aprno == ea_line2){
//				dvo.setDo_aprno(ea_line3);
//			}
//			if(ea_aprno == ea_line3){
//				dvo.setDo_aprno("");
//			}
				

			
			int result1 = eaApprovalService.poomSign(param);
			int result2 = eaApprovalService.poomSign2(dvo);
			
			
			return "redirect:/ea/goEaMain.uni";
		}// end	
		
		//품의 반려
		@RequestMapping(value="/poomBack")
		public ModelAndView poomBack(HttpServletRequest req, @ModelAttribute EaDocumentVO param){
			logger.info("컨트롤러 poomBack()함수 시작");
			logger.info("컨트롤러 docno" + param.getDo_docno());
			
			
			String i_no = (String)req.getSession().getAttribute("i_no");
			int result = eaApprovalService.poomBack(param);
			int result2 = eaApprovalService.poomBack2(param);
//			String ea_stateno = "";
//			String ea_date = "";
//			
//						
//			param.setEa_stateno(ea_stateno);
//			param.setEa_date(ea_date);
			
			
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("i_no", i_no);
			mav.addObject("result", result);
			mav.addObject("result2", result2);
			mav.setViewName(CONTEXT_PATH + "/eaMain");
			
			return mav;
			
		}// end		
		
		//업로드게시판 인서트
		@RequestMapping("/eaUploadInsert")
		public String eaUploadInsert(HttpServletRequest req, @ModelAttribute EaUploadboardVO param)
				throws ServletException, IOException{
			logger.info("컨트롤러 eaUploadInsert()시작");
			
			req.setCharacterEncoding("UTF-8");
		    String uploadPath = "D:/00.BITCAMP/java142_Luna/.metadata/"
							  	+ ".plugins/org.eclipse.wst.server.core/tmp1/webapps/uploads";
		    int size = 10*1024*1024;
		    int result = 0;	
			
		    String i_no=(String)req.getSession().getAttribute("i_no");
		      			
		    String up_no = "";
		    String up_category = "";
		    String up_title = "";
		    String up_writer = "";
		    String up_content = "";
		    String up_file = "";
		    String file1 = "";
		    String up_insertdate = "";
		    String up_deleteyn = "";
		    
		    List<EaUploadboardVO> chUp = eaApprovalService.uploadChaebun();
		      
		    String upCh = Chaebun.uploadChaebun(chUp);
		      
		    MultipartRequest mr = new MultipartRequest(req, uploadPath, size, "UTF-8"
		    					,new DefaultFileRenamePolicy());
		      
		    
		    up_category = mr.getParameter("up_category");
		    up_title = mr.getParameter("up_title");
		    up_writer = mr.getParameter(i_no);
		    up_content = mr.getParameter("up_content");
		    Enumeration file = mr.getFileNames();
		    file1 = (String)file.nextElement();
		    up_file = mr.getFilesystemName(file1);
		    up_insertdate = mr.getParameter(up_insertdate);
		    up_deleteyn = mr.getParameter(up_deleteyn);
		    
		    param.setUp_no(Chaebun.uploadChaebun(chUp));
		    param.setUp_category(up_category);
		    param.setUp_title(up_title);
		    param.setUp_writer(i_no);
		    param.setUp_content(up_content);
		    param.setUp_file(up_file);
		    
		    result = eaApprovalService.eaUploadInsert(param);

			return "redirect:/ea/goUploadList.uni";
		}// end		
	   
} // end of EaApprovalController

