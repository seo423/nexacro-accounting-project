package kr.co.seoulit.erp.account.operate.vehicle.dao;

import kr.co.seoulit.erp.account.operate.vehicle.entity.VehicleLogbookEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface VehicleLogbookDAO {

    // 업무용차량 운행기록부 상세조회
    List<VehicleLogbookEntity> findVehicleLogbookList(String vehicleCode);

    // 업무용차량 운행기록 추가
    void insertVehicleLogbook(VehicleLogbookEntity vehicleLogbookEntity);

    // 업무용차량 운행기록 삭제
    void deleteVehicleLogbook(HashMap<String, String> vehicleLogbookReqMap);

    // 업무용차량 삭제에 따른 관련 데이터 삭제
    void deleteVehicleLogbookList(String vehicleCode);
}
