package kr.co.seoulit.erp.account.statement.financialstatements.dao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FinancialPositionMapper {
	
	public HashMap<String, Object> selectcallFinancialPosition(HashMap<String,Object> params);
}
