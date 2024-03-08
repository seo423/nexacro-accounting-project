package kr.co.seoulit.erp.account.operate.currentAsset.dao;

import kr.co.seoulit.erp.account.operate.currentAsset.entity.CurrentAssetEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CurrentAssetDAO {

	// 고정자산 조회
	List<CurrentAssetEntity> findAssetList() throws Exception;

	// 고정자산 상세조회
	CurrentAssetEntity findAssetDetail(String assetCode) throws Exception;

	// 고정자산 차량조회
	List<CurrentAssetEntity> findCarAsset() throws Exception;

	// 고정자산 추가 / 수정
	void mergeAsset(CurrentAssetEntity currentAssetEntity) throws Exception;

	// 고정자산 삭제
	void deleteAsset(String assetCode) throws Exception;

	// 감가상각비현황 전체조회
	List<CurrentAssetEntity> findDepreciationList() throws Exception;

	// 감가상각비현황 선택조회
	List<CurrentAssetEntity> selectDepreciationList(String accountCode) throws Exception;

	// 고정자산관리대장 조회
	List<CurrentAssetEntity> findCurrentAssetLedgerList() throws Exception;
}
