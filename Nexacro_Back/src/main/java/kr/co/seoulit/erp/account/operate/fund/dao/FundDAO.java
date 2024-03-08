package kr.co.seoulit.erp.account.operate.fund.dao;

import kr.co.seoulit.erp.account.operate.fund.to.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface FundDAO {

    // 일일거래증감현황 조회
    public HashMap<String, Object> findDailyTradeStatus(HashMap<String, Object> param);

    // 입출금예정액 조회
    public List<OutBean> findOutExpectedPrice(HashMap<String, String> data);
    public List<InBean> findInExpectedPrice(HashMap<String, String> data);

    // 예적금현황 조회
    public HashMap<String, Object> findFinanceStatus(HashMap<String, Object> data);

    // 총괄거래현황 조회
    public List<GeneralFundBean> findGeneralFundStatus(HashMap<String, String> data);
}
