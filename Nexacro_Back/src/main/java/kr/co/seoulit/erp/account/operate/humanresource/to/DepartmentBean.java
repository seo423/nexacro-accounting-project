package kr.co.seoulit.erp.account.operate.humanresource.to;

import kr.co.seoulit.erp.account.sys.base.to.BaseBean;
import kr.co.seoulit.erp.account.sys.common.annotation.Dataset;
import lombok.Data;

@Data
@Dataset(name="gds_department")
public class DepartmentBean extends BaseBean{
	
	private String workplaceCode;
	private String workplaceName;
	private String deptCode;
	private String deptName;
	private String companyCode;
	private String deptStartDate;
	private String deptEndDate;
	
	
	

}
