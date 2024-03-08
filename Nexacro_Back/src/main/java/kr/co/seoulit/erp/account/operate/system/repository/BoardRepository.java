package kr.co.seoulit.erp.account.operate.system.repository;

import kr.co.seoulit.erp.account.operate.system.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {

    // 게시판 조회
    @Query("SELECT board FROM BoardEntity board")
    List<BoardEntity> findBoardList();

    // 게시판 상세 조회
    @Query("SELECT board FROM BoardEntity board WHERE board.id = :boardId")
    BoardEntity findBoardDetail(@Param("boardId") String boardId);



}
