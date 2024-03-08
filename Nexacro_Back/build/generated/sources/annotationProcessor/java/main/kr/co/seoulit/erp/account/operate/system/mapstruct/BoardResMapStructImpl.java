package kr.co.seoulit.erp.account.operate.system.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import kr.co.seoulit.erp.account.operate.system.entity.BoardEntity;
import kr.co.seoulit.erp.account.operate.system.to.BoardResDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-05T21:32:50+0900",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.1.jar, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class BoardResMapStructImpl implements BoardResMapStruct {

    @Override
    public BoardResDTO toDto(BoardEntity entity) {
        if ( entity == null ) {
            return null;
        }

        BoardResDTO boardResDTO = new BoardResDTO();

        boardResDTO.setId( entity.getId() );
        boardResDTO.setTitle( entity.getTitle() );
        boardResDTO.setContents( entity.getContents() );
        boardResDTO.setWrittenBy( entity.getWrittenBy() );
        boardResDTO.setWriteDate( entity.getWriteDate() );
        boardResDTO.setUpdateDateTime( entity.getUpdateDateTime() );

        return boardResDTO;
    }

    @Override
    public List<BoardResDTO> toDto(List<BoardEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<BoardResDTO> list = new ArrayList<BoardResDTO>( entities.size() );
        for ( BoardEntity boardEntity : entities ) {
            list.add( toDto( boardEntity ) );
        }

        return list;
    }
}
