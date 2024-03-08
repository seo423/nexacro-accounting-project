package kr.co.seoulit.erp.account.posting.business.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import kr.co.seoulit.erp.account.posting.business.entity.SlipEntity;
import kr.co.seoulit.erp.account.posting.business.dto.SlipreqDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-15T20:26:19+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.11 (Oracle Corporation)"
)
@Component
public class SlipReqMapstructImpl implements SlipReqMapstruct {

    @Override
    public SlipEntity toEntity(SlipreqDto dto) {
        if ( dto == null ) {
            return null;
        }

        SlipEntity slipEntity = new SlipEntity();

        slipEntity.setStatus( dto.getStatus() );
        slipEntity.setSlipNo( dto.getSlipNo() );
        slipEntity.setAccountPeriodNo( dto.getAccountPeriodNo() );
        slipEntity.setDeptCode( dto.getDeptCode() );
        slipEntity.setSlipType( dto.getSlipType() );
        slipEntity.setExpenseReport( dto.getExpenseReport() );
        slipEntity.setReportingEmpCode( dto.getReportingEmpCode() );
        slipEntity.setReportingDate( dto.getReportingDate() );
        slipEntity.setApprovalEmpCode( dto.getApprovalEmpCode() );
        slipEntity.setApprovalDate( dto.getApprovalDate() );
        slipEntity.setSlipStatus( dto.getSlipStatus() );

        return slipEntity;
    }

    @Override
    public List<SlipEntity> toEntity(List<SlipreqDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<SlipEntity> list = new ArrayList<SlipEntity>( dtos.size() );
        for ( SlipreqDto slipreqDto : dtos ) {
            list.add( toEntity( slipreqDto ) );
        }

        return list;
    }
}
