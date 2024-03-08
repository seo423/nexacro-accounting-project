package kr.co.seoulit.erp.account.operate.currentAsset.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import kr.co.seoulit.erp.account.operate.currentAsset.entity.CurrentAssetEntity;
import kr.co.seoulit.erp.account.operate.currentAsset.to.CurrentAssetReqDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-08T18:47:44+0900",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.1.jar, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class CurrentAssetReqMapStructImpl implements CurrentAssetReqMapStruct {

    @Override
    public CurrentAssetEntity toEntity(CurrentAssetReqDTO dto) {
        if ( dto == null ) {
            return null;
        }

        CurrentAssetEntity currentAssetEntity = new CurrentAssetEntity();

        currentAssetEntity.setAccountName( dto.getAccountName() );
        currentAssetEntity.setAssetCode( dto.getAssetCode() );
        currentAssetEntity.setAccountCode( dto.getAccountCode() );
        currentAssetEntity.setAssetName( dto.getAssetName() );
        currentAssetEntity.setProgress( dto.getProgress() );
        currentAssetEntity.setFinalizeStatus( dto.getFinalizeStatus() );
        currentAssetEntity.setAcquisitionCost( dto.getAcquisitionCost() );
        currentAssetEntity.setAmortizationWay( dto.getAmortizationWay() );
        currentAssetEntity.setDepartment( dto.getDepartment() );
        currentAssetEntity.setDepreciation( dto.getDepreciation() );
        currentAssetEntity.setBookValue( dto.getBookValue() );
        currentAssetEntity.setUsefulLife( dto.getUsefulLife() );
        currentAssetEntity.setAmortizationFinalYear( dto.getAmortizationFinalYear() );
        currentAssetEntity.setAcquisitionQuantity( dto.getAcquisitionQuantity() );
        currentAssetEntity.setChangeQuantity( dto.getChangeQuantity() );
        currentAssetEntity.setRemainQuantity( dto.getRemainQuantity() );
        currentAssetEntity.setAmortizationRate( dto.getAmortizationRate() );
        currentAssetEntity.setMonth( dto.getMonth() );
        currentAssetEntity.setNormalAmortization( dto.getNormalAmortization() );
        currentAssetEntity.setAccumulatedAmortization( dto.getAccumulatedAmortization() );
        currentAssetEntity.setBookValueEnd( dto.getBookValueEnd() );

        return currentAssetEntity;
    }

    @Override
    public List<CurrentAssetEntity> toEntity(List<CurrentAssetReqDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<CurrentAssetEntity> list = new ArrayList<CurrentAssetEntity>( dtos.size() );
        for ( CurrentAssetReqDTO currentAssetReqDTO : dtos ) {
            list.add( toEntity( currentAssetReqDTO ) );
        }

        return list;
    }
}
