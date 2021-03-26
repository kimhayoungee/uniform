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

	// �α�
	private Logger logger = Logger.getLogger(BmReplyController.class);
	
	@Autowired
	private BmReplyService bmReplyService;
	
	// �����ü��ȸ ���� ===================================
	@ResponseBody
	@RequestMapping(value="/replyList", produces="application/json; charset=utf-8")
	public List<BmReplyVO> replyList(@ModelAttribute BmReplyVO brvo,
													 Model model){
		logger.info("�����ü��ȸ �Լ� ȣ�� ����!");
		logger.info("������ Ȯ�� >>> bm_no : " + brvo.getBm_no() + ", i_no : " + brvo.getI_no());
		
		// ���ǿ� �´� ��ü��۰���
		int replyTotal = bmReplyService.replyPaging(brvo);
		logger.info("replyTotal : " + replyTotal);
		
		// replyStart, replyEnd, replyPage ����
		PagingUtil.setReplyPage(brvo);
		
		// �۹�ȣ �缳��
		int replyCount = replyTotal - (Integer.parseInt(brvo.getReplyPage())-1)*10;
		logger.info("replyCount : " + replyCount);
		
		List<BmReplyVO> replyList = bmReplyService.replyList(brvo);
		logger.info("��ȸ������ ��� ���� >>> replyListSize : " + replyList.size());

		// ��� ����¡�� ������
		model.addAttribute("curReplyPage", brvo.getReplyPage());
		model.addAttribute("replyTotal", replyTotal);
		model.addAttribute("replyCount", replyCount);
		return replyList;
	} // end of �����ü��ȸ
	
	// ��۾��� ���� ======================================
	@ResponseBody
	@RequestMapping(value="/replyInsert", produces="application/json; charset=utf-8")
	public String replyInsert(@ModelAttribute BmReplyVO brvo){
		logger.info("��۾��� ���� �Լ� ȣ�� ����!");
		logger.info("������ Ȯ�� >>> bm_no : " + brvo.getBm_no() + ", i_no : " + brvo.getI_no());
		
		// ���ä��
		BmReplyVO chaebunVO = bmReplyService.replyNum();
		String bm_reno = ChaebunUtil.bmReplyChaebun(chaebunVO.getBm_reno());
		brvo.setBm_reno(bm_reno);
		
		int nCntReplyInsert = bmReplyService.replyInsert(brvo);

		String insertResult = "";
		
		if(nCntReplyInsert == 1){
			logger.info("��۵�� ���� >>> nCntReplyInsert : " + nCntReplyInsert);
			insertResult = "����� ��ϵǾ����ϴ�.";
		}else{
			logger.info("��۵�� ���� >>> nCntReplyInsert : " + nCntReplyInsert);
			insertResult = "��۵�Ͽ� �����߽��ϴ�.";
		}
		
		return insertResult;
	}
	// ��ۼ��� ���� ======================================
	@ResponseBody
	@RequestMapping(value="/replyUpdate",produces="application/json; charset=utf-8")
	public String replyUpdate(@ModelAttribute BmReplyVO brvo){
		logger.info("��ۼ��� ���� �Լ� ȣ�� ����!");
		
		int nCntReplyUpdate = bmReplyService.replyUpdate(brvo);
		String updateResult = "";
		
		if(nCntReplyUpdate==1){
			logger.info("��ۼ��� ���� >>> nCntReplyUpdate : " + nCntReplyUpdate);
			updateResult = "����� �����Ǿ����ϴ�.";
		}else{
			logger.info("��ۼ��� ���� >>> nCntReplyUpdate : " + nCntReplyUpdate);
			updateResult = "��ۼ����� �����߽��ϴ�.";
		}
		return updateResult;
	}
	
	// ��ۻ��� ���� ======================================
	@ResponseBody
	@RequestMapping(value="/replyDelete",produces="application/json; charset=utf-8")
	public String replyDelete(@ModelAttribute BmReplyVO brvo){
		logger.info("��ۻ��� ���� �Լ� ȣ�� ����!");
		
		int nCntReplyDelete = bmReplyService.replyDelete(brvo);
		String deleteResult = "";
		
		if(nCntReplyDelete==1){
			logger.info("��ۻ��� ���� >>> nCntReplyDelete : " + nCntReplyDelete);
			deleteResult = "����� �����Ǿ����ϴ�.";
		}else{
			logger.info("��ۻ��� ���� >>> nCntReplyDelete : " + nCntReplyDelete);
			deleteResult = "��ۻ����� �����߽��ϴ�.";
		}
		return deleteResult;
	}	
	// ���total ======================================
	
} // end of BmReplyController
