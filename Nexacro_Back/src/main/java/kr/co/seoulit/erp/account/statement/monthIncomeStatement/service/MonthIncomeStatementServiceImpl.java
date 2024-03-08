package kr.co.seoulit.erp.account.statement.monthIncomeStatement.service;

import kr.co.seoulit.erp.account.statement.monthIncomeStatement.dao.MonthIncomeStatementMapper;
import kr.co.seoulit.erp.account.statement.monthIncomeStatement.to.MonthIncomeStatementBean;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Slf4j
@Service
@RequiredArgsConstructor
public class MonthIncomeStatementServiceImpl implements MonthIncomeStatementService {

    @Autowired
    private MonthIncomeStatementMapper monthIncomeStatementDAO;

    //기간별원가명세서 조회

    @Override
    public ArrayList<MonthIncomeStatementBean> findMonthIncomeStatement(HashMap<String, Object> params) {

        log.debug("기간별손익계산서_ServiceImpl");
        log.debug("selectedDate : " + params);

        //ArrayList<MonthIncomeStatementBean> monthIncomeStatementList = monthIncomeStatementDAO.selectMonthIncomeStatement(params);

        try {
            monthIncomeStatementDAO.selectMonthIncomeStatement(params);
        } catch (Exception e) {
            log.error("에러발생: " + e.getMessage());
            return null;
        }
        ArrayList<MonthIncomeStatementBean> result = (ArrayList<MonthIncomeStatementBean>) params.get("result");
        log.debug("result : " + result);
        return result;

    }

}