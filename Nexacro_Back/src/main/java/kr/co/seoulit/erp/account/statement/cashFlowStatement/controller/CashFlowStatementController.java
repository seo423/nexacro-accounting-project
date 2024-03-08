package kr.co.seoulit.erp.account.statement.cashFlowStatement.controller;

import com.nexacro.java.xapi.data.PlatformData;
import kr.co.seoulit.erp.account.statement.cashFlowStatement.service.CashFlowStatementService;
import kr.co.seoulit.erp.account.statement.cashFlowStatement.to.CashFlowStatementBean;
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
public class CashFlowStatementController {

    @Autowired
    private CashFlowStatementService cashFlowStatementService;
    @Autowired
    private DatasetToBeanMapper datasetToBeanMapper;

    //현금흐름표 조회
    @RequestMapping(value = "/cashFlow")
    public void findCashFlowStatement(@RequestAttribute("reqData") PlatformData reqData,
                                                                  @RequestAttribute("resData") PlatformData resData) throws Exception {
        log.debug("현금흐름표_Controller");
        String selectedDate = reqData.getVariable("selectedDate").getString(); // 받은 데이터 추출
        log.debug("selectedDate : " + selectedDate);

        HashMap<String,Object> params = new HashMap<>();
        params.put("selectedDate",selectedDate); // 데이터를 map에 담음

        ArrayList<CashFlowStatementBean> cashFlowStatementList = cashFlowStatementService.findCashFlowStatement(params); // Facade 호출
        datasetToBeanMapper.beansToDataset(resData, cashFlowStatementList, CashFlowStatementBean.class); // DTO -> Dataset
    }
}
