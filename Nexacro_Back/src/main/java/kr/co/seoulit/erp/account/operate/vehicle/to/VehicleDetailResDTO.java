package kr.co.seoulit.erp.account.operate.vehicle.to;

import kr.co.seoulit.erp.account.sys.base.to.BaseBean;
import kr.co.seoulit.erp.account.sys.common.annotation.Dataset;
import lombok.*;

@EqualsAndHashCode(callSuper = false)
@Dataset(name="ds_vehicleDetail")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDetailResDTO extends BaseBean {

    private String vehicleCode;
    private String accountCode;
    private String accountName;
    private String assetCode;
    private String assetName;
    private String acquisitionDate;
    private String disposalDate;
    private String expenseCategory;
    private String insuranceStatus;
    private String customerCode;
    private String insuranceCompany;
    private String insuranceStartPeriod;
    private String insuranceEndPeriod;
    private String leaseType;
    private String leaseStartPeriod;
    private String leaseEndPeriod;
    private String usageType;
}

