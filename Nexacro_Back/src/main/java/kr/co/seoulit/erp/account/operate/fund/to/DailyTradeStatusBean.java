package kr.co.seoulit.erp.account.operate.fund.to;

import kr.co.seoulit.erp.account.sys.base.to.BaseBean;
import kr.co.seoulit.erp.account.sys.common.annotation.Dataset;
import lombok.*;

@EqualsAndHashCode(callSuper = false)
@Dataset(name="ds_dailyTrade")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DailyTradeStatusBean extends BaseBean {

    private String accountName;
    private String previousBalance;
    private String dayIncrease;
    private String dayDecrease;
    private String dayBalance;
}
