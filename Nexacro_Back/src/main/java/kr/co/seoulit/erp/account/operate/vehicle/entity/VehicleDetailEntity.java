package kr.co.seoulit.erp.account.operate.vehicle.entity;

import kr.co.seoulit.erp.account.sys.common.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name="VEHICLE_DETAIL")
@Dataset(name="ds_vehicleDetail")
@Data
public class VehicleDetailEntity {

    @Id
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
