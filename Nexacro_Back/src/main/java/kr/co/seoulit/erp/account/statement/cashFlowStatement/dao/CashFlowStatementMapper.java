package kr.co.seoulit.erp.account.statement.cashFlowStatement.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface CashFlowStatementMapper {

    //현금흐름표 조회
    public HashMap<String, Object> selectCashFlowStatement(HashMap<String,Object> params);
}
