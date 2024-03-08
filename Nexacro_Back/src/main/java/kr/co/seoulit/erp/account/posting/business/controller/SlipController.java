package kr.co.seoulit.erp.account.posting.business.controller;

import java.util.ArrayList;
import java.util.HashMap;

import io.swagger.v3.oas.annotations.Hidden;
import kr.co.seoulit.erp.account.posting.business.dto.JournalDetailreqDto;
import kr.co.seoulit.erp.account.posting.business.dto.JournalreqDto;
import kr.co.seoulit.erp.account.posting.business.dto.SlipreqDto;
import kr.co.seoulit.erp.account.posting.business.dto.SlipresDto;
import kr.co.seoulit.erp.account.posting.business.entity.SlipEntity;
import kr.co.seoulit.erp.account.sys.common.dao.DatasetToBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kr.co.seoulit.erp.account.posting.business.service.BusinessService;
import kr.co.seoulit.erp.account.posting.business.entity.JournalEntity;
import kr.co.seoulit.erp.account.posting.business.entity.JournalDetailEntity;
import net.sf.json.JSONObject;
import com.nexacro.java.xapi.data.PlatformData;


@Hidden //swagger test : 일단 ledger부분만 나오도록 설정해둠
@RestController
@RequestMapping("/acc/posting")
public class SlipController {

    @Autowired
    private BusinessService businessService;
    @Autowired
    private DatasetToBeanMapper datasetToBeanMapper;

    //전표조회
    @RequestMapping("/findRangedSlipList")
    public void findRangedSlipList(@RequestAttribute("reqData") PlatformData reqData,
                                   @RequestAttribute("resData") PlatformData resData) throws Exception{

        String from = reqData.getVariable("startDate").getString();
        String to = reqData.getVariable("endDate").getString();
        String slipStatus = reqData.getVariable("slipStatus").getString();

        HashMap<String, Object> param = new HashMap<>();
        param.put("fromDate", from);
        param.put("toDate", to);
        param.put("slipStatus", slipStatus);
        ArrayList<SlipresDto> slipList =  businessService.findRangedSlipList(param);
        datasetToBeanMapper.beansToDataset(resData, slipList, SlipresDto.class);
    }

    //전표 추가
    @RequestMapping("/addSlip")
    public void addSlip(@RequestAttribute("reqData") PlatformData reqData,
                        @RequestAttribute("resData") PlatformData resData) throws Exception{
        // 넘어온 dataset 데이터를 Bean객체로 파싱
        SlipEntity slipObj = datasetToBeanMapper.datasetToBean(reqData, SlipEntity.class); // 전표추가는 한번에 하나 가능

        ArrayList<JournalEntity> journal = (ArrayList<JournalEntity>) datasetToBeanMapper.datasetToBeans(reqData, JournalEntity.class); // 분개

        ArrayList<JournalDetailEntity> journalDetail = (ArrayList<JournalDetailEntity>) datasetToBeanMapper.datasetToBeans(reqData, JournalDetailEntity.class);



        String empCode = reqData.getVariable("empCode").getString();
        String deptCode = reqData.getVariable("deptCode").getString();

        slipObj.setReportingEmpCode(empCode);
        slipObj.setDeptCode(deptCode);
        slipObj.setSlipStatus("작성중");

        businessService.addSlip(slipObj, journal, journalDetail);//journalDetail
    }


    //전표수정
    @RequestMapping("/updateSlip")
    public void modifySlip(@RequestAttribute("reqData") PlatformData reqData,
                           @RequestAttribute("resData") PlatformData resData) throws Exception {
        SlipreqDto slipreqdto= datasetToBeanMapper.datasetToBean(reqData, SlipreqDto.class);
        ArrayList<JournalreqDto> journalObj=(ArrayList<JournalreqDto>) datasetToBeanMapper.datasetToBeans(reqData, JournalreqDto.class);
        ArrayList<JournalDetailreqDto> journalDetailObj=(ArrayList<JournalDetailreqDto>) datasetToBeanMapper.datasetToBeans(reqData, JournalDetailreqDto.class);

        businessService.modifySlip(slipreqdto, journalObj, journalDetailObj);
    }



    @RequestMapping("/removeSlip")
    public void removeSlip( @RequestAttribute("reqData") PlatformData reqData,
                            @RequestAttribute("resData") PlatformData resData) throws Exception{
        String slipNo=reqData.getVariable("slipNo").getString();

        businessService.removeSlip(slipNo);
    }

    //전표승인
    @RequestMapping("/approveSlip")
    public void approveSlip(@RequestAttribute("reqData") PlatformData reqData,
                            @RequestAttribute("resData") PlatformData resData) throws Exception{

        ArrayList<SlipreqDto> slipDtos =(ArrayList<SlipreqDto>) datasetToBeanMapper.datasetToBeans(reqData, SlipreqDto.class);

        businessService.approveSlip(slipDtos);
    }

    @GetMapping("/disapprovalsliplist")
    public ArrayList<SlipEntity> findDisApprovalSlipList() {

        return businessService.findDisApprovalSlipList();
    }
    @GetMapping("/findSlip")
    public ArrayList<SlipEntity> findSlip(@RequestParam String slipNo) {

        return businessService.findSlip(slipNo);
    }

    @GetMapping("/accountingsettlementstatus")
    public HashMap<String, Object> findAccountingSettlementStatus(@RequestParam String accountPeriodNo,
                                                                  @RequestParam String callResult) {
        JSONObject json = new JSONObject();
        HashMap<String, Object> params = new HashMap<>();

        params.put("accountPeriodNo", accountPeriodNo);
        params.put("callResult",callResult);

        json.put("errorCode", 0); json.put("errorMsg", "데이터 조회 성공");

        businessService.findAccountingSettlementStatus(params);


        return params;
    }

}
