package kr.co.seoulit.erp.account.statement.monthCostStatement.controller;

import com.nexacro.java.xapi.data.PlatformData;
import kr.co.seoulit.erp.account.statement.monthCostStatement.Service.MonthCostStatementService;
import kr.co.seoulit.erp.account.statement.monthCostStatement.to.MonthCostStatementBean;
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
public class MonthCostStatementController {

    @Autowired
    private MonthCostStatementService monthCostStatementService;
    @Autowired
    private DatasetToBeanMapper datasetToBeanMapper;

    //기간별원가명세서 조회
    @RequestMapping(value = "/monthCost")
    public void findMonthCostStatement(@RequestAttribute("reqData") PlatformData reqData,
                                                                    @RequestAttribute("resData")PlatformData resData) throws Exception {
        log.debug("기간별원가명세서_Controller");
        String selectedDate=reqData.getVariable("selectedDate").getString(); // 받은 데이터 추출
        log.debug("selectedDate : " + selectedDate);

        HashMap<String,Object> params = new HashMap<>();
        params.put("selectedDate",selectedDate); // 데이터를 map에 담음

        ArrayList<MonthCostStatementBean> monthCostStatementList = monthCostStatementService.findMonthCostStatement(params); // Facade 호출
        datasetToBeanMapper.beansToDataset(resData, monthCostStatementList, MonthCostStatementBean.class); // DTO -> Dataset
    }
}
