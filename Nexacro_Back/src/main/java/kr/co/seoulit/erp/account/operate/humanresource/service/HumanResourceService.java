package kr.co.seoulit.erp.account.operate.humanresource.service;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.erp.account.operate.humanresource.to.DepartmentBean;
import kr.co.seoulit.erp.account.operate.entity.EmployeeEntity;
import kr.co.seoulit.erp.account.operate.humanresource.to.EmployeeReqDTO;

public interface HumanResourceService {


							//Employee CRUD


    public ArrayList<EmployeeEntity> findEmployeeList()throws Exception;

	void modifyEmployee(EmployeeEntity employeeEntity)throws Exception;

	public void registerEmployee(EmployeeEntity employeeEntity)throws Exception;

    public void removeEmployee(String empCode)throws Exception;

	void modifyEmployee(EmployeeReqDTO employeeReqDTO, byte[] imageData)throws Exception;


                                // 아래의 코드는 아직 사용하지 않는 코드들이다.








	public ArrayList<DepartmentBean> findDeptList();

	public ArrayList<DepartmentBean> selectworkplaceCode();

	public ArrayList<DepartmentBean> selectdeptCode();

	public void modifyImage(String newFileName);

	public EmployeeEntity findImage(String EMP_CODE);


	public void saveEmpImg(HashMap<String,String> map);
}
