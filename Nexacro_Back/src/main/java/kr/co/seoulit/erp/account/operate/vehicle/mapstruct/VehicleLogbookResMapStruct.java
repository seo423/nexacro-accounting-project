package kr.co.seoulit.erp.account.operate.vehicle.mapstruct;

import kr.co.seoulit.erp.account.operate.vehicle.entity.VehicleLogbookEntity;
import kr.co.seoulit.erp.account.operate.vehicle.to.VehicleLogbookResDTO;
import kr.co.seoulit.erp.account.sys.common.mapstruct.EntityResMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VehicleLogbookResMapStruct extends EntityResMapper<VehicleLogbookEntity, VehicleLogbookResDTO> {

    @Override
    VehicleLogbookResDTO toDto(VehicleLogbookEntity entity);

    @Override
    List<VehicleLogbookResDTO> toDto(List<VehicleLogbookEntity> entities);
}
