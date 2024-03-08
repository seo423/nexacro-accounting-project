package kr.co.seoulit.erp.account.operate.system.repository;

import kr.co.seoulit.erp.account.operate.system.entity.AccountControlEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountControlRepository extends CrudRepository<AccountControlEntity, String> {

}
