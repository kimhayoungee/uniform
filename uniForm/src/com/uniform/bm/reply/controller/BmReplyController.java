package com.uniform.bm.reply.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uniform.bm.reply.service.BmReplyService;
import com.uniform.bm.reply.vo.BmReplyVO;
import com.uniform.common.utils.ChaebunUtil;
import com.uniform.common.utils.PagingUtil;

@Controller
@RequestMapping(value="/reply")
public class BmReplyController {

	// 로그
	private Logger logger = Logger.getLogger(BmReplyController.class);
	
	@Autowired
	private BmReplyService bmReplyService;
	
	// 댓글전체조회 구현 ===================================
	@ResponseBody
	@RequestMapping(value="/replyList", produces="application/json; charset=utf-8")
	public List<BmReplyVO> replyList(@ModelAttribute BmReplyVO brvo,
													 Model model){
		logger.info("댓글전체조회 함수 호출 성공!");
		logger.info("데이터 확인 >>> bm_no : " + brvo.getBm_no() + ", i_no : " + brvo.getI_no());
		
		// 조건에 맞는 전체댓글갯수
		int replyTotal = bmReplyService.replyPaging(brvo);
		logger.info("replyTotal : " + replyTotal);
		
		// replyStart, replyEnd, replyPage 셋팅
		PagingUtil.setReplyPage(brvo);
		
		// 글번호 재설정
		int replyCount = replyTotal - (Integer.parseInt(brvo.getReplyPage())-1)*10;
		logger.info("replyCount : " + replyCount);
		
		List<BmReplyVO> replyList = bmReplyService.replyList(brvo);
		logger.info("조회성공한 댓글 갯수 >>> replyListSize : " + replyList.size());

		// 댓글 페이징용 데이터
		model.addAttribute("curReplyPage", brvo.getReplyPage());
		model.addAttribute("replyTotal", replyTotal);
		model.addAttribute("replyCount", replyCount);
		return replyList;
	} // end of 댓글전체조회
	
	// 댓글쓰기 구현 ======================================
	@ResponseBody
	@RequestMapping(value="/replyInsert", produces="application/json; charset=utf-8")
	public String replyInsert(@ModelAttribute BmReplyVO brvo){
		logger.info("댓글쓰기 구현 함수 호출 성공!");
		logger.info("데이터 확인 >>> bm_no : " + brvo.getBm_no() + ", i_no : " + brvo.getI_no());
		
		// 댓글채번
		BmReplyVO chaebunVO = bmReplyService.replyNum();
		String bm_reno = ChaebunUtil.bmReplyChaebun(chaebunVO.getBm_reno());
		brvo.setBm_reno(bm_reno);
		
		int nCntReplyInsert = bmReplyService.replyInsert(brvo);

		String insertResult = "";
		
		if(nCntReplyInsert == 1){
			logger.info("댓글등록 성공 >>> nCntReplyInsert : " + nCntReplyInsert);
			insertResult = "댓글이 등록되었습니다.";
		}else{
			logger.info("댓글등록 실패 >>> nCntReplyInsert : " + nCntReplyInsert);
			insertResult = "댓글등록에 실패했습니다.";
		}
		
		return insertResult;
	}
	// 댓글수정 구현 ======================================
	@ResponseBody
	@RequestMapping(value="/replyUpdate",produces="application/json; charset=utf-8")
	public String replyUpdate(@ModelAttribute BmReplyVO brvo){
		logger.info("댓글수정 구현 함수 호출 성공!");
		
		int nCntReplyUpdate = bmReplyService.replyUpdate(brvo);
		String updateResult = "";
		
		if(nCntReplyUpdate==1){
			logger.info("댓글수정 성공 >>> nCntReplyUpdate : " + nCntReplyUpdate);
			updateResult = "댓글이 수정되었습니다.";
		}else{
			logger.info("댓글수정 실패 >>> nCntReplyUpdate : " + nCntReplyUpdate);
			updateResult = "댓글수정에 실패했습니다.";
		}
		return updateResult;
	}
	
	// 댓글삭제 구현 ======================================
	@ResponseBody
	@RequestMapping(value="/replyDelete",produces="application/json; charset=utf-8")
	public String replyDelete(@ModelAttribute BmReplyVO brvo){
		logger.info("댓글삭제 구현 함수 호출 성공!");
		
		int nCntReplyDelete = bmReplyService.replyDelete(brvo);
		String deleteResult = "";
		
		if(nCntReplyDelete==1){
			logger.info("댓글삭제 성공 >>> nCntReplyDelete : " + nCntReplyDelete);
			deleteResult = "댓글이 삭제되었습니다.";
		}else{
			logger.info("댓글삭제 실패 >>> nCntReplyDelete : " + nCntReplyDelete);
			deleteResult = "댓글삭제에 실패했습니다.";
		}
		return deleteResult;
	}	
	// 댓글total ======================================
	
} // end of BmReplyController
