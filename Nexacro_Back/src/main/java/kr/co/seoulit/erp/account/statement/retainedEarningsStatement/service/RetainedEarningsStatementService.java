package kr.co.seoulit.erp.account.statement.retainedEarningsStatement.service;

import kr.co.seoulit.erp.account.statement.retainedEarningsStatement.to.RetainedEarningsStatementBean;

import java.util.ArrayList;
import java.util.HashMap;

    public interface RetainedEarningsStatementService {

        //이익잉여금처분계산서 조회
        ArrayList<RetainedEarningsStatementBean> findRetainedEarningsStatement(HashMap<String,Object> params);

    }
