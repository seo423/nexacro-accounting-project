package kr.co.seoulit.erp.account.posting.ledger.mapstruct;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.annotation.processing.Generated;
import kr.co.seoulit.erp.account.posting.ledger.dto.AssetResDto;
import kr.co.seoulit.erp.account.posting.ledger.entity.AssetEntity;
import kr.co.seoulit.erp.account.posting.ledger.entity.AssetItemEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-15T20:26:19+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.11 (Oracle Corporation)"
)
@Component
public class AssetMapStructImpl implements AssetMapStruct {

    @Override
    public AssetResDto toDto(AssetEntity entity) {
        if ( entity == null ) {
            return null;
        }

        AssetResDto assetResDto = new AssetResDto();

        assetResDto.setAssetName( entity.getAssetName() );
        assetResDto.setAssetCode( entity.getAssetCode() );

        return assetResDto;
    }

    @Override
    public List<AssetResDto> toDto(List<AssetEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<AssetResDto> list = new ArrayList<AssetResDto>( entities.size() );
        for ( AssetEntity assetEntity : entities ) {
            list.add( toDto( assetEntity ) );
        }

        return list;
    }

    @Override
    public AssetResDto toDto(Optional<AssetItemEntity> entity) {
        if ( entity == null ) {
            return null;
        }

        AssetResDto assetResDto = new AssetResDto();

        return assetResDto;
    }
}
