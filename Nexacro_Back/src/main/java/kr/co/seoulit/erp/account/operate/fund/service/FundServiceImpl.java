package kr.co.seoulit.erp.account.operate.fund.service;

import kr.co.seoulit.erp.account.operate.fund.dao.FundDAO;
import kr.co.seoulit.erp.account.operate.fund.to.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FundServiceImpl implements FundService{

    @Autowired
    private FundDAO fundDAO;

    // 일일거래증감현황 조회
    @Override
    public List<DailyTradeStatusBean> findDailyTradeStatus(String date) throws Exception {
        HashMap<String,Object> param = new HashMap<>();

        param.put("selectDate", date);
        fundDAO.findDailyTradeStatus(param);
        List<DailyTradeStatusBean> dailyTradeStatusList = (List<DailyTradeStatusBean>) param.get("RESULT");

        return dailyTradeStatusList;
    }

    // 입출금예정액 조회
    @Override
    public HashMap<String, Object> findInoutExpectedPrice(String date) throws Exception {
        HashMap<String, Object> param = new HashMap<>();

        HashMap<String, String> rightData = new HashMap<>();
        rightData.put("selectDate", date);
        rightData.put("balanceDivision", "대변");
        HashMap<String, String> leftData = new HashMap<>();
        leftData.put("selectDate", date);
        leftData.put("balanceDivision", "차변");

        List<OutBean> outExpectedPriceList = fundDAO.findOutExpectedPrice(rightData);
        List<InBean> inExpectedPriceList = fundDAO.findInExpectedPrice(leftData);

        param.put("outExpectedPriceList", outExpectedPriceList);
        param.put("inExpectedPriceList", inExpectedPriceList);

        return param;
    }

    // 예적금현황 조회
    @Override
    public List<FinanceBean> findFinanceStatus(String date, String accountName) throws Exception {
        HashMap<String, Object> param = new HashMap<>();
        param.put("selectDate", date);
        param.put("selectAccount", accountName);
        System.out.println("date: " + date);
        System.out.println("accountName: " + accountName);



        fundDAO.findFinanceStatus(param);
        List<FinanceBean> financeStatusList = (List<FinanceBean>) param.get("RESULT");

        return financeStatusList;

    }

    // 총괄거래현황 조회
    @Override
    public List<GeneralFundBean> findGeneralFundStatus(String startDate, String endDate) throws Exception {

        HashMap<String, String> param = new HashMap<>();
        param.put("startDate", startDate);
        param.put("endDate", endDate);

        List<GeneralFundBean> generalFundStatusList = fundDAO.findGeneralFundStatus(param);

        return generalFundStatusList;
    }
}
