package kr.co.seoulit.erp.account.operate.currentAsset.mapstruct;


import kr.co.seoulit.erp.account.operate.currentAsset.entity.CurrentAssetDetailEntity;
import kr.co.seoulit.erp.account.operate.currentAsset.to.CurrentAssetDetailResDTO;
import kr.co.seoulit.erp.account.sys.common.mapstruct.EntityResMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CurrentAssetDetailResMapStruct extends EntityResMapper<CurrentAssetDetailEntity, CurrentAssetDetailResDTO> {

    @Override
    CurrentAssetDetailResDTO toDto(CurrentAssetDetailEntity entity);

    @Override
    List<CurrentAssetDetailResDTO> toDto(List<CurrentAssetDetailEntity> entities);
}
