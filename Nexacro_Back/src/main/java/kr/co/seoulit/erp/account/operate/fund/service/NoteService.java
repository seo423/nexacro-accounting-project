package kr.co.seoulit.erp.account.operate.fund.service;

import java.util.HashMap;

public interface NoteService {

    // 어음현황 조회
    public HashMap<String, Object> findNoteStatus(String date) throws Exception;
}
