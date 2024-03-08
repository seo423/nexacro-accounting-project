package kr.co.seoulit.erp.account.operate.fund.service;

import kr.co.seoulit.erp.account.operate.fund.dao.NoteDAO;
import kr.co.seoulit.erp.account.operate.fund.to.PayNoteStatusBean;
import kr.co.seoulit.erp.account.operate.fund.to.ReceiveNoteStatusBean;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService{

    @Autowired
    private NoteDAO noteDAO;


    // 어음현황 조회
    @Override
    public HashMap<String, Object> findNoteStatus(String date) throws Exception {

        HashMap<String, Object> param = new HashMap<>();

        HashMap<String, Object> payNoteMap = new HashMap<>();
        payNoteMap.put("selectDate", date);
        payNoteMap.put("selectAccount", "0252");

        noteDAO.findPayNoteStatus(payNoteMap);
        List<PayNoteStatusBean> payableNoteStatusList = (List<PayNoteStatusBean>) payNoteMap.get("RESULT");

        HashMap<String, Object> receiveNoteMap = new HashMap<>();
        receiveNoteMap.put("selectDate", date);
        receiveNoteMap.put("selectAccount", "0110");

        noteDAO.findReceiveNoteStatus(receiveNoteMap);
        List<ReceiveNoteStatusBean> receivableNoteStatusList = (List<ReceiveNoteStatusBean>) receiveNoteMap.get("RESULT");

        param.put("payableNoteStatusList", payableNoteStatusList);
        param.put("receivableNoteStatusList", receivableNoteStatusList);

        return param;
    }
}
