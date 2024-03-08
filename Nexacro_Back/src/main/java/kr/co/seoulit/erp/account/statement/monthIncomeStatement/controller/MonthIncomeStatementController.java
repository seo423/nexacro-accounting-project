package kr.co.seoulit.erp.account.statement.monthIncomeStatement.controller;


import com.nexacro.java.xapi.data.PlatformData;
import kr.co.seoulit.erp.account.statement.monthCostStatement.to.MonthCostStatementBean;
import kr.co.seoulit.erp.account.statement.monthIncomeStatement.service.MonthIncomeStatementService;
import kr.co.seoulit.erp.account.statement.monthIncomeStatement.to.MonthIncomeStatementBean;
import kr.co.seoulit.erp.account.sys.common.dao.DatasetToBeanMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@Slf4j
@RestController
@RequestMapping("/acc/statement")
public class MonthIncomeStatementController {

    @Autowired
    private MonthIncomeStatementService monthIncomeStatementService;

    @Autowired
    private DatasetToBeanMapper datasetToBeanMapper;

    //월별손익계산서 조회
    @RequestMapping("/monthIncome")
    public void findMonthIncomeStatement(@RequestAttribute("reqData") PlatformData reqData,
                                         @RequestAttribute("resData") PlatformData resData) throws Exception {
        log.debug("기간별손익계산서_Controller");
        String startDate = reqData.getVariable("startDate").getString(); // 받은 데이터 추출
        String endDate = reqData.getVariable("endDate").getString(); // 받은 데이터 추출

        log.debug("startDate : " + startDate);
        log.debug("endDate : " + endDate);

        HashMap<String, Object> params = new HashMap<>();
        params.put("startingDate", startDate); // 데이터를 map에 담음
        params.put("endDate", endDate); // 데이터를 map에 담음

        ArrayList<MonthIncomeStatementBean> monthIncomeStatementList = monthIncomeStatementService.findMonthIncomeStatement(params); // Facade 호출
        datasetToBeanMapper.beansToDataset(resData, monthIncomeStatementList, MonthIncomeStatementBean.class); // DTO -> Dataset


    }
}
