package kr.co.seoulit.erp.account.operate.system.mapstruct;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.processing.Generated;
import kr.co.seoulit.erp.account.operate.system.entity.BoardEntity;
import kr.co.seoulit.erp.account.operate.system.to.BoardReqDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-05T21:32:50+0900",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.1.jar, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class BoardReqMapStructImpl implements BoardReqMapStruct {

    @Override
    public BoardEntity toEntity(BoardReqDTO dto) {
        if ( dto == null ) {
            return null;
        }

        String id = null;
        String title = null;
        String contents = null;
        String writtenBy = null;
        Date writeDate = null;
        Date updateDateTime = null;

        id = dto.getId();
        title = dto.getTitle();
        contents = dto.getContents();
        writtenBy = dto.getWrittenBy();
        writeDate = dto.getWriteDate();
        updateDateTime = dto.getUpdateDateTime();

        BoardEntity boardEntity = new BoardEntity( id, title, contents, writtenBy, writeDate, updateDateTime );

        boardEntity.setStatus( dto.getStatus() );

        return boardEntity;
    }

    @Override
    public List<BoardEntity> toEntity(List<BoardReqDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<BoardEntity> list = new ArrayList<BoardEntity>( dtos.size() );
        for ( BoardReqDTO boardReqDTO : dtos ) {
            list.add( toEntity( boardReqDTO ) );
        }

        return list;
    }
}
