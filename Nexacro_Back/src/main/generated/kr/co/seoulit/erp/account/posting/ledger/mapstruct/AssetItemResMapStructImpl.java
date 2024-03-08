package kr.co.seoulit.erp.account.posting.ledger.mapstruct;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.annotation.processing.Generated;
import kr.co.seoulit.erp.account.posting.ledger.dto.AssetItemResDto;
import kr.co.seoulit.erp.account.posting.ledger.entity.AssetItemEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-15T20:26:19+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.11 (Oracle Corporation)"
)
@Component
public class AssetItemResMapStructImpl implements AssetItemResMapStruct {

    @Override
    public AssetItemResDto toDto(AssetItemEntity entity) {
        if ( entity == null ) {
            return null;
        }

        AssetItemResDto assetItemResDto = new AssetItemResDto();

        assetItemResDto.setAssetItemCode( entity.getAssetItemCode() );
        assetItemResDto.setAssetItemName( entity.getAssetItemName() );
        assetItemResDto.setAcquisitionDate( entity.getAcquisitionDate() );
        assetItemResDto.setAcquisitionAmount( entity.getAcquisitionAmount() );
        assetItemResDto.setUsefulLife( entity.getUsefulLife() );
        assetItemResDto.setManagementDeptName( entity.getManagementDeptName() );
        assetItemResDto.setParentsCode( entity.getParentsCode() );
        assetItemResDto.setParentsName( entity.getParentsName() );
        assetItemResDto.setAccumulatedDepreciation( entity.getAccumulatedDepreciation() );
        assetItemResDto.setResidualValue( entity.getResidualValue() );
        assetItemResDto.setResidualLife( entity.getResidualLife() );

        return assetItemResDto;
    }

    @Override
    public List<AssetItemResDto> toDto(List<AssetItemEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<AssetItemResDto> list = new ArrayList<AssetItemResDto>( entities.size() );
        for ( AssetItemEntity assetItemEntity : entities ) {
            list.add( toDto( assetItemEntity ) );
        }

        return list;
    }

    @Override
    public AssetItemResDto toDto(Optional<AssetItemEntity> entity) {
        if ( entity == null ) {
            return null;
        }

        AssetItemResDto assetItemResDto = new AssetItemResDto();

        return assetItemResDto;
    }
}
