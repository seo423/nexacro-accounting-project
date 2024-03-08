package kr.co.seoulit.erp.account.statement.monthIncomeStatement.service;

import kr.co.seoulit.erp.account.statement.monthIncomeStatement.to.MonthIncomeStatementBean;

import java.util.ArrayList;
import java.util.HashMap;

public interface MonthIncomeStatementService {

    //기간별손익계산서 조회
    ArrayList<MonthIncomeStatementBean> findMonthIncomeStatement(HashMap<String,Object> params);

}