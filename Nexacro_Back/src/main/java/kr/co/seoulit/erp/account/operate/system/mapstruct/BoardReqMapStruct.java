package kr.co.seoulit.erp.account.operate.system.mapstruct;


import kr.co.seoulit.erp.account.operate.system.entity.BoardEntity;
import kr.co.seoulit.erp.account.operate.system.to.BoardReqDTO;
import kr.co.seoulit.erp.account.sys.common.mapstruct.EntityReqMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BoardReqMapStruct extends EntityReqMapper<BoardEntity, BoardReqDTO>
{



}
