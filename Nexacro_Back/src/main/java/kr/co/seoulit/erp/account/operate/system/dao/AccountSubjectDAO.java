package kr.co.seoulit.erp.account.operate.system.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kr.co.seoulit.erp.account.operate.system.entity.AccountDetailEntity;
import kr.co.seoulit.erp.account.operate.system.entity.AccountControlEntity;
import kr.co.seoulit.erp.account.operate.system.entity.AccountEntity;
import kr.co.seoulit.erp.account.operate.system.entity.PeriodEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountSubjectDAO {



                                             // 계정 CRUD


    void insertAccountDetail(AccountDetailEntity accountDetailEntity)throws Exception;


    List<AccountDetailEntity> forFindDuplication()throws Exception;


    //상세 계정목록 가져오기
     ArrayList<AccountDetailEntity> selectDetailAccountList(String parentAccountInnerCode)throws Exception;

    ArrayList<AccountEntity> selectParentAccountList()throws Exception;

    AccountDetailEntity selectAccountDetail(String accountInnerCode)throws Exception;

    void updateAccountDetail(HashMap<String,Object> map)throws Exception;

    void deleteAccountDetail(String accountInnerCode)throws Exception;








                                    // 운영관리에서 사용하지 않는 계정 관련 코드들


    public AccountEntity selectAccount(String accountCode);


    public void updateAccount(AccountEntity accountEntity);

    public ArrayList<AccountEntity> selectAccountListByName(String accountName);

    public ArrayList<AccountControlEntity> selectAccountControlList(String accountCode);

    public ArrayList<AccountEntity> selectDetailBudgetList(String code);

    public ArrayList<AccountEntity> selectParentBudgetList();
    public ArrayList<AccountEntity> selectAccountList();

    public ArrayList<PeriodEntity> selectAccountPeriodList();

    public ArrayList<PeriodEntity> selectPeriodList();

}
