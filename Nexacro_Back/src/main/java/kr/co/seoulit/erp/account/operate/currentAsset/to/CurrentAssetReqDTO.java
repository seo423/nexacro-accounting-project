package kr.co.seoulit.erp.account.operate.currentAsset.to;

import kr.co.seoulit.erp.account.sys.base.to.BaseBean;
import kr.co.seoulit.erp.account.sys.common.annotation.Dataset;
import lombok.*;

import javax.persistence.Transient;


@EqualsAndHashCode(callSuper = false)
@Dataset(name="ds_asset")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CurrentAssetReqDTO extends BaseBean {

    private String accountName;
    private String assetCode;
    private String accountCode;
    private String assetName;
    private String progress;
    private String finalizeStatus;

    @Transient
    private String acquisitionCost;             // 취득원가
    @Transient
    private String amortizationWay;             // 상각방법
    @Transient
    private String department;                  // 관리부서
    @Transient
    private String depreciation;                // 전기말상각누계액
    @Transient
    private String bookValue;                   // 전기말장부가액
    @Transient
    private String usefulLife;                  // 내용연수
    @Transient
    private String amortizationFinalYear;       // 상각완료년도
    @Transient
    private String acquisitionQuantity;         // 취득수량
    @Transient
    private String changeQuantity;              // 증감수량
    @Transient
    private String remainQuantity;              // 잔존수량
    @Transient
    private String amortizationRate;            // 상각률
    @Transient
    private String month;                       // 월수
    @Transient
    private String normalAmortization;          // 일반상각비
    @Transient
    private String accumulatedAmortization;     // 당기말상각누계액
    @Transient
    private String bookValueEnd;                // 당기말장부가액
}
