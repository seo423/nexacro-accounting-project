package kr.co.seoulit.erp.account.posting.ledger.controller;

import java.util.ArrayList;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.seoulit.erp.account.posting.ledger.dto.CashJournalBean;
import kr.co.seoulit.erp.account.posting.ledger.service.LedgerService;
import kr.co.seoulit.erp.account.sys.common.dao.DatasetToBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.nexacro.java.xapi.data.PlatformData;

@Tag(name = "CashJournalController", description = "<b>[posting/ledger]</b> 현급출납장 API")
@RestController
@RequestMapping("/acc/posting")
public class CashJournalController {

	@Autowired
    private LedgerService ledgerService;
	@Autowired
    private DatasetToBeanMapper datasetToBeanMapper;


    ModelAndView mav = null;
    ModelMap map = new ModelMap();

    //현금출납장 조회
    @RequestMapping("/cashjournal")
    @Operation(summary = "현금출납장 조회", description = "현금출납장을 조회한다.")
    public ArrayList<CashJournalBean> handleRequestInternal(@RequestAttribute("reqData") PlatformData reqData,
                                                            @RequestAttribute("resData") PlatformData resData) throws Exception{
    	String account=reqData.getVariable("account").getString();
    	String fromDate=reqData.getVariable("startDate").getString();
    	String toDate=reqData.getVariable("endDate").getString();
    	System.out.println(account+"@@@@@@@@@@@@@@@@@@");
    	System.out.println(fromDate+"@@@@@@@@@@@@@@@@@@");
    	System.out.println(toDate+"@@@@@@@@@@@@@@@@@@");

        ArrayList<CashJournalBean> cashJournalList = ledgerService.findCashJournal(fromDate, toDate, account);
        datasetToBeanMapper.beansToDataset(resData, cashJournalList, CashJournalBean.class);
        return null;
    }
}
