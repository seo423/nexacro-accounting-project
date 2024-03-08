package kr.co.seoulit.erp.account.statement.financialstatements.service;

import kr.co.seoulit.erp.account.statement.financialstatements.to.IncomeStatementBean;

import java.util.ArrayList;
import java.util.HashMap;

public interface FinancialStatementsService {

	public HashMap<String, Object> findFinancialPosition(HashMap<String, Object> params);

	public ArrayList<IncomeStatementBean> findIncomeStatement(HashMap<String, Object> param);
}
