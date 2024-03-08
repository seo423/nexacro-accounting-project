package kr.co.seoulit.erp.account.posting.business.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import kr.co.seoulit.erp.account.posting.business.dto.JournalDetailreqDto;
import kr.co.seoulit.erp.account.posting.business.entity.JournalDetailEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-08T18:14:24+0900",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.1.jar, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class JournalDetailReqMapstructImpl implements JournalDetailReqMapstruct {

    @Override
    public JournalDetailEntity toEntity(JournalDetailreqDto dto) {
        if ( dto == null ) {
            return null;
        }

        JournalDetailEntity journalDetailEntity = new JournalDetailEntity();

        journalDetailEntity.setStatus( dto.getStatus() );
        journalDetailEntity.setJournalDetailNo( dto.getJournalDetailNo() );
        journalDetailEntity.setJournalNo( dto.getJournalNo() );
        journalDetailEntity.setAccountControlCode( dto.getAccountControlCode() );
        journalDetailEntity.setJournalDescription( dto.getJournalDescription() );
        journalDetailEntity.setAccountControlDescription( dto.getAccountControlDescription() );
        journalDetailEntity.setAccountControlName( dto.getAccountControlName() );
        journalDetailEntity.setAccountControlType( dto.getAccountControlType() );
        journalDetailEntity.setAccountName( dto.getAccountName() );

        return journalDetailEntity;
    }

    @Override
    public List<JournalDetailEntity> toEntity(List<JournalDetailreqDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<JournalDetailEntity> list = new ArrayList<JournalDetailEntity>( dtos.size() );
        for ( JournalDetailreqDto journalDetailreqDto : dtos ) {
            list.add( toEntity( journalDetailreqDto ) );
        }

        return list;
    }
}
