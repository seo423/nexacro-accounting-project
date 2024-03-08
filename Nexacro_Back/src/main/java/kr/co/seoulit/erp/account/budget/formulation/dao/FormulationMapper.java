package kr.co.seoulit.erp.account.budget.formulation.dao;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.erp.account.budget.formulation.to.BudgetRequest;
import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.account.budget.formulation.to.BudgetBean;
import kr.co.seoulit.erp.account.budget.formulation.to.BudgetCodeBean;

@Mapper
public interface FormulationMapper {

	public BudgetBean selectBudget(BudgetBean bean);

	public ArrayList<BudgetBean> selectBudgetList(HashMap<String,String> map);

	public ArrayList<BudgetBean>  selectBudgetAppl(BudgetBean bean);

	public void selectBudgetStatus(HashMap<String, Object> map);

	public void batchBudgetCode(BudgetBean obj);

	// 예산 조회
	public BudgetRequest findBudget(HashMap<String, String> budgetMap);

	public void formationBudget(HashMap<String, String> map);

	void selectComparisonBudget(HashMap<String, Object> map);
}
