package kr.co.seoulit.erp.account.operate.fund.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface NoteDAO {

    // 지급어음현황 조회
    public HashMap<String, Object> findPayNoteStatus(HashMap<String, Object> data);

    // 받을어음현황 조회
    public HashMap<String, Object> findReceiveNoteStatus(HashMap<String, Object> data);
}
