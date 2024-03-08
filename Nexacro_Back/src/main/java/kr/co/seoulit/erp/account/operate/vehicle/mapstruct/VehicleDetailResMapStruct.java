package kr.co.seoulit.erp.account.operate.vehicle.mapstruct;

import kr.co.seoulit.erp.account.operate.vehicle.entity.VehicleDetailEntity;
import kr.co.seoulit.erp.account.operate.vehicle.to.VehicleDetailResDTO;
import kr.co.seoulit.erp.account.sys.common.mapstruct.EntityResMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VehicleDetailResMapStruct extends EntityResMapper<VehicleDetailEntity, VehicleDetailResDTO> {

    @Override
    VehicleDetailResDTO toDto(VehicleDetailEntity entity);

    @Override
    List<VehicleDetailResDTO> toDto(List<VehicleDetailEntity> entities);
}
