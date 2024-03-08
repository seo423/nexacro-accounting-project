package kr.co.seoulit.erp.account.posting.ledger.dto;

import kr.co.seoulit.erp.account.sys.common.annotation.Dataset;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Dataset(name = "ds_asset")
@AllArgsConstructor
@NoArgsConstructor

public class AssetResDto {

    //assetNumber : nexacro에서 구현

    private String assetName;

    private String assetCode;


}