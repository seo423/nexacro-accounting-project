package kr.co.seoulit.erp.account.operate.humanresource.mapstruct;



import kr.co.seoulit.erp.account.operate.entity.EmployeeEntity;
import kr.co.seoulit.erp.account.operate.humanresource.to.EmployeeReqDTO;

import kr.co.seoulit.erp.account.sys.common.mapstruct.EntityReqMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeReqMapStruct extends EntityReqMapper<EmployeeEntity, EmployeeReqDTO>
{
    @Override
    @Mapping(target = "image", ignore = true)
    EmployeeEntity toEntity(EmployeeReqDTO dto);

    @Override
    @Mapping(target = "image", ignore = true)
    List<EmployeeEntity> toEntity(List<EmployeeReqDTO> dtos);

    EmployeeReqMapStruct MAPPER = Mappers.getMapper(EmployeeReqMapStruct.class);
}