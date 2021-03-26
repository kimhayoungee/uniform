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

	// 로그
	private Logger logger = Logger.getLogger(BmBoardServiceImpl.class);

	// 다오
	@Autowired
	private BmBoardDao bmBoardDao;

	// 글목록(selectAll) 구현 ===================================
	@Override
	public List<BmBoardVO> boardList(BmBoardVO bbvo) {
		logger.info("서비스 글목록 구현 함수 호출 성공!");

		List<BmBoardVO> boardList = bmBoardDao.boardList(bbvo);
		return boardList;
	}

	// 글상세보기(detail)구현 =====================================
	@Override
	public List<BmBoardVO> boardDetail(BmBoardVO bbvo) {
		logger.info("서비스 글상세보기 구현 함수 호출 성공!");

		List<BmBoardVO> boardDetailList = bmBoardDao.boardDetail(bbvo);
		return boardDetailList;
	}

	// 글번호 채번 ===============================================
	@Override
	public BmBoardVO boardNum() {
		logger.info("서비스 글번호 채번 함수 호출 성공!");

		BmBoardVO boardNum = bmBoardDao.boardNum();
		return boardNum;
	}

	// 글쓰기(insert)구현 (첨부파일 제외) ============================
	@Override
	public int boardInsert(BmBoardVO bbvo) {
		logger.info("서비스 글쓰기 함수 호출 성공!");

		int nCntInsert = bmBoardDao.boardInsert(bbvo);
		return nCntInsert;
	}

	// 글수정(update)구현 (첨부파일 제외) ============================
	@Override
	public int boardUpdate(BmBoardVO bbvo) {
		logger.info("서비스 글수정 함수 호출 성공!");

		int nCntUpdate = bmBoardDao.boardUpdate(bbvo);
		return nCntUpdate;
	}

	// 글삭제(delete)구현 =======================================
	@Override
	public int boardDelete(BmBoardVO bbvo) {
		logger.info("서비스 글삭제 함수 호출 성공!");

		int nCntDelete = bmBoardDao.boardDelete(bbvo);
		return nCntDelete;
	}

	// 1.게시글추천여부 조회 =========================================
	@Override
	public List<BmBoardVO> boardLikeyYN(BmBoardVO bbvo) {
		logger.info("서비스 게시글추천여부 조회 함수 호출 성공!");

		List<BmBoardVO> boardLikeyYNList = bmBoardDao.boardLikeyYN(bbvo);
		return boardLikeyYNList;
	}

	// 2-1.추천 여부 조회 후 0건일 경우 => INSERT 하기 ===================
	@Override
	public int boardLikeyInsert(BmBoardVO bbvo) {
		logger.info("서비스 좋아요 여부 조회 후 0건일 경우, INSERT 하기 함수 호출 성공!");

		int nCntboardLikeyInsert = bmBoardDao.boardLikeyInsert(bbvo);
		return nCntboardLikeyInsert;
	}

	// 2-2.추천 여부 조회 결과 1건이면서, 값이 'N'일 경우 => 'Y'로 변경하기 ======
	@Override
	public int boardLikeyON(BmBoardVO bbvo) {
		logger.info("좋아요 여부 조회 결과 1건이면서, 값이 'N'일 경우 'Y'로 변경하기  함수 호출 성공!");

		int nCntBoardLikeyON = bmBoardDao.boardLikeyON(bbvo);
		return nCntBoardLikeyON;
	}

	// 2-3.추천 여부 조회 결과 1건이면서, 값이 'Y'일 경우 => 'N'으로 변경하기 ======
	@Override
	public int boardLikeyOFF(BmBoardVO bbvo) {
		logger.info("좋아요 여부 조회 결과 1건이면서, 값이 'Y'일 경우 'N'으로 변경하기  함수 호출 성공!");

		int nCntBoardLikeyOFF = bmBoardDao.boardLikeyOFF(bbvo);
		return nCntBoardLikeyOFF;
	}
	
	// 3-1.추천수 count 올리기 구현 ============================
	@Override
	public int boardLikeyUp(BmBoardVO bbvo) {
		logger.info("서비스 추천수 count 올리기 함수 호출 성공!");
		return bmBoardDao.boardLikeyUp(bbvo);
	}
	
	// 3-2.추천수 count 내리기 구현 ============================
	@Override
	public int boardLikeyDown(BmBoardVO bbvo) {
		logger.info("서비스 추천수 count 내리기 함수 호출 성공!");
		return bmBoardDao.boardLikeyDown(bbvo);
	}
	
	
	// 1.게시글스크랩여부 조회 =========================================
	@Override
	public List<BmBoardVO> boardScrapYN(BmBoardVO bbvo) {
		logger.info("서비스 게시글스크랩여부 조회 함수 호출 성공!");

		List<BmBoardVO> boardScrapYNList = bmBoardDao.boardScrapYN(bbvo);
		return boardScrapYNList;
	}

	// 2-0.스크랩 채번 ===============================================
	@Override
	public BmBoardVO scrapNum() {
		logger.info("서비스 스크랩 채번 함수 호출 성공!");

		BmBoardVO scrapNum = bmBoardDao.scrapNum();
		return scrapNum;
	}
	
	// 2-1.스크랩 여부 조회 후 0건일 경우 => INSERT 하기 ===================
	@Override
	public int boardScrapInsert(BmBoardVO bbvo) {
		logger.info("서비스 스크랩 여부 조회 후 0건일 경우, INSERT 하기 함수 호출 성공!");

		int nCntboardScrapInsert = bmBoardDao.boardScrapInsert(bbvo);
		return nCntboardScrapInsert;
	}

	// 2-2.스크랩 여부 조회 결과 1건이면서, 값이 'N'일 경우 => 'Y'로 변경하기 ======
	@Override
	public int boardScrapON(BmBoardVO bbvo) {
		logger.info("스크랩 여부 조회 결과 1건이면서, 값이 'N'일 경우 'Y'로 변경하기  함수 호출 성공!");

		int nCntBoardScrapON = bmBoardDao.boardScrapON(bbvo);
		return nCntBoardScrapON;
	}

	// 2-3.스크랩 여부 조회 결과 1건이면서, 값이 'Y'일 경우 => 'N'으로 변경하기 ======
	@Override
	public int boardScrapOFF(BmBoardVO bbvo) {
		logger.info("스크랩 여부 조회 결과 1건이면서, 값이 'Y'일 경우 'N'으로 변경하기  함수 호출 성공!");

		int nCntBoardScrapOFF = bmBoardDao.boardScrapOFF(bbvo);
		return nCntBoardScrapOFF;
	}
	
	// 3-1.스크랩 count 올리기 구현 ============================
	@Override
	public int boardScrapUp(BmBoardVO bbvo) {
		logger.info("서비스 스크랩 count 올리기 함수 호출 성공!");
		return bmBoardDao.boardScrapUp(bbvo);
	}
	
	// 3-2.스크랩 count 내리기 구현 ============================
	@Override
	public int boardScrapDown(BmBoardVO bbvo) {
		logger.info("서비스 스크랩 count 내리기 함수 호출 성공!");
		return bmBoardDao.boardScrapDown(bbvo);
	}
	
	// 4.스크랩보관함 구현 ===================================
	@Override
	public List<BmBoardVO> boardScrapList(BmBoardVO bbvo) {
		logger.info("서비스 스크랩보관함 구현 함수 호출 성공!");

		List<BmBoardVO> boardScrapList = bmBoardDao.boardScrapList(bbvo);
		return boardScrapList;
	}
	
	// 페이징 total 구현 ============================
	@Override
	public int paging(BmBoardVO bbvo) {
		logger.info("서비스 페이징 total 함수 호출 성공!");
		return bmBoardDao.paging(bbvo);
	}
	
	// 페이징스크랩 total 구현 ============================
	@Override
	public int pagingScrap(BmBoardVO bbvo) {
		logger.info("서비스 페이징 total 함수 호출 성공!");
		return bmBoardDao.pagingScrap(bbvo);
	}
	
	// 조회수 count 구현 ============================
	@Override
	public int viewCount(BmBoardVO bbvo) {
		logger.info("조회수 count 함수 호출 성공!");

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
	}// end of scrapOff() 함수
	
	// 내가쓴글 구현 ===================================
	@Override
	public List<BmBoardVO> boardMyList(BmBoardVO bbvo) {
		logger.info("서비스 내가쓴글 구현 함수 호출 성공!");

		List<BmBoardVO> boardMyList = bmBoardDao.boardMyList(bbvo);
		return boardMyList;
	}
	
	// 내가쓴글 페이징 total 구현 ============================
	@Override
	public int pagingMyList(BmBoardVO bbvo) {
		logger.info("서비스 내가쓴글 페이징 total 함수 호출 성공!");
		return bmBoardDao.pagingMyList(bbvo);
	}
}
