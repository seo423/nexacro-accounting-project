package kr.co.seoulit.erp.account.operate.humanresource.to;

import kr.co.seoulit.erp.account.sys.base.to.BaseBean;
import kr.co.seoulit.erp.account.sys.common.annotation.Dataset;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;

@EqualsAndHashCode(callSuper = false)
@Dataset(name = "gds_emp")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeReqDTO extends BaseBean {

    @Id
    @Column(name = "EMP_CODE", columnDefinition = "nvarchar2")
    private String empCode;
    @Column(name = "EMP_NAME", columnDefinition = "nvarchar2")
    private String empName;
    private String userPw;
    private String positionName;
    private String email;
    private String deptName;
    private String socialSecurityNumber;
    private String BasicAddress;
    private String userOrNot;
    private String gender;
    private String phoneNumber;
    private String birthDate;
    private String image;


    @Column(name = "COMPANY_CODE", columnDefinition = "nvarchar2")
    private String companyCode;
    private String workplaceCode;
    private String deptCode;
    private String positionCode;
    private String ZipCode;
    private String levelOfEducation;
    private String DetailAddress;
}