package kr.co.seoulit.erp.account.posting.ledger.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import kr.co.seoulit.erp.account.posting.business.dto.JournalDetailresDto;
import kr.co.seoulit.erp.account.posting.ledger.dto.JournalDtoRes;
import kr.co.seoulit.erp.account.posting.ledger.entity.JournalDetailResEntity;
import kr.co.seoulit.erp.account.posting.ledger.entity.JournalResEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-15T20:26:19+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.11 (Oracle Corporation)"
)
@Component
public class JournalMapstructImpl implements JournalMapstruct {

    @Override
    public JournalDtoRes toDto(JournalResEntity entity) {
        if ( entity == null ) {
            return null;
        }

        JournalDtoRes journalDtoRes = new JournalDtoRes();

        journalDtoRes.setStatus( entity.getStatus() );
        journalDtoRes.setJournalNo( entity.getJournalNo() );
        journalDtoRes.setSlipNo( entity.getSlipNo() );
        journalDtoRes.setBalanceDivision( entity.getBalanceDivision() );
        journalDtoRes.setAccountInnerCode( entity.getAccountInnerCode() );
        journalDtoRes.setAccountName( entity.getAccountName() );
        journalDtoRes.setLeftDebtorPrice( entity.getLeftDebtorPrice() );
        journalDtoRes.setRightCreditsPrice( entity.getRightCreditsPrice() );
        journalDtoRes.setJournalDetailList( journalDetailResEntityListToJournalDetailresDtoList( entity.getJournalDetailList() ) );

        return journalDtoRes;
    }

    @Override
    public List<JournalDtoRes> toDto(List<JournalResEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<JournalDtoRes> list = new ArrayList<JournalDtoRes>( entities.size() );
        for ( JournalResEntity journalResEntity : entities ) {
            list.add( toDto( journalResEntity ) );
        }

        return list;
    }

    protected JournalDetailresDto journalDetailResEntityToJournalDetailresDto(JournalDetailResEntity journalDetailResEntity) {
        if ( journalDetailResEntity == null ) {
            return null;
        }

        JournalDetailresDto journalDetailresDto = new JournalDetailresDto();

        journalDetailresDto.setStatus( journalDetailResEntity.getStatus() );
        journalDetailresDto.setJournalDetailNo( journalDetailResEntity.getJournalDetailNo() );
        journalDetailresDto.setJournalNo( journalDetailResEntity.getJournalNo() );
        journalDetailresDto.setAccountControlCode( journalDetailResEntity.getAccountControlCode() );
        journalDetailresDto.setJournalDescription( journalDetailResEntity.getJournalDescription() );
        journalDetailresDto.setAccountControlDescription( journalDetailResEntity.getAccountControlDescription() );
        journalDetailresDto.setAccountControlName( journalDetailResEntity.getAccountControlName() );
        journalDetailresDto.setAccountControlType( journalDetailResEntity.getAccountControlType() );

        return journalDetailresDto;
    }

    protected List<JournalDetailresDto> journalDetailResEntityListToJournalDetailresDtoList(List<JournalDetailResEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<JournalDetailresDto> list1 = new ArrayList<JournalDetailresDto>( list.size() );
        for ( JournalDetailResEntity journalDetailResEntity : list ) {
            list1.add( journalDetailResEntityToJournalDetailresDto( journalDetailResEntity ) );
        }

        return list1;
    }
}
