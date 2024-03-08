package kr.co.seoulit.erp.account.operate.vehicle.service;

import kr.co.seoulit.erp.account.operate.vehicle.dao.*;
import kr.co.seoulit.erp.account.operate.vehicle.entity.*;
import kr.co.seoulit.erp.account.operate.vehicle.mapstruct.*;
import kr.co.seoulit.erp.account.operate.vehicle.to.*;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    private VehicleDAO vehicleDAO;
    @Autowired
    private VehicleDetailDAO vehicleDetailDAO;
    @Autowired
    private VehicleLogbookDAO vehicleLogbookDAO;
    @Autowired
    private VehicleReqMapStruct vehicleReqMapStruct;
    @Autowired
    private VehicleResMapStruct vehicleResMapStruct;
    @Autowired
    private VehicleDetailReqMapStruct vehicleDetailReqMapStruct;
    @Autowired
    private VehicleDetailResMapStruct vehicleDetailResMapStruct;
    @Autowired
    private VehicleLogbookReqMapStruct vehicleLogbookReqMapStruct;
    @Autowired
    private VehicleLogbookResMapStruct vehicleLogbookResMapStruct;


    // 업무용차량 전체조회
    @Override
    public List<VehicleResDTO> findVehicleList() {

        List<VehicleEntity> vehicleEntities = vehicleDAO.findVehicleList();

        return vehicleResMapStruct.toDto(vehicleEntities);

    }

    // 업무용차량 한개조회
    @Override
    public VehicleResDTO findVehicle(String vehicleCode) {

        VehicleEntity vehicleEntity = vehicleDAO.findVehicle(vehicleCode);

        return vehicleResMapStruct.toDto(vehicleEntity);
    }

    // 업무용차량 상세조회
    @Override
    public VehicleDetailResDTO findVehicleDetail(String vehicleCode) {

        VehicleDetailEntity vehicleDetailEntity = vehicleDetailDAO.findVehicleDetail(vehicleCode);

        return vehicleDetailResMapStruct.toDto(vehicleDetailEntity);
    }

    // 업무용차량 추가
    @Override
    public void insertVehicle(VehicleReqDTO vehicleReqDTO, VehicleDetailReqDTO vehicleDetailReqDTO) {

        VehicleEntity vehicleEntity = vehicleReqMapStruct.toEntity(vehicleReqDTO);
        VehicleDetailEntity vehicleDetailEntity = vehicleDetailReqMapStruct.toEntity(vehicleDetailReqDTO);

        vehicleDAO.mergeVehicle(vehicleEntity);
        vehicleDetailDAO.mergeVehicleDetail(vehicleDetailEntity);
    }

    // 업무용차량 수정
    @Override
    public void updateVehicle(VehicleReqDTO vehicleReqDTO, VehicleDetailReqDTO vehicleDetailReqDTO) {

        VehicleEntity vehicleEntity = vehicleReqMapStruct.toEntity(vehicleReqDTO);
        VehicleDetailEntity vehicleDetailEntity = vehicleDetailReqMapStruct.toEntity(vehicleDetailReqDTO);

        vehicleDAO.mergeVehicle(vehicleEntity);
        vehicleDetailDAO.mergeVehicleDetail(vehicleDetailEntity);
    }

    // 업무용차량 삭제
    @Override
    public void deleteVehicle(String vehicleCode) {

        vehicleLogbookDAO.deleteVehicleLogbookList(vehicleCode);
        vehicleDetailDAO.deleteVehicleDetail(vehicleCode);
        vehicleDAO.deleteVehicle(vehicleCode);
    }

    // 업무용차량 운행기록부 상세조회
    @Override
    public List<VehicleLogbookResDTO> findVehicleLogbookList(String vehicleCode) {

        List<VehicleLogbookEntity> vehicleLogbookEntities = vehicleLogbookDAO.findVehicleLogbookList(vehicleCode);

        return vehicleLogbookResMapStruct.toDto(vehicleLogbookEntities);
    }

    // 업무용차량 운행기록 추가
    @Override
    public void insertVehicleLogbook(VehicleLogbookReqDTO vehicleLogbookReqDTO) {

        VehicleLogbookEntity vehicleLogbookEntity = vehicleLogbookReqMapStruct.toEntity(vehicleLogbookReqDTO);

        vehicleLogbookDAO.insertVehicleLogbook(vehicleLogbookEntity);
    }

    // 업무용차량 운행기록 삭제
    @Override
    public void deleteVehicleLogbook(HashMap<String, String> vehicleLogbookReqMap) {

        vehicleLogbookDAO.deleteVehicleLogbook(vehicleLogbookReqMap);
    }


}
