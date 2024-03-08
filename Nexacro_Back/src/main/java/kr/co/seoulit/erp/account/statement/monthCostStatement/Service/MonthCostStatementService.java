package kr.co.seoulit.erp.account.statement.monthCostStatement.Service;

import kr.co.seoulit.erp.account.statement.monthCostStatement.to.MonthCostStatementBean;

import java.util.ArrayList;
import java.util.HashMap;

    public interface MonthCostStatementService {

        //기간별원가명세서 조회
        ArrayList<MonthCostStatementBean> findMonthCostStatement(HashMap<String,Object> params);

    }
