package kr.co.seoulit.erp.account.operate.system.dao;

import java.util.ArrayList;

import kr.co.seoulit.erp.account.operate.system.to.BusinessBean;
import kr.co.seoulit.erp.account.operate.system.to.DetailBusinessBean;
import kr.co.seoulit.erp.account.operate.system.entity.WorkplaceEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WorkplaceDAO {

    public ArrayList<BusinessBean> selectBusinessList();

    public void updateWorkplaceAccount(String code,String status); //사업장 승인상태 업데이트

    public WorkplaceEntity selectWorkplace(String workplaceCode); //사업장조회

	public void insertWorkplace(WorkplaceEntity workplaceEntity); //사업장추가

	public void deleteWorkplace(String code); //사업장삭제

	public ArrayList<WorkplaceEntity> selectAllWorkplaceList(); //모든사업장조회
	
	public ArrayList<DetailBusinessBean> selectDetailBusinessList(String businessCode);
}
