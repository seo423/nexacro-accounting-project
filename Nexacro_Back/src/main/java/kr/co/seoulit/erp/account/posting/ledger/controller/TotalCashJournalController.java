package kr.co.seoulit.erp.account.posting.ledger.controller;

import java.util.ArrayList;
import java.util.HashMap;

import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.seoulit.erp.account.posting.ledger.dto.CashJournalBean;
import kr.co.seoulit.erp.account.posting.ledger.service.LedgerService;
import kr.co.seoulit.erp.account.sys.common.dao.DatasetToBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexacro.java.xapi.data.PlatformData;

@Tag(name = "TotalCashJournalController", description = "<b>[posting/ledger]</b> 총계정원장 API")
@RestController
@RequestMapping("/acc/posting")
public class TotalCashJournalController {

    private LedgerService ledgerService;
    private DatasetToBeanMapper datasetToBeanMapper;
    
    @Autowired
    public TotalCashJournalController(LedgerService ledgerService, DatasetToBeanMapper datasetToBeanMapper) {
    	this.ledgerService=ledgerService;
    	this.datasetToBeanMapper = datasetToBeanMapper;
    }

   // @RequestMapping("/ledgerbyaccount")
    @RequestMapping("/Ledgerbyaccount")
    public ArrayList<CashJournalBean> handleRequestInternal(@RequestAttribute("reqData") PlatformData reqData,
                                                            @RequestAttribute("resData") PlatformData resData) throws Exception{
    	//String date=reqData.getVariable("date").getString();
    	String account=reqData.getVariable("account").getString();
        String year=reqData.getVariable("year").getString();
    	//String today=reqData.getVariable("accounttoday").getString();
    	HashMap<String, String> map = new HashMap<>();
    	//map.put("date",date );
    	map.put("account", account);
        map.put("year", year);
    	//map.put("today", today);

    	
            ArrayList<CashJournalBean> cashJournalList = ledgerService.findTotalCashJournal(map);
            datasetToBeanMapper.beansToDataset(resData, cashJournalList, CashJournalBean.class);
            return null;
    }

}
