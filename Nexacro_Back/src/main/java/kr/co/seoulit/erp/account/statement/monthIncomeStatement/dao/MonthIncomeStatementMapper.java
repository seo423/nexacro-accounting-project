package kr.co.seoulit.erp.account.statement.monthIncomeStatement.dao;

import kr.co.seoulit.erp.account.statement.monthIncomeStatement.to.MonthIncomeStatementBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface MonthIncomeStatementMapper {
    //기간별손익계산서 조회
    public ArrayList<MonthIncomeStatementBean> selectMonthIncomeStatement(HashMap<String,Object> params);

}
