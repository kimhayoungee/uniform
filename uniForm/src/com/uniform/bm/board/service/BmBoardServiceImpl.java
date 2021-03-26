package com.uniform.bm.board.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uniform.bm.board.dao.BmBoardDao;
import com.uniform.bm.board.vo.BmBoardVO;

@Service
@Transactional
public class BmBoardServiceImpl implements BmBoardService {

	// �α�
	private Logger logger = Logger.getLogger(BmBoardServiceImpl.class);

	// �ٿ�
	@Autowired
	private BmBoardDao bmBoardDao;

	// �۸��(selectAll) ���� ===================================
	@Override
	public List<BmBoardVO> boardList(BmBoardVO bbvo) {
		logger.info("���� �۸�� ���� �Լ� ȣ�� ����!");

		List<BmBoardVO> boardList = bmBoardDao.boardList(bbvo);
		return boardList;
	}

	// �ۻ󼼺���(detail)���� =====================================
	@Override
	public List<BmBoardVO> boardDetail(BmBoardVO bbvo) {
		logger.info("���� �ۻ󼼺��� ���� �Լ� ȣ�� ����!");

		List<BmBoardVO> boardDetailList = bmBoardDao.boardDetail(bbvo);
		return boardDetailList;
	}

	// �۹�ȣ ä�� ===============================================
	@Override
	public BmBoardVO boardNum() {
		logger.info("���� �۹�ȣ ä�� �Լ� ȣ�� ����!");

		BmBoardVO boardNum = bmBoardDao.boardNum();
		return boardNum;
	}

	// �۾���(insert)���� (÷������ ����) ============================
	@Override
	public int boardInsert(BmBoardVO bbvo) {
		logger.info("���� �۾��� �Լ� ȣ�� ����!");

		int nCntInsert = bmBoardDao.boardInsert(bbvo);
		return nCntInsert;
	}

	// �ۼ���(update)���� (÷������ ����) ============================
	@Override
	public int boardUpdate(BmBoardVO bbvo) {
		logger.info("���� �ۼ��� �Լ� ȣ�� ����!");

		int nCntUpdate = bmBoardDao.boardUpdate(bbvo);
		return nCntUpdate;
	}

	// �ۻ���(delete)���� =======================================
	@Override
	public int boardDelete(BmBoardVO bbvo) {
		logger.info("���� �ۻ��� �Լ� ȣ�� ����!");

		int nCntDelete = bmBoardDao.boardDelete(bbvo);
		return nCntDelete;
	}

	// 1.�Խñ���õ���� ��ȸ =========================================
	@Override
	public List<BmBoardVO> boardLikeyYN(BmBoardVO bbvo) {
		logger.info("���� �Խñ���õ���� ��ȸ �Լ� ȣ�� ����!");

		List<BmBoardVO> boardLikeyYNList = bmBoardDao.boardLikeyYN(bbvo);
		return boardLikeyYNList;
	}

	// 2-1.��õ ���� ��ȸ �� 0���� ��� => INSERT �ϱ� ===================
	@Override
	public int boardLikeyInsert(BmBoardVO bbvo) {
		logger.info("���� ���ƿ� ���� ��ȸ �� 0���� ���, INSERT �ϱ� �Լ� ȣ�� ����!");

		int nCntboardLikeyInsert = bmBoardDao.boardLikeyInsert(bbvo);
		return nCntboardLikeyInsert;
	}

	// 2-2.��õ ���� ��ȸ ��� 1���̸鼭, ���� 'N'�� ��� => 'Y'�� �����ϱ� ======
	@Override
	public int boardLikeyON(BmBoardVO bbvo) {
		logger.info("���ƿ� ���� ��ȸ ��� 1���̸鼭, ���� 'N'�� ��� 'Y'�� �����ϱ�  �Լ� ȣ�� ����!");

		int nCntBoardLikeyON = bmBoardDao.boardLikeyON(bbvo);
		return nCntBoardLikeyON;
	}

	// 2-3.��õ ���� ��ȸ ��� 1���̸鼭, ���� 'Y'�� ��� => 'N'���� �����ϱ� ======
	@Override
	public int boardLikeyOFF(BmBoardVO bbvo) {
		logger.info("���ƿ� ���� ��ȸ ��� 1���̸鼭, ���� 'Y'�� ��� 'N'���� �����ϱ�  �Լ� ȣ�� ����!");

		int nCntBoardLikeyOFF = bmBoardDao.boardLikeyOFF(bbvo);
		return nCntBoardLikeyOFF;
	}
	
	// 3-1.��õ�� count �ø��� ���� ============================
	@Override
	public int boardLikeyUp(BmBoardVO bbvo) {
		logger.info("���� ��õ�� count �ø��� �Լ� ȣ�� ����!");
		return bmBoardDao.boardLikeyUp(bbvo);
	}
	
