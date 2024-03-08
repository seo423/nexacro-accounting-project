package kr.co.seoulit.erp.account.statement.financialstatements.controller;

import java.util.ArrayList;
import java.util.HashMap;


import kr.co.seoulit.erp.account.statement.financialstatements.service.FinancialStatementsService;
import kr.co.seoulit.erp.account.statement.financialstatements.to.IncomeStatementBean;
import kr.co.seoulit.erp.account.sys.base.service.BaseService;
import kr.co.seoulit.erp.account.sys.common.dao.DatasetToBeanMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexacro.java.xapi.data.PlatformData;

@Slf4j
@RestController
@RequestMapping("/acc/statement")
public class IncomeStatementController  {

	@Autowired
	private FinancialStatementsService financialStatementsService;
	@Autowired
	private DatasetToBeanMapper datasetToBeanMapper;
	@Autowired
	private BaseService baseService;

	//손익계산서 조회
	@RequestMapping("/incomestatement")
    public HashMap<String, Object> handleRequestInternal(@RequestAttribute("reqData") PlatformData reqData,
														 @RequestAttribute("resData") PlatformData resData) throws Exception {
		String accountPeriodNum=reqData.getVariable("period").getString();
		String callResult=reqData.getVariable("callresult").getString();

		log.debug("accountPeriodNo: " + accountPeriodNum);
		log.debug("callResult: " + callResult);

		int accountPeriodNo = Integer.parseInt(accountPeriodNum);
		HashMap<String, Object> params = new HashMap<>();
		params.put("searchPeriodNo",accountPeriodNo);
		params.put("accountingSettlementStatus",callResult);

		ArrayList<IncomeStatementBean> bean = financialStatementsService.findIncomeStatement(params);
		for(IncomeStatementBean list: bean){
			//뒷단에서 매출원가를 구할 때 기초상품재고액 + 당기상품순매입액 - 기말상품재고액 이 공식을 사용해야 하기 때문에
			// 기말상품재고액이 마이너스로 기재되어있음. 앞단에 데이터를 뿌려줄 때에는 플러스로 표기하기.
			if(list.getAccountName().contains("기말상품재고액")){
				log.debug("account명: " + list.getAccountName());
				try {
					int income = Integer.parseInt(list.getIncome()) * -1;
					String sIncome = String.valueOf(income);
					list.setIncome(sIncome);
				}catch(Exception e){
					log.error("income의 값이 null입니다.");
				}

				try{
					int earlyIncome = Integer.parseInt(list.getEarlyIncome()) * -1;
					String sEarlyIncome = String.valueOf(earlyIncome);
					list.setEarlyIncome(sEarlyIncome);
				}catch(Exception e){
					log.error("earlyIncome의 값이 null입니다.");
				}

			}

		}


		datasetToBeanMapper.beansToDataset(resData, bean, IncomeStatementBean.class);
        return null;
    }

	@RequestMapping("/selectincomestatement")
    public HashMap<String, Object> Selectincomestatement( @RequestAttribute("reqData") PlatformData reqData,
			@RequestAttribute("resData") PlatformData resData) throws Exception {
		String date=reqData.getVariable("date").getString();
		String callResult=reqData.getVariable("callresult").getString();

		 //date로 값받아올때 ex) 20170717 이런식으로 받아와서 -> 2017-07-17 이런식으로 값을 바꿔줌
		String year = date.substring(0, 4);
		String month = date.substring(4, 6);
		String day = date.substring(5, 7);

		String ddate = year +"-"+month+"-"+day;

		String accountPeriodNo = baseService.findPeriodNo(ddate);
		HashMap<String, Object> params = new HashMap<>();
		params.put("accountPeriodNo",Integer.parseInt(accountPeriodNo));
		params.put("callResult",callResult);


		financialStatementsService.findIncomeStatement(params);

			ArrayList<IncomeStatementBean> bean = (ArrayList<IncomeStatementBean>) params.get("incomeStatement");
			  datasetToBeanMapper.beansToDataset(resData, bean, IncomeStatementBean.class);
        return null;
    }

}


