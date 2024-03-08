package kr.co.seoulit.erp.account.posting.business.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import kr.co.seoulit.erp.account.posting.business.entity.JournalDetailEntity;
import kr.co.seoulit.erp.account.posting.business.entity.JournalEntity;
import kr.co.seoulit.erp.account.posting.business.dto.JournalDetailreqDto;
import kr.co.seoulit.erp.account.posting.business.dto.JournalresDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-15T20:26:19+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.11 (Oracle Corporation)"
)
@Component
public class JournalResMapstructImpl implements JournalResMapstruct {

    @Override
    public JournalresDto toDto(JournalEntity entity) {
        if ( entity == null ) {
            return null;
        }

        JournalresDto journalresDto = new JournalresDto();

        journalresDto.setStatus( entity.getStatus() );
        journalresDto.setJournalNo( entity.getJournalNo() );
        journalresDto.setSlipNo( entity.getSlipNo() );
        journalresDto.setBalanceDivision( entity.getBalanceDivision() );
        journalresDto.setAccountInnerCode( entity.getAccountInnerCode() );
        journalresDto.setAccountName( entity.getAccountName() );
        journalresDto.setCustomerCode( entity.getCustomerCode() );
        journalresDto.setCustomerName( entity.getCustomerName() );
        journalresDto.setLeftDebtorPrice( entity.getLeftDebtorPrice() );
        journalresDto.setRightCreditsPrice( entity.getRightCreditsPrice() );
        journalresDto.setJournalDetailList( journalDetailEntityListToJournalDetailreqDtoList( entity.getJournalDetailList() ) );

        return journalresDto;
    }

    @Override
    public List<JournalresDto> toDto(List<JournalEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<JournalresDto> list = new ArrayList<JournalresDto>( entities.size() );
        for ( JournalEntity journalEntity : entities ) {
            list.add( toDto( journalEntity ) );
        }

        return list;
    }

    protected JournalDetailreqDto journalDetailEntityToJournalDetailreqDto(JournalDetailEntity journalDetailEntity) {
        if ( journalDetailEntity == null ) {
            return null;
        }

        JournalDetailreqDto journalDetailreqDto = new JournalDetailreqDto();

        journalDetailreqDto.setStatus( journalDetailEntity.getStatus() );
        journalDetailreqDto.setJournalDetailNo( journalDetailEntity.getJournalDetailNo() );
        journalDetailreqDto.setJournalNo( journalDetailEntity.getJournalNo() );
        journalDetailreqDto.setAccountControlCode( journalDetailEntity.getAccountControlCode() );
        journalDetailreqDto.setJournalDescription( journalDetailEntity.getJournalDescription() );
        journalDetailreqDto.setAccountControlDescription( journalDetailEntity.getAccountControlDescription() );
        journalDetailreqDto.setAccountControlName( journalDetailEntity.getAccountControlName() );
        journalDetailreqDto.setAccountControlType( journalDetailEntity.getAccountControlType() );

        return journalDetailreqDto;
    }

    protected List<JournalDetailreqDto> journalDetailEntityListToJournalDetailreqDtoList(List<JournalDetailEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<JournalDetailreqDto> list1 = new ArrayList<JournalDetailreqDto>( list.size() );
        for ( JournalDetailEntity journalDetailEntity : list ) {
            list1.add( journalDetailEntityToJournalDetailreqDto( journalDetailEntity ) );
        }

        return list1;
    }
}
