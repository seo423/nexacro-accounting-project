package kr.co.seoulit.erp.account.operate.vehicle.controller;

import com.nexacro.java.xapi.data.PlatformData;
import kr.co.seoulit.erp.account.operate.vehicle.service.VehicleService;
import kr.co.seoulit.erp.account.operate.vehicle.to.*;
import kr.co.seoulit.erp.account.sys.common.dao.DatasetToBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/acc/operate")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private DatasetToBeanMapper datasetToBeanMapper;

    // 업무용차량 전체조회
    @RequestMapping("/findVehicleList")
    public void findVehicleList(@RequestAttribute("reqData") PlatformData reqData,
                                @RequestAttribute("resData") PlatformData resData) throws Exception {

        System.out.println("업무용차량 전체조회 Rest API");
        List<VehicleResDTO> vehicleList = vehicleService.findVehicleList();
        datasetToBeanMapper.beansToDataset(resData, vehicleList, VehicleResDTO.class);
    }

    // 업무용차량 한개조회
    @RequestMapping("/findVehicle")
    public void findVehicle(@RequestAttribute("reqData") PlatformData reqData,
                            @RequestAttribute("resData") PlatformData resData) throws Exception {

        String vehicleCode = reqData.getVariable("vehicleCode").getString();
        System.out.println("업무용차량 : " + vehicleCode + " 조회 Rest API");
        VehicleResDTO vehicleDTO = vehicleService.findVehicle(vehicleCode);
        datasetToBeanMapper.beanToDataset(resData, vehicleDTO, VehicleResDTO.class);
    }

    // 업무용차량 상세조회
    @RequestMapping("/findVehicleDetail")
    public void findVehicleDetail(@RequestAttribute("reqData") PlatformData reqData,
                                  @RequestAttribute("resData") PlatformData resData) throws Exception {

        String vehicleCode = reqData.getVariable("vehicleCode").getString();
        System.out.println("업무용차량 : " + vehicleCode + " 상세조회 Rest API");
        VehicleDetailResDTO vehicleDetailResDTO = vehicleService.findVehicleDetail(vehicleCode);
        datasetToBeanMapper.beanToDataset(resData, vehicleDetailResDTO, VehicleDetailResDTO.class);
    }

    // 업무용차량 추가
    @RequestMapping("/insertVehicle")
    public void insertVehicle(@RequestAttribute("reqData") PlatformData reqData,
                              @RequestAttribute("resData") PlatformData resData) throws Exception {

        VehicleReqDTO vehicleReqDTO = datasetToBeanMapper.datasetToBean(reqData, VehicleReqDTO.class);
        VehicleDetailReqDTO vehicleDetailReqDTO = datasetToBeanMapper.datasetToBean(reqData, VehicleDetailReqDTO.class);
        System.out.println("업무용차량 추가 Rest API " + vehicleReqDTO);
        System.out.println("업무용차량상세 추가 Rest API " + vehicleDetailReqDTO);

        vehicleService.insertVehicle(vehicleReqDTO, vehicleDetailReqDTO);
    }

    // 업무용차량 수정
    @RequestMapping("/updateVehicle")
    public void updateVehicle(@RequestAttribute("reqData") PlatformData reqData,
                              @RequestAttribute("resData") PlatformData resData) throws Exception {

        VehicleReqDTO vehicleReqDTO = datasetToBeanMapper.datasetToBean(reqData, VehicleReqDTO.class);
        VehicleDetailReqDTO vehicleDetailReqDTO = datasetToBeanMapper.datasetToBean(reqData, VehicleDetailReqDTO.class);
        System.out.println("업무용차량 수정 Rest API " + vehicleReqDTO);
        System.out.println("업무용차량상세 수정 Rest API " + vehicleDetailReqDTO);

        vehicleService.updateVehicle(vehicleReqDTO, vehicleDetailReqDTO);
    }

    // 업무용차량 삭제
    @RequestMapping("/deleteVehicle")
    public void deleteVehicle(@RequestAttribute("reqData") PlatformData reqData,
                              @RequestAttribute("resData") PlatformData resData) throws Exception {

        String vehicleCode = reqData.getVariable("vehicleCode").getString();
        System.out.println("업무용차량 : " + vehicleCode + " 삭제 Rest API");

        vehicleService.deleteVehicle(vehicleCode);
    }

    // 업무용차량 운행기록부 상세조회
    @RequestMapping("/findVehicleLogbookList")
    public void findVehicleLogbookList(@RequestAttribute("reqData") PlatformData reqData,
                                       @RequestAttribute("resData") PlatformData resData) throws Exception {

        String vehicleCode = reqData.getVariable("vehicleCode").getString();
        System.out.println("업무용차량 : " + vehicleCode + " 운행기록부 상세조회 Rest API");
        List<VehicleLogbookResDTO> vehicleLogbookList = vehicleService.findVehicleLogbookList(vehicleCode);
        datasetToBeanMapper.beansToDataset(resData, vehicleLogbookList, VehicleLogbookResDTO.class);
    }

    // 업무용차량 운행기록 추가
    @RequestMapping("/insertVehicleLogbook")
    public void insertVehicleLogbook(@RequestAttribute("reqData") PlatformData reqData,
                                       @RequestAttribute("resData") PlatformData resData) throws Exception {

        VehicleLogbookReqDTO vehicleLogbookReqDTO = datasetToBeanMapper.datasetToBean(reqData, VehicleLogbookReqDTO.class);
        System.out.println("업무용차량 운행기록 추가 Rest API" + vehicleLogbookReqDTO);

        vehicleService.insertVehicleLogbook(vehicleLogbookReqDTO);
    }

    // 업무용차량 운행기록 삭제
    @RequestMapping("/deleteVehicleLogbook")
    public void deleteVehicleLogbook(@RequestAttribute("reqData") PlatformData reqData,
                                       @RequestAttribute("resData") PlatformData resData) throws Exception {

        String vehicleCode = reqData.getVariable("vehicleCode").getString();
        String useDate = reqData.getVariable("selectDate").getString();
        String startTime = reqData.getVariable("selectTime").getString();
        System.out.println("업무용차량 : " + vehicleCode + "운행기록 : " + useDate + " " + startTime + "삭제 Rest API");

        HashMap<String, String> vehicleLogbookReqMap = new HashMap<>();

        vehicleLogbookReqMap.put("vehicleCode", vehicleCode);
        vehicleLogbookReqMap.put("useDate", useDate);
        vehicleLogbookReqMap.put("startTime", startTime);

        vehicleService.deleteVehicleLogbook(vehicleLogbookReqMap);
    }



}
