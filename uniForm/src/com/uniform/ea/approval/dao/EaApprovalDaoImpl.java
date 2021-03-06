package com.uniform.ea.approval.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

@Repository
public class EaApprovalDaoImpl implements EaApprovalDao {
	Logger logger = Logger.getLogger(EaApprovalDaoImpl.class);
	
	@Autowired
	private SqlSession session;
	
	//문서함 결재중
	public List<PageVO> eaIngSelect(PageVO param){
		logger.info("다오 eaIngSelect(param)함수 시작");
		return session.selectList("eaIngSelect");
	}
	
	//문서함 결재할
	public List<PageVO> toApSelect(PageVO param){
		logger.info("다오 toAprSelect(param)함수 시작");
		return session.selectList("toApSelect");
	}
	
	//문서함 반려함
	public List<PageVO> returnSelect(PageVO param){
		logger.info("다오 toAprSelect(param)함수 시작");
		return session.selectList("returnSelect");
	}
	
	//문서함 완료함
	public List<PageVO> finSelect(PageVO param){
		logger.info("다오 toAprSelect(param)함수 시작");
		return session.selectList("finSelect");
	}
	
	//문서함 결재한
	public List<PageVO> edSelect(PageVO param){
		logger.info("다오 edSelect(param)함수 시작");
		return session.selectList("edSelect");
	}
	
	//오늘 날짜 조회
	public String today(){
		return session.selectOne("today");
	}
	
	//작성자 팀, 이름 조회
	public List<EmCommonVO> writerSelect(CommonInfoVO param){
		logger.info("다오 writerSelect(param)함수 시작");
		return session.selectOne("writerSelect");
	}
	
	//총장 조회
	public List<CommonInfoVO> presidentSelect(){
		return session.selectOne("presidentSelect");
	}
	
	//처 조회
	public List<CommonCodeVO> deptSelect(){
		return session.selectList("deptSelect");
	}
	
	//처장 조회
	public List<CommonInfoVO> deptLeaderSelect(CommonCodeVO param){
		return session.selectOne("deptLeaderSelect");
	}
	
	//팀 조회
	public List<CommonCodeVO> teamSelect(CommonCodeVO param){
		return session.selectList("teamSelect");
	}
	
	//팀장 조회
	public List<CommonInfoVO> teamLeaderSelect(CommonCodeVO param){
		return session.selectOne("teamLeaderSelect");
	}
	
	//기안서 채번
	public List<EaGianVO> gianChaebun(){
		logger.info("다오 gianChaebun()함수 시작");
		return session.selectOne("gianChaebun");
	}
	
	//결재선 채번
	public List<EaLineVO> lineChaebun(){
		logger.info("다오 lineChaebun()함수 시작");
		return session.selectOne("lineChaebun");
	}
	
	//결재 채번
	public List<EaApprovalVO> eaChaebun(){
		logger.info("다오 eaChaebun()함수 시작");
		return session.selectOne("eaChaebun");
	}
	
	//기안서 작성, 기안테이블
	public int gianInsert(EaGianVO param){
		logger.info("다오 gianInsert()함수 시작");
		return session.insert("gianInsert");
	}
	
	//문서 작성, 결재선테이블
	public int lineInsert(EaLineVO param){
		logger.info("다오 lineInsert()함수 시작");
		return session.insert("lineInsert");
	}
	
	//문서 작성, 문서테이블
	public int documentInsert(EaDocumentVO param){
		logger.info("다오 documentInsert()함수 시작");
		return session.insert("documentInsert");
	}
	
	//문서 작성, 결재테이블 
	public int ea1Insert(EaApprovalVO param){
		logger.info("다오 ea1Insert()함수 시작");
		return session.insert("ea1Insert");
	}
	
	//문서 삭제
	public int docDelete(EaDocumentVO param){
		logger.info("다오 docDelete(param)함수 시작");
		return session.update("docDelete");
	}	

	//히스토리 insert
	public int historyInsert(EaApprovalVO param){
		logger.info("다오 historyInsert(param)함수 시작");
		return session.insert("historyInsert");
	}
	
	//서명 조회
	public List<EmCommonVO> signSelect(EmCommonVO param){
		logger.info("다오 signSelect(param)함수 시작");
		return session.selectOne("signSelect");
	}
	
	//다음결재자 조회
	public List<EaLineVO> nextApr(EaApprovalVO param){
		logger.info("다오 nextApr(param)함수 시작");
		return session.selectOne("nextApr");
	}

	//서명 히스토리 조회
	public List<EaApprovalVO> signHistory(EaApprovalVO param){
		logger.info("다오 signHistory(param)함수 시작");
		return session.selectOne("signHistory");
	}	
	
	//결재 update
	public int eaUpdate(EaApprovalVO param){
		logger.info("다오 eaUpdate(param)함수 시작");	
		return session.update("eaUpdate");
	}
	
