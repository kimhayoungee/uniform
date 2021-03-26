package com.uniform.bm.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uniform.bm.board.vo.BmBoardVO;

@Repository
public class BmBoardDaoImpl implements BmBoardDao {
	// 로그
	private Logger logger = Logger.getLogger(BmBoardDaoImpl.class);
	
	// SqlSession
	@Autowired
	private SqlSession sqlSession;
	
	// 글목록(selectAll) 구현 ===================================
	@Override
	public List<BmBoardVO> boardList(BmBoardVO bbvo) {
		
		return sqlSession.selectList("boardList", bbvo);
	}
	// 글상세보기(detail)구현 =====================================
	@Override
	public List<BmBoardVO> boardDetail(BmBoardVO bbvo) {
		
		return sqlSession.selectList("boardDetail", bbvo);
	}
	// 글번호 채번 ===============================================
	@Override
	public BmBoardVO boardNum(){
		
		return sqlSession.selectOne("boardNum");
	}
	// 글쓰기(insert)구현 ============================
	@Override
	public int boardInsert(BmBoardVO bbvo) {
		
		return (Integer)sqlSession.insert("boardInsert", bbvo);
	}
	// 글수정(update)구현 ============================
	@Override
	public int boardUpdate(BmBoardVO bbvo) {
		
		return (Integer)sqlSession.update("boardUpdate", bbvo);
	}
	// 글삭제(delete)구현 =======================================
	@Override
	public int boardDelete(BmBoardVO bbvo) {
		return (Integer)sqlSession.update("boardDelete", bbvo);
	}
	// 1.게시글추천여부 조회 =========================================
	@Override
	public List<BmBoardVO> boardLikeyYN(BmBoardVO bbvo){
		
		return  sqlSession.selectList("boardLikeyYN", bbvo);
	}
	// 2-1.추천 여부 조회 후 0건일 경우 => INSERT 하기 ===================
	@Override
	public int boardLikeyInsert(BmBoardVO bbvo){
		return (Integer)sqlSession.insert("boardLikeyInsert", bbvo);
	}
	// 2-2.추천 여부 조회 결과 1건이면서, 값이 'N'일 경우 => 'Y'로 변경하기 ======
	@Override
	public int boardLikeyON(BmBoardVO bbvo) {
		
		return (Integer)sqlSession.update("boardLikeyON", bbvo);
	}
	// 2-3.추천 여부 조회 결과 1건이면서, 값이 'Y'일 경우 => 'N'으로 변경하기 ======
	@Override
	public int boardLikeyOFF(BmBoardVO bbvo) {
		
		return (Integer)sqlSession.update("boardLikeyOFF", bbvo);
	}
	// 3-1.추천수 count 올리기 구현 ============================
	@Override
	public int boardLikeyUp(BmBoardVO bbvo) {

		return (Integer)sqlSession.update("boardLikeyUp", bbvo);
	}
	// 3-2.추천수 count 내리기 구현 ============================
	@Override
	public int boardLikeyDown(BmBoardVO bbvo) {

		return (Integer)sqlSession.update("boardLikeyDown", bbvo);
	}
	
	// 1.게시글스크랩여부 조회 =========================================
	@Override
	public List<BmBoardVO> boardScrapYN(BmBoardVO bbvo){
		
		return  sqlSession.selectList("boardScrapYN", bbvo);
	}
	// 2-0.스크랩 채번 ===============================================
	@Override
	public BmBoardVO scrapNum(){
		
		return sqlSession.selectOne("scrapNum");
	}
	// 2-1.스크랩 여부 조회 후 0건일 경우 => INSERT 하기 ===================
	@Override
	public int boardScrapInsert(BmBoardVO bbvo){
		return (Integer)sqlSession.insert("boardScrapInsert", bbvo);
	}
	// 2-2.스크랩 여부 조회 결과 1건이면서, 값이 'N'일 경우 => 'Y'로 변경하기 ======
	@Override
	public int boardScrapON(BmBoardVO bbvo) {
		
		return (Integer)sqlSession.update("boardScrapON", bbvo);
	}
	// 2-3.스크랩 여부 조회 결과 1건이면서, 값이 'Y'일 경우 => 'N'으로 변경하기 ======
	@Override
	public int boardScrapOFF(BmBoardVO bbvo) {
		
		return (Integer)sqlSession.update("boardScrapOFF", bbvo);
	}
	// 스크랩 count 올리기 구현 ============================
	@Override
	public int boardScrapUp(BmBoardVO bbvo) {

		return (Integer)sqlSession.update("boardScrapUp", bbvo);
	}
	// 스크랩 count 내리기 구현 ============================
	@Override
	public int boardScrapDown(BmBoardVO bbvo) {

		return (Integer)sqlSession.update("boardScrapDown", bbvo);
	}
	// 스크랩보관함 구현 ===================================
	@Override
	public List<BmBoardVO> boardScrapList(BmBoardVO bbvo) {
		
		return sqlSession.selectList("boardScrapList", bbvo);
	}	
	// 페이징 total 구현 ============================
	@Override
	public int paging(BmBoardVO bbvo) {
		
		return (Integer)sqlSession.selectOne("paging",bbvo);
	}
	// 페이징 스크랩 total 구현 ============================
	@Override
	public int pagingScrap(BmBoardVO bbvo) {
		
		return (Integer)sqlSession.selectOne("pagingScrap",bbvo);
	}
	// 조회수 count 구현 ============================
	@Override
	public int viewCount(BmBoardVO bbvo) {

		return (Integer)sqlSession.update("viewCount", bbvo);
	}
	// 내가쓴글 구현 ===================================
	@Override
	public List<BmBoardVO> boardMyList(BmBoardVO bbvo) {
		
		return sqlSession.selectList("boardMyList", bbvo);
	}
	// 페이징 스크랩 total 구현 ============================
	@Override
	public int pagingMyList(BmBoardVO bbvo) {
		
		return (Integer)sqlSession.selectOne("pagingMyList",bbvo);
	}
}
