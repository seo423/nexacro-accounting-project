package kr.co.seoulit.erp.account.statement.costStatement.controller;

import com.nexacro.java.xapi.data.PlatformData;
import kr.co.seoulit.erp.account.statement.costStatement.service.CostStatementService;
import kr.co.seoulit.erp.account.statement.costStatement.to.CostStatementBean;
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
public class CostStatementController {

    @Autowired
    private CostStatementService costStatementService;
    @Autowired
    private DatasetToBeanMapper datasetToBeanMapper;

    //원가명세서 조회
    @RequestMapping(value = "/selectedDate")
    public ArrayList<CostStatementBean> findCostStatement(@RequestAttribute("reqData") PlatformData reqData,
                                                          @RequestAttribute("resData")PlatformData resData) throws Exception {
        log.debug("원가명세서_Controller");
        String selectedDate=reqData.getVariable("selectedDate").getString(); // 받은 데이터 추출
        log.debug("selectedDate : " + selectedDate);

        HashMap<String,Object> params = new HashMap<>();
        params.put("selectedDate",selectedDate); // 데이터를 map에 담음

        ArrayList<CostStatementBean> costStatementList = costStatementService.findCostStatement(params); // Facade 호출
        datasetToBeanMapper.beansToDataset(resData, costStatementList, CostStatementBean.class); // DTO -> Dataset
        return null;
    }
}
