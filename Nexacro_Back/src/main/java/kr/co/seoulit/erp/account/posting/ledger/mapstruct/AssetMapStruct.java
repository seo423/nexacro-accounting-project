package kr.co.seoulit.erp.account.posting.ledger.mapstruct;

import kr.co.seoulit.erp.account.posting.ledger.entity.AssetEntity;
import kr.co.seoulit.erp.account.posting.ledger.entity.AssetItemEntity;
import kr.co.seoulit.erp.account.posting.ledger.dto.AssetResDto;
import kr.co.seoulit.erp.account.sys.common.mapstruct.EntityResMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.Optional;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface AssetMapStruct extends EntityResMapper<AssetEntity, AssetResDto> {

    AssetResDto toDto(Optional<AssetItemEntity> entity) ;
}



