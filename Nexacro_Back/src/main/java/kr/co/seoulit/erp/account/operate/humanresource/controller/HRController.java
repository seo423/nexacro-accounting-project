package kr.co.seoulit.erp.account.operate.humanresource.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.erp.account.operate.humanresource.to.EmployeeReqDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.nexacro.java.xapi.data.PlatformData;

import kr.co.seoulit.erp.account.operate.humanresource.service.HumanResourceService;

import kr.co.seoulit.erp.account.operate.humanresource.to.DepartmentBean;
import kr.co.seoulit.erp.account.operate.entity.EmployeeEntity;
import kr.co.seoulit.erp.account.sys.common.dao.DatasetToBeanMapper;

@Slf4j
@RestController
@RequestMapping("/acc/operate")
public class HRController {

    @Autowired
    private HumanResourceService humanResourceService;
    @Autowired
    private DatasetToBeanMapper datasetToBeanMapper;

    ModelAndView mav;
    ModelMap map = new ModelMap();

    //사원정보를 등록한다.
  @RequestMapping("/registerEmp")
  public void registerEmployee(@RequestAttribute("reqData")PlatformData reqData,
                               @RequestAttribute("resData")PlatformData resData)throws Exception{
         log.debug("request has arrived at registerEmployee");
         EmployeeEntity employeeEntity= datasetToBeanMapper.datasetToBean(reqData,EmployeeEntity.class);
         humanResourceService.registerEmployee(employeeEntity);

  }

    //전체 사원의 정보를 가지고 온다.
  @RequestMapping("/findEmpList" )
  public ArrayList<EmployeeEntity> findEmployeeList(@RequestAttribute("reqData") PlatformData reqData,
                                                    @RequestAttribute("resData") PlatformData resData) throws Exception{
      log.debug("request has arrived at findEmployeeList");
      ArrayList<EmployeeEntity> empList= humanResourceService.findEmployeeList();
      datasetToBeanMapper.beansToDataset(resData, empList, EmployeeEntity.class);
      return null;
  }

    @RequestMapping("/modifyEmp")
    public void modifyEmployee(@RequestAttribute("reqData")PlatformData reqData,
                               @RequestAttribute("resData")PlatformData resData)throws Exception{

        EmployeeReqDTO employeeReqDTO = datasetToBeanMapper.datasetToBean(reqData, EmployeeReqDTO.class);
        // 파일 경로에서 이미지 파일을 읽어서 바이너리 데이터로 변환
        byte[] imageData = getImageData(employeeReqDTO.getImage());

        humanResourceService.modifyEmployee(employeeReqDTO, imageData);

    }

    // 이미지 파일을 읽어서 바이너리 데이터로 변환하는 메서드
    private byte[] getImageData(String imagePath) throws Exception {
        String filePath = imagePath.substring("file://".length()); // "file://" 접두사 제거
        File file = new File(filePath);
        try (InputStream inputStream = new FileInputStream(file)) {
            byte[] data = new byte[(int) file.length()];
            inputStream.read(data);
            return data;
        }
    }


  @RequestMapping("/removeEmp")
  public void removeEmployee(@RequestAttribute("reqData")PlatformData reqData,
                             @RequestAttribute("resData")PlatformData resData)throws Exception{
        log.debug("request has arrived at removeEmployee");
        String empCode=reqData.getVariable("empCode").getString();
        humanResourceService.removeEmployee(empCode);

  }















                                        // 아래의 코드들은 운영관리에서 아직 사용하지 않는 코드들



    @RequestMapping(value="/saveEmpImg",method={RequestMethod.GET, RequestMethod.POST})
    public void saveEmpImg(@RequestAttribute("reqData") PlatformData reqData,
                           @RequestAttribute("resData") PlatformData resData) throws Exception{

        String image = reqData.getVariable("image").getString();
        String empCode = reqData.getVariable("empCode").getString();
        System.out.println("image    :"+image);
        System.out.println("empCode    :"+empCode);
        HashMap<String, String> map = new HashMap<>();
        map.put("image", image);
        map.put("empCode", empCode);
        humanResourceService.saveEmpImg(map);


    }





    @GetMapping("/deptlist")
    public ArrayList<DepartmentBean> findDeptList(@RequestAttribute("reqData") PlatformData reqData,
                                                  @RequestAttribute("resData") PlatformData resData) throws Exception {

            ArrayList<DepartmentBean> deptList = humanResourceService.findDeptList();
            datasetToBeanMapper.beansToDataset(resData, deptList, DepartmentBean.class);

        return null;
    }

    @RequestMapping("/selectworkplaceCode")
    public ArrayList<DepartmentBean> selectworkplaceCode(@RequestAttribute("reqData") PlatformData reqData,
                                                         @RequestAttribute("resData") PlatformData resData) throws Exception{

            ArrayList<DepartmentBean> workplaceList = humanResourceService.selectworkplaceCode();
            datasetToBeanMapper.beansToDataset(resData, workplaceList, DepartmentBean.class);

        return null;
    }
    @RequestMapping("/selectdeptCode")
    public ArrayList<DepartmentBean> selectdeptCode(@RequestAttribute("reqData") PlatformData reqData,
    		                                        @RequestAttribute("resData") PlatformData resData) throws Exception{

    	ArrayList<DepartmentBean> deptList = humanResourceService.selectdeptCode();
    	datasetToBeanMapper.beansToDataset(resData, deptList, DepartmentBean.class);

    	return null;
        }



}
