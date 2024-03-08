package kr.co.seoulit.erp.account.posting.ledger.controller;


import com.nexacro.java.xapi.data.PlatformData;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.seoulit.erp.account.posting.ledger.service.LedgerService;
import kr.co.seoulit.erp.account.posting.ledger.dto.CustomerLedgerBean;
import kr.co.seoulit.erp.account.posting.ledger.dto.CustomerLedgerDetailResDto;
import kr.co.seoulit.erp.account.sys.common.dao.DatasetToBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@Tag(name = "CustomerLedgerController", description = "<b>[posting/ledger]</b> 거래처원장 API")
@RestController
@RequestMapping("/acc/posting")
public class CustomerLedgerController {

    @Autowired
    private LedgerService ledgerService;
    @Autowired
    private DatasetToBeanMapper datasetToBeanMapper;

    @Autowired
    public CustomerLedgerController(LedgerService ledgerService, DatasetToBeanMapper datasetToBeanMapper) {
        this.ledgerService=ledgerService;
        this.datasetToBeanMapper = datasetToBeanMapper;
    }


    @RequestMapping("/customerledger")
    public void handleRequestInternal(@RequestAttribute("reqData") PlatformData reqData,
                                                            @RequestAttribute("resData") PlatformData resData) throws Exception{

        String fromDate=reqData.getVariable("startDate").getString();
        String toDate=reqData.getVariable("endDate").getString();

        ArrayList<CustomerLedgerBean> customerLedgerList = ledgerService.findCustomerLedger(fromDate, toDate);
        System.out.println("%%%%%%%"+customerLedgerList.get(0).getCustomerName());
        datasetToBeanMapper.beansToDataset(resData, customerLedgerList, CustomerLedgerBean.class);

    }

    @RequestMapping("/findCustomerLedgerDetailList")
    public void findJournalDetailList(@RequestAttribute("reqData") PlatformData reqData,
                                      @RequestAttribute("resData") PlatformData resData) throws Exception{

        String customerCode=reqData.getVariable("customerCode").getString();

        ArrayList<CustomerLedgerDetailResDto> customerLedgerDetailList = ledgerService.findCustomerLedgerDetailList(customerCode);
        //System.out.println("%%%%%%%"+customerLedgerDetailList.get(0).getReportingDate());
        datasetToBeanMapper.beansToDataset(resData, customerLedgerDetailList, CustomerLedgerDetailResDto.class);

    }
}
