package kr.co.seoulit.erp.account.operate.system.service;

import kr.co.seoulit.erp.account.operate.system.to.BoardReqDTO;
import kr.co.seoulit.erp.account.operate.system.to.BoardResDTO;

import java.util.List;

public interface BoardService {

    // 게시판 조회
    public List<BoardResDTO> findBoardList()throws Exception;

    // 게시판 상세 조회
    public BoardResDTO findBoardDetail(String boardId)throws Exception;

    // 게시판 추가
    public void insertBoard(BoardReqDTO BoardReqDto)throws Exception;

    // 게시판 수정
    public void updateBoard(BoardReqDTO BoardReqDto)throws Exception;

    // 게시판 삭제
    public void deleteBoard(String boardId)throws Exception;

}
