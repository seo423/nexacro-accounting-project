package kr.co.seoulit.erp.account.posting.ledger.mapstruct;

import kr.co.seoulit.erp.account.posting.ledger.dto.JournalDetailDtoRes;
import kr.co.seoulit.erp.account.posting.ledger.entity.JournalDetailResEntity;
import kr.co.seoulit.erp.account.sys.common.mapstruct.EntityResMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JournalDetailMapstruct extends EntityResMapper<JournalDetailResEntity, JournalDetailDtoRes> {
}
