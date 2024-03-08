package kr.co.seoulit.erp.account.statement.retainedEarningsStatement.controller;

import com.nexacro.java.xapi.data.PlatformData;
import kr.co.seoulit.erp.account.statement.retainedEarningsStatement.service.RetainedEarningsStatementService;
import kr.co.seoulit.erp.account.statement.retainedEarningsStatement.to.RetainedEarningsStatementBean;
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
public class RetainedEarningsStatementController {

    @Autowired
    private RetainedEarningsStatementService retainedEarningsStatementService;
    @Autowired
    private DatasetToBeanMapper datasetToBeanMapper;

        //이익잉여금처분계산서 조회
    @RequestMapping(value = "/retainedEarnings")
    public void findRetainedEarningsStatement(@RequestAttribute("reqData") PlatformData reqData,
                                           @RequestAttribute("resData")PlatformData resData) throws Exception {
        log.debug("이익잉여금처분계산서_Controller");
        String selectedDate=reqData.getVariable("selectedDate").getString(); // 받은 데이터 추출
        log.debug("selectedDate : " + selectedDate);

        HashMap<String,Object> params = new HashMap<>();
        params.put("selectedDate",selectedDate); // 데이터를 map에 담음

        ArrayList<RetainedEarningsStatementBean> retainedEarningsStatementList = retainedEarningsStatementService.findRetainedEarningsStatement(params); // Facade 호출
        datasetToBeanMapper.beansToDataset(resData, retainedEarningsStatementList, RetainedEarningsStatementBean.class); // DTO -> Dataset
        }
    }
