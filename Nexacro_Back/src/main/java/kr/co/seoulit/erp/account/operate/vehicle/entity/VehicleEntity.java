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
@Table(name="VEHICLE")
@Dataset(name="ds_vehicle")
@Data
public class VehicleEntity {

    @Id
    private String vehicleCode;
    private String vehicleNumber;
    private String vehicleType;
    private String deptCode;
    private String deptName;
    private String empCode;
    private String empName;
    private String availability;

    @Transient
    private String distance;
    @Transient
    private String businessDistance;
    @Transient
    private String businessUsageRatio;
}
