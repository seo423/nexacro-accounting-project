package kr.co.seoulit.erp.account.sys.common.mapstruct;


import kr.co.seoulit.erp.account.posting.business.dto.JournalDetailreqDto;
import kr.co.seoulit.erp.account.posting.business.entity.JournalDetailEntity;

import java.util.List;


public interface EntityResMapper<E,D> {
    //ResMapper
    D toDto(E entity);
    List<D> toDto(List<E> entities);

}
