package kr.co.seoulit.erp.account.posting.ledger.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import kr.co.seoulit.erp.account.posting.ledger.dto.JournalDetailDtoRes;
import kr.co.seoulit.erp.account.posting.ledger.entity.JournalDetailResEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-05T21:32:50+0900",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.1.jar, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class JournalDetailMapstructImpl implements JournalDetailMapstruct {

    @Override
    public JournalDetailDtoRes toDto(JournalDetailResEntity entity) {
        if ( entity == null ) {
            return null;
        }

        JournalDetailDtoRes journalDetailDtoRes = new JournalDetailDtoRes();

        journalDetailDtoRes.setStatus( entity.getStatus() );
        journalDetailDtoRes.setJournalDetailNo( entity.getJournalDetailNo() );
        journalDetailDtoRes.setJournalNo( entity.getJournalNo() );
        journalDetailDtoRes.setAccountControlDescription( entity.getAccountControlDescription() );
        journalDetailDtoRes.setAccountControlName( entity.getAccountControlName() );

        return journalDetailDtoRes;
    }

    @Override
    public List<JournalDetailDtoRes> toDto(List<JournalDetailResEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<JournalDetailDtoRes> list = new ArrayList<JournalDetailDtoRes>( entities.size() );
        for ( JournalDetailResEntity journalDetailResEntity : entities ) {
            list.add( toDto( journalDetailResEntity ) );
        }

        return list;
    }
}
