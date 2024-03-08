package kr.co.seoulit.erp.account.operate.system.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import kr.co.seoulit.erp.account.operate.system.entity.BoardEntity;
import kr.co.seoulit.erp.account.operate.system.to.BoardReqDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-15T20:44:08+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.11 (Oracle Corporation)"
)
@Component
public class BoardReqMapStructImpl implements BoardReqMapStruct {

    @Override
    public BoardEntity toEntity(BoardReqDTO arg0) {
        if ( arg0 == null ) {
            return null;
        }

        BoardEntity boardEntity = new BoardEntity();

        boardEntity.setStatus( arg0.getStatus() );
        boardEntity.setId( arg0.getId() );
        boardEntity.setTitle( arg0.getTitle() );
        boardEntity.setContents( arg0.getContents() );
        boardEntity.setWrittenBy( arg0.getWrittenBy() );
        boardEntity.setWriteDate( arg0.getWriteDate() );
        boardEntity.setUpdateDateTime( arg0.getUpdateDateTime() );

        return boardEntity;
    }

    @Override
    public List<BoardEntity> toEntity(List<BoardReqDTO> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<BoardEntity> list = new ArrayList<BoardEntity>( arg0.size() );
        for ( BoardReqDTO boardReqDTO : arg0 ) {
            list.add( toEntity( boardReqDTO ) );
        }

        return list;
    }
}
