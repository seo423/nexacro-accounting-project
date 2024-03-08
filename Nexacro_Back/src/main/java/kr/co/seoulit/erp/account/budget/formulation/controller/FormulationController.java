package kr.co.seoulit.erp.account.budget.formulation.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.erp.account.budget.formulation.to.*;
import kr.co.seoulit.erp.account.sys.common.util.BeanCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nexacro.java.xapi.data.PlatformData;

import kr.co.seoulit.erp.account.sys.common.dao.DatasetToBeanMapper;

import kr.co.seoulit.erp.account.budget.formulation.service.FormulationService;

import net.sf.json.JSONObject;

@RestController
@RequestMapping("/acc/budget")
public class FormulationController{

	@Autowired
	private FormulationService formulationService;
	@Autowired
	private DatasetToBeanMapper datasetToBeanMapper;

	BeanCreator beanCreator  = BeanCreator.getInstance();

    @GetMapping("/budget")
	 public BudgetBean findBudget(@RequestParam String budgetObj) {

		 JSONObject budgetJsonObj = JSONObject.fromObject(budgetObj); //예산
		 BudgetBean budgetBean =beanCreator.create(budgetJsonObj, BudgetBean.class);


	        return formulationService.findBudget(budgetBean);
	 }

    @RequestMapping("/batch")
    public void batchBudget(@RequestAttribute("reqData") PlatformData reqData,
							@RequestAttribute("resData")PlatformData resData) throws Exception {

		System.out.println(" batatchcsc");

		String deptCode = reqData.getVariable("deptCode").getString();
		String workplaceCode=reqData.getVariable("workplaceCode").getString();
		String accountPeriodNo=reqData.getVariable("accountPeriodNo").getString();
		String budgetingCode=reqData.getVariable("budgetingCode").getString();
		String accountInnerCode=reqData.getVariable("accountInnerCode").getString();

		BudgetBean obj = datasetToBeanMapper.datasetToBean(reqData, BudgetBean.class);
		obj.setDeptCode(deptCode);
		obj.setWorkplaceCode(workplaceCode);
		obj.setAccountPeriodNo(accountPeriodNo);
		obj.setBudgetingCode(budgetingCode);
		obj.setAccountInnerCode(accountInnerCode);

		formulationService.batchBudgetCode(obj);

    }

    @RequestMapping("/formationbudgetlist")
    public void formationBudget(@RequestAttribute("reqData") PlatformData reqData,
    		@RequestAttribute("resData")PlatformData resData) throws Exception {
    	String budgetCode=reqData.getVariable("budgetCode").getString();
 		 String budgetingCode=reqData.getVariable("budgetingCode").getString();

 		 HashMap<String, String> map=new HashMap<String, String>();
    	map.put("budgetCode", budgetCode);
    	map.put("budgetingCode", budgetingCode);
 		  ArrayList<BudgetBean> bean =  formulationService.formationBudget(map);
   		  datasetToBeanMapper.beansToDataset(resData, bean, BudgetBean.class);
    }

    @RequestMapping("/budgetlist")
	 public void findBudgetList(@RequestAttribute("reqData") PlatformData reqData,
	            @RequestAttribute("resData")PlatformData resData) throws Exception {
	      		 String budgetCode = reqData.getVariable("budgetCode").getString();
	      		 String budgetingCode=reqData.getVariable("budgetingCode").getString();

	      		 HashMap<String,String> map = new HashMap<String, String>();
	      		 map.put("budgetCode", budgetCode);
	      		 map.put("budgetingCode", budgetingCode);
	   		  ArrayList<BudgetBean> bean =  formulationService.findBudgetList(map);

	   		  datasetToBeanMapper.beansToDataset(resData, bean, BudgetBean.class);

	 }

	 // 예산 조회
	@RequestMapping("/budgetListForComp")
	public void budgetListForComp(@RequestAttribute("reqData") PlatformData reqData,
								  @RequestAttribute("resData")PlatformData resData) throws Exception {

		System.out.println("budgetListForComp");


		String deptCode = reqData.getVariable("deptCode").getString();
		String workplaceCode = reqData.getVariable("workplaceCode").getString();
		String accountPeriodNo = reqData.getVariable("accountPeriodNo").getString();
		String accountInnerCode = reqData.getVariable("accountInnerCode").getString();
		String budgetingCode = reqData.getVariable("budgetingCode").getString();

		HashMap<String, String> budgetMap = new HashMap<>();
		budgetMap.put("deptCode", deptCode);
		budgetMap.put("workplaceCode", workplaceCode);
		budgetMap.put("accountPeriodNo", accountPeriodNo);
		budgetMap.put("accountInnerCode", accountInnerCode);
		budgetMap.put("budgetingCode", budgetingCode);

		BudgetRequest result = formulationService.budgetListForComp(budgetMap);

		datasetToBeanMapper.beanToDataset(resData, result, BudgetRequest.class);
	}

	 @RequestMapping("/compBudget")
	 public void compBudget(@RequestAttribute("reqData") PlatformData reqData,
												 @RequestAttribute("resData")PlatformData resData) throws Exception {

		 String deptCode=reqData.getVariable("deptCode").getString();
		 String workplaceCode=reqData.getVariable("workplaceCode").getString();
		 String accountPeriodNo=reqData.getVariable("accountPeriodNo").getString();
		 String accountInnerCode=reqData.getVariable("accountInnerCode").getString();
		 String budgetingCode=reqData.getVariable("budgetingCode").getString();

		 BudgetRequest updateRequest = datasetToBeanMapper.datasetToBean(reqData, BudgetRequest.class);
		 updateRequest.setAccountInnerCode(accountInnerCode);
		 updateRequest.setAccountPeriodNo(accountPeriodNo);
		 updateRequest.setDeptCode(deptCode);
		 updateRequest.setWorkplaceCode(workplaceCode);
		 updateRequest.setBudgetingCode(budgetingCode);

		 formulationService.compBudget(updateRequest);


	 }

