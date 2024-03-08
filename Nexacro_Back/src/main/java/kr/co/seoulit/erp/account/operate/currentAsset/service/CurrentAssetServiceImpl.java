package kr.co.seoulit.erp.account.operate.currentAsset.service;

import kr.co.seoulit.erp.account.operate.currentAsset.dao.*;
import kr.co.seoulit.erp.account.operate.currentAsset.to.*;
import kr.co.seoulit.erp.account.operate.currentAsset.entity.*;
import kr.co.seoulit.erp.account.operate.currentAsset.mapstruct.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CurrentAssetServiceImpl implements CurrentAssetService {
    @Autowired
    private CurrentAssetDAO currentAssetDAO;
    @Autowired
    private CurrentAssetDetailDAO currentAssetDetailDAO;
    @Autowired
    private CurrentAssetReqMapStruct currentAssetReqMapStruct;
    @Autowired
    private CurrentAssetResMapStruct currentAssetResMapStruct;
    @Autowired
    private CurrentAssetDetailReqMapStruct currentAssetDetailReqMapStruct;
    @Autowired
    private CurrentAssetDetailResMapStruct currentAssetDetailResMapStruct;



    // 고정자산 조회
    @Override
    public List<CurrentAssetResDTO> findAssetList() throws Exception {

        List<CurrentAssetEntity> currentAssetEntities = currentAssetDAO.findAssetList();

        return	currentAssetResMapStruct.toDto(currentAssetEntities);
    }

    // 고정자산 상세 조회
    @Override
    public HashMap<String, Object> findAssetDetail(String assetCode) throws Exception {

        HashMap<String, Object> currentAssetMap = new HashMap<>();

        CurrentAssetEntity currentAssetEntity = currentAssetDAO.findAssetDetail(assetCode);
        CurrentAssetDetailEntity currentAssetDetailEntity = currentAssetDetailDAO.findAssetDetail(assetCode);

        currentAssetMap.put("currentAssetResDTO", currentAssetResMapStruct.toDto(currentAssetEntity));
        currentAssetMap.put("currentAssetDetailResDTO", currentAssetDetailResMapStruct.toDto(currentAssetDetailEntity));

        return currentAssetMap;
    }

    // 고정자산 차량 조회
    @Override
    public List<CurrentAssetResDTO> findCarAsset() throws Exception {

        List<CurrentAssetEntity> currentAssetEntities = currentAssetDAO.findCarAsset();

        return currentAssetResMapStruct.toDto(currentAssetEntities);
    }

    // 고정자산 추가
    @Override
    public void insertAsset(CurrentAssetReqDTO currentAssetReqDTO, CurrentAssetDetailReqDTO currentAssetDetailReqDTO) throws Exception {

        CurrentAssetEntity currentAssetEntity = currentAssetReqMapStruct.toEntity(currentAssetReqDTO);
        CurrentAssetDetailEntity currentAssetDetailEntity = currentAssetDetailReqMapStruct.toEntity(currentAssetDetailReqDTO);

        currentAssetDAO.mergeAsset(currentAssetEntity);
        System.out.println("고정자산 등록완료");

        currentAssetDetailDAO.mergeAssetDetail(currentAssetDetailEntity);
        System.out.println("고정자산상세 등록완료");
    }

    // 고정자산 수정
    @Override
    public void updateAsset(CurrentAssetReqDTO currentAssetReqDTO, CurrentAssetDetailReqDTO currentAssetDetailReqDTO) throws Exception {

        CurrentAssetEntity currentAssetEntity = currentAssetReqMapStruct.toEntity(currentAssetReqDTO);
        CurrentAssetDetailEntity currentAssetDetailEntity = currentAssetDetailReqMapStruct.toEntity(currentAssetDetailReqDTO);

        currentAssetDAO.mergeAsset(currentAssetEntity);
        System.out.println("고정자산 수정완료");

        currentAssetDetailDAO.mergeAssetDetail(currentAssetDetailEntity);
        System.out.println("고정자산상세 수정완료");
    }

    // 고정자산 삭제
    @Override
    public void deleteAsset(String assetCode) throws Exception {

        currentAssetDAO.deleteAsset(assetCode);
        System.out.println("고정자산 삭제완료");

        currentAssetDetailDAO.deleteAssetDetail(assetCode);
        System.out.println("고정자산상세 삭제완료");
    }

    // 감가상각비현황 전체조회
    @Override
    public List<CurrentAssetResDTO> findDepreciationList() throws Exception {

        List<CurrentAssetEntity> currentAssetEntities =  currentAssetDAO.findDepreciationList();

        return currentAssetResMapStruct.toDto(currentAssetEntities);
    }

    // 감가상각비현황 선택조회
    @Override
    public List<CurrentAssetResDTO> selectDepreciationList(String accountCode) throws Exception {

        List<CurrentAssetEntity> currentAssetEntities =  currentAssetDAO.selectDepreciationList(accountCode);

        return currentAssetResMapStruct.toDto(currentAssetEntities);
    }

    // 고정자산관리대장 조회
    @Override
    public List<CurrentAssetResDTO> findCurrentAssetLedgerList() throws Exception {

        List<CurrentAssetEntity> currentAssetLedgerEntities =  currentAssetDAO.findCurrentAssetLedgerList();

        return currentAssetResMapStruct.toDto(currentAssetLedgerEntities);
    }
}

