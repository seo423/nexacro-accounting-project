package kr.co.seoulit.erp.account.operate.currentAsset.repository;

import kr.co.seoulit.erp.account.operate.currentAsset.entity.CurrentAssetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface CurrentAssetRepository extends JpaRepository<CurrentAssetEntity, Integer> {

    // 게시판 조회
    @Query("SELECT currentAsset FROM CurrentAssetEntity currentAsset")
    ArrayList<CurrentAssetEntity> findAssetList();

    // 게시판 상세 조회
    @Query("SELECT currentAsset FROM CurrentAssetEntity currentAsset WHERE currentAsset.assetCode = :assetCode")
    CurrentAssetEntity findAssetDetail(@Param("assetCode") String assetCode);

}
