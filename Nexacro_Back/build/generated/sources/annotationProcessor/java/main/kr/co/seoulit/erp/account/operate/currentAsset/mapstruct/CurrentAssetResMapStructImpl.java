package kr.co.seoulit.erp.account.operate.currentAsset.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import kr.co.seoulit.erp.account.operate.currentAsset.entity.CurrentAssetEntity;
import kr.co.seoulit.erp.account.operate.currentAsset.to.CurrentAssetResDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-05T21:32:50+0900",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.1.jar, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class CurrentAssetResMapStructImpl implements CurrentAssetResMapStruct {

    @Override
    public CurrentAssetResDTO toDto(CurrentAssetEntity entity) {
        if ( entity == null ) {
            return null;
        }

        CurrentAssetResDTO currentAssetResDTO = new CurrentAssetResDTO();

        currentAssetResDTO.setAccountName( entity.getAccountName() );
        currentAssetResDTO.setAssetCode( entity.getAssetCode() );
        currentAssetResDTO.setAccountCode( entity.getAccountCode() );
        currentAssetResDTO.setAssetName( entity.getAssetName() );
        currentAssetResDTO.setProgress( entity.getProgress() );
        currentAssetResDTO.setFinalizeStatus( entity.getFinalizeStatus() );
        currentAssetResDTO.setAcquisitionCost( entity.getAcquisitionCost() );
        currentAssetResDTO.setAmortizationWay( entity.getAmortizationWay() );
        currentAssetResDTO.setDepartment( entity.getDepartment() );
        currentAssetResDTO.setDepreciation( entity.getDepreciation() );
        currentAssetResDTO.setBookValue( entity.getBookValue() );
        currentAssetResDTO.setUsefulLife( entity.getUsefulLife() );
        currentAssetResDTO.setAmortizationFinalYear( entity.getAmortizationFinalYear() );
        currentAssetResDTO.setAcquisitionQuantity( entity.getAcquisitionQuantity() );
        currentAssetResDTO.setChangeQuantity( entity.getChangeQuantity() );
        currentAssetResDTO.setRemainQuantity( entity.getRemainQuantity() );
        currentAssetResDTO.setAmortizationRate( entity.getAmortizationRate() );
        currentAssetResDTO.setMonth( entity.getMonth() );
        currentAssetResDTO.setNormalAmortization( entity.getNormalAmortization() );
        currentAssetResDTO.setAccumulatedAmortization( entity.getAccumulatedAmortization() );
        currentAssetResDTO.setBookValueEnd( entity.getBookValueEnd() );

        return currentAssetResDTO;
    }

    @Override
    public ArrayList<CurrentAssetResDTO> toDto(List<CurrentAssetEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        ArrayList<CurrentAssetResDTO> arrayList = new ArrayList<CurrentAssetResDTO>();
        for ( CurrentAssetEntity currentAssetEntity : entities ) {
            arrayList.add( toDto( currentAssetEntity ) );
        }

        return arrayList;
    }
}
