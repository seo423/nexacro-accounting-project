package kr.co.seoulit.erp.account.operate.system.dao;


import kr.co.seoulit.erp.account.operate.system.to.CustomerUpdateRequest;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerDAO {

    public void insertCustomer(CustomerUpdateRequest customerUpdateRequest); //거래처추가

    public void deleteCustomer(String code); //거래처삭제
    
    public void updateCustomer(CustomerUpdateRequest customerUpdateRequest); //거래처수정

}
