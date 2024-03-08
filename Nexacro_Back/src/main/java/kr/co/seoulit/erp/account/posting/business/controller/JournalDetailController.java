package kr.co.seoulit.erp.account.posting.business.controller;

import java.util.ArrayList;

import io.swagger.v3.oas.annotations.Hidden;
import kr.co.seoulit.erp.account.posting.business.dto.JournalDetailresDto;
import kr.co.seoulit.erp.account.posting.business.entity.JournalDetailEntity;
import kr.co.seoulit.erp.account.posting.business.service.BusinessService;
import kr.co.seoulit.erp.account.sys.common.dao.DatasetToBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.nexacro.java.xapi.data.PlatformData;

@Hidden //swagger test : 일단 ledger부분만 나오도록 설정해둠
@RestController
@RequestMapping("/acc/posting")
public class JournalDetailController {

    @Autowired
    private BusinessService businessService;
    @Autowired
    private DatasetToBeanMapper datasetToBeanMapper;

    //분개상세정보 범위 조회
    @RequestMapping(value = "/findJournalDetailList")
    public void findJournalDetailList(@RequestAttribute("reqData") PlatformData reqData,
                                      @RequestAttribute("resData") PlatformData resData) throws Exception {
        String fromDate = reqData.getVariable("startDate").getString();
        String toDate = reqData.getVariable("endDate").getString();
        ArrayList<JournalDetailresDto> journalDetailList = businessService.findJournalDetailList(fromDate,toDate);
        datasetToBeanMapper.beansToDataset(resData, journalDetailList, JournalDetailresDto.class);
    }

    @RequestMapping(value = "/journalDetailAccountList")
    public ArrayList<JournalDetailEntity> journalDetailAccountList(@RequestAttribute("reqData")PlatformData reqData,
                                                                   @RequestAttribute("resData")PlatformData resData) throws Exception {
        String accountCode = reqData.getVariable("accountCode").getString();

        ArrayList<JournalDetailEntity> List = businessService.detailAccountList(accountCode);
        datasetToBeanMapper.beansToDataset(resData, List, JournalDetailEntity.class);
        return null;
    }

    @GetMapping("/journaldetailmodification")
    public void modifyJournalDetail(@RequestParam String accountControlType, @RequestParam String journalNo,
                                    @RequestParam(value = "journalDetailNo", required = false) String journalDetailNo,
                                    @RequestParam String journalDescription) {

        JournalDetailEntity journalDetailEntity = new JournalDetailEntity();

        journalDetailEntity.setAccountControlType(accountControlType);
        journalDetailEntity.setJournalNo(journalNo);
        journalDetailEntity.setJournalDetailNo(journalDetailNo);
        journalDetailEntity.setJournalDescription(journalDescription);

        businessService.modifyJournalDetail(journalDetailEntity);
    }
}
