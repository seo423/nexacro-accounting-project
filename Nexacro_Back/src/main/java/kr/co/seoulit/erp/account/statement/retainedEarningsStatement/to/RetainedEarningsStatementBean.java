package kr.co.seoulit.erp.account.statement.retainedEarningsStatement.to;

import kr.co.seoulit.erp.account.sys.base.to.BaseBean;
import kr.co.seoulit.erp.account.sys.common.annotation.Dataset;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
    @Entity
    @Dataset(name = "ds_retainedEarnings")
    @Table(name = "RETAINED_EARNINGS")
    @Getter
    @Setter
    public class RetainedEarningsStatementBean extends BaseBean {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "CURRENT_YEAR", columnDefinition = "NVARCHAR2")
        private String currentYear;

        @Column(name = "RETAINED", columnDefinition = "NUMBER")
        private String retained ;

        @Column(name = "RETAINED_SUMMARY", columnDefinition = "NUMBER")
        private String retainedSummary;

        @Column(name = "ACCOUNT_NAME", columnDefinition = "NUMBER")
        private String accountName;

        @Column(name = "FISCAL_YEAR", columnDefinition = "NUMBER")
        private String fiscalYear;

        @Column(name = "PRE_RETAINED", columnDefinition = "NUMBER")
        private String preRetained;

        @Column(name = "PRE_RETAINED_SUMMARY", columnDefinition = "NUMBER")
        private String preRetainedSummary;

}
