package kr.co.seoulit.erp.account.posting.business.mapstruct;

import kr.co.seoulit.erp.account.posting.business.dto.SlipreqDto;
import kr.co.seoulit.erp.account.posting.business.entity.SlipEntity;
import kr.co.seoulit.erp.account.sys.common.mapstruct.EntityReqMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SlipReqMapstruct extends EntityReqMapper<SlipEntity, SlipreqDto> {
}


