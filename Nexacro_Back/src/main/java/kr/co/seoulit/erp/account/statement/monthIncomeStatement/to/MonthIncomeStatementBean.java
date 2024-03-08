package kr.co.seoulit.erp.account.statement.monthIncomeStatement.to;

import kr.co.seoulit.erp.account.sys.base.to.BaseBean;
import kr.co.seoulit.erp.account.sys.common.annotation.Dataset;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Dataset(name = "ds_mincomeStatement")
@Data
public class MonthIncomeStatementBean{

    private String accountName;
    private String incomeSummary;

}
