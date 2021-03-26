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

	//������ ������
	public List<PageVO> eaIngSelect(PageVO param){
		logger.info("���� eaIngSelect(param)�Լ� ����");
		List<PageVO> list = eaApprovalDao.eaIngSelect(param);
		return list;
	}
	
	//������ ������
	public List<PageVO> toApSelect(PageVO param){
		logger.info("���� toApSelect(param)�Լ� ����");
		List<PageVO> list = eaApprovalDao.toApSelect(param);
		return list;
	}
	
	//������ �ݷ���
	public List<PageVO> returnSelect(PageVO param){
		logger.info("���� returnSelect(param)�Լ� ����");
		List<PageVO> list = eaApprovalDao.returnSelect(param);
		return list;
	}
	
	//������ �Ϸ���
	public List<PageVO> finSelect(PageVO param){
		logger.info("���� finSelect(param)�Լ� ����");
		List<PageVO> list = eaApprovalDao.finSelect(param);
		return list;
	}

	//������ ������
	public List<PageVO> edSelect(PageVO param){
		logger.info("���� edSelect(param)�Լ� ����");
		List<PageVO> list = eaApprovalDao.edSelect(param);
		return list;
	}	
	
	//���� ��¥ ��ȸ
	public String today(){
		String today = eaApprovalDao.today();
		return today;
	}

	//�ۼ��� ��, �̸� ��ȸ
	public List<EmCommonVO> writerSelect(CommonInfoVO param){
		logger.info("���� writerSelect(param)�Լ� ����");
		List<EmCommonVO> list = eaApprovalDao.writerSelect(param);
		return list;
	}
	
	//���� ��ȸ
	public List<CommonInfoVO> presidentSelect(){
		List<CommonInfoVO> list = eaApprovalDao.presidentSelect();
		return list;
	}
	
	//ó ��ȸ
	public List<CommonCodeVO> deptSelect(){
		List<CommonCodeVO> list = eaApprovalDao.deptSelect();
		return list;
	}
	
	//ó�� ��ȸ
	public List<CommonInfoVO> deptLeaderSelect(CommonCodeVO param){
		List<CommonInfoVO> list = eaApprovalDao.deptLeaderSelect(param);
		return list;
	}
	
	//�� ��ȸ
	public List<CommonCodeVO> teamSelect(CommonCodeVO param){
		List<CommonCodeVO> list = eaApprovalDao.teamSelect(param);
		return list;
	}
	
	//���� ��ȸ
	public List<CommonInfoVO> teamLeaderSelect(CommonCodeVO param){
		List<CommonInfoVO> list = eaApprovalDao.teamLeaderSelect(param);
		return list;
	}
	
	//��ȼ� ä��
	public List<EaGianVO> gianChaebun(){
		logger.info("���� gianChaebun()�Լ� ����");
		List<EaGianVO> list = eaApprovalDao.gianChaebun();
		return list;
	}
	
	//���缱 ä��
	public List<EaLineVO> lineChaebun(){
		logger.info("���� lineChaebun()�Լ� ����");
		List<EaLineVO> list = eaApprovalDao.lineChaebun();
		return list;
	}	

	//���� ä��
	public List<EaApprovalVO> eaChaebun(){
		logger.info("���� eaChaebun()�Լ� ����");
		List<EaApprovalVO> list = eaApprovalDao.eaChaebun();
		return list;
	}
	
	//��ȼ� �ۼ�, ������̺�
	public int gianInsert(EaGianVO param){
		logger.info("���� gianInsert(param)�Լ� ����");
		int result = eaApprovalDao.gianInsert(param);
		return result;
	}

	//���� �ۼ�, ���缱���̺�
	public int lineInsert(EaLineVO param){
		logger.info("���� lineInsert(param)�Լ� ����");
		int result = eaApprovalDao.lineInsert(param);
		return result;
	}
	
	//���� �ۼ�, �������̺�
	public int documentInsert(EaDocumentVO param){
		logger.info("���� documentInsert(param)�Լ� ����");
		int result = eaApprovalDao.documentInsert(param);
		return result;
	}
	
	//���� �ۼ�, �������̺� 
	public int ea1Insert(EaApprovalVO param){
		logger.info("���� ea1Insert(param)�Լ� ����");
		int result = eaApprovalDao.ea1Insert(param);
		return result;
	}
	
	//���� ����
	public int docDelete(EaDocumentVO param){
		logger.info("���� docDelete(param)�Լ� ����");
		int result = eaApprovalDao.docDelete(param);
		return result;
	}	
	
	//�����丮 insert
	public int historyInsert(EaApprovalVO param){
		logger.info("���� historyInsert(param)�Լ� ����");
		int result = eaApprovalDao.historyInsert(param);
		return result;
	}
	
	//���� ��ȸ
	public List<EmCommonVO> signSelect(EmCommonVO param){
		logger.info("���� signSelect(param)�Լ� ����");
		List<EmCommonVO> list = eaApprovalDao.signSelect(param);
		return list;
	}
	
	//���������� ��ȸ
	public List<EaLineVO> nextApr(EaApprovalVO param){
		logger.info("���� nextApr(param)�Լ� ����");
		List<EaLineVO> list = eaApprovalDao.nextApr(param);
		return list;
	}

	//���� �����丮 ��ȸ
	public List<EaApprovalVO> signHistory(EaApprovalVO param){
		logger.info("���� signHistory(param)�Լ� ����");
		List<EaApprovalVO> list = eaApprovalDao.signHistory(param);
		return list;
	}	
	
	//���� update
	public int eaUpdate(EaApprovalVO param){
		logger.info("���� eaUpdate(param)�Լ� ����");
		int result = eaApprovalDao.eaUpdate(param);
		return result;
	}
	
	//���������� update
	public int aprUpdate(EaDocumentVO param){
		logger.info("���� aprUpdate(param)�Լ� ����");
		int result = eaApprovalDao.aprUpdate(param);
		return result;
	}
	
	//��ȼ����� ����ȸ
	public List<EaGianVO> giDetailSelect(EaDocumentVO param){
		logger.info("���� giDetailSelect(param)�Լ� ����");
		List<EaGianVO> list = eaApprovalDao.giDetailSelect(param);
		return list;
	}
	
	//���� ���系��(�ǰ�) ����ȸ
	public List<EaApprovalVO> detailEaSelect(EaDocumentVO param){
		logger.info("���� detailEaSelect(param)�Լ� ����");
		List<EaApprovalVO> list = eaApprovalDao.detailEaSelect(param);
		return list;
	}
		
	//�ǰ� history
	public List<EaApprovalVO> historyComment(EaDocumentVO param){
		logger.info("���� historyComment(param)�Լ� ����");
		List<EaApprovalVO> list = eaApprovalDao.historyComment(param);
		return list;
	}
	
	//�ް��� ����
	//�ް��� ä��
	public List<EaVacationVO> vacaChaebun(){
		logger.info("���� vacaChaebun()�Լ� ����");
		List<EaVacationVO> list = eaApprovalDao.vacaChaebun();
		return list;		
	}	
	
	//�ް��� �ۼ�, �ް����̺� insert
	public int vacaInsert(EaVacationVO param){
		logger.info("���� vacaInsert(param)�Լ� ����");
		int result = eaApprovalDao.vacaInsert(param);
		return result;
	}
	
	//�ް��� ���� ����ȸ
	public List<EaVacationVO> vaDetailSelect(EaDocumentVO param){
		logger.info("���� vaDetailSelect(param)�Լ� ����");
		List<EaVacationVO> list = eaApprovalDao.vaDetailSelect(param);
		return list;
	}

	@Override
	public List<UploadPageVO> uploadSelect(UploadPageVO param) {
		// TODO Auto-generated method stub
		logger.info("���� uploadSelect()�Լ� ����");
		List<UploadPageVO> list = eaApprovalDao.uploadSelect(param);
		return list;
	}	// end

	@Override
	public List<EaUploadboardVO> uploadSelectOne(EaUploadboardVO param) {
		// TODO Auto-generated method stub
		logger.info("���� uploadSelectOne()�Լ� ����");
		List<EaUploadboardVO> list = eaApprovalDao.uploadSelectOne(param);
		return list;
	}// end

	@Override
	public List<CommonInfoVO> eaLine(CommonInfoVO cvo) {
		// TODO Auto-generated method stub
		logger.info("���� eaList()�Լ� ����");
		List<CommonInfoVO> list = eaApprovalDao.eaLine(cvo);
		return list;
	}

	@Override
	public List<EaPoomVO> poomChaebun() {
		// TODO Auto-generated method stub
		logger.info("���� poomChaebun()�Լ� ����");
	    List<EaPoomVO> list = eaApprovalDao.poomChaebun();
	    return list;
	}// end

	@Override
	public List<EaDocumentVO> documentChaebun() {
		// TODO Auto-generated method stub
		logger.info("���� documentChaebun()�Լ� ����");
		List<EaDocumentVO> list = eaApprovalDao.documentChaebun();
		return list;
	}// end

	@Override
	public int poomFormInsert(EaPoomVO pvo) {
		// TODO Auto-generated method stub
		logger.info("���� poomFormInsert()�Լ� ����");
		return eaApprovalDao.poomFormInsert(pvo);
	}// end

	@Override
	public int eaLineInsert(EaLineVO lvo) {
		// TODO Auto-generated method stub
		logger.info("���� eaLineInsert()�Լ� ����");
		return eaApprovalDao.eaLineInsert(lvo);
	}// end

	@Override
	public int eaDocumentInsert(EaDocumentVO dvo) {
		// TODO Auto-generated method stub
		logger.info("���� eaDocumentInsert()�Լ� ����");		
		return eaApprovalDao.eaDocumentInsert(dvo);
	}// end

	@Override
	public int eaEaInsert(EaApprovalVO evo) {
		// TODO Auto-generated method stub
		logger.info("���� eaEaInsert()�Լ� ����");
		return eaApprovalDao.eaEaInsert(evo);
	}// end

	@Override
	public List<EaPoomVO> poomSelect(EaPoomVO param) {
		// TODO Auto-generated method stub
		logger.info("���� poomSelect()�Լ� ����");
		List<EaPoomVO> list = eaApprovalDao.poomSelect(param);
		return list;
	}// end

	@Override
	public List<EaApprovalVO> poEaSelect(EaApprovalVO param) {
		// TODO Auto-generated method stub
		logger.info("���� poEaSelect()�Լ� ����");
		List<EaApprovalVO> list = eaApprovalDao.poEaSelect(param);
		return list;
	}// end

	@Override
	public List<EaLineVO> poLineSelect(EaLineVO param) {
		// TODO Auto-generated method stub
		logger.info("���� poLineSelect()�Լ� ����");
		List<EaLineVO> list = eaApprovalDao.poLineSelect(param);
		return list;
	}// end

	@Override
	public List<EaDocumentVO> poDocumentSelect(EaDocumentVO param) {
		// TODO Auto-generated method stub
		logger.info("���� poDocumentSelect()�Լ� ����");
		List<EaDocumentVO> list = eaApprovalDao.poDocumentSelect(param);
		return list;
	}

	@Override
	public int poomSign(EaApprovalVO param) {
		// TODO Auto-generated method stub
		logger.info("���� poomSign()�Լ� ����");
		return eaApprovalDao.poomSign(param);
	}

	@Override
	public int poomSign2(EaApprovalVO param) {
		// TODO Auto-generated method stub
		logger.info("���� poomSign2()�Լ� ����");
		return eaApprovalDao.poomSign2(param);
	}

	@Override
	public int poomBack(EaApprovalVO param) {
		// TODO Auto-generated method stub
		logger.info("���� poomBack()�Լ� ����");
		return eaApprovalDao.poomBack(param);
	}

	@Override
	public int poomBack2(EaApprovalVO param) {
		// TODO Auto-generated method stub
		logger.info("���� poomBack2()�Լ� ����");
		return eaApprovalDao.poomBack2(param);
	}

	@Override
	public List<EaUploadboardVO> uploadChaebun() {
		// TODO Auto-generated method stub
		logger.info("���� uploadChaebun()�Լ� ����");
		List<EaUploadboardVO> list = eaApprovalDao.uploadChaebun();
		return list;
	}

	@Override
	public int eaUploadInsert(EaUploadboardVO param) {
		// TODO Auto-generated method stub
		logger.info("���� eaUploadInsert()�Լ� ����");
		return eaApprovalDao.eaUploadInsert(param);
	}

	@Override
	public List<EaPoomVO> poDetailSelect(EaDocumentVO param) {
		// TODO Auto-generated method stub
		return eaApprovalDao.poDetailSelect(param);
	}
	
} //end of EaApprovalServiceImpl class