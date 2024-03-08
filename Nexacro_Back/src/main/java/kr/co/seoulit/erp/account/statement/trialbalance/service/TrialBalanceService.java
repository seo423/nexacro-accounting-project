package kr.co.seoulit.erp.account.statement.trialbalance.service;

import kr.co.seoulit.erp.account.statement.costStatement.to.CostStatementBean;
import kr.co.seoulit.erp.account.statement.trialbalance.to.DetailTrialBalanceBean;
import kr.co.seoulit.erp.account.statement.trialbalance.to.TotalTrialBalanceBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface TrialBalanceService {

	public ArrayList<TotalTrialBalanceBean> findTotalTrialBalance(String accountPeriodNo);


//	ArrayList<TotalTrialBalanceBean> findEarlyStatements(HashMap<String, Object> params);

//	 public HashMap<String, Object> findchangeAccountingSettlement(String accountPeriodNo, String callResult);

	//일(월)계표 조회
	 public List<DetailTrialBalanceBean> findDetailTrialBalance(HashMap<String, Object> params);

}
