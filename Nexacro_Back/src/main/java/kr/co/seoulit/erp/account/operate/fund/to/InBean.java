package kr.co.seoulit.erp.account.operate.fund.to;

import kr.co.seoulit.erp.account.sys.base.to.BaseBean;
import kr.co.seoulit.erp.account.sys.common.annotation.Dataset;
import lombok.*;

@EqualsAndHashCode(callSuper = false)
@Dataset(name="ds_inExpected")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InBean extends BaseBean {

    private String accountName;
    private String expenseReport;
    private String price;

}
