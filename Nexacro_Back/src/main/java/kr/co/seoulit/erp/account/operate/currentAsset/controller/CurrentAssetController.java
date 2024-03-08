package kr.co.seoulit.erp.account.operate.currentAsset.controller;

import com.nexacro.java.xapi.data.PlatformData;
import kr.co.seoulit.erp.account.operate.currentAsset.service.CurrentAssetService;
import kr.co.seoulit.erp.account.operate.currentAsset.to.CurrentAssetDetailReqDTO;
import kr.co.seoulit.erp.account.operate.currentAsset.to.CurrentAssetDetailResDTO;
import kr.co.seoulit.erp.account.operate.currentAsset.to.CurrentAssetReqDTO;
import kr.co.seoulit.erp.account.operate.currentAsset.to.CurrentAssetResDTO;
import kr.co.seoulit.erp.account.sys.common.dao.DatasetToBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/acc/operate")
public class CurrentAssetController {

    @Autowired
    private CurrentAssetService currentAssetService;
    @Autowired
    private DatasetToBeanMapper datasetToBeanMapper;

    // 고정자산 조회
    @RequestMapping("/findAssetList")
    public void findAssetList(@RequestAttribute("reqData") PlatformData reqData,
                              @RequestAttribute("resData") PlatformData resData) throws Exception {

        System.out.println("고정자산 조회 Rest API");
        List<CurrentAssetResDTO> currentAssetList = currentAssetService.findAssetList();
        datasetToBeanMapper.beansToDataset(resData, currentAssetList, CurrentAssetResDTO.class);
    }

    // 고정자산상세 조회
    @RequestMapping("/findAssetDetail")
    public void findAssetDetail(@RequestAttribute("reqData") PlatformData reqData,
                                @RequestAttribute("resData") PlatformData resData) throws Exception {

        String assetCode = reqData.getVariable("assetCode").getString();
        System.out.println("고정자산 : "+ assetCode + " 상세 조회 Rest API");

        HashMap<String, Object> currentAssetMap = currentAssetService.findAssetDetail(assetCode);

        CurrentAssetResDTO currentAssetResDTO = (CurrentAssetResDTO) currentAssetMap.get("currentAssetResDTO");
        CurrentAssetDetailResDTO currentAssetDetailResDTO= (CurrentAssetDetailResDTO) currentAssetMap.get("currentAssetDetailResDTO");

        datasetToBeanMapper.beanToDataset(resData, currentAssetResDTO, CurrentAssetResDTO.class);
        datasetToBeanMapper.beanToDataset(resData, currentAssetDetailResDTO, CurrentAssetDetailResDTO.class);
    }

    // 고정자산 차량조회
    @RequestMapping("/findCarAsset")
    public void findCarAsset(@RequestAttribute("reqData") PlatformData reqData,
                             @RequestAttribute("resData") PlatformData resData) throws Exception {

        List<CurrentAssetResDTO> currentAssetResDTOList = currentAssetService.findCarAsset();
        datasetToBeanMapper.beansToDataset(resData, currentAssetResDTOList, CurrentAssetResDTO.class);
    }

    // 고정자산 추가
    @RequestMapping("/insertAsset")
    public void insertAsset(@RequestAttribute("reqData") PlatformData reqData,
                            @RequestAttribute("resData") PlatformData resData) throws Exception {

        CurrentAssetReqDTO currentAssetReqDTO = datasetToBeanMapper.datasetToBean(reqData, CurrentAssetReqDTO.class);
        CurrentAssetDetailReqDTO currentAssetDetailReqDTO = datasetToBeanMapper.datasetToBean(reqData, CurrentAssetDetailReqDTO.class);
        System.out.println("고정자산 추가 Rest API "+ currentAssetReqDTO + currentAssetDetailReqDTO);

        currentAssetService.insertAsset(currentAssetReqDTO, currentAssetDetailReqDTO);
    }

    // 고정자산 수정
    @RequestMapping("/updateAsset")
    public void updateAsset(@RequestAttribute("reqData") PlatformData reqData,
                            @RequestAttribute("resData") PlatformData resData) throws Exception {

        CurrentAssetReqDTO currentAssetReqDTO = datasetToBeanMapper.datasetToBean(reqData, CurrentAssetReqDTO.class);
        CurrentAssetDetailReqDTO currentAssetDetailReqDTO = datasetToBeanMapper.datasetToBean(reqData, CurrentAssetDetailReqDTO.class);
        System.out.println("고정자산 수정 Rest API "+ currentAssetReqDTO + currentAssetDetailReqDTO);

        currentAssetService.updateAsset(currentAssetReqDTO, currentAssetDetailReqDTO);
    }

    // 고정자산 삭제
    @RequestMapping("/deleteAsset")
    public void deleteAsset(@RequestAttribute("reqData") PlatformData reqData,
                            @RequestAttribute("resData") PlatformData resData) throws Exception {

        String assetCode = reqData.getVariable("assetCode").getString();
        System.out.println("고정자산 : " + assetCode + " 삭제 Rest API");

        currentAssetService.deleteAsset(assetCode);
    }

    // 감가상각비현황 전체조회
    @RequestMapping("/findDepreciationList")
    public void findDepreciationList(@RequestAttribute("reqData") PlatformData reqData,
                                     @RequestAttribute("resData") PlatformData resData) throws Exception {

        List<CurrentAssetResDTO> currentAssetList = currentAssetService.findDepreciationList();
        System.out.println("감가상각비현황 조회 Rest API" + currentAssetList);

        datasetToBeanMapper.beansToDataset(resData, currentAssetList, CurrentAssetResDTO.class);
    }

    // 감가상각비현황 선택조회
    @RequestMapping("/selectDepreciationList")
    public void selectDepreciationList(@RequestAttribute("reqData") PlatformData reqData,
                                       @RequestAttribute("resData") PlatformData resData) throws Exception{

        String accountCode = reqData.getVariable("accountCode").getString();
        System.out.println("계정과목 : " + accountCode + " 감가상각비현황 Rest API");

        List<CurrentAssetResDTO> currentAssetList = currentAssetService.selectDepreciationList(accountCode);
        datasetToBeanMapper.beansToDataset(resData, currentAssetList, CurrentAssetResDTO.class);
    }

    // 고정자산관리대장 조회
    @RequestMapping("findCurrentAssetLedgerList")
    public void findCurrentAssetLedgerList(@RequestAttribute("reqData") PlatformData reqData,
                                           @RequestAttribute("resData") PlatformData resData) throws Exception{

        List<CurrentAssetResDTO> currentAssetLedgerList = currentAssetService.findCurrentAssetLedgerList();
        System.out.println("고정자산관리대장 조회 Rest API" + currentAssetLedgerList);

        datasetToBeanMapper.beansToDataset(resData, currentAssetLedgerList, CurrentAssetResDTO.class);
    }

}
