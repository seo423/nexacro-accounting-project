package kr.co.seoulit.erp.account.statement.costStatement.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface CostStatementMapper {

    //원가명세서 조회
    //public ArrayList<CostStatementBean> selectCostStatement(HashMap<String,Object> params);
    public HashMap<String, Object> selectCostStatement(HashMap<String,Object> params);

}
