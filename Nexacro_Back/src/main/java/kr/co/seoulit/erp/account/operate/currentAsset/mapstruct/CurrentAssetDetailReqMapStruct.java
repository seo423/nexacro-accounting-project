package kr.co.seoulit.erp.account.operate.currentAsset.mapstruct;


import kr.co.seoulit.erp.account.operate.currentAsset.entity.CurrentAssetDetailEntity;
import kr.co.seoulit.erp.account.operate.currentAsset.to.CurrentAssetDetailReqDTO;
import kr.co.seoulit.erp.account.sys.common.mapstruct.EntityReqMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CurrentAssetDetailReqMapStruct extends EntityReqMapper<CurrentAssetDetailEntity, CurrentAssetDetailReqDTO>
{
    @Override
    CurrentAssetDetailEntity toEntity(CurrentAssetDetailReqDTO dto);

    @Override
    List<CurrentAssetDetailEntity> toEntity(List<CurrentAssetDetailReqDTO> dtos);

    CurrentAssetDetailReqMapStruct MAPPER = Mappers.getMapper(CurrentAssetDetailReqMapStruct.class);
}
