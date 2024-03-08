package kr.co.seoulit.erp.account.posting.ledger.mapstruct;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.annotation.processing.Generated;
import kr.co.seoulit.erp.account.posting.ledger.dto.AssetItemReqDto;
import kr.co.seoulit.erp.account.posting.ledger.entity.AssetItemEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-08T18:14:24+0900",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.1.jar, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class AssetItemReqMapStructImpl implements AssetItemReqMapStruct {

    @Override
    public List<AssetItemEntity> toEntity(List<AssetItemReqDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<AssetItemEntity> list = new ArrayList<AssetItemEntity>( dtos.size() );
        for ( AssetItemReqDto assetItemReqDto : dtos ) {
            list.add( toEntity( assetItemReqDto ) );
        }

        return list;
    }

    @Override
    public AssetItemReqDto toDto(Optional<AssetItemEntity> entity) {
        if ( entity == null ) {
            return null;
        }

        AssetItemReqDto assetItemReqDto = new AssetItemReqDto();

        return assetItemReqDto;
    }

    @Override
    public AssetItemEntity toEntity(AssetItemReqDto dto) {
        if ( dto == null ) {
            return null;
        }

        AssetItemEntity assetItemEntity = new AssetItemEntity();

        assetItemEntity.setAssetItemCode( dto.getAssetItemCode() );
        assetItemEntity.setAssetItemName( dto.getAssetItemName() );
        assetItemEntity.setAcquisitionDate( dto.getAcquisitionDate() );
        assetItemEntity.setAcquisitionAmount( dto.getAcquisitionAmount() );
        assetItemEntity.setUsefulLife( dto.getUsefulLife() );
        assetItemEntity.setManagementDeptName( dto.getManagementDeptName() );
        assetItemEntity.setParentsCode( dto.getParentsCode() );
        assetItemEntity.setParentsName( dto.getParentsName() );

        return assetItemEntity;
    }
}
