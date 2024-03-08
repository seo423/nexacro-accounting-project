package kr.co.seoulit.erp.account.posting.ledger.mapstruct;

import kr.co.seoulit.erp.account.posting.ledger.dto.JournalDtoRes;
import kr.co.seoulit.erp.account.posting.ledger.entity.JournalResEntity;
import kr.co.seoulit.erp.account.sys.common.mapstruct.EntityResMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JournalMapstruct extends EntityResMapper<JournalResEntity, JournalDtoRes> {
}
