package kr.co.seoulit.erp.account.operate.fund.to;

import kr.co.seoulit.erp.account.sys.common.annotation.Dataset;
import lombok.*;

@EqualsAndHashCode(callSuper = false)
@Dataset(name="ds_finance")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FinanceBean {

    private String customerCode;
    private String customerName;
    private String accountNo;
    private String previousBalance;
    private String increase;
    private String decrease;
    private String dayBalance;
    private String limitBalance;
}
