package kr.co.seoulit.erp.account.posting.ledger.controller;

import java.util.ArrayList;

import com.nexacro.java.xapi.data.PlatformData;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.seoulit.erp.account.posting.ledger.dto.JournalDetailDtoRes;
import kr.co.seoulit.erp.account.posting.ledger.dto.JournalDtoRes;
import kr.co.seoulit.erp.account.sys.common.dao.DatasetToBeanMapper;
import kr.co.seoulit.erp.account.posting.ledger.service.LedgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "JournalEntryController", description = "<b>[posting/ledger]</b> 분개장 API")
@RestController
@RequestMapping("/acc/posting")
public class JournalEntryController {
	
    @Autowired
    private LedgerService ledgerService;
    @Autowired
    private DatasetToBeanMapper datasetToBeanMapper;

    @RequestMapping("/findRangedJournalList2")
	public ArrayList<JournalDtoRes> findRangedJournalList(@RequestAttribute("reqData") PlatformData reqData,
                                                          @RequestAttribute("resData") PlatformData resData) throws Exception {

        String fromDate = reqData.getVariable("startDate").getString();
        String toDate = reqData.getVariable("endDate").getString();

        ArrayList<JournalDtoRes> journalList = ledgerService.findRangedJournalList(fromDate, toDate);

        datasetToBeanMapper.beansToDataset(resData, journalList, JournalDtoRes.class);

        return null;
    }




    @RequestMapping(value = "/findJournalDetailList2")
    public ArrayList<JournalDetailDtoRes> findJournalDetailList(@RequestAttribute("reqData") PlatformData reqData,
                                                                @RequestAttribute("resData")PlatformData resData) throws Exception {

        String journalNo = reqData.getVariable("journalNo").getString();

        ArrayList<JournalDetailDtoRes> journalDetailDtoRes = ledgerService.findJournalDetailList(journalNo);

        datasetToBeanMapper.beansToDataset(resData, journalDetailDtoRes, JournalDetailDtoRes.class);

        return null;
    }
}
