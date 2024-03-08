package kr.co.seoulit.erp.account.posting.ledger.controller;

import java.util.ArrayList;

import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.seoulit.erp.account.posting.ledger.dto.AssetItemReqDto;
import kr.co.seoulit.erp.account.posting.ledger.dto.AssetItemResDto;
import kr.co.seoulit.erp.account.posting.ledger.dto.AssetResDto;
import kr.co.seoulit.erp.account.posting.ledger.dto.DeptResDto;
import kr.co.seoulit.erp.account.posting.ledger.entity.AssetEntity;
import kr.co.seoulit.erp.account.posting.ledger.service.LedgerService;
import kr.co.seoulit.erp.account.sys.common.dao.DatasetToBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexacro.java.xapi.data.PlatformData;

@Tag(name = "AssetManagementController", description = "<b>[posting/ledger]</b> 자산관리대장 API")
@RestController
@RequestMapping("/acc/posting")
public class AssetManagementController{

	@Autowired
    private LedgerService ledgerService;
	@Autowired
	private DatasetToBeanMapper datasetToBeanMapper;

	@RequestMapping("/assetList")
	public ArrayList<AssetEntity> assetList(@RequestAttribute("reqData") PlatformData reqData,
                                            @RequestAttribute("resData") PlatformData resData) throws Exception {

		ArrayList<AssetResDto> AssetList = ledgerService.findAssetList();
		datasetToBeanMapper.beansToDataset(resData, AssetList, AssetResDto.class);
		return null;
	}

	@RequestMapping("/assetitemlist")
    public ArrayList<AssetItemResDto> assetItemList(@RequestAttribute("reqData") PlatformData reqData,
                                                    @RequestAttribute("resData") PlatformData resData) throws Exception{
        String assetCode = reqData.getVariable("assetCode").getString();

        	ArrayList<AssetItemResDto> AssetItemList = ledgerService.findAssetItemList(assetCode);
        	datasetToBeanMapper.beansToDataset(resData, AssetItemList, AssetItemResDto.class);
        	return null;
    }

	@RequestMapping("/deptlist")
	public ArrayList<DeptResDto> deptList(@RequestAttribute("reqData") PlatformData reqData,
                                          @RequestAttribute("resData") PlatformData resData) throws Exception {

		long start=System.currentTimeMillis();

		ArrayList<DeptResDto> DeptList = ledgerService.findDeptList();

		long finish=System.currentTimeMillis();

		System.out.println("부서목록 조회 소요시간 : "+(finish-start)+"ms");

		datasetToBeanMapper.beansToDataset(resData, DeptList, DeptResDto.class);

		return null;
	}

	@PostMapping("/assetitemlistRegist")
	public void assetStorage(@RequestAttribute("reqData") PlatformData reqData,
							 @RequestAttribute("resData") PlatformData resData) throws Exception {

		AssetItemReqDto assetItemReqDto = datasetToBeanMapper.datasetToBean(reqData, AssetItemReqDto.class);
		ledgerService.assetStorage(assetItemReqDto);

	}


	@RequestMapping("/assetremoval")
	public void assetRemove(@RequestAttribute("reqData") PlatformData reqData,
							@RequestAttribute("resData") PlatformData resData) throws Exception {

		String assetItemCode = reqData.getVariable("code").getString();
		ledgerService.removeAssetItem(assetItemCode);

	}
}
