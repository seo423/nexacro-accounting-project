package kr.co.seoulit.erp.account.operate.fund.service;

import kr.co.seoulit.erp.account.operate.fund.to.DailyTradeStatusBean;
import kr.co.seoulit.erp.account.operate.fund.to.FinanceBean;
import kr.co.seoulit.erp.account.operate.fund.to.GeneralFundBean;

import java.util.HashMap;
import java.util.List;

public interface FundService {

    // 일일거래증감현황 조회
    public List<DailyTradeStatusBean> findDailyTradeStatus(String date) throws Exception;

    // 입출금예정액 조회
    public HashMap<String, Object> findInoutExpectedPrice(String date) throws Exception;

    // 예적금현황 조회
    public List<FinanceBean> findFinanceStatus(String date, String accountName) throws Exception;

    // 총괄거래현황 조회
    public List<GeneralFundBean> findGeneralFundStatus(String startDate, String endDate) throws Exception;

    // 어음현황 조회
}
