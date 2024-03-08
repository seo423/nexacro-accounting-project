package kr.co.seoulit.erp.account.statement.monthCostStatement.dao;

import kr.co.seoulit.erp.account.statement.monthCostStatement.to.MonthCostStatementBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface MonthCostStatementMapper {
    //기간별원가명세서 조회
    public ArrayList<MonthCostStatementBean> selectMonthCostStatement(HashMap<String,Object> params);

}