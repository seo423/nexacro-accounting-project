package kr.co.seoulit.erp.account.operate.entity;

import javax.persistence.*;

import kr.co.seoulit.erp.account.sys.base.to.BaseBean;
import kr.co.seoulit.erp.account.sys.common.annotation.Dataset;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Dataset(name = "gds_emp")
@Table(name = "EMPLOYEE")
@Getter@Setter@ToString
public class EmployeeEntity extends BaseBean {

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
    private byte[] image;


    @Column(name = "COMPANY_CODE", columnDefinition = "nvarchar2")
    private String companyCode;
    private String workplaceCode;
    private String deptCode;
    private String positionCode;
    private String ZipCode;
    private String levelOfEducation;
    private String DetailAddress;


}