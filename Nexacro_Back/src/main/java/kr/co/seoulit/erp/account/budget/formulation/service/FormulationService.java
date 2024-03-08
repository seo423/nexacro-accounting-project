package kr.co.seoulit.erp.account.budget.formulation.service;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.erp.account.budget.formulation.to.*;

public interface FormulationService {

	public BudgetBean findBudget(BudgetBean bean);

	public ArrayList<BudgetBean> findBudgetList(HashMap<String,String> map);

	public BudgetRequest budgetListForComp(HashMap<String, String> budgetMap);
	public BudgetRequestForRecon budgetRequestForRecon(BudgetRequestForRecon budgetRequestForRecon);

	public void compBudget(BudgetRequest updateRequest);
	public void reconBudget(BudgetRequestForRecon updateRequest);

	public ArrayList<BudgetBean> findBudgetAppl(BudgetBean bean);

	public ArrayList<BudgetStatusBean> findBudgetStatus(BudgetBean bean);

	public ArrayList<BudgetComparisonBean> findBudgetComparison(BudgetBean bean);
	public void batchBudgetCode(BudgetBean obj);

	public ArrayList<BudgetBean> formationBudget(HashMap<String, String> map);

}
