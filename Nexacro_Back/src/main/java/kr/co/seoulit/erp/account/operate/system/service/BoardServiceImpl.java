package kr.co.seoulit.erp.account.operate.system.service;

import kr.co.seoulit.erp.account.operate.system.dao.*;
import kr.co.seoulit.erp.account.operate.system.to.*;
import kr.co.seoulit.erp.account.operate.system.entity.*;
import kr.co.seoulit.erp.account.operate.system.mapstruct.*;
import kr.co.seoulit.erp.account.operate.system.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardDAO boardDAO;
    @Autowired
    private BoardReqMapStruct boardReqMapstruct;
    @Autowired
    private BoardResMapStruct boardResMapstruct;


    // 게시판 조회
    @Override
    public List<BoardResDTO> findBoardList() throws Exception {

        List<BoardEntity> BoardEntityList = boardDAO.findBoardList();

        return	boardResMapstruct.toDto(BoardEntityList);
    }

    // 게시판 상세 조회
    @Override
    public BoardResDTO findBoardDetail(String boardId) throws Exception {

        BoardEntity BoardEntity = boardDAO.findBoardDetail(boardId);

        return	boardResMapstruct.toDto(BoardEntity);
    }

    // 게시판 추가
    @Override
    public void insertBoard(BoardReqDTO boardReqDTO) throws Exception {

        BoardEntity BoardEntity = boardReqMapstruct.toEntity(boardReqDTO);

        boardDAO.mergeBoard(BoardEntity);
    }

    // 게시판 수정
    @Override
    public void updateBoard(BoardReqDTO boardReqDTO) throws Exception {

        BoardEntity BoardEntity = boardReqMapstruct.toEntity(boardReqDTO);

        boardDAO.mergeBoard(BoardEntity);
    }

    // 게시판 삭제
    @Override
    public void deleteBoard(String boardId) throws Exception {

        boardDAO.deleteBoard(boardId);
    }
}

