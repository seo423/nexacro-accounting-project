package kr.co.seoulit.erp.account.operate.currentAsset.entity;

import kr.co.seoulit.erp.account.sys.common.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name="CURRENT_ASSET_DETAIL")
@Dataset(name="ds_assetDetail")
@Data
public class CurrentAssetDetailEntity {

    @Id
    private String assetCode;                   // 자산코드
    private String acquisitionCost;             // 취득원가
    private String amortizationWay;             // 상각방법
    private String department;                  // 관리부서
    private String depreciation;                // 전기말상각누계액
    private String bookValue;                   // 전기말장부가액
    private String usefulLife;                  // 내용연수
    private String amortizationFinalYear;       // 상각완료년도
    private String acquisitionQuantity;         // 취득수량
    private String changeQuantity;              // 증감수량
    private String remainQuantity;              // 잔존수량
    private String amortizationRate;            // 상각률
    private String month;                       // 월수
    private String normalAmortization;          // 일반상각비
    private String accumulatedAmortization;     // 당기말상각누계액
    private String bookValueEnd;                // 당기말장부가액


}
