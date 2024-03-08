package kr.co.seoulit.erp.account.posting.business.controller;

import java.util.ArrayList;

import io.swagger.v3.oas.annotations.Hidden;
import kr.co.seoulit.erp.account.posting.business.dto.JournalresDto;
import kr.co.seoulit.erp.account.posting.business.service.BusinessService;
import kr.co.seoulit.erp.account.posting.business.entity.JournalEntity;
import kr.co.seoulit.erp.account.sys.common.dao.DatasetToBeanMapper;
import kr.co.seoulit.erp.account.sys.common.util.BeanCreator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nexacro.java.xapi.data.PlatformData;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Hidden //swagger test : 일단 ledger부분만 나오도록 설정해둠
@RestController
@RequestMapping("/acc/posting")
public class JournalController {

    @Autowired
    private BusinessService businessService;
    @Autowired
    private DatasetToBeanMapper datasetToBeanMapper;

    @RequestMapping("/findSingleJournalList")
    public ArrayList<JournalEntity> findSingleJournalList(@RequestAttribute("reqData") PlatformData reqData,
                                                          @RequestAttribute("resData")PlatformData resData) throws Exception {
        String slipNo = reqData.getVariable("slipNo").getString();
        ArrayList<JournalEntity> journalList = businessService.findSingleJournalList(slipNo);
        datasetToBeanMapper.beansToDataset(resData, journalList, JournalEntity.class);
        return null;
    }

    //분개 범위 조회
    @RequestMapping(value = "/findRangedJournalList")
    public void findRangedJournalList(@RequestAttribute("reqData") PlatformData reqData,
                                      @RequestAttribute("resData")PlatformData resData) throws Exception {
        String fromDate = reqData.getVariable("startDate").getString();
        String toDate = reqData.getVariable("endDate").getString();

        ArrayList<JournalresDto> journalList = businessService.findRangedJournalList(fromDate,toDate);
        datasetToBeanMapper.beansToDataset(resData, journalList, JournalresDto.class);
    }

    @GetMapping("/journalremoval")
    public void removeJournal(@RequestParam String journalNo) {
        businessService.removeJournal(journalNo);
    }
    @GetMapping("modifyJournal")
    public void modifyJournal(@RequestParam String slipNo,
                              @RequestParam JSONArray journalObj) {

        JSONArray journalObjs = JSONArray.fromObject(journalObj);

        ArrayList<JournalEntity> journalBeanList = new ArrayList<>();

        for (Object journalObjt : journalObjs) {
            JournalEntity journalEntity = BeanCreator.getInstance().create(JSONObject.fromObject(journalObjt), JournalEntity.class);
            journalEntity.setStatus(((JSONObject)journalObjt).getString("status"));
            journalBeanList.add(journalEntity);
        }
        businessService.modifyJournal(slipNo, journalBeanList);
    }
}
