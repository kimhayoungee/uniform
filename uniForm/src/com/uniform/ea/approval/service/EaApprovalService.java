package com.uniform.ea.approval.service;

import java.util.List;

import com.uniform.common.info.vo.CommonCodeVO;
import com.uniform.common.info.vo.CommonInfoVO;
import com.uniform.ea.approval.vo.EaApprovalVO;
import com.uniform.ea.approval.vo.EaDocumentVO;
import com.uniform.ea.approval.vo.EaGianVO;
import com.uniform.ea.approval.vo.EaLineVO;
import com.uniform.ea.approval.vo.EaPoomVO;
import com.uniform.ea.approval.vo.EaUploadboardVO;
import com.uniform.ea.approval.vo.EaVacationVO;
import com.uniform.ea.approval.vo.PageVO;
import com.uniform.ea.approval.vo.UploadPageVO;
import com.uniform.em.common.vo.EmCommonVO;

public interface EaApprovalService {

	//문서함 결재중
	public List<PageVO> eaIngSelect(PageVO param);		
	
	//문서함 결재할
	public List<PageVO> toApSelect(PageVO param);
	
	//문서함 반려함
	public List<PageVO> returnSelect(PageVO param);
	
	//문서함 완료함
	public List<PageVO> finSelect(PageVO param);

	//문서함 결재한
	public List<PageVO> edSelect(PageVO param);
	
	//오늘 날짜 조회
	public String today();

	//작성자 팀, 이름 조회
	public List<EmCommonVO> writerSelect(CommonInfoVO param);
	
	//총장 조회
	public List<CommonInfoVO> presidentSelect();
	
	//처 조회
	public List<CommonCodeVO> deptSelect();
	
	//처장 조회
	public List<CommonInfoVO> deptLeaderSelect(CommonCodeVO param);

	//팀 조회
	public List<CommonCodeVO> teamSelect(CommonCodeVO param);
	
	//팀장 조회
	public List<CommonInfoVO> teamLeaderSelect(CommonCodeVO param);
	
	//기안서 채번
	public List<EaGianVO> gianChaebun();

	//결재선 채번
	public List<EaLineVO> lineChaebun();

	//결재 채번
	public List<EaApprovalVO> eaChaebun();
	
	//기안서 작성, 기안테이블
	public int gianInsert(EaGianVO param);

	//문서 작성, 결재선테이블
	public int lineInsert(EaLineVO param);
	
	//문서 작성, 문서테이블
	public int documentInsert(EaDocumentVO param);
	
	//문서 작성, 결재테이블 
	public int ea1Insert(EaApprovalVO param);
	
	//문서 삭제
	public int docDelete(EaDocumentVO param);
	
	//히스토리 insert
	public int historyInsert(EaApprovalVO param);
	
	//서명 조회
	public List<EmCommonVO> signSelect(EmCommonVO param);
		
	//다음결재자 조회
	public List<EaLineVO> nextApr(EaApprovalVO param);

	//서명 히스토리 조회
	public List<EaApprovalVO> signHistory(EaApprovalVO param);	
	
	//결재 update
	public int eaUpdate(EaApprovalVO param);
	
	//다음결재자 update
	public int aprUpdate(EaDocumentVO param);
	
	//기안서내용 상세조회
	public List<EaGianVO> giDetailSelect(EaDocumentVO param);
	
	//문서 결재내용(의견) 상세조회
	public List<EaApprovalVO> detailEaSelect(EaDocumentVO param);
	
	//의견 history
	public List<EaApprovalVO> historyComment(EaDocumentVO param);
	
	//휴가계 시작
	//휴가계 채번
	public List<EaVacationVO> vacaChaebun();	
	
	//휴가계 작성, 휴가테이블 insert
	public int vacaInsert(EaVacationVO param);	

	//휴가계 내용 상세조회
	public List<EaVacationVO> vaDetailSelect(EaDocumentVO param);	
	
	
	public List<EaPoomVO> poDetailSelect(EaDocumentVO param);
	public List<UploadPageVO> uploadSelect (UploadPageVO param);
	public List<EaUploadboardVO> uploadSelectOne (EaUploadboardVO param);
	public List<CommonInfoVO> eaLine(CommonInfoVO cvo);
	public List<EaPoomVO> poomChaebun();
	public List<EaDocumentVO> documentChaebun();
	public int poomFormInsert(EaPoomVO pvo);
	public int eaLineInsert(EaLineVO lvo);
	public int eaDocumentInsert(EaDocumentVO dvo);
	public int eaEaInsert(EaApprovalVO evo);
	public List<EaPoomVO> poomSelect(EaPoomVO param);
	public List<EaApprovalVO> poEaSelect(EaApprovalVO param);
	public List<EaLineVO> poLineSelect(EaLineVO param);
	public List<EaDocumentVO> poDocumentSelect(EaDocumentVO param);
	public int poomSign(EaApprovalVO param);
	public int poomSign2(EaApprovalVO param);
	public int poomBack(EaApprovalVO param);
	public int poomBack2(EaApprovalVO param);
	public List<EaUploadboardVO> uploadChaebun();
	public int eaUploadInsert(EaUploadboardVO param);
	
} //end of EaApprovalService class
