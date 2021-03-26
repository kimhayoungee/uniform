package com.uniform.bm.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uniform.bm.board.vo.BmBoardVO;

@Repository
public class BmBoardDaoImpl implements BmBoardDao {
	// �α�
	private Logger logger = Logger.getLogger(BmBoardDaoImpl.class);
	
	// SqlSession
	@Autowired
	private SqlSession sqlSession;
	
	// �۸��(selectAll) ���� ===================================
	@Override
	public List<BmBoardVO> boardList(BmBoardVO bbvo) {
		
		return sqlSession.selectList("boardList", bbvo);
	}
	// �ۻ󼼺���(detail)���� =====================================
	@Override
	public List<BmBoardVO> boardDetail(BmBoardVO bbvo) {
		
		return sqlSession.selectList("boardDetail", bbvo);
	}
	// �۹�ȣ ä�� ===============================================
	@Override
	public BmBoardVO boardNum(){
		
		return sqlSession.selectOne("boardNum");
	}
	// �۾���(insert)���� ============================
	@Override
	public int boardInsert(BmBoardVO bbvo) {
		
		return (Integer)sqlSession.insert("boardInsert", bbvo);
	}
	// �ۼ���(update)���� ============================
	@Override
	public int boardUpdate(BmBoardVO bbvo) {
		
		return (Integer)sqlSession.update("boardUpdate", bbvo);
	}
	// �ۻ���(delete)���� =======================================
	@Override
	public int boardDelete(BmBoardVO bbvo) {
		return (Integer)sqlSession.update("boardDelete", bbvo);
	}
	// 1.�Խñ���õ���� ��ȸ =========================================
	@Override
	public List<BmBoardVO> boardLikeyYN(BmBoardVO bbvo){
		
		return  sqlSession.selectList("boardLikeyYN", bbvo);
	}
	// 2-1.��õ ���� ��ȸ �� 0���� ��� => INSERT �ϱ� ===================
	@Override
	public int boardLikeyInsert(BmBoardVO bbvo){
		return (Integer)sqlSession.insert("boardLikeyInsert", bbvo);
	}
	// 2-2.��õ ���� ��ȸ ��� 1���̸鼭, ���� 'N'�� ��� => 'Y'�� �����ϱ� ======
	@Override
	public int boardLikeyON(BmBoardVO bbvo) {
		
		return (Integer)sqlSession.update("boardLikeyON", bbvo);
	}
	// 2-3.��õ ���� ��ȸ ��� 1���̸鼭, ���� 'Y'�� ��� => 'N'���� �����ϱ� ======
	@Override
	public int boardLikeyOFF(BmBoardVO bbvo) {
		
		return (Integer)sqlSession.update("boardLikeyOFF", bbvo);
	}
	// 3-1.��õ�� count �ø��� ���� ============================
	@Override
	public int boardLikeyUp(BmBoardVO bbvo) {

		return (Integer)sqlSession.update("boardLikeyUp", bbvo);
	}
	// 3-2.��õ�� count ������ ���� ============================
	@Override
	public int boardLikeyDown(BmBoardVO bbvo) {

		return (Integer)sqlSession.update("boardLikeyDown", bbvo);
	}
	
	// 1.�Խñ۽�ũ������ ��ȸ =========================================
	@Override
	public List<BmBoardVO> boardScrapYN(BmBoardVO bbvo){
		
		return  sqlSession.selectList("boardScrapYN", bbvo);
	}
	// 2-0.��ũ�� ä�� ===============================================
	@Override
	public BmBoardVO scrapNum(){
		
		return sqlSession.selectOne("scrapNum");
	}
	// 2-1.��ũ�� ���� ��ȸ �� 0���� ��� => INSERT �ϱ� ===================
	@Override
	public int boardScrapInsert(BmBoardVO bbvo){
		return (Integer)sqlSession.insert("boardScrapInsert", bbvo);
	}
	// 2-2.��ũ�� ���� ��ȸ ��� 1���̸鼭, ���� 'N'�� ��� => 'Y'�� �����ϱ� ======
	@Override
	public int boardScrapON(BmBoardVO bbvo) {
		
		return (Integer)sqlSession.update("boardScrapON", bbvo);
	}
	// 2-3.��ũ�� ���� ��ȸ ��� 1���̸鼭, ���� 'Y'�� ��� => 'N'���� �����ϱ� ======
	@Override
	public int boardScrapOFF(BmBoardVO bbvo) {
		
		return (Integer)sqlSession.update("boardScrapOFF", bbvo);
	}
	// ��ũ�� count �ø��� ���� ============================
	@Override
	public int boardScrapUp(BmBoardVO bbvo) {

		return (Integer)sqlSession.update("boardScrapUp", bbvo);
	}
	// ��ũ�� count ������ ���� ============================
	@Override
	public int boardScrapDown(BmBoardVO bbvo) {

		return (Integer)sqlSession.update("boardScrapDown", bbvo);
	}
	// ��ũ�������� ���� ===================================
	@Override
	public List<BmBoardVO> boardScrapList(BmBoardVO bbvo) {
		
		return sqlSession.selectList("boardScrapList", bbvo);
	}	
	// ����¡ total ���� ============================
	@Override
	public int paging(BmBoardVO bbvo) {
		
		return (Integer)sqlSession.selectOne("paging",bbvo);
	}
	// ����¡ ��ũ�� total ���� ============================
	@Override
	public int pagingScrap(BmBoardVO bbvo) {
		
		return (Integer)sqlSession.selectOne("pagingScrap",bbvo);
	}
	// ��ȸ�� count ���� ============================
	@Override
	public int viewCount(BmBoardVO bbvo) {

		return (Integer)sqlSession.update("viewCount", bbvo);
	}
	// �������� ���� ===================================
	@Override
	public List<BmBoardVO> boardMyList(BmBoardVO bbvo) {
		
		return sqlSession.selectList("boardMyList", bbvo);
	}
	// ����¡ ��ũ�� total ���� ============================
	@Override
	public int pagingMyList(BmBoardVO bbvo) {
		
		return (Integer)sqlSession.selectOne("pagingMyList",bbvo);
	}
}