	// 3-2.��õ�� count ������ ���� ============================
	@Override
	public int boardLikeyDown(BmBoardVO bbvo) {
		logger.info("���� ��õ�� count ������ �Լ� ȣ�� ����!");
		return bmBoardDao.boardLikeyDown(bbvo);
	}
	
	
	// 1.�Խñ۽�ũ������ ��ȸ =========================================
	@Override
	public List<BmBoardVO> boardScrapYN(BmBoardVO bbvo) {
		logger.info("���� �Խñ۽�ũ������ ��ȸ �Լ� ȣ�� ����!");

		List<BmBoardVO> boardScrapYNList = bmBoardDao.boardScrapYN(bbvo);
		return boardScrapYNList;
	}

	// 2-0.��ũ�� ä�� ===============================================
	@Override
	public BmBoardVO scrapNum() {
		logger.info("���� ��ũ�� ä�� �Լ� ȣ�� ����!");

		BmBoardVO scrapNum = bmBoardDao.scrapNum();
		return scrapNum;
	}
	
	// 2-1.��ũ�� ���� ��ȸ �� 0���� ��� => INSERT �ϱ� ===================
	@Override
	public int boardScrapInsert(BmBoardVO bbvo) {
		logger.info("���� ��ũ�� ���� ��ȸ �� 0���� ���, INSERT �ϱ� �Լ� ȣ�� ����!");

		int nCntboardScrapInsert = bmBoardDao.boardScrapInsert(bbvo);
		return nCntboardScrapInsert;
	}

	// 2-2.��ũ�� ���� ��ȸ ��� 1���̸鼭, ���� 'N'�� ��� => 'Y'�� �����ϱ� ======
	@Override
	public int boardScrapON(BmBoardVO bbvo) {
		logger.info("��ũ�� ���� ��ȸ ��� 1���̸鼭, ���� 'N'�� ��� 'Y'�� �����ϱ�  �Լ� ȣ�� ����!");

		int nCntBoardScrapON = bmBoardDao.boardScrapON(bbvo);
		return nCntBoardScrapON;
	}

	// 2-3.��ũ�� ���� ��ȸ ��� 1���̸鼭, ���� 'Y'�� ��� => 'N'���� �����ϱ� ======
	@Override
	public int boardScrapOFF(BmBoardVO bbvo) {
		logger.info("��ũ�� ���� ��ȸ ��� 1���̸鼭, ���� 'Y'�� ��� 'N'���� �����ϱ�  �Լ� ȣ�� ����!");

		int nCntBoardScrapOFF = bmBoardDao.boardScrapOFF(bbvo);
		return nCntBoardScrapOFF;
	}
	
	// 3-1.��ũ�� count �ø��� ���� ============================
	@Override
	public int boardScrapUp(BmBoardVO bbvo) {
		logger.info("���� ��ũ�� count �ø��� �Լ� ȣ�� ����!");
		return bmBoardDao.boardScrapUp(bbvo);
	}
	
	// 3-2.��ũ�� count ������ ���� ============================
	@Override
	public int boardScrapDown(BmBoardVO bbvo) {
		logger.info("���� ��ũ�� count ������ �Լ� ȣ�� ����!");
		return bmBoardDao.boardScrapDown(bbvo);
	}
	
	// 4.��ũ�������� ���� ===================================
	@Override
	public List<BmBoardVO> boardScrapList(BmBoardVO bbvo) {
		logger.info("���� ��ũ�������� ���� �Լ� ȣ�� ����!");

		List<BmBoardVO> boardScrapList = bmBoardDao.boardScrapList(bbvo);
		return boardScrapList;
	}
	
	// ����¡ total ���� ============================
	@Override
	public int paging(BmBoardVO bbvo) {
		logger.info("���� ����¡ total �Լ� ȣ�� ����!");
		return bmBoardDao.paging(bbvo);
	}
	
	// ����¡��ũ�� total ���� ============================
	@Override
	public int pagingScrap(BmBoardVO bbvo) {
		logger.info("���� ����¡ total �Լ� ȣ�� ����!");
		return bmBoardDao.pagingScrap(bbvo);
	}
	
	// ��ȸ�� count ���� ============================
	@Override
	public int viewCount(BmBoardVO bbvo) {
		logger.info("��ȸ�� count �Լ� ȣ�� ����!");

		int nCntViewCount = bmBoardDao.viewCount(bbvo);
		return nCntViewCount;
	}

	@Override
	public int scrapOff(BmBoardVO bbvo) {
		// TODO Auto-generated method stub
		
		int offCnt = 0;
		int downCnt = 0;
		
		offCnt = bmBoardDao.boardScrapOFF(bbvo);
		
		downCnt = bmBoardDao.boardScrapDown(bbvo);
		
		return offCnt + downCnt;
	}// end of scrapOff() �Լ�
	
	// �������� ���� ===================================
	@Override
	public List<BmBoardVO> boardMyList(BmBoardVO bbvo) {
		logger.info("���� �������� ���� �Լ� ȣ�� ����!");

		List<BmBoardVO> boardMyList = bmBoardDao.boardMyList(bbvo);
		return boardMyList;
	}
	
	// �������� ����¡ total ���� ============================
	@Override
	public int pagingMyList(BmBoardVO bbvo) {
		logger.info("���� �������� ����¡ total �Լ� ȣ�� ����!");
		return bmBoardDao.pagingMyList(bbvo);
	}
}
