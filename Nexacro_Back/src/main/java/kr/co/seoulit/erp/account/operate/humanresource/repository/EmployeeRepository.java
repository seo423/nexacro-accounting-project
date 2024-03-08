package kr.co.seoulit.erp.account.operate.humanresource.repository;

import kr.co.seoulit.erp.account.operate.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, String> {

    // 아래의 쿼리는 사원등록후 제일먼저 등록한 사원이 먼저 조회되게 하기 위함입니다.
    @Query(value="select * from employee order by emp_code asc",nativeQuery = true)
    List<EmployeeEntity> findAll();


}
