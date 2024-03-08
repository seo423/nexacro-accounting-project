package kr.co.seoulit.erp.account.posting.business.mapstruct;

import kr.co.seoulit.erp.account.posting.business.dto.SlipresDto;
import kr.co.seoulit.erp.account.posting.business.entity.SlipEntity;
import kr.co.seoulit.erp.account.sys.common.mapstruct.EntityResMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SlipResMapstruct extends EntityResMapper<SlipEntity, SlipresDto> {
}
