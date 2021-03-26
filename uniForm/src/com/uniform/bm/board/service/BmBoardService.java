package com.uniform.bm.board.service;

import java.util.List;

import com.uniform.bm.board.vo.BmBoardVO;

public interface BmBoardService {

	// 글목록(selectAll) 구현 ===================================
	public List<BmBoardVO> boardList(BmBoardVO bbvo);

	// 글상세보기(detail)구현 =====================================
	public List<BmBoardVO> boardDetail(BmBoardVO bbvo);
	
	// 글번호 채번 ===============================================
	public BmBoardVO boardNum();
	
	// 글쓰기(insert)구현  ============================
	public int boardInsert(BmBoardVO bbvo);
	
	// 글수정(update)구현 ============================
	public int boardUpdate(BmBoardVO bbvo);
	
	// 글삭제(delete)구현 =======================================
	public int boardDelete(BmBoardVO bbvo);
	
	// 1.게시글추천여부 조회 =========================================
	public List<BmBoardVO> boardLikeyYN(BmBoardVO bbvo);
	
	// 2-1.추천수 여부 조회 후 0건일 경우 => INSERT 하기 ===================
	public int boardLikeyInsert(BmBoardVO bbvo);
	
	// 2-2.추천수 여부 조회 결과 1건이면서, 값이 'N'일 경우 => 'Y'로 변경하기 ======
	public int boardLikeyON(BmBoardVO bbvo);
	
	// 2-3.추천수 여부 조회 결과 1건이면서, 값이 'Y'일 경우 => 'N'으로 변경하기 ======
	public int boardLikeyOFF(BmBoardVO bbvo);
	
	// 3-1.추천수 count 올리기 구현 ============================
	public int boardLikeyUp(BmBoardVO bbvo);
	
	// 3-2.추천수 count 내리기 구현 ============================
	public int boardLikeyDown(BmBoardVO bbvo);
	
	// 1.게시글스크랩여부 조회 =========================================	
	public List<BmBoardVO> boardScrapYN(BmBoardVO bbvo);
	
	// 2-0.스크랩 채번 ===============================================
	public BmBoardVO scrapNum();
	
	// 2-1.스크랩 여부 조회 후 0건일 경우 => INSERT 하기 ===================
	public int boardScrapInsert(BmBoardVO bbvo);
	
	// 2-2.스크랩 여부 조회 결과 1건이면서, 값이 'N'일 경우 => 'Y'로 변경하기 ======
	public int boardScrapON(BmBoardVO bbvo);
	
	// 2-3.스크랩 여부 조회 결과 1건이면서, 값이 'Y'일 경우 => 'N'으로 변경하기 ======
	public int boardScrapOFF(BmBoardVO bbvo);
	
	// 3-1.스크랩 count 올리기 구현 ============================
	public int boardScrapUp(BmBoardVO bbvo);
	
	// 3-2.스크랩 count 내리기 구현 ============================
	public int boardScrapDown(BmBoardVO bbvo);	
	
	// 4.스크랩보관함 구현 ===================================
	public List<BmBoardVO> boardScrapList(BmBoardVO bbvo);
	
	// 페이징 total 구현 ============================
	public int paging(BmBoardVO bbvo);
	
	// 스크랩 페이징 total 구현 ============================
	public int pagingScrap(BmBoardVO bbvo);		
	
	// 조회수 카운트 구현 ============================
	public int viewCount(BmBoardVO bbvo);
	
	// 스크랩 오프 카운트 구현 ==========================
	public int scrapOff(BmBoardVO bbvo);
	
	// 내가쓴글 구현 ===================================
	public List<BmBoardVO> boardMyList(BmBoardVO bbvo);
	
	// 페이징 스크랩 total 구현 ============================
	public int pagingMyList(BmBoardVO bbvo);
}
