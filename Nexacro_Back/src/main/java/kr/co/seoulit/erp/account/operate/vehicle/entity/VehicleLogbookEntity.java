package kr.co.seoulit.erp.account.operate.vehicle.entity;

import kr.co.seoulit.erp.account.sys.common.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name="VEHICLE_LOGBOOK")
@Dataset(name="ds_vehicleLogbook")
@Data
public class VehicleLogbookEntity {

    @Id
    private String vehicleCode;
    private String useDate;
    private String startTime;
    private String empCode;
    private String empName;
    private String deptCode;
    private String deptName;
    private String distance;
    private String businessDistance;
    private String personalDistance;
    private String beforeOdometer;
    private String afterOdometer;
    private String notes;
}