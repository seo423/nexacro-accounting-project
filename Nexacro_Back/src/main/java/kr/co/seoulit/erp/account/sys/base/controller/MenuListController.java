package kr.co.seoulit.erp.account.sys.base.controller;

import java.util.ArrayList;

import kr.co.seoulit.erp.account.sys.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexacro.java.xapi.data.PlatformData;

import kr.co.seoulit.erp.account.sys.base.to.MenuEntity;
import kr.co.seoulit.erp.account.sys.common.dao.DatasetToBeanMapper;

@RestController
@RequestMapping("/acc/base")
public class MenuListController {  // 하나의 컨트롤러에서 여러개의 요청처리 지원

    @Autowired
    private BaseService baseService;
    @Autowired
    private DatasetToBeanMapper datasetToBeanMapper;

    @RequestMapping("/findMenuList")
    public ArrayList<MenuEntity>findMenuList(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception{
    	
    	ArrayList<MenuEntity> menuList = baseService.selectAllMenuList();

        datasetToBeanMapper.beansToDataset(resData, menuList, MenuEntity.class);
        return null;
    }
    




}
