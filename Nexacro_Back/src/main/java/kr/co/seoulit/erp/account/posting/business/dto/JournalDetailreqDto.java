package kr.co.seoulit.erp.account.posting.business.dto;

import kr.co.seoulit.erp.account.sys.base.to.BaseBean;
import kr.co.seoulit.erp.account.sys.common.annotation.Dataset;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Dataset(name = "gds_journal_detail")
@Table(name = "JOURNAL_DETAIL")
@Data
public class JournalDetailreqDto extends BaseBean {

    private String journalDetailNo;
    private String journalNo;
    private String accountControlCode;
    @Column(name = "DESCRIPTION")
    private String journalDescription;
    private String accountControlDescription;
    private String accountControlName;
    private String accountControlType; //일괄처리를 위한 상태값

    private String accountName;

}
