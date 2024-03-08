package kr.co.seoulit.erp.account.sys.base.dao;

import java.util.ArrayList;

import kr.co.seoulit.erp.account.sys.base.to.MenuEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuMapper {
    ArrayList<MenuEntity> selectMenuList(String empCode);

    ArrayList<MenuEntity> selectAllMenuList();
    
    ArrayList<MenuEntity> selectMenuNameList(String deptCode);

}
