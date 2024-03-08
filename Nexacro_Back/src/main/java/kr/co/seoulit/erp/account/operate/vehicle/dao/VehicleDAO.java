package kr.co.seoulit.erp.account.operate.vehicle.dao;

import kr.co.seoulit.erp.account.operate.vehicle.entity.VehicleEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VehicleDAO {

    // 업무용차량 전체조회
    List<VehicleEntity> findVehicleList();

    // 업무용차량 한개조회
    VehicleEntity findVehicle(String vehicleCode);

    // 업무용차량 추가 / 수정
    void mergeVehicle(VehicleEntity vehicleEntity);

    // 업무용차량 삭제
    void deleteVehicle(String vehicleCode);
}