	//다음결재자 update
	public int aprUpdate(EaDocumentVO param){
		logger.info("다오 aprUpdate(param)함수 시작");	
		return session.update("aprUpdate");
	}
	
	//기안서 내용 상세조회
	public List<EaGianVO> giDetailSelect(EaDocumentVO param){
		logger.info("다오 giDetailSelect(param)함수 시작");
		return session.selectOne("giDetailSelect");
	}
	
	//문서 결재내용(의견) 상세조회
	public List<EaApprovalVO> detailEaSelect(EaDocumentVO param){
		logger.info("다오 detailEaSelect(param)함수 시작");
		return session.selectOne("detailEaSelect");
	}
	
	//의견 history
	public List<EaApprovalVO> historyComment(EaDocumentVO param){
		logger.info("다오 historyComment(param)함수 시작");
		return session.selectList("historyComment");
	}
	
	//휴가계 시작
	//휴가계 채번
	public List<EaVacationVO> vacaChaebun(){
		logger.info("다오 vacaChaebun()함수 시작");
		return session.selectOne("vacaChaebun");
	}	

	//휴가계 작성, 휴가테이블 insert
	public int vacaInsert(EaVacationVO param){
		logger.info("다오 vacaInsert(param)함수 시작");
		return session.insert("vacaInsert");
	}	

	//휴가계 내용 상세조회
	public List<EaVacationVO> vaDetailSelect(EaDocumentVO param){
		logger.info("다오 vaDetailSelect(param)함수 시작");
		return session.selectOne("vaDetailSelect");
	}

	@Override
	public List<UploadPageVO> uploadSelect(UploadPageVO param) {
		// TODO Auto-generated method stub
		return session.selectList("uploadSelect");
	}

	@Override
	public List<EaUploadboardVO> uploadSelectOne(EaUploadboardVO param) {
		// TODO Auto-generated method stub
		return session.selectList("uploadSelectOne");
	}

	@Override
	public List<CommonInfoVO> eaLine(CommonInfoVO cvo) {
		// TODO Auto-generated method stub
		return session.selectList("eaLine");
	}// end

	@Override
	public List<EaPoomVO> poomChaebun() {
		// TODO Auto-generated method stub
	     return session.selectOne("poomChaebun");
	}// end

	@Override
	public List<EaDocumentVO> documentChaebun() {
		// TODO Auto-generated method stub
		return session.selectOne("documentChaebun");
	}// end

	@Override
	public int poomFormInsert(EaPoomVO pvo) {
		// TODO Auto-generated method stub
		return session.insert("PoomFormInsert");
	}// end

	@Override
	public int eaLineInsert(EaLineVO lvo) {
		// TODO Auto-generated method stub
		return session.insert("PoomFormInsert");
	}// end

	@Override
	public int eaDocumentInsert(EaDocumentVO dvo) {
		// TODO Auto-generated method stub
		return session.insert("PoomFormInsert");
	}

	@Override
	public int eaEaInsert(EaApprovalVO evo) {
		// TODO Auto-generated method stub
		return session.insert("PoomFormInsert");
	}// end

	@Override
	public List<EaPoomVO> poomSelect(EaPoomVO param) {
		// TODO Auto-generated method stub
		return session.selectList("poomSelect");
	}// end

	@Override
	public List<EaApprovalVO> poEaSelect(EaApprovalVO param) {
		// TODO Auto-generated method stub
		return session.selectList("poEaSelect");
	}// end

	@Override
	public List<EaLineVO> poLineSelect(EaLineVO param) {
		// TODO Auto-generated method stub
		return session.selectList("poLineSelect");
	}// end

	@Override
	public List<EaDocumentVO> poDocumentSelect(EaDocumentVO param) {
		// TODO Auto-generated method stub
		return session.selectList("poDocumentSelect");
	}

	@Override
	public int poomSign(EaApprovalVO param) {
		// TODO Auto-generated method stub
		return session.update("poomSign");
	}

	@Override
	public int poomSign2(EaApprovalVO param) {
		// TODO Auto-generated method stub
		return session.update("poomSign2");
	}

	@Override
	public int poomBack(EaApprovalVO param) {
		// TODO Auto-generated method stub
		return session.update("poomBack");
	}

	@Override
	public int poomBack2(EaApprovalVO param) {
		// TODO Auto-generated method stub
		return session.update("poomBack2");
	}

	@Override
	public List<EaUploadboardVO> uploadChaebun() {
		// TODO Auto-generated method stub
		return session.selectOne("uploadChaebun");
	}

	@Override
	public int eaUploadInsert(EaUploadboardVO param) {
		// TODO Auto-generated method stub
		return session.insert("eaUploadInsert");
	}// end

	@Override
	public List<EaPoomVO> poDetailSelect(EaDocumentVO param) {
		// TODO Auto-generated method stub
		return session.selectList("poDetailSelect");
	}
	
	
} //end of EaApprovalDaoImpl class
