package kr.co.seoulit.erp.account.operate.vehicle.mapstruct;

import kr.co.seoulit.erp.account.operate.currentAsset.mapstruct.CurrentAssetReqMapStruct;
import kr.co.seoulit.erp.account.operate.vehicle.entity.VehicleEntity;
import kr.co.seoulit.erp.account.operate.vehicle.to.VehicleReqDTO;
import kr.co.seoulit.erp.account.sys.common.mapstruct.EntityReqMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VehicleReqMapStruct extends EntityReqMapper<VehicleEntity, VehicleReqDTO> {

    @Override
    VehicleEntity toEntity(VehicleReqDTO dto);

    @Override
    List<VehicleEntity> toEntity(List<VehicleReqDTO> dtos);

    CurrentAssetReqMapStruct MAPPER = Mappers.getMapper(CurrentAssetReqMapStruct.class);

}
