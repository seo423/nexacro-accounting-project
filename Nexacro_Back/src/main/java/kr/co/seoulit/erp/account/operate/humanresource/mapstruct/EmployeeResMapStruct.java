package kr.co.seoulit.erp.account.operate.humanresource.mapstruct;


import kr.co.seoulit.erp.account.operate.entity.EmployeeEntity;
import kr.co.seoulit.erp.account.operate.humanresource.to.EmployeeResDTO;
import kr.co.seoulit.erp.account.sys.common.mapstruct.EntityResMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeResMapStruct extends EntityResMapper<EmployeeEntity, EmployeeResDTO> {

    @Override
    EmployeeResDTO toDto(EmployeeEntity entity);

    @Override
    List<EmployeeResDTO> toDto(List<EmployeeEntity> entities);
}