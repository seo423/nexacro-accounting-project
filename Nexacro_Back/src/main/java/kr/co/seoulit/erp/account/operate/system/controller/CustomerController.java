package kr.co.seoulit.erp.account.operate.system.controller;

import com.nexacro.java.xapi.data.PlatformData;
import kr.co.seoulit.erp.account.operate.system.entity.Customer;
import kr.co.seoulit.erp.account.operate.system.service.CustomerService;
import kr.co.seoulit.erp.account.operate.system.to.CustomerUpdateRequest;
import kr.co.seoulit.erp.account.sys.common.dao.DatasetToBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/acc/operate")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private DatasetToBeanMapper datasetToBeanMapper;

    ModelAndView mav;
    ModelMap map = new ModelMap();

    /*@RequestMapping("/registerCustomer")
    public void registerCustomer(@RequestAttribute("reqData")PlatformData reqData,
                                 @RequestAttribute("resData")PlatformData resData) throws Exception {
        System.out.println("reqData = " + reqData.toString());
//      CustomerUpdateRequest customerUpdateRequest = datasetBeanMapper.datasetToBean(reqData, CustomerUpdateRequest.class);
        List<CustomerUpdateRequest> customerUpdateRequests = datasetBeanMapper.datasetToBeans(reqData, CustomerUpdateRequest.class);
        customerService.registerCustomers(customerUpdateRequests);
    }*/


                                    // 거래처 CRUD는 CustomerMRepository를 이용했습니다.

    @RequestMapping("/registerCustomer")
    public void registerCustomer(@RequestAttribute("reqData")PlatformData reqData,
                                 @RequestAttribute("resData")PlatformData resData) throws Exception {
        CustomerUpdateRequest customerUpdateRequest = datasetToBeanMapper.datasetToBean(reqData, CustomerUpdateRequest.class);
        customerService.registerCustomer(customerUpdateRequest);
    }


    @RequestMapping("/findCustomerList")
    public void findAllCustomerList(@RequestAttribute("reqData") PlatformData reqData,
                                    @RequestAttribute("resData") PlatformData resData) throws Exception {
        System.out.println("@@@@customerList@@@@");
        List<Customer> customerList = customerService.findCustomerList();
        System.out.println("customerList = " + customerList);
        datasetToBeanMapper.beansToDataset(resData, customerList, Customer.class);
    }


    @RequestMapping("/updateCustomer")
    public void updateCustomer(@RequestAttribute("reqData")PlatformData reqData,
                               @RequestAttribute("resData")PlatformData resData) throws Exception {
        CustomerUpdateRequest customerUpdateRequest = datasetToBeanMapper.datasetToBean(reqData, CustomerUpdateRequest.class);
        customerService.updateCustomer(customerUpdateRequest);

    }

    @RequestMapping("/removeCustomer")
    public void removeCustomer(@RequestAttribute("reqData") PlatformData reqData,
                               @RequestAttribute("resData") PlatformData resData) throws Exception {

        String customerCode = reqData.getVariable("customerCode").getString();

        customerService.removeCustomer(customerCode);
    }




}
