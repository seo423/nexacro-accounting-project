package kr.co.seoulit.erp.account.operate.fund.to;

import kr.co.seoulit.erp.account.sys.common.annotation.Dataset;
import lombok.*;

@EqualsAndHashCode(callSuper = false)
@Dataset(name="ds_general")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GeneralFundBean {

    private String indexNo;
    private String accountName;
    private String customerName;
    private String previousBalance;
    private String dayInout;
    private String dayBalance;
}
