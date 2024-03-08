package kr.co.seoulit.erp.account.operate.fund.to;

import kr.co.seoulit.erp.account.sys.base.to.BaseBean;
import kr.co.seoulit.erp.account.sys.common.annotation.Dataset;
import lombok.*;

import javax.persistence.Id;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = false)
@Table(name="DAILY_FUND_PLAN")
@Dataset(name="ds_plan")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PlanBean extends BaseBean {

    @Id
    private String planNo;
    private String planDate;
    private String fundCode;
    private String fundName;
    private String customerCode;
    private String customerName;
    private String expenseReport;
    private String balanceDivision;
    private String price;
}
