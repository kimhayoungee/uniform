package com.uniform.nm.notice.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uniform.nm.notice.vo.NmNoticeVO;

@Repository
public class NmNoticeDaoImpl implements NmNoticeDao {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<NmNoticeVO> noticeList(NmNoticeVO nnvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("noticeList");
	}// end of noticeList() 함수

	@Override
	public NmNoticeVO nmChaebun() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("nmChaebun");
	}// end of nmChaebun() 함수

	@Override
	public int insertNotice(NmNoticeVO nnvo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("insertNotice");
	}// end of insertNotice() 함수

	@Override
	public NmNoticeVO detailNotice(NmNoticeVO nnvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("detailNotice");
	}// end of detailNotice() 함수

	@Override
	public int deleteNotice(NmNoticeVO nnvo) {
		// TODO Auto-generated method stub
		return sqlSession.update("deleteNotice");
	}// end of deleteNotice() 함수

	@Override
	public int updateNotice(NmNoticeVO nnvo) {
		// TODO Auto-generated method stub
		return sqlSession.update("updateNotice");
	}// end of updateNotice() 함수

	@Override
	public int listCnt(NmNoticeVO nnvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("listCnt");
	}// end of listCnt() 함수

	@Override
	public int updateView(NmNoticeVO nnvo) {
		// TODO Auto-generated method stub
		return sqlSession.update("updateView");
	}// end of updateView() 함수

	@Override
	public List<NmNoticeVO> miniNotice() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("miniNotice");
	}// end of miniNotice() 함수

}// end of NmNoticeDaoImpl class
