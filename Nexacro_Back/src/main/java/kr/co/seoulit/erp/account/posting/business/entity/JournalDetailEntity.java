package kr.co.seoulit.erp.account.posting.business.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import kr.co.seoulit.erp.account.sys.base.to.BaseBean;
import kr.co.seoulit.erp.account.sys.common.annotation.Dataset;
import lombok.Getter;
import lombok.Setter;

@Entity
@Dataset(name = "gds_journal_detail")
@Table(name = "JOURNAL_DETAIL")
@Getter @Setter
public class JournalDetailEntity extends BaseBean {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "number")
    private String journalDetailNo;
    private String journalNo;
    private String accountControlCode;
    @Column(name = "DESCRIPTION")
    private String journalDescription;
    @Transient
    private String accountControlDescription;
    @Transient
    private String accountControlName;
    @Transient
    private String accountControlType; //일괄처리를 위한 상태값
    @Transient
    private String accountName;

}
