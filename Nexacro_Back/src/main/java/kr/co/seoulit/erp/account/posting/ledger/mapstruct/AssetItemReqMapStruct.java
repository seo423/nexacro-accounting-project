package kr.co.seoulit.erp.account.posting.ledger.mapstruct;

import kr.co.seoulit.erp.account.posting.ledger.entity.AssetItemEntity;
import kr.co.seoulit.erp.account.posting.ledger.dto.AssetItemReqDto;
import kr.co.seoulit.erp.account.sys.common.mapstruct.EntityReqMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.Optional;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface AssetItemReqMapStruct extends EntityReqMapper<AssetItemEntity, AssetItemReqDto> {


    AssetItemReqDto toDto(Optional<AssetItemEntity> entity);

    @Override
    AssetItemEntity toEntity(AssetItemReqDto dto);
}



