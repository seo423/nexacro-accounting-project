package kr.co.seoulit.erp.account.operate.vehicle.to;

import kr.co.seoulit.erp.account.sys.base.to.BaseBean;
import kr.co.seoulit.erp.account.sys.common.annotation.Dataset;
import lombok.*;

@EqualsAndHashCode(callSuper = false)
@Dataset(name="ds_vehicleLogbook")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class VehicleLogbookResDTO extends BaseBean {

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