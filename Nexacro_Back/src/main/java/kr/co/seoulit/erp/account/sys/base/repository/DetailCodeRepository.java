package kr.co.seoulit.erp.account.sys.base.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kr.co.seoulit.erp.account.sys.base.to.DetailCodeEntity;

@Repository
public interface DetailCodeRepository extends CrudRepository<DetailCodeEntity, String> {
}
