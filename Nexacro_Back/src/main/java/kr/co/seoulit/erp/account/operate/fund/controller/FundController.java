package kr.co.seoulit.erp.account.operate.fund.controller;

import com.nexacro.java.xapi.data.PlatformData;
import kr.co.seoulit.erp.account.operate.fund.service.FundService;
import kr.co.seoulit.erp.account.operate.fund.to.*;
import kr.co.seoulit.erp.account.sys.common.dao.DatasetToBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/acc/operate")
public class FundController {

    @Autowired
    private FundService fundService;
    @Autowired
    private DatasetToBeanMapper datasetToBeanMapper;

    // 일일거래증감현황 조회
    @RequestMapping("/findDailyTradeStatus")
    public void findDailyTradeStatus(@RequestAttribute("reqData") PlatformData reqData,
                                     @RequestAttribute("resData") PlatformData resData) throws Exception {

        String date = reqData.getVariable("date").getString();
        System.out.println(date + " 일일거래증감현황 조회 Rest API ");

        List<DailyTradeStatusBean> dailyTradeStatusList = fundService.findDailyTradeStatus(date);
        datasetToBeanMapper.beansToDataset(resData, dailyTradeStatusList, DailyTradeStatusBean.class);
    }

    // 입출금예정액 조회
    @RequestMapping("/findInoutExpectedPrice")
    public void findInoutExpectedPrice(@RequestAttribute("reqData") PlatformData reqData,
                                       @RequestAttribute("resData") PlatformData resData) throws Exception {

        String date = reqData.getVariable("date").getString();
        System.out.println(date + " 입출금예정액 조회 Rest API ");

        HashMap<String, Object> inoutMap = fundService.findInoutExpectedPrice(date);

        List<OutBean> outExpectedPriceList = (List<OutBean>)inoutMap.get("outExpectedPriceList");
        List<InBean> inExpectedPriceList = (List<InBean>)inoutMap.get("inExpectedPriceList");

        datasetToBeanMapper.beansToDataset(resData, outExpectedPriceList, OutBean.class);
        datasetToBeanMapper.beansToDataset(resData, inExpectedPriceList, InBean.class);

    }

    // 예적금현황 조회
    @RequestMapping("/findFinanceStatus")
    public void findFinanceStatus(@RequestAttribute("reqData") PlatformData reqData,
                                  @RequestAttribute("resData") PlatformData resData) throws Exception {

        String date = reqData.getVariable("date").getString();
        String accountName = reqData.getVariable("accountName").getString();
        System.out.println(date + " : " + accountName + " 예적금현황 조회 Rest API ");

        List<FinanceBean> financeStatusList = fundService.findFinanceStatus(date, accountName);
        datasetToBeanMapper.beansToDataset(resData, financeStatusList, FinanceBean.class);
    }

    // 총괄거래현황 조회
    @RequestMapping("/findGeneralFundStatus")
    public void findGeneralFundStatus(@RequestAttribute("reqData") PlatformData reqData,
                                      @RequestAttribute("resData") PlatformData resData) throws Exception {

        String startDate = reqData.getVariable("startDate").getString();
        String endDate = reqData.getVariable("endDate").getString();
        System.out.println(startDate + " ~ " + endDate + " 총괄거래현황 조회 Rest API ");

        List<GeneralFundBean> generalFundStatusList = fundService.findGeneralFundStatus(startDate, endDate);
        datasetToBeanMapper.beansToDataset(resData, generalFundStatusList, GeneralFundBean.class);
    }

}
