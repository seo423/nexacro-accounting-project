package kr.co.seoulit.erp.account.operate.system.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nexacro.java.xapi.data.PlatformData;

import kr.co.seoulit.erp.account.sys.common.dao.DatasetToBeanMapper;
import kr.co.seoulit.erp.account.operate.system.service.SystemService;

import kr.co.seoulit.erp.account.operate.system.to.AuthorityEmpBean;
import kr.co.seoulit.erp.account.operate.system.entity.AuthorityMenuEntity;

@RestController
@RequestMapping("/acc/operate")
public class AuthorityController {

	private SystemService systemService;
	private DatasetToBeanMapper datasetToBeanMapper;

    @Autowired
	public AuthorityController(SystemService systemService, DatasetToBeanMapper datasetToBeanMapper) {
		this.systemService=systemService;
		this.datasetToBeanMapper = datasetToBeanMapper;
		
	}
    /* nexacro */
    @RequestMapping(value = "/loginAuthority")
    public void loginAuthority(@RequestAttribute("reqData") PlatformData reqData,
                               @RequestAttribute("resData") PlatformData resData)throws Exception{
        String empCode = reqData.getVariable("empCode").getString();
        ArrayList<AuthorityMenuEntity> authorityList = systemService.findEmpAuthorityList(empCode);
        datasetToBeanMapper.beansToDataset(resData, authorityList, AuthorityMenuEntity.class);
    }





    //권한 관련
    //관리자로 로그인 했을때 보여주기 위해서 필요
    @RequestMapping("/authorityEmpList")
    public void findAuthorityList(@RequestAttribute("reqData")PlatformData reqData,
                                  @RequestAttribute("resData")PlatformData resData)throws Exception{


        List<AuthorityEmpBean> authorityEmp = systemService.findEmpAuthorityList();
        datasetToBeanMapper.beansToDataset(resData,authorityEmp, AuthorityEmpBean.class);


    }


    @RequestMapping ("/authorityEmpDetailList")
    public void findAuthorityEmp(@RequestAttribute("reqData") PlatformData reqData,
                                 @RequestAttribute("resData") PlatformData resData)throws Exception{

        String empCode= reqData.getVariable("empCode").getString();
        List<AuthorityEmpBean> authorityEmp = systemService.findEmpAuthorityDetailList(empCode);
        for(AuthorityEmpBean bean: authorityEmp){
            System.out.println("사원의 권한명: " + bean.getAuthorityName());
        }
        datasetToBeanMapper.beansToDataset(resData,authorityEmp, AuthorityEmpBean.class);

    }


    @RequestMapping("/registerAuthorityEmp")
    public void registerAuthorityEmp(@RequestAttribute("reqData")PlatformData reqData,
                                     @RequestAttribute("resData")PlatformData resData)throws Exception{
        System.out.println("<<<<< data has benn arrived at registerAuthorityEmp Controller!!!");
        AuthorityEmpBean authorityEmpBean= datasetToBeanMapper.datasetToBean(reqData,AuthorityEmpBean.class);
        systemService.registerAuthorityEmp(authorityEmpBean);
        System.out.println(">>>>> data has benn inserted to DB from registerAuthorityEmp Controller!!!");

    }


    @RequestMapping("/removeAuthorityEmpDetail")
    public void removeAuthorityEmp(@RequestAttribute("reqData")PlatformData reqData,
                                   @RequestAttribute("resData")PlatformData resData)throws Exception{
        System.out.println(" <<<<<remove id data has been arrived at Controller!!!");
        String id =reqData.getVariable("id").getString();
        systemService.removeAuthorityEmpDetail(id);
        System.out.println(" >>>>>remove id data has been successfully transfer to DB from Controller!!!");
    }









    @GetMapping("/authoritygroupmodification")
    public void modifyAuthorityGroup(@RequestParam String authority,
    								 @RequestParam String deptCode) {
        
     
        	Gson gson = new Gson();
			ArrayList<AuthorityEmpBean> authorityEmpBean = gson.fromJson(authority,
					new TypeToken<ArrayList<AuthorityEmpBean>>() {
					}.getType());
        	
            	
			systemService.modifyAuthorityGroup(authorityEmpBean , deptCode);
           
 
    }
	@GetMapping("/authoritygroupcode")
    public ArrayList<AuthorityEmpBean> findAuthorityGroupCode() {
      
        	
            ArrayList<AuthorityEmpBean> findAuthorityGroupCode = systemService.findAuthorityGroupCode();
   
        return findAuthorityGroupCode;
    }

	@GetMapping("/additionauthoritygroup")
    public void addAuthorityGroup(@RequestParam String addAuthority,
			 							  @RequestParam String nextGroupCode) {
       
        	
		systemService.addAuthorityGroup(addAuthority,nextGroupCode);
             
        
    }

	@GetMapping("/authoritygroupremoval")
    public void removeAuthorityGroup(@RequestParam String groupCode) {
       
        	
		systemService.removeAuthorityGroup(groupCode);

    }
	@GetMapping("/authoritygroup")
    public ArrayList<AuthorityMenuEntity> findAuthorityGroup() {
     
            ArrayList<AuthorityMenuEntity> authorityGroup = systemService.findAuthorityGroup();
   
        return authorityGroup;
    }

	@GetMapping("/authoritymenu")
    public ArrayList<AuthorityMenuEntity> findAuthorityMenu(@RequestParam String menuName) {

            ArrayList<AuthorityMenuEntity> authorityMenu = systemService.findAuthorityMenu(menuName);

        return authorityMenu;
    }

	@GetMapping("/authoritymenumodification")
    public void modifyAuthorityMenu(@RequestParam String authority,@RequestParam String deptCode) {
        
  
        	Gson gson = new Gson();
			ArrayList<AuthorityMenuEntity> authorityMenuBean = gson.fromJson(authority,
					new TypeToken<ArrayList<AuthorityMenuEntity>>() {
					}.getType());
        	
            	
			systemService.modifyAuthorityMenu(authorityMenuBean , deptCode);
       
    }
}
