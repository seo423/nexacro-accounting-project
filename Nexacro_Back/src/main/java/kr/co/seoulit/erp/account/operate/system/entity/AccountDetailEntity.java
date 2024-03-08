package kr.co.seoulit.erp.account.operate.system.entity;

import kr.co.seoulit.erp.account.sys.base.to.BaseBean;
import kr.co.seoulit.erp.account.sys.common.annotation.Dataset;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "ACCOUNT")
@Dataset(name = "gds_account_detail")
@Getter@Setter @ToString
public class AccountDetailEntity extends BaseBean {

    @Id
    @Column(name = "ACCOUNT_INNER_CODE")
    private String accountInnerCode;
    @Column(name = "PARENT_ACCOUNT_INNER_CODE")
    private String parentAccountInnerCode;
    @Column(name = "ACCOUNT_CODE")
    private String accountCode;
    @Column(name="ACCOUNT_CHARACTER",columnDefinition ="nvarchar2" )
    private String accountCharacter;
    @Column(name="GROUP_CODE")
    private String groupCode;
    @Column(name = "ACCOUNT_NAME", columnDefinition = "nvarchar2")
    private String accountName;


    public AccountDetailEntity(){}

}
