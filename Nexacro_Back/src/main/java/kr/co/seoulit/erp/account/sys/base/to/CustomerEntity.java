package kr.co.seoulit.erp.account.sys.base.to;

import kr.co.seoulit.erp.account.sys.common.annotation.Dataset;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Dataset(name = "gds_customer")
@Table(name = "CUSTOMER")
@Getter @Setter
public class CustomerEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String customerCode;

    private String customerName;
    private String businessLicenseNumber;

    @Column(columnDefinition = "nvarchar2")
    private String customerType;

    @Column(columnDefinition = "nvarchar2")
    private String customerBusinessConditions;

    private String accountNumber;
    private String cardNumber;
    private String cardOpenPlace;
}
