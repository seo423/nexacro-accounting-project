package kr.co.seoulit.erp.account.operate.humanresource.dao;

import java.util.ArrayList;

import kr.co.seoulit.erp.account.operate.humanresource.to.DepartmentBean;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserAuthorityGroupMapper {
	
	public ArrayList<DepartmentBean> selectDeptList();
	
	public ArrayList<DepartmentBean> selectDeptList2();
	
	public ArrayList<DepartmentBean> selectworkplaceCode();
	
	
	public ArrayList<DepartmentBean> selectdeptCode();

	
}
