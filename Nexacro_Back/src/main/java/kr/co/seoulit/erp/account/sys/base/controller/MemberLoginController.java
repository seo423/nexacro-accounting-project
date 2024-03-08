package kr.co.seoulit.erp.account.sys.base.controller;

import kr.co.seoulit.erp.account.sys.base.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nexacro.java.xapi.data.PlatformData;
import kr.co.seoulit.erp.account.sys.common.dao.DatasetToBeanMapper;
import kr.co.seoulit.erp.account.operate.entity.EmployeeEntity;
import kr.co.seoulit.erp.account.operate.system.service.SystemService;
import kr.co.seoulit.erp.account.operate.system.entity.PeriodEntity;

import java.util.ArrayList;

@Slf4j
@Controller
@RequestMapping("/acc/base")
public class MemberLoginController {

	@Autowired
	private BaseService baseService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private DatasetToBeanMapper datasetToBeanMapper;


	@RequestMapping("/login")
	public ModelAndView handleRequestInternal( @RequestAttribute("reqData") PlatformData reqData,
			@RequestAttribute("resData") PlatformData resData) throws Exception {

		String empCode = reqData.getVariable("empCode").getString();
		String userPw = reqData.getVariable("userPw").getString();
		String today = reqData.getVariable("today").getString();
		log.debug("view 에서 넘겨 받은 값 : empCode = " + empCode + ", userPw = " + userPw + ", today = " + today);
		EmployeeEntity employeeEntity = baseService.findLoginData(empCode, userPw);
		log.debug(employeeEntity.getEmpCode());
		log.debug("BaseService에서 접근 권한을 얻어옴");
		String periodNo = baseService.findPeriodNo(today); // 회계기수를 반환함. 오늘날짜가 period기수정보 테이블에 없으면 null
		log.debug("today: " + today);
		log.debug("periodNO" + periodNo);
		log.debug("today: " + today);
		if (periodNo == null) {
			String[] str = today.split("-"); // str={"2020","02","05"}
			//System.out.println(str);
			String sdate = str[0] + "-" + "01-01";
			//System.out.println(sdate);
			String edate = str[0] + "-" + "12-31";
			//System.out.println(edate);
			baseService.registerPeriodNo(sdate, edate); // sdate=2020-01-01 sdate=2020-12-31
			periodNo = baseService.findPeriodNo(today);

		}
		ArrayList<PeriodEntity> periodNoList = systemService.findAccountPeriodList();

		datasetToBeanMapper.beanToDataset(resData, employeeEntity, EmployeeEntity.class);
		datasetToBeanMapper.beansToDataset(resData, periodNoList, PeriodEntity.class);

		return null;
	}

}