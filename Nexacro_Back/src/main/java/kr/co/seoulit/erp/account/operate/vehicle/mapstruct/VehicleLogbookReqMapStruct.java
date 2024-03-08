package kr.co.seoulit.erp.account.operate.vehicle.mapstruct;

import kr.co.seoulit.erp.account.operate.vehicle.entity.VehicleLogbookEntity;
import kr.co.seoulit.erp.account.operate.vehicle.to.VehicleLogbookReqDTO;
import kr.co.seoulit.erp.account.sys.common.mapstruct.EntityReqMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VehicleLogbookReqMapStruct  extends EntityReqMapper<VehicleLogbookEntity, VehicleLogbookReqDTO> {

    @Override
    VehicleLogbookEntity toEntity(VehicleLogbookReqDTO dto);

    @Override
    List<VehicleLogbookEntity> toEntity(List<VehicleLogbookReqDTO> dtos);
}
