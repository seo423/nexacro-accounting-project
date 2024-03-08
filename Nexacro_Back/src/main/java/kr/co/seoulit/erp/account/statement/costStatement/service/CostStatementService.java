package kr.co.seoulit.erp.account.statement.costStatement.service;

import kr.co.seoulit.erp.account.statement.costStatement.to.CostStatementBean;

import java.util.ArrayList;
import java.util.HashMap;

public interface CostStatementService {

    //원가명세서 조회
    //ArrayList<CostStatementBean> findCostStatement(HashMap<String,Object> params);
    ArrayList<CostStatementBean> findCostStatement(HashMap<String,Object> params);

}
