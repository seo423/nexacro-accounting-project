package kr.co.seoulit.erp.account.posting.business.dao;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.erp.account.posting.business.entity.SlipEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SlipMapper {

    public void deleteSlip(String slipNo);

    public void updateSlip(SlipEntity slipEntity);

    public void insertSlip(SlipEntity slipEntity);

    public ArrayList<SlipEntity> selectRangedSlipList(HashMap<String, Object> param);

    public int selectSlipCount(String today);
    
    public ArrayList<SlipEntity> selectSlipDataList(String slipDate);
	
    public ArrayList<SlipEntity> selectSlip(String slipNo);
        
    public HashMap<String, Object> selectAccountingSettlementStatus(HashMap<String, Object> param);
}
