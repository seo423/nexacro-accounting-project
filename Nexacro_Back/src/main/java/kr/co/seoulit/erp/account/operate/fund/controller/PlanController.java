package kr.co.seoulit.erp.account.operate.fund.controller;

import com.nexacro.java.xapi.data.PlatformData;
import kr.co.seoulit.erp.account.operate.fund.service.PlanService;
import kr.co.seoulit.erp.account.operate.fund.to.*;
import kr.co.seoulit.erp.account.sys.common.dao.DatasetToBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acc/operate")
public class PlanController {

    @Autowired
    private PlanService planService;
    @Autowired
    private DatasetToBeanMapper datasetToBeanMapper;

    // 자금계획 조회 + 자금계획카렌다 조회
    @RequestMapping("/findPlan")
    public void findPlan(@RequestAttribute("reqData") PlatformData reqData,
                         @RequestAttribute("resData") PlatformData resData) throws Exception {
        String startDate = reqData.getVariable("startDate").getString();
        String endDate = reqData.getVariable("endDate").getString();
        System.out.println(startDate + " ~ " + endDate + " 자금계획 조회 Rest API ");

        List<PlanBean> selectPlanList = planService.findPlan(startDate, endDate);
        datasetToBeanMapper.beansToDataset(resData, selectPlanList, PlanBean.class);

    }

    // 자금계획 추가
    @RequestMapping("/insertPlan")
    public void insertPlan(@RequestAttribute("reqData") PlatformData reqData,
                            @RequestAttribute("resData") PlatformData resData) throws Exception {

        PlanBean planBean = datasetToBeanMapper.datasetToBean(reqData, PlanBean.class);
        System.out.println("자금계획 추가 Rest API "+ planBean);
        planService.insertPlan(planBean);
    }

    // 자금계획 수정
    @RequestMapping("/updatePlan")
    public void updatePlan(@RequestAttribute("reqData") PlatformData reqData,
                           @RequestAttribute("resData") PlatformData resData) throws Exception {

        PlanBean planBean = datasetToBeanMapper.datasetToBean(reqData, PlanBean.class);
        System.out.println("자금계획 수정 Rest API "+ planBean);
        planService.updatePlan(planBean);

    }

    // 자금계획 삭제
    @RequestMapping("/deletePlan")
    public void deletePlan(@RequestAttribute("reqData") PlatformData reqData,
                           @RequestAttribute("resData") PlatformData resData) throws Exception {

        String planNo = reqData.getVariable("planNo").getString();
        System.out.println("자금계획 : "+ planNo + " 삭제 Rest API ");
        planService.deletePlan(planNo);

    }
}
