package kr.co.seoulit.erp.account.statement.trialbalance.to;

import kr.co.seoulit.erp.account.sys.base.to.BaseBean;
import kr.co.seoulit.erp.account.sys.common.annotation.Dataset;
import lombok.Data;

@Data
@Dataset( name = "ds_tmptotaltrialbalance")
public class TotalTrialBalanceBean extends BaseBean {

    private int debitsSumBalance;
    private int debitsSum;
    private String accountName;
    private int creditsSum;
    private int creditsSumBalance;

}
