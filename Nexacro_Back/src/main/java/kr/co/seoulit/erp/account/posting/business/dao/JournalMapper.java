package kr.co.seoulit.erp.account.posting.business.dao;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.erp.account.posting.business.dto.JournalDetailresDto;
import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.account.posting.business.entity.JournalEntity;
import kr.co.seoulit.erp.account.posting.business.entity.JournalDetailEntity;

@Mapper
public interface JournalMapper {

    public ArrayList<JournalEntity> selectJournalList(String slipNo);

    public void deleteJournal(String journalNo);
    
    public void deleteJournalAll(String slipNo);

    public boolean updateJournal(JournalEntity journalEntity);
    
    ArrayList<JournalDetailresDto> selectJournalDetailList(String fromDate, String toDate);
    
    ArrayList<JournalDetailEntity> detailAccountList(String accountCode);
    
    String selectJournalDetailDescriptionName(String journalDetailNo);

    public void deleteJournalDetail(String journalNo);
    
    public void deleteJournalDetailByJournalNo(String journalNo);

    public void updateJournalDetail(JournalDetailEntity journalDetailEntity);

    public void insertJournalDetailList(JournalDetailEntity journalDetailEntity);

	public ArrayList<JournalEntity> selectRangedJournalList(HashMap<String, String> map);

	public void insertJournal(JournalEntity journalEntity);

	public String selectJournalName(String slipNo);
}
