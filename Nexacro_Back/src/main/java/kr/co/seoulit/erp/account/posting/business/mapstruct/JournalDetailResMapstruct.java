package kr.co.seoulit.erp.account.posting.business.mapstruct;

import kr.co.seoulit.erp.account.posting.business.dto.JournalDetailresDto;

import kr.co.seoulit.erp.account.posting.business.entity.JournalDetailEntity;
import kr.co.seoulit.erp.account.sys.common.mapstruct.EntityResMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JournalDetailResMapstruct extends EntityResMapper<JournalDetailEntity, JournalDetailresDto> {
}
