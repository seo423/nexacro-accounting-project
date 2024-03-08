package kr.co.seoulit.erp.account.operate.currentAsset.mapstruct;


import kr.co.seoulit.erp.account.operate.currentAsset.entity.CurrentAssetEntity;
import kr.co.seoulit.erp.account.operate.currentAsset.to.CurrentAssetResDTO;
import kr.co.seoulit.erp.account.sys.common.mapstruct.EntityResMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CurrentAssetResMapStruct extends EntityResMapper<CurrentAssetEntity, CurrentAssetResDTO> {

    @Override
    CurrentAssetResDTO toDto(CurrentAssetEntity entity);

    @Override
    ArrayList<CurrentAssetResDTO> toDto(List<CurrentAssetEntity> entities);
}
