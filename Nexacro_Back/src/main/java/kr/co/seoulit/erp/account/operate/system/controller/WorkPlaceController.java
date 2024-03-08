package kr.co.seoulit.erp.account.operate.system.controller;

import java.util.ArrayList;

import kr.co.seoulit.erp.account.operate.system.service.SystemService;
import kr.co.seoulit.erp.account.operate.system.to.BusinessBean;
import kr.co.seoulit.erp.account.operate.system.to.DetailBusinessBean;
import kr.co.seoulit.erp.account.operate.system.entity.WorkplaceEntity;
import kr.co.seoulit.erp.account.sys.common.dao.DatasetToBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.nexacro.java.xapi.data.PlatformData;

import net.sf.json.JSONArray;

@RestController
@RequestMapping("/acc/operate")
public class WorkPlaceController {

    @Autowired
    private SystemService systemService;
    @Autowired
    private DatasetToBeanMapper datasetToBeanMapper;


    ModelAndView mav;
    ModelMap map = new ModelMap();

    // 업태리스트조회
    @GetMapping("/businesslist")
    public ArrayList<BusinessBean> findBusinessList() {

        ArrayList<BusinessBean> businessList = systemService.findBusinessList();

        return businessList;

    }

    @GetMapping("/detailbusiness")
    public ArrayList<DetailBusinessBean> findDetailBusiness(@RequestParam String businessCode) {

        ArrayList<DetailBusinessBean> detailBusinessList = systemService.findDetailBusiness(businessCode);

        return detailBusinessList;


    }

    @RequestMapping("/registerworkplace")
    public void registerworkPlace(@RequestAttribute("reqData") PlatformData reqData,
                                  @RequestAttribute("resData") PlatformData resData) throws Exception {
        WorkplaceEntity obj = datasetToBeanMapper.datasetToBean(reqData, WorkplaceEntity.class);
        systemService.registerWorkplace(obj);
//        JSONObject workplaceAddItemsAll = JSONObject.fromObject(workplaceAddItems);
//        WorkplaceEntity workplaceEntity = BeanCreator.getInstance().create(workplaceAddItemsAll, WorkplaceEntity.class);
//        systemService.registerWorkplace(workplaceEntity); //insert

    }

    @RequestMapping("/removeWorkplace")
    public void removeWorkplace(@RequestAttribute("reqData") PlatformData reqData,
                                @RequestAttribute("resData") PlatformData resData) throws Exception {

        String workplaceCode = reqData.getVariable("workplaceCode").getString();


        systemService.removeWorkplace(workplaceCode); //delete

    }

    @PostMapping("/workplace")
    public WorkplaceEntity findWorkplace(@RequestParam String workplaceCode) {

        WorkplaceEntity workplaceEntity = new WorkplaceEntity();

        workplaceEntity = systemService.findWorkplace(workplaceCode);

        return workplaceEntity;
    }

    @RequestMapping("/allworkplacelist")
    public void findAllWorkplaceList(@RequestAttribute("reqData") PlatformData reqData,
                                     @RequestAttribute("resData") PlatformData resData) throws Exception {
        System.out.println("@@@@WorkplaceController@@@@");
        ArrayList<WorkplaceEntity> allWorkplaceList = systemService.findAllWorkplaceList();
        System.out.println("workplaceList = " + allWorkplaceList);
        datasetToBeanMapper.beansToDataset(resData, allWorkplaceList, WorkplaceEntity.class);


    }

    @GetMapping("/approvalstatusmodification")
    public void modifyApprovalStatus(@RequestParam String status,
                                     @RequestParam String codes) {

        ArrayList<String> getCodes = new ArrayList<>();

        JSONArray jsonArray = JSONArray.fromObject(codes);
        for (Object obj : jsonArray) {
            String code = (String) obj;
            getCodes.add(code);
        }

        systemService.modifyApprovalStatus(getCodes, status);

    }

}
