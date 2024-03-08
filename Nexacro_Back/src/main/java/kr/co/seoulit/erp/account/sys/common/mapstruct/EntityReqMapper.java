package kr.co.seoulit.erp.account.sys.common.mapstruct;


import java.util.List;

public interface EntityReqMapper <E,D> {
    //ReqMapper
    E toEntity(D dto);

    List<E> toEntity (List<D> dtos);
}
