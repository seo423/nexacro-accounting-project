package kr.co.seoulit.erp.account.operate.system.to;

import kr.co.seoulit.erp.account.sys.base.to.BaseBean;
import kr.co.seoulit.erp.account.sys.common.annotation.Dataset;
import lombok.Data;

@Data
@Dataset(name="gds_authority_emp")
public class AuthorityEmpBean extends BaseBean {
	private String id;
	private String empCode;
	private String empName;
	private String authorityCode;
	private String authorityName;
	private String isAuthority;
	private String authorityLevel;
}
