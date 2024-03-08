package kr.co.seoulit.erp.account.posting.ledger.mapstruct;

import kr.co.seoulit.erp.account.posting.ledger.entity.AssetItemEntity;
import kr.co.seoulit.erp.account.posting.ledger.entity.DeptEntity;
import kr.co.seoulit.erp.account.posting.ledger.dto.DeptResDto;
import kr.co.seoulit.erp.account.sys.common.mapstruct.EntityResMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.Optional;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface DeptMapStruct extends EntityResMapper<DeptEntity, DeptResDto> {


    DeptResDto toDto(Optional<AssetItemEntity> entity) ;
}



