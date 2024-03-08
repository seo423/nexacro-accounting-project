package kr.co.seoulit.erp.account.statement.monthCostStatement.Service;

import kr.co.seoulit.erp.account.statement.monthCostStatement.dao.MonthCostStatementMapper;
import kr.co.seoulit.erp.account.statement.monthCostStatement.to.MonthCostStatementBean;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class MonthCostStatementServiceImpl implements MonthCostStatementService {

    @Autowired
    private MonthCostStatementMapper monthCostStatementDAO;

    //기간별원가명세서 조회

    @Override
    public ArrayList<MonthCostStatementBean> findMonthCostStatement(HashMap<String, Object> params) {

        log.debug("기간별원가명세서_ServiceImpl");
        log.debug("selectedDate : " + params);

        ArrayList<MonthCostStatementBean> monthCostStatementList = monthCostStatementDAO.selectMonthCostStatement(params);
//        ArrayList<MonthCostStatementBean> result = (ArrayList<MonthCostStatementBean>) params.get("RESULT");

        log.debug("result : " + monthCostStatementList);

        return monthCostStatementList;
    }
}