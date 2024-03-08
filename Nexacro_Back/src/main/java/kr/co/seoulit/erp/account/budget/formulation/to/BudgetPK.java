package kr.co.seoulit.erp.account.budget.formulation.to;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Data
public class BudgetPK implements Serializable {

	@Column(name="DEPT_CODE")
	public String deptCode;
	@Column(name="WORKPLACE_CODE")
	public String workplaceCode;
	@Column(name="ACCOUNT_INNER_CODE")
	public String accountInnerCode;
	@Column(name="ACCOUNT_PERIOD_NO")
	public String accountPeriodNo;
	@Column(name="BUDGETING_CODE", columnDefinition = "char")
	public String budgetingCode;

	public BudgetPK() {
	}

	@Builder
	public BudgetPK(String deptCode, String workplaceCode, String accountInnerCode,  String accountPeriodNo, String budgetingCode) {
		this.deptCode = deptCode;
		this.workplaceCode = workplaceCode;
		this.accountInnerCode = accountInnerCode;
		this.accountPeriodNo = accountPeriodNo;
		this.budgetingCode = budgetingCode;
	}
}
