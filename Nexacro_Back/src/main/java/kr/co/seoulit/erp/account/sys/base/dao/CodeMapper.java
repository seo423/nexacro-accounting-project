package kr.co.seoulit.erp.account.sys.base.dao;

import java.util.ArrayList;

import kr.co.seoulit.erp.account.sys.base.to.CodeBean;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CodeMapper {

    public ArrayList<CodeBean> selectCodeList();

    public void insertCode(CodeBean codeBean);

    public void updateCode(CodeBean codeBean);

    public void deleteCode(String Code);

}
