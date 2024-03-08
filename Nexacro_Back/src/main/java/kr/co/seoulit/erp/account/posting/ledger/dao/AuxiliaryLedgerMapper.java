package kr.co.seoulit.erp.account.posting.ledger.dao;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.erp.account.posting.ledger.dto.CashJournalBean;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuxiliaryLedgerMapper {

	//현금출납장 조회
	public ArrayList<CashJournalBean> selectCashJournalList(HashMap<String, String> map);

	public ArrayList<CashJournalBean> selectTotalCashJournalList(HashMap<String, String> map);
}
