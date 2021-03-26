package com.uniform.common.utils;

import org.apache.log4j.Logger;

import com.uniform.bm.board.vo.BmBoardVO;
import com.uniform.bm.reply.vo.BmReplyVO;
import com.uniform.nm.notice.vo.NmNoticeVO;

public class PagingUtil {

	// 로그
	static Logger logger = Logger.getLogger(PagingUtil.class);
	
	public static void setPage(BmBoardVO bbvo){
		logger.info("페이지에 보여질 행의 시작과 끝을 뽑는 class");
		
		int page = 0;
		int pageSize = 10;
		
		logger.info(bbvo.getPage());
		
		if(bbvo.getPage()==null||bbvo.getPage().equals("null")||bbvo.getPage()==""||bbvo.getPage().indexOf("un")>-1){
			page = 1;
			bbvo.setPage("1");
		}else{
			page = Integer.parseInt(bbvo.getPage());
		}
		
		int start = (page-1)*pageSize + 1;
		int end = (page-1)*pageSize+pageSize;
		
		bbvo.setStart(start + "");
		bbvo.setEnd(end + "");
		
		logger.info("PagingUtil class 끝");
	}// end of setPage
	
	public static void setReplyPage(BmReplyVO brvo){
		logger.info("댓글페이지에 보여질 행의 시작과 끝을 뽑는 class");
		
		int replyPage = 0;
		int replyPageSize = 20;
		
		logger.info(brvo.getReplyPage());
		
		if(brvo.getReplyPage()==null||brvo.getReplyPage().equals("null")||brvo.getReplyPage()==""||brvo.getReplyPage().indexOf("un")>-1){
			replyPage = 1;
			brvo.setReplyPage("1");
		}else{
			replyPage = Integer.parseInt(brvo.getReplyPage());
		}
		
		int replyStart = (replyPage-1)*replyPageSize + 1;
		int replyEnd = (replyPage-1)*replyPageSize+replyPageSize;
		
		brvo.setReplyStart(replyStart + "");
		brvo.setReplyEnd(replyEnd + "");
		
		logger.info("setReplyPage class 끝");
	}// end of setPage
	
	public static void setPageN(NmNoticeVO nnvo){
		logger.info("페이지에 보여질 행의 시작과 끝을 뽑는 class");
		
		int page = 0;
		int pageSize = 10;
		
		logger.info(nnvo.getPage());
		
		if(nnvo.getPage()==null||nnvo.getPage().equals("null")||nnvo.getPage()==""||nnvo.getPage().indexOf("un")>-1){
			page = 1;
			nnvo.setPage("1");
		}else{
			page = Integer.parseInt(nnvo.getPage());
		}
		
		int start = (page-1)*pageSize + 1;
		int end = (page-1)*pageSize+pageSize;
		
		nnvo.setStart(start + "");
		nnvo.setEnd(end + "");
		
		logger.info("PagingUtil class 끝");
	}// end of setPage
}
