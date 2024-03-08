package kr.co.seoulit.erp.account.statement.retainedEarningsStatement.dao;

import kr.co.seoulit.erp.account.statement.retainedEarningsStatement.to.RetainedEarningsStatementBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;

    @Mapper
    public interface RetainedEarningsStatementMapper {
        //이익잉여금처분계산서 조회
        public ArrayList<RetainedEarningsStatementBean> selectRetainedEarningsStatement(HashMap<String,Object> params);
}
