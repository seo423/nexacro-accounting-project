package kr.co.seoulit.erp.account.operate.vehicle.mapstruct;

import kr.co.seoulit.erp.account.operate.vehicle.entity.VehicleDetailEntity;
import kr.co.seoulit.erp.account.operate.vehicle.to.VehicleDetailReqDTO;
import kr.co.seoulit.erp.account.sys.common.mapstruct.EntityReqMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VehicleDetailReqMapStruct extends EntityReqMapper<VehicleDetailEntity, VehicleDetailReqDTO> {

    @Override
    VehicleDetailEntity toEntity(VehicleDetailReqDTO dto);

    @Override
    List<VehicleDetailEntity> toEntity(List<VehicleDetailReqDTO> dtos);
}
