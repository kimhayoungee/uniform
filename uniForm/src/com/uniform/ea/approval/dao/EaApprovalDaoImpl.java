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
	
	//������ ������
	public List<PageVO> eaIngSelect(PageVO param){
		logger.info("�ٿ� eaIngSelect(param)�Լ� ����");
		return session.selectList("eaIngSelect");
	}
	
	//������ ������
	public List<PageVO> toApSelect(PageVO param){
		logger.info("�ٿ� toAprSelect(param)�Լ� ����");
		return session.selectList("toApSelect");
	}
	
	//������ �ݷ���
	public List<PageVO> returnSelect(PageVO param){
		logger.info("�ٿ� toAprSelect(param)�Լ� ����");
		return session.selectList("returnSelect");
	}
	
	//������ �Ϸ���
	public List<PageVO> finSelect(PageVO param){
		logger.info("�ٿ� toAprSelect(param)�Լ� ����");
		return session.selectList("finSelect");
	}
	
	//������ ������
	public List<PageVO> edSelect(PageVO param){
		logger.info("�ٿ� edSelect(param)�Լ� ����");
		return session.selectList("edSelect");
	}
	
	//���� ��¥ ��ȸ
	public String today(){
		return session.selectOne("today");
	}
	
	//�ۼ��� ��, �̸� ��ȸ
	public List<EmCommonVO> writerSelect(CommonInfoVO param){
		logger.info("�ٿ� writerSelect(param)�Լ� ����");
		return session.selectOne("writerSelect");
	}
	
	//���� ��ȸ
	public List<CommonInfoVO> presidentSelect(){
		return session.selectOne("presidentSelect");
	}
	
	//ó ��ȸ
	public List<CommonCodeVO> deptSelect(){
		return session.selectList("deptSelect");
	}
	
	//ó�� ��ȸ
	public List<CommonInfoVO> deptLeaderSelect(CommonCodeVO param){
		return session.selectOne("deptLeaderSelect");
	}
	
	//�� ��ȸ
	public List<CommonCodeVO> teamSelect(CommonCodeVO param){
		return session.selectList("teamSelect");
	}
	
	//���� ��ȸ
	public List<CommonInfoVO> teamLeaderSelect(CommonCodeVO param){
		return session.selectOne("teamLeaderSelect");
	}
	
	//��ȼ� ä��
	public List<EaGianVO> gianChaebun(){
		logger.info("�ٿ� gianChaebun()�Լ� ����");
		return session.selectOne("gianChaebun");
	}
	
	//���缱 ä��
	public List<EaLineVO> lineChaebun(){
		logger.info("�ٿ� lineChaebun()�Լ� ����");
		return session.selectOne("lineChaebun");
	}
	
	//���� ä��
	public List<EaApprovalVO> eaChaebun(){
		logger.info("�ٿ� eaChaebun()�Լ� ����");
		return session.selectOne("eaChaebun");
	}
	
	//��ȼ� �ۼ�, ������̺�
	public int gianInsert(EaGianVO param){
		logger.info("�ٿ� gianInsert()�Լ� ����");
		return session.insert("gianInsert");
	}
	
	//���� �ۼ�, ���缱���̺�
	public int lineInsert(EaLineVO param){
		logger.info("�ٿ� lineInsert()�Լ� ����");
		return session.insert("lineInsert");
	}
	
	//���� �ۼ�, �������̺�
	public int documentInsert(EaDocumentVO param){
		logger.info("�ٿ� documentInsert()�Լ� ����");
		return session.insert("documentInsert");
	}
	
	//���� �ۼ�, �������̺� 
	public int ea1Insert(EaApprovalVO param){
		logger.info("�ٿ� ea1Insert()�Լ� ����");
		return session.insert("ea1Insert");
	}
	
	//���� ����
	public int docDelete(EaDocumentVO param){
		logger.info("�ٿ� docDelete(param)�Լ� ����");
		return session.update("docDelete");
	}	

	//�����丮 insert
	public int historyInsert(EaApprovalVO param){
		logger.info("�ٿ� historyInsert(param)�Լ� ����");
		return session.insert("historyInsert");
	}
	
	//���� ��ȸ
	public List<EmCommonVO> signSelect(EmCommonVO param){
		logger.info("�ٿ� signSelect(param)�Լ� ����");
		return session.selectOne("signSelect");
	}
	
	//���������� ��ȸ
	public List<EaLineVO> nextApr(EaApprovalVO param){
		logger.info("�ٿ� nextApr(param)�Լ� ����");
		return session.selectOne("nextApr");
	}

	//���� �����丮 ��ȸ
	public List<EaApprovalVO> signHistory(EaApprovalVO param){
		logger.info("�ٿ� signHistory(param)�Լ� ����");
		return session.selectOne("signHistory");
	}	
	
	//���� update
	public int eaUpdate(EaApprovalVO param){
		logger.info("�ٿ� eaUpdate(param)�Լ� ����");	
		return session.update("eaUpdate");
	}
	
	//���������� update
	public int aprUpdate(EaDocumentVO param){
		logger.info("�ٿ� aprUpdate(param)�Լ� ����");	
		return session.update("aprUpdate");
	}
	
	//��ȼ� ���� ����ȸ
	public List<EaGianVO> giDetailSelect(EaDocumentVO param){
		logger.info("�ٿ� giDetailSelect(param)�Լ� ����");
		return session.selectOne("giDetailSelect");
	}
	
	//���� ���系��(�ǰ�) ����ȸ
	public List<EaApprovalVO> detailEaSelect(EaDocumentVO param){
		logger.info("�ٿ� detailEaSelect(param)�Լ� ����");
		return session.selectOne("detailEaSelect");
	}
	
	//�ǰ� history
	public List<EaApprovalVO> historyComment(EaDocumentVO param){
		logger.info("�ٿ� historyComment(param)�Լ� ����");
		return session.selectList("historyComment");
	}
	
	//�ް��� ����
	//�ް��� ä��
	public List<EaVacationVO> vacaChaebun(){
		logger.info("�ٿ� vacaChaebun()�Լ� ����");
		return session.selectOne("vacaChaebun");
	}	

	//�ް��� �ۼ�, �ް����̺� insert
	public int vacaInsert(EaVacationVO param){
		logger.info("�ٿ� vacaInsert(param)�Լ� ����");
		return session.insert("vacaInsert");
	}	

	//�ް��� ���� ����ȸ
	public List<EaVacationVO> vaDetailSelect(EaDocumentVO param){
		logger.info("�ٿ� vaDetailSelect(param)�Լ� ����");
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