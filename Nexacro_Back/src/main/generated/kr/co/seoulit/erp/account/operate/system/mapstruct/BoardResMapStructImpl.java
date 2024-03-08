package kr.co.seoulit.erp.account.operate.system.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import kr.co.seoulit.erp.account.operate.system.entity.BoardEntity;
import kr.co.seoulit.erp.account.operate.system.to.BoardResDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-15T20:44:08+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.11 (Oracle Corporation)"
)
@Component
public class BoardResMapStructImpl implements BoardResMapStruct {

    @Override
    public BoardResDTO toDto(BoardEntity arg0) {
        if ( arg0 == null ) {
            return null;
        }

        BoardResDTO boardResDTO = new BoardResDTO();

        boardResDTO.setId( arg0.getId() );
        boardResDTO.setTitle( arg0.getTitle() );
        boardResDTO.setContents( arg0.getContents() );
        boardResDTO.setWrittenBy( arg0.getWrittenBy() );
        boardResDTO.setWriteDate( arg0.getWriteDate() );
        boardResDTO.setUpdateDateTime( arg0.getUpdateDateTime() );

        return boardResDTO;
    }

    @Override
    public List<BoardResDTO> toDto(List<BoardEntity> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<BoardResDTO> list = new ArrayList<BoardResDTO>( arg0.size() );
        for ( BoardEntity boardEntity : arg0 ) {
            list.add( toDto( boardEntity ) );
        }

        return list;
    }
}
