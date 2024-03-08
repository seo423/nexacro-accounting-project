package kr.co.seoulit.erp.account.operate.currentAsset.mapstruct;


import kr.co.seoulit.erp.account.operate.currentAsset.entity.CurrentAssetEntity;
import kr.co.seoulit.erp.account.operate.currentAsset.to.CurrentAssetReqDTO;
import kr.co.seoulit.erp.account.sys.common.mapstruct.EntityReqMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CurrentAssetReqMapStruct extends EntityReqMapper<CurrentAssetEntity, CurrentAssetReqDTO>
{
    @Override
    CurrentAssetEntity toEntity(CurrentAssetReqDTO dto);

    @Override
    List<CurrentAssetEntity> toEntity(List<CurrentAssetReqDTO> dtos);

    CurrentAssetReqMapStruct MAPPER = Mappers.getMapper(CurrentAssetReqMapStruct.class);
}
