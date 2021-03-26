package com.uniform.bm.board.dao;

import java.util.List;

import com.uniform.bm.board.vo.BmBoardVO;

public interface BmBoardDao {
	// �۸��(selectAll) ���� ===================================
	public List<BmBoardVO> boardList(BmBoardVO bbvo);

	// �ۻ󼼺���(detail)���� ========================================
	public List<BmBoardVO> boardDetail(BmBoardVO bbvo);
	
	// �۹�ȣ ä�� ===============================================
	public BmBoardVO boardNum();
	
	// �۾���(insert)���� ============================
	public int boardInsert(BmBoardVO bbvo);
	
	// �ۼ���(update)���� ============================
	public int boardUpdate(BmBoardVO bbvo);
	
	// �ۻ���(delete)���� =======================================
	public int boardDelete(BmBoardVO bbvo);
	
	// ��ȸ�� ī��Ʈ ���� ============================
	public int viewCount(BmBoardVO bbvo);
	
	// 1.�Խñ���õ���� ��ȸ =========================================	
	public List<BmBoardVO> boardLikeyYN(BmBoardVO bbvo);
	
	// 2-1.��õ ���� ��ȸ �� 0���� ��� => INSERT �ϱ� ===================
	public int boardLikeyInsert(BmBoardVO bbvo);
	
	// 2-2.��õ ���� ��ȸ ��� 1���̸鼭, ���� 'N'�� ��� => 'Y'�� �����ϱ� ======
	public int boardLikeyON(BmBoardVO bbvo);
	
	// 2-3.��õ ���� ��ȸ ��� 1���̸鼭, ���� 'Y'�� ��� => 'N'���� �����ϱ� ======
	public int boardLikeyOFF(BmBoardVO bbvo);
	
	// 3-1.��õ�� count �ø��� ���� ============================
	public int boardLikeyUp(BmBoardVO bbvo);
	
	// 3-2.��õ�� count ������ ���� ============================
	public int boardLikeyDown(BmBoardVO bbvo);
	
	// 1.�Խñ۽�ũ������ ��ȸ =========================================	
	public List<BmBoardVO> boardScrapYN(BmBoardVO bbvo);
	
	// 2-0.��ũ�� ä�� ===============================================
	public BmBoardVO scrapNum();
	
	// 2-1.��ũ�� ���� ��ȸ �� 0���� ��� => INSERT �ϱ� ===================
	public int boardScrapInsert(BmBoardVO bbvo);
	
	// 2-2.��ũ�� ���� ��ȸ ��� 1���̸鼭, ���� 'N'�� ��� => 'Y'�� �����ϱ� ======
	public int boardScrapON(BmBoardVO bbvo);
	
	// 2-3.��ũ�� ���� ��ȸ ��� 1���̸鼭, ���� 'Y'�� ��� => 'N'���� �����ϱ� ======
	public int boardScrapOFF(BmBoardVO bbvo);
	
	// 3-1.��ũ�� count �ø��� ���� ============================
	public int boardScrapUp(BmBoardVO bbvo);
	
	// 3-2.��ũ�� count ������ ���� ============================
	public int boardScrapDown(BmBoardVO bbvo);
	
	// 4.��ũ�������� ���� ===================================
	public List<BmBoardVO> boardScrapList(BmBoardVO bbvo);
	
	// ��ũ�� ����¡ total ���� ============================
	public int pagingScrap(BmBoardVO bbvo);	
	
	// ����¡ total ���� ============================
	public int paging(BmBoardVO bbvo);
	
	// �������� ���� ===================================
	public List<BmBoardVO> boardMyList(BmBoardVO bbvo);
	
	// ����¡ ��ũ�� total ���� ============================
	public int pagingMyList(BmBoardVO bbvo);
}
