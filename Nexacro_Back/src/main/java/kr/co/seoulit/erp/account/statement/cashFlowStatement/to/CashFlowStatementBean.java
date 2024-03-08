package kr.co.seoulit.erp.account.statement.cashFlowStatement.to;

import kr.co.seoulit.erp.account.sys.base.to.BaseBean;
import kr.co.seoulit.erp.account.sys.common.annotation.Dataset;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Dataset(name = "ds_tmpCashFlowStatement")
@Table(name = "TMP_CASHFLOW_STATEMENT")
@Getter
@Setter
public class CashFlowStatementBean extends BaseBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACCOUNT_INNER_CODE")
    private String accountInnerCode;

    @Column(name = "ACCOUNT_NAME", columnDefinition = "NVARCHAR2")
    private String accountName;

    @Column(name = "PARENT_ACCOUNT_CODE")
    private String parentAccountCode;

    @Column(name = "CASHFLOW", columnDefinition = "NUMBER")
    private String cashFlow;

    @Column(name = "CASHFLOW_SUMMARY", columnDefinition = "NUMBER")
    private String cashFlowSummary ;

    @Column(name = "EARLYCASHFLOW", columnDefinition = "NUMBER")
    private String earlyCashFlow;

    @Column(name = "EARLY_CASHFLOW_SUMMARY", columnDefinition = "NUMBER")
    private String earlyCashFlowSummary ;

}
