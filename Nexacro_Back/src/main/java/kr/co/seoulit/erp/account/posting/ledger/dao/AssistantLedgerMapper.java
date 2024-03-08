package kr.co.seoulit.erp.account.posting.ledger.dao;

import java.util.ArrayList;

import kr.co.seoulit.erp.account.posting.ledger.entity.AssetItemEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AssistantLedgerMapper {

	public ArrayList<AssetItemEntity> selectAssetItemList(String assetCode);

}
