package kr.co.seoulit.erp.account.statement.cashFlowStatement.service;

import kr.co.seoulit.erp.account.statement.cashFlowStatement.dao.CashFlowStatementMapper;
import kr.co.seoulit.erp.account.statement.cashFlowStatement.to.CashFlowStatementBean;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class CashFlowStatementServiceImpl implements CashFlowStatementService {

    @Autowired
    private CashFlowStatementMapper cashFlowStatementDAO;

    //현금흐름표 조회
    @Override
    public ArrayList<CashFlowStatementBean> findCashFlowStatement(HashMap<String,Object> params) {

        System.out.println("현금흐름표_ServiceImpl");
        System.out.println("selectedDate : " + params);

        cashFlowStatementDAO.selectCashFlowStatement(params);
        ArrayList<CashFlowStatementBean> result = (ArrayList<CashFlowStatementBean>)params.get("RESULT");

        System.out.println("result : " + result);
        System.out.println("params1 : " + params);

        return result;
    }
}
