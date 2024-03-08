package kr.co.seoulit.erp.account.budget.formulation.to;

import kr.co.seoulit.erp.account.sys.common.annotation.Dataset;
import lombok.Data;

@Data
@Dataset(name="ds_budgetCode")
public class BudgetCodeBean {

	private String budgetCode;
	private String budgetName;
}
