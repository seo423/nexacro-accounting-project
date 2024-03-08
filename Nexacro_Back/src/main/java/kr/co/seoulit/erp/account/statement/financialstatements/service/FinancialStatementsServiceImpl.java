package kr.co.seoulit.erp.account.statement.financialstatements.service;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.erp.account.statement.financialstatements.dao.FinancialPositionMapper;
import kr.co.seoulit.erp.account.statement.financialstatements.dao.IncomeStatementMapper;
import kr.co.seoulit.erp.account.statement.financialstatements.to.IncomeStatementBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
public class FinancialStatementsServiceImpl implements FinancialStatementsService{
    
	@Autowired
    private FinancialPositionMapper financialPositionDAO;
	@Autowired
    private IncomeStatementMapper incomeStatementDAO;

    @Override
    public HashMap<String, Object> findFinancialPosition(HashMap<String,Object> params) {
        try{
            HashMap<String, Object>  financialPosition = financialPositionDAO.selectcallFinancialPosition(params);
            return financialPosition;
        }catch(Exception e){
            log.error("에러발생: " + e.getMessage());
            return null;
        }

    }

    
    @Override
    public ArrayList<IncomeStatementBean> findIncomeStatement(HashMap<String, Object> param) {
            log.debug("findIncomeStatement service까지 옴.");
        try {
            incomeStatementDAO.selectcallIncomeStatement(param);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
            ArrayList<IncomeStatementBean> bean = (ArrayList<IncomeStatementBean>) param.get("result");
        return bean;
    }
}
