package kr.co.seoulit.erp.account.posting.business.dto;

import kr.co.seoulit.erp.account.sys.base.to.BaseBean;
import kr.co.seoulit.erp.account.sys.common.annotation.Dataset;
import lombok.Data;

import java.util.List;

@Data
@Dataset(name="gds_journal")
public class JournalreqDto extends BaseBean {

    private String journalNo;

    private String slipNo;

    private String balanceDivision;

    private String accountInnerCode;

    private String accountName;
    private String customerCode;
    private String customerName;

    private String leftDebtorPrice;

    private String rightCreditsPrice;

    private List<JournalDetailreqDto> journalDetailList;
}
