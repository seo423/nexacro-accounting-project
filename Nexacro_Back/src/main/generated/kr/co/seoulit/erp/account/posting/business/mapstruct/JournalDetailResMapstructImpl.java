package kr.co.seoulit.erp.account.posting.business.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import kr.co.seoulit.erp.account.posting.business.entity.JournalDetailEntity;
import kr.co.seoulit.erp.account.posting.business.dto.JournalDetailresDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-15T20:26:19+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.11 (Oracle Corporation)"
)
@Component
public class JournalDetailResMapstructImpl implements JournalDetailResMapstruct {

    @Override
    public JournalDetailresDto toDto(JournalDetailEntity entity) {
        if ( entity == null ) {
            return null;
        }

        JournalDetailresDto journalDetailresDto = new JournalDetailresDto();

        journalDetailresDto.setStatus( entity.getStatus() );
        journalDetailresDto.setJournalDetailNo( entity.getJournalDetailNo() );
        journalDetailresDto.setJournalNo( entity.getJournalNo() );
        journalDetailresDto.setAccountControlCode( entity.getAccountControlCode() );
        journalDetailresDto.setJournalDescription( entity.getJournalDescription() );
        journalDetailresDto.setAccountControlDescription( entity.getAccountControlDescription() );
        journalDetailresDto.setAccountControlName( entity.getAccountControlName() );
        journalDetailresDto.setAccountControlType( entity.getAccountControlType() );

        return journalDetailresDto;
    }

    @Override
    public List<JournalDetailresDto> toDto(List<JournalDetailEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<JournalDetailresDto> list = new ArrayList<JournalDetailresDto>( entities.size() );
        for ( JournalDetailEntity journalDetailEntity : entities ) {
            list.add( toDto( journalDetailEntity ) );
        }

        return list;
    }
}
