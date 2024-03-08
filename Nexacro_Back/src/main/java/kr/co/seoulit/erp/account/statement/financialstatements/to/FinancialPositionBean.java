package kr.co.seoulit.erp.account.statement.financialstatements.to;

import kr.co.seoulit.erp.account.sys.base.to.BaseBean;
import kr.co.seoulit.erp.account.sys.common.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Dataset(name="ds_financialposition")
public class FinancialPositionBean extends BaseBean {
    private int lev;
    private String category;
    private String accountName;
    private String accountCode;
    private int balanceDetail;
    private long balanceSummary;
    private int preBalanceDetail;
    private long preBalanceSummary;
    private int isThisYear;

}
