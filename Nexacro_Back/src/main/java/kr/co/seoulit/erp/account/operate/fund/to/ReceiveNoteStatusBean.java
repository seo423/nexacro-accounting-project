package kr.co.seoulit.erp.account.operate.fund.to;

import kr.co.seoulit.erp.account.sys.base.to.BaseBean;
import kr.co.seoulit.erp.account.sys.common.annotation.Dataset;
import lombok.*;

@EqualsAndHashCode(callSuper = false)
@Dataset(name="ds_receivenote")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReceiveNoteStatusBean extends BaseBean {

    private String customerName;
    private String previousBalance;
    private String dayIncrease;
    private String dayDecrease;
    private String dayBalance;
}
