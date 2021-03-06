package com.uniform.ea.approval.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uniform.common.info.vo.CommonCodeVO;
import com.uniform.common.info.vo.CommonInfoVO;
import com.uniform.ea.approval.dao.EaApprovalDao;
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

@Service
@Transactional
public class EaApprovalServiceImpl implements EaApprovalService {
	Logger logger = Logger.getLogger(EaApprovalServiceImpl.class);
	
	@Autowired
	private EaApprovalDao eaApprovalDao;

	//문서함 결재중
	public List<PageVO> eaIngSelect(PageVO param){
		logger.info("서비스 eaIngSelect(param)함수 시작");
		List<PageVO> list = eaApprovalDao.eaIngSelect(param);
		return list;
	}
	
	//문서함 결재할
	public List<PageVO> toApSelect(PageVO param){
		logger.info("서비스 toApSelect(param)함수 시작");
		List<PageVO> list = eaApprovalDao.toApSelect(param);
		return list;
	}
	
	//문서함 반려함
	public List<PageVO> returnSelect(PageVO param){
		logger.info("서비스 returnSelect(param)함수 시작");
		List<PageVO> list = eaApprovalDao.returnSelect(param);
		return list;
	}
	
	//문서함 완료함
	public List<PageVO> finSelect(PageVO param){
		logger.info("서비스 finSelect(param)함수 시작");
		List<PageVO> list = eaApprovalDao.finSelect(param);
		return list;
	}

	//문서함 결재한
	public List<PageVO> edSelect(PageVO param){
		logger.info("서비스 edSelect(param)함수 시작");
		List<PageVO> list = eaApprovalDao.edSelect(param);
		return list;
	}	
	
	//오늘 날짜 조회
	public String today(){
		String today = eaApprovalDao.today();
		return today;
	}

	//작성자 팀, 이름 조회
	public List<EmCommonVO> writerSelect(CommonInfoVO param){
		logger.info("서비스 writerSelect(param)함수 시작");
		List<EmCommonVO> list = eaApprovalDao.writerSelect(param);
		return list;
	}
	
	//총장 조회
	public List<CommonInfoVO> presidentSelect(){
		List<CommonInfoVO> list = eaApprovalDao.presidentSelect();
		return list;
	}
	
	//처 조회
	public List<CommonCodeVO> deptSelect(){
		List<CommonCodeVO> list = eaApprovalDao.deptSelect();
		return list;
	}
	
	//처장 조회
	public List<CommonInfoVO> deptLeaderSelect(CommonCodeVO param){
		List<CommonInfoVO> list = eaApprovalDao.deptLeaderSelect(param);
		return list;
	}
	
	//팀 조회
	public List<CommonCodeVO> teamSelect(CommonCodeVO param){
		List<CommonCodeVO> list = eaApprovalDao.teamSelect(param);
		return list;
	}
	
	//팀장 조회
	public List<CommonInfoVO> teamLeaderSelect(CommonCodeVO param){
		List<CommonInfoVO> list = eaApprovalDao.teamLeaderSelect(param);
		return list;
	}
	
	//기안서 채번
	public List<EaGianVO> gianChaebun(){
		logger.info("서비스 gianChaebun()함수 시작");
		List<EaGianVO> list = eaApprovalDao.gianChaebun();
		return list;
	}
	
	//결재선 채번
	public List<EaLineVO> lineChaebun(){
		logger.info("서비스 lineChaebun()함수 시작");
		List<EaLineVO> list = eaApprovalDao.lineChaebun();
		return list;
	}	

	//결재 채번
	public List<EaApprovalVO> eaChaebun(){
		logger.info("서비스 eaChaebun()함수 시작");
		List<EaApprovalVO> list = eaApprovalDao.eaChaebun();
		return list;
	}
	
	//기안서 작성, 기안테이블
	public int gianInsert(EaGianVO param){
		logger.info("서비스 gianInsert(param)함수 시작");
		int result = eaApprovalDao.gianInsert(param);
		return result;
	}

	//문서 작성, 결재선테이블
	public int lineInsert(EaLineVO param){
		logger.info("서비스 lineInsert(param)함수 시작");
		int result = eaApprovalDao.lineInsert(param);
		return result;
	}
	
	//문서 작성, 문서테이블
	public int documentInsert(EaDocumentVO param){
		logger.info("서비스 documentInsert(param)함수 시작");
		int result = eaApprovalDao.documentInsert(param);
		return result;
	}
	
