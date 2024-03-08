package kr.co.seoulit.erp.account.sys.base.dao;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.erp.account.sys.base.to.DetailCodeEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DetailCodeMapper {

    ArrayList<DetailCodeEntity> selectDetailCodeList(HashMap<String, String> param);

    void insertDetailCode(DetailCodeEntity codeDetailBean);

    void updateDetailCode(DetailCodeEntity codeDetailBean);

    void deleteDetailCode(String codeNo);

}
