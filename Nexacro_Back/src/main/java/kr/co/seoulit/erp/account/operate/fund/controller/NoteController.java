package kr.co.seoulit.erp.account.operate.fund.controller;

import com.nexacro.java.xapi.data.PlatformData;
import kr.co.seoulit.erp.account.operate.fund.service.NoteService;
import kr.co.seoulit.erp.account.operate.fund.to.*;
import kr.co.seoulit.erp.account.sys.common.dao.DatasetToBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/acc/operate")
public class NoteController {

    @Autowired
    private NoteService noteService;
    @Autowired
    private DatasetToBeanMapper datasetToBeanMapper;


    // 어음현황 조회
    @RequestMapping("/findNoteStatus")
    public void findNoteStatus(@RequestAttribute("reqData") PlatformData reqData,
                               @RequestAttribute("resData") PlatformData resData) throws Exception {

        String date = reqData.getVariable("date").getString();
        System.out.println(date + " 어음현황 조회 Rest API ");

        HashMap<String, Object> noteStatusMap = noteService.findNoteStatus(date);

        List<PayNoteStatusBean> payNoteStatusList = (List<PayNoteStatusBean>)noteStatusMap.get("payableNoteStatusList");
        List<ReceiveNoteStatusBean> receiveNoteStatusList = (List<ReceiveNoteStatusBean>)noteStatusMap.get("receivableNoteStatusList");

        datasetToBeanMapper.beansToDataset(resData, payNoteStatusList, PayNoteStatusBean.class);
        datasetToBeanMapper.beansToDataset(resData, receiveNoteStatusList, ReceiveNoteStatusBean.class);
    }
}
