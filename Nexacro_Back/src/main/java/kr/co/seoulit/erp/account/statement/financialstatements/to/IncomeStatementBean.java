package kr.co.seoulit.erp.account.statement.financialstatements.to;

import kr.co.seoulit.erp.account.sys.base.to.BaseBean;
import kr.co.seoulit.erp.account.sys.common.annotation.Dataset;
import lombok.Data;

@Data
@Dataset(name = "ds_incomestatement")
public class IncomeStatementBean extends BaseBean {

    private String accountName;
    private String income;
    private String incomeSummary;
    private String earlyIncome;
    private String earlyIncomeSummary;

}
