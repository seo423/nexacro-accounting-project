package kr.co.seoulit.erp.account.posting.ledger.dto;

import kr.co.seoulit.erp.account.posting.business.dto.JournalDetailresDto;
import kr.co.seoulit.erp.account.sys.base.to.BaseBean;
import kr.co.seoulit.erp.account.sys.common.annotation.Dataset;
import lombok.Data;

import java.util.List;

@Data
@Dataset(name="gds_journal")
public class JournalDtoRes extends BaseBean {

    private String journalNo;
    private String slipNo;
    private String balanceDivision;
    private String accountInnerCode;
    private String accountName;
    private String leftDebtorPrice;
    private String rightCreditsPrice;
    private List<JournalDetailresDto> journalDetailList;
}