	//문서 작성, 결재테이블 
	public int ea1Insert(EaApprovalVO param){
		logger.info("서비스 ea1Insert(param)함수 시작");
		int result = eaApprovalDao.ea1Insert(param);
		return result;
	}
	
	//문서 삭제
	public int docDelete(EaDocumentVO param){
		logger.info("서비스 docDelete(param)함수 시작");
		int result = eaApprovalDao.docDelete(param);
		return result;
	}	
	
	//히스토리 insert
	public int historyInsert(EaApprovalVO param){
		logger.info("서비스 historyInsert(param)함수 시작");
		int result = eaApprovalDao.historyInsert(param);
		return result;
	}
	
	//서명 조회
	public List<EmCommonVO> signSelect(EmCommonVO param){
		logger.info("서비스 signSelect(param)함수 시작");
		List<EmCommonVO> list = eaApprovalDao.signSelect(param);
		return list;
	}
	
	//다음결재자 조회
	public List<EaLineVO> nextApr(EaApprovalVO param){
		logger.info("서비스 nextApr(param)함수 시작");
		List<EaLineVO> list = eaApprovalDao.nextApr(param);
		return list;
	}

	//서명 히스토리 조회
	public List<EaApprovalVO> signHistory(EaApprovalVO param){
		logger.info("서비스 signHistory(param)함수 시작");
		List<EaApprovalVO> list = eaApprovalDao.signHistory(param);
		return list;
	}	
	
	//결재 update
	public int eaUpdate(EaApprovalVO param){
		logger.info("서비스 eaUpdate(param)함수 시작");
		int result = eaApprovalDao.eaUpdate(param);
		return result;
	}
	
	//다음결재자 update
	public int aprUpdate(EaDocumentVO param){
		logger.info("서비스 aprUpdate(param)함수 시작");
		int result = eaApprovalDao.aprUpdate(param);
		return result;
	}
	
	//기안서내용 상세조회
	public List<EaGianVO> giDetailSelect(EaDocumentVO param){
		logger.info("서비스 giDetailSelect(param)함수 시작");
		List<EaGianVO> list = eaApprovalDao.giDetailSelect(param);
		return list;
	}
	
	//문서 결재내용(의견) 상세조회
	public List<EaApprovalVO> detailEaSelect(EaDocumentVO param){
		logger.info("서비스 detailEaSelect(param)함수 시작");
		List<EaApprovalVO> list = eaApprovalDao.detailEaSelect(param);
		return list;
	}
		
	//의견 history
	public List<EaApprovalVO> historyComment(EaDocumentVO param){
		logger.info("서비스 historyComment(param)함수 시작");
		List<EaApprovalVO> list = eaApprovalDao.historyComment(param);
		return list;
	}
	
	//휴가계 시작
	//휴가계 채번
	public List<EaVacationVO> vacaChaebun(){
		logger.info("서비스 vacaChaebun()함수 시작");
		List<EaVacationVO> list = eaApprovalDao.vacaChaebun();
		return list;		
	}	
	
	//휴가계 작성, 휴가테이블 insert
	public int vacaInsert(EaVacationVO param){
		logger.info("서비스 vacaInsert(param)함수 시작");
		int result = eaApprovalDao.vacaInsert(param);
		return result;
	}
	
	//휴가계 내용 상세조회
	public List<EaVacationVO> vaDetailSelect(EaDocumentVO param){
		logger.info("서비스 vaDetailSelect(param)함수 시작");
		List<EaVacationVO> list = eaApprovalDao.vaDetailSelect(param);
		return list;
	}

	@Override
	public List<UploadPageVO> uploadSelect(UploadPageVO param) {
		// TODO Auto-generated method stub
		logger.info("서비스 uploadSelect()함수 시작");
		List<UploadPageVO> list = eaApprovalDao.uploadSelect(param);
		return list;
	}	// end

	@Override
	public List<EaUploadboardVO> uploadSelectOne(EaUploadboardVO param) {
		// TODO Auto-generated method stub
		logger.info("서비스 uploadSelectOne()함수 시작");
		List<EaUploadboardVO> list = eaApprovalDao.uploadSelectOne(param);
		return list;
	}// end

	@Override
	public List<CommonInfoVO> eaLine(CommonInfoVO cvo) {
		// TODO Auto-generated method stub
		logger.info("서비스 eaList()함수 시작");
		List<CommonInfoVO> list = eaApprovalDao.eaLine(cvo);
		return list;
	}

