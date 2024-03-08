package kr.co.seoulit.erp.account.operate.system.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import kr.co.seoulit.erp.account.operate.system.entity.BoardEntity;

@Mapper
public interface BoardDAO {

	// 게시판 조회
	List<BoardEntity> findBoardList()throws Exception;

	// 게시글 상세조회
	BoardEntity findBoardDetail(String boardId)throws Exception;

	// 게시판 추가 / 수정
	void mergeBoard(BoardEntity noticeBoardEntity) throws Exception;

	// 게시판 삭제
	void deleteBoard(String boardId)throws Exception;
}
