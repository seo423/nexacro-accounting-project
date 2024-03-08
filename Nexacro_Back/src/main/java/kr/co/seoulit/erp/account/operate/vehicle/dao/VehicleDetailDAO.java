package kr.co.seoulit.erp.account.operate.vehicle.dao;

import kr.co.seoulit.erp.account.operate.vehicle.entity.VehicleDetailEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VehicleDetailDAO {

    // 업무용차량 상세조회
    VehicleDetailEntity findVehicleDetail(String vehicleCode);

    // 업무용차량상세 추가 / 수정
    void mergeVehicleDetail(VehicleDetailEntity vehicleDetailEntity);

    // 업무용차량 삭제에 따른 관련 데이터 삭제
    void deleteVehicleDetail(String vehicleCode);
}
