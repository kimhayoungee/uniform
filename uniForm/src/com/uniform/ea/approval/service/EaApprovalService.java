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

	//������ ������
	public List<PageVO> eaIngSelect(PageVO param);		
	
	//������ ������
	public List<PageVO> toApSelect(PageVO param);
	
	//������ �ݷ���
	public List<PageVO> returnSelect(PageVO param);
	
	//������ �Ϸ���
	public List<PageVO> finSelect(PageVO param);

	//������ ������
	public List<PageVO> edSelect(PageVO param);
	
	//���� ��¥ ��ȸ
	public String today();

	//�ۼ��� ��, �̸� ��ȸ
	public List<EmCommonVO> writerSelect(CommonInfoVO param);
	
	//���� ��ȸ
	public List<CommonInfoVO> presidentSelect();
	
	//ó ��ȸ
	public List<CommonCodeVO> deptSelect();
	
	//ó�� ��ȸ
	public List<CommonInfoVO> deptLeaderSelect(CommonCodeVO param);

	//�� ��ȸ
	public List<CommonCodeVO> teamSelect(CommonCodeVO param);
	
	//���� ��ȸ
	public List<CommonInfoVO> teamLeaderSelect(CommonCodeVO param);
	
	//��ȼ� ä��
	public List<EaGianVO> gianChaebun();

	//���缱 ä��
	public List<EaLineVO> lineChaebun();

	//���� ä��
	public List<EaApprovalVO> eaChaebun();
	
	//��ȼ� �ۼ�, ������̺�
	public int gianInsert(EaGianVO param);

	//���� �ۼ�, ���缱���̺�
	public int lineInsert(EaLineVO param);
	
	//���� �ۼ�, �������̺�
	public int documentInsert(EaDocumentVO param);
	
	//���� �ۼ�, �������̺� 
	public int ea1Insert(EaApprovalVO param);
	
	//���� ����
	public int docDelete(EaDocumentVO param);
	
	//�����丮 insert
	public int historyInsert(EaApprovalVO param);
	
	//���� ��ȸ
	public List<EmCommonVO> signSelect(EmCommonVO param);
		
	//���������� ��ȸ
	public List<EaLineVO> nextApr(EaApprovalVO param);

	//���� �����丮 ��ȸ
	public List<EaApprovalVO> signHistory(EaApprovalVO param);	
	
	//���� update
	public int eaUpdate(EaApprovalVO param);
	
	//���������� update
	public int aprUpdate(EaDocumentVO param);
	
	//��ȼ����� ����ȸ
	public List<EaGianVO> giDetailSelect(EaDocumentVO param);
	
	//���� ���系��(�ǰ�) ����ȸ
	public List<EaApprovalVO> detailEaSelect(EaDocumentVO param);
	
	//�ǰ� history
	public List<EaApprovalVO> historyComment(EaDocumentVO param);
	
	//�ް��� ����
	//�ް��� ä��
	public List<EaVacationVO> vacaChaebun();	
	
	//�ް��� �ۼ�, �ް����̺� insert
	public int vacaInsert(EaVacationVO param);	

	//�ް��� ���� ����ȸ
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