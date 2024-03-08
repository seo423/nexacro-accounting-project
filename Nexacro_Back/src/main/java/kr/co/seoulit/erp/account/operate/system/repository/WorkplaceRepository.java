package kr.co.seoulit.erp.account.operate.system.repository;

import kr.co.seoulit.erp.account.operate.system.entity.WorkplaceEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface WorkplaceRepository extends CrudRepository<WorkplaceEntity,String> {

}
