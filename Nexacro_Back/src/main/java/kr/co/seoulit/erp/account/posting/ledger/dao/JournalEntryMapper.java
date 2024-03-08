package kr.co.seoulit.erp.account.posting.ledger.dao;

import java.util.ArrayList;

import kr.co.seoulit.erp.account.posting.ledger.entity.JournalDetailResEntity;
import kr.co.seoulit.erp.account.posting.ledger.entity.JournalResEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JournalEntryMapper {
	
    ArrayList<JournalResEntity> selectRangedJournalList(String fromDate, String toDate);
    
    ArrayList<JournalDetailResEntity> selectJournalDetailList(String journalNo);
}
