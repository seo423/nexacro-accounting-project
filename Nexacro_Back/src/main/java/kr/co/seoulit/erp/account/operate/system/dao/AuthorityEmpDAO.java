package kr.co.seoulit.erp.account.operate.system.dao;


import kr.co.seoulit.erp.account.operate.system.to.AuthorityEmpBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AuthorityEmpDAO {


    List<AuthorityEmpBean> selectEmpAuthorityList()throws Exception;

    List<AuthorityEmpBean> selectEmpAuthorityDetailList(String empCode)throws Exception;

    void insertAuthorityEmp(AuthorityEmpBean authorityEmpBean)throws Exception;
    void deleteAuthorityEmpDetail(String id)throws Exception;



}
