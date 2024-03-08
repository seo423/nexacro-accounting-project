package kr.co.seoulit.erp.account.statement.monthCostStatement.to;

import kr.co.seoulit.erp.account.sys.base.to.BaseBean;
import kr.co.seoulit.erp.account.sys.common.annotation.Dataset;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

    @Entity
    @Dataset(name = "ds_monthCost")
    @Table(name = "MONTH_COST")
    @Getter
    @Setter
    public class MonthCostStatementBean extends BaseBean {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ACCOUNT_NAME", columnDefinition = "NVARCHAR2")
        private String accountName;

        @Column(name = "COST_SUMMARY", columnDefinition = "NUMBER")
        private String costSummary ;

        @Column(name = "JANUARY", columnDefinition = "NUMBER")
        private String january;

        @Column(name = "FEBRUARY", columnDefinition = "NUMBER")
        private String february;

        @Column(name = "MARCH", columnDefinition = "NUMBER")
        private String march;

        @Column(name = "APRIL", columnDefinition = "NUMBER")
        private String april;

        @Column(name = "MAY", columnDefinition = "NUMBER")
        private String may;

        @Column(name = "JUNE", columnDefinition = "NUMBER")
        private String june;

        @Column(name = "JULY", columnDefinition = "NUMBER")
        private String july;

        @Column(name = "AUGUST", columnDefinition = "NUMBER")
        private String august;

        @Column(name = "SEPTEMBER", columnDefinition = "NUMBER")
        private String september;

        @Column(name = "OCTOBER", columnDefinition = "NUMBER")
        private String october;

        @Column(name = "NOVEMBER", columnDefinition = "NUMBER")
        private String november;

        @Column(name = "DECEMBER", columnDefinition = "NUMBER")
        private String december;
    }
