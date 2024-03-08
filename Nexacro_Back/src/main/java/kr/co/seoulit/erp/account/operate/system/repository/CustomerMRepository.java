package kr.co.seoulit.erp.account.operate.system.repository;

import kr.co.seoulit.erp.account.operate.system.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CustomerMRepository extends JpaRepository<Customer, Long> {


    @Query(value="select * from CUSTOMER order by CUSTOMER_CODE asc",nativeQuery = true)
    List<Customer> findAll();


    Customer findByCustomerCode(String CustomerCode);

    @Query("SELECT c FROM Customer c WHERE c.customerCode IN :customerCodeList")
    List<Customer> findAllByCustomerCode(@Param("customerCodeList") List<String> customerCodeList);
}