	@Override
	public List<EaPoomVO> poomChaebun() {
		// TODO Auto-generated method stub
		logger.info("서비스 poomChaebun()함수 시작");
	    List<EaPoomVO> list = eaApprovalDao.poomChaebun();
	    return list;
	}// end

	@Override
	public List<EaDocumentVO> documentChaebun() {
		// TODO Auto-generated method stub
		logger.info("서비스 documentChaebun()함수 시작");
		List<EaDocumentVO> list = eaApprovalDao.documentChaebun();
		return list;
	}// end

	@Override
	public int poomFormInsert(EaPoomVO pvo) {
		// TODO Auto-generated method stub
		logger.info("서비스 poomFormInsert()함수 시작");
		return eaApprovalDao.poomFormInsert(pvo);
	}// end

	@Override
	public int eaLineInsert(EaLineVO lvo) {
		// TODO Auto-generated method stub
		logger.info("서비스 eaLineInsert()함수 시작");
		return eaApprovalDao.eaLineInsert(lvo);
	}// end

	@Override
	public int eaDocumentInsert(EaDocumentVO dvo) {
		// TODO Auto-generated method stub
		logger.info("서비스 eaDocumentInsert()함수 시작");		
		return eaApprovalDao.eaDocumentInsert(dvo);
	}// end

	@Override
	public int eaEaInsert(EaApprovalVO evo) {
		// TODO Auto-generated method stub
		logger.info("서비스 eaEaInsert()함수 시작");
		return eaApprovalDao.eaEaInsert(evo);
	}// end

	@Override
	public List<EaPoomVO> poomSelect(EaPoomVO param) {
		// TODO Auto-generated method stub
		logger.info("서비스 poomSelect()함수 시작");
		List<EaPoomVO> list = eaApprovalDao.poomSelect(param);
		return list;
	}// end

	@Override
	public List<EaApprovalVO> poEaSelect(EaApprovalVO param) {
		// TODO Auto-generated method stub
		logger.info("서비스 poEaSelect()함수 시작");
		List<EaApprovalVO> list = eaApprovalDao.poEaSelect(param);
		return list;
	}// end

	@Override
	public List<EaLineVO> poLineSelect(EaLineVO param) {
		// TODO Auto-generated method stub
		logger.info("서비스 poLineSelect()함수 시작");
		List<EaLineVO> list = eaApprovalDao.poLineSelect(param);
		return list;
	}// end

	@Override
	public List<EaDocumentVO> poDocumentSelect(EaDocumentVO param) {
		// TODO Auto-generated method stub
		logger.info("서비스 poDocumentSelect()함수 시작");
		List<EaDocumentVO> list = eaApprovalDao.poDocumentSelect(param);
		return list;
	}

	@Override
	public int poomSign(EaApprovalVO param) {
		// TODO Auto-generated method stub
		logger.info("서비스 poomSign()함수 시작");
		return eaApprovalDao.poomSign(param);
	}

	@Override
	public int poomSign2(EaApprovalVO param) {
		// TODO Auto-generated method stub
		logger.info("서비스 poomSign2()함수 시작");
		return eaApprovalDao.poomSign2(param);
	}

	@Override
	public int poomBack(EaApprovalVO param) {
		// TODO Auto-generated method stub
		logger.info("서비스 poomBack()함수 시작");
		return eaApprovalDao.poomBack(param);
	}

	@Override
	public int poomBack2(EaApprovalVO param) {
		// TODO Auto-generated method stub
		logger.info("서비스 poomBack2()함수 시작");
		return eaApprovalDao.poomBack2(param);
	}

	@Override
	public List<EaUploadboardVO> uploadChaebun() {
		// TODO Auto-generated method stub
		logger.info("서비스 uploadChaebun()함수 시작");
		List<EaUploadboardVO> list = eaApprovalDao.uploadChaebun();
		return list;
	}

	@Override
	public int eaUploadInsert(EaUploadboardVO param) {
		// TODO Auto-generated method stub
		logger.info("서비스 eaUploadInsert()함수 시작");
		return eaApprovalDao.eaUploadInsert(param);
	}

	@Override
	public List<EaPoomVO> poDetailSelect(EaDocumentVO param) {
		// TODO Auto-generated method stub
		return eaApprovalDao.poDetailSelect(param);
	}
	
} //end of EaApprovalServiceImpl class
