package kr.co.seoulit.erp.account.posting.business.dto;

import kr.co.seoulit.erp.account.sys.base.to.BaseBean;
import kr.co.seoulit.erp.account.sys.common.annotation.Dataset;
import lombok.Data;

@Data
@Dataset(name="gds_slip")
public class SlipresDto extends BaseBean {
    private String slipNo;
    private String accountPeriodNo;
    private String slipType;
    private String expenseReport;
    private String reportingEmpCode;
    private String reportingDate;
    private String approvalEmpCode;
    private String approvalDate;
    private String slipStatus;
}
