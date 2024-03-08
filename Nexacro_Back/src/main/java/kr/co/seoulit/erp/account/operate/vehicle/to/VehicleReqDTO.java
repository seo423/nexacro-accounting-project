package kr.co.seoulit.erp.account.operate.vehicle.to;

import kr.co.seoulit.erp.account.sys.base.to.BaseBean;
import kr.co.seoulit.erp.account.sys.common.annotation.Dataset;
import lombok.*;

import javax.persistence.Transient;

@EqualsAndHashCode(callSuper = false)
@Dataset(name="ds_vehicle")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class VehicleReqDTO extends BaseBean {

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

