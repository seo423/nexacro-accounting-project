package kr.co.seoulit.erp.account.statement.cashFlowStatement.service;

import kr.co.seoulit.erp.account.statement.cashFlowStatement.to.CashFlowStatementBean;

import java.util.ArrayList;
import java.util.HashMap;

public interface CashFlowStatementService {

    ArrayList<CashFlowStatementBean> findCashFlowStatement(HashMap<String,Object> params);
}
