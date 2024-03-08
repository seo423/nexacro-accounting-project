package kr.co.seoulit.erp.account.posting.ledger.dto;

import kr.co.seoulit.erp.account.sys.base.to.BaseBean;
import kr.co.seoulit.erp.account.sys.common.annotation.Dataset;
import lombok.Getter;
import lombok.Setter;

@Dataset(name = "gds_journalDetail")
@Getter
@Setter
public class JournalDetailDtoRes extends BaseBean {
    private String journalDetailNo;
    private String journalNo;
    private String accountControlDescription;
    private String accountControlName;

}
