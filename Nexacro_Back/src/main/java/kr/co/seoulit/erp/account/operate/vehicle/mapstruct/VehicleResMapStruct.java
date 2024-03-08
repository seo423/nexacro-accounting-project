package kr.co.seoulit.erp.account.operate.vehicle.mapstruct;

import kr.co.seoulit.erp.account.operate.vehicle.entity.VehicleEntity;
import kr.co.seoulit.erp.account.operate.vehicle.to.VehicleResDTO;
import kr.co.seoulit.erp.account.sys.common.mapstruct.EntityResMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VehicleResMapStruct extends EntityResMapper<VehicleEntity, VehicleResDTO> {

    @Override
    VehicleResDTO toDto(VehicleEntity entity);

    @Override
    List<VehicleResDTO> toDto(List<VehicleEntity> entities);

}
