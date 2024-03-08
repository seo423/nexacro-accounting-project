package kr.co.seoulit.erp.account.statement.trialbalance.controller;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.erp.account.statement.financialstatements.to.FinancialPositionBean;
import kr.co.seoulit.erp.account.sys.base.service.BaseService;
import kr.co.seoulit.erp.account.sys.common.dao.DatasetToBeanMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexacro.java.xapi.data.PlatformData;

import kr.co.seoulit.erp.account.statement.trialbalance.service.TrialBalanceService;
import kr.co.seoulit.erp.account.statement.trialbalance.to.TotalTrialBalanceBean;

@Slf4j
@RestController
@RequestMapping("/acc/statement")
@AllArgsConstructor
public class TotalTrialBalanceController {

	private final TrialBalanceService trialBalanceService;

	private final DatasetToBeanMapper datasetToBeanMapper;


	@RequestMapping("/totaltrialbalance")
	public void findTotalTrialBalance(@RequestAttribute("reqData") PlatformData reqData,
									  @RequestAttribute("resData") PlatformData resData) throws Exception {

		log.debug("합계잔액시산표 controller");
		String accountPeriodNo = reqData.getVariable("period").getString();
		String callResult = reqData.getVariable("callresult").getString();

		System.out.println(accountPeriodNo);
		System.out.println(callResult);

		//HashMap<String, Object> params = new HashMap<>();
		//params.put("accountPeriodNo", accountPeriodNo);
		//params.put("callResult", callResult);
		try{
			ArrayList<TotalTrialBalanceBean> bean = trialBalanceService.findTotalTrialBalance(accountPeriodNo);
			datasetToBeanMapper.beansToDataset(resData, bean, TotalTrialBalanceBean.class);

			for(TotalTrialBalanceBean bean1: bean) {
				System.out.println("차변합계: " + bean1.getDebitsSum());
				System.out.println("대변합계: " + bean1.getCreditsSum());
			}
		}catch (Exception e){
			System.out.println("합계잔액시산표를 받아오지 못했음.");
			System.out.println(e.getMessage());
		}
		//TotalTrialBalanceBean bean=(TotalTrialBalanceBean)trialBalanceService.findTotalTrialBalance(params).get("totalTrialBalanceResult")
	}
	

}
