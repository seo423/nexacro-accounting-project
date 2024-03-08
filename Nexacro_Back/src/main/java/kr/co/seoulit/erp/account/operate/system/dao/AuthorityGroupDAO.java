package kr.co.seoulit.erp.account.operate.system.dao;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.erp.account.operate.system.to.AuthorityEmpBean;
import kr.co.seoulit.erp.account.operate.system.entity.AuthorityMenuEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthorityGroupDAO {

    public ArrayList<AuthorityEmpBean> selectAuthorityEmp(String deptCode);
    
    public void updateAuthorityGroup(AuthorityEmpBean authorityEmpBean, String dept);
    
    public void insertAuthorityGroup(String addAuthority,String nextGroupCode);
    
    public ArrayList<AuthorityEmpBean> selectAuthorityGroupCode();
    
    public ArrayList<AuthorityMenuEntity> selectEmpAuthorityMenu(String empCode);
    
    public void deleteAuthorityGroup(String groupCode);
    
    public void deleteAuthorityMenu(String groupCode);
    
    public ArrayList<AuthorityMenuEntity> selectAuthorityGroup();
    
    public ArrayList<AuthorityMenuEntity> selectAuthorityMenu(HashMap<String, String> map);
    
    public void updateAuthorityMenu(AuthorityMenuEntity authorityMenuEntity, String dept);
}