	@RequestMapping("/budgetListForRecon")
	public ArrayList<BudgetRequestForRecon> budgetListForRecon(@RequestAttribute("reqData") PlatformData reqData,
                                                               @RequestAttribute("resData")PlatformData resData) throws Exception {
		String deptCode=reqData.getVariable("deptCode").getString();
		String workplaceCode=reqData.getVariable("workplaceCode").getString();
		String accountPeriodNo=reqData.getVariable("accountPeriodNo").getString();
		String accountInnerCode=reqData.getVariable("accountInnerCode").getString();
		String budgetingCode=reqData.getVariable("budgetingCode").getString();


		BudgetRequestForRecon budgetRequestForRecon = new BudgetRequestForRecon(deptCode, workplaceCode, accountPeriodNo, accountInnerCode, budgetingCode);

		BudgetRequestForRecon result = formulationService.budgetRequestForRecon(budgetRequestForRecon);

		datasetToBeanMapper.beanToDataset(resData, result, BudgetRequestForRecon.class);

		return null;
	}

	@RequestMapping("/reconBudget")
	public void reconBudget(@RequestAttribute("reqData") PlatformData reqData,
															   @RequestAttribute("resData")PlatformData resData) throws Exception {
		String deptCode=reqData.getVariable("deptCode").getString();
		String workplaceCode=reqData.getVariable("workplaceCode").getString();
		String accountPeriodNo=reqData.getVariable("accountPeriodNo").getString();
		String accountInnerCode=reqData.getVariable("accountInnerCode").getString();
		String budgetingCode=reqData.getVariable("budgetingCode").getString();

		BudgetRequestForRecon updateRequest = datasetToBeanMapper.datasetToBean(reqData, BudgetRequestForRecon.class);
		updateRequest.setAccountInnerCode(accountInnerCode);
		updateRequest.setAccountPeriodNo(accountPeriodNo);
		updateRequest.setDeptCode(deptCode);
		updateRequest.setWorkplaceCode(workplaceCode);
		updateRequest.setBudgetingCode(budgetingCode);

		formulationService.reconBudget(updateRequest);
	}


//    @GetMapping("/budgetStatus")
//	 public Vector<BudgetStatusBean> findBudgetStatus(@RequestParam String budgetObj) {
//
//    	JSONObject budgetJsonObj = JSONObject.fromObject(budgetObj); //예산
//		 BudgetBean budgetBean =beanCreator.create(budgetJsonObj, BudgetBean.class);
//		Vector<BudgetStatusBean> beans=formulationService.findBudgetStatus(budgetBean);
//
//	        return beans;
//	 }


	@RequestMapping("/budgetStatus")
	public ArrayList<BudgetStatusBean> budgetStatus(@RequestAttribute("reqData") PlatformData reqData,
														 @RequestAttribute("resData")PlatformData resData) throws Exception {
		String deptCode=reqData.getVariable("deptCode").getString();
		String workplaceCode=reqData.getVariable("workplaceCode").getString();
		String accountPeriodNo=reqData.getVariable("accountPeriodNo").getString();

		BudgetBean budgetBean = new BudgetBean();
 		budgetBean.setDeptCode(deptCode);
 		budgetBean.setWorkplaceCode(workplaceCode);
 		budgetBean.setAccountPeriodNo(accountPeriodNo);

		ArrayList<BudgetStatusBean> result = formulationService.findBudgetStatus(budgetBean);

		datasetToBeanMapper.beansToDataset(resData, result, BudgetStatusBean.class);

		return null;
	}

	@RequestMapping("/budgetComparison")
	public ArrayList<BudgetStatusBean> budgetComparison(@RequestAttribute("reqData") PlatformData reqData,
													@RequestAttribute("resData")PlatformData resData) throws Exception {
		String deptCode=reqData.getVariable("deptCode").getString();
		String workplaceCode=reqData.getVariable("workplaceCode").getString();
		String accountPeriodNo=reqData.getVariable("accountPeriodNo").getString();
		String accountInnerCode=reqData.getVariable("accountInnerCode").getString();

		BudgetBean budgetBean = new BudgetBean();
		budgetBean.setDeptCode(deptCode);
		budgetBean.setWorkplaceCode(workplaceCode);
		budgetBean.setAccountPeriodNo(accountPeriodNo);
		budgetBean.setAccountInnerCode(accountInnerCode);

		ArrayList<BudgetComparisonBean> result = formulationService.findBudgetComparison(budgetBean);

		datasetToBeanMapper.beansToDataset(resData, result, BudgetComparisonBean.class);

		return null;
	}



	@RequestMapping(value = "/budgetappl", method = RequestMethod.POST)
	 public ArrayList<BudgetBean> findBudgetAppl(@RequestParam String budgetObj) {


		 JSONObject budgetJsonObj = JSONObject.fromObject(budgetObj); //예산
		 BudgetBean budgetBean =beanCreator.create(budgetJsonObj, BudgetBean.class);

		  return null;
	 }

}
