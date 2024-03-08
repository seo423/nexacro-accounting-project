package kr.co.seoulit.erp.account.operate.vehicle.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import kr.co.seoulit.erp.account.operate.vehicle.entity.VehicleEntity;
import kr.co.seoulit.erp.account.operate.vehicle.to.VehicleResDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-05T21:32:50+0900",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.1.jar, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class VehicleResMapStructImpl implements VehicleResMapStruct {

    @Override
    public VehicleResDTO toDto(VehicleEntity entity) {
        if ( entity == null ) {
            return null;
        }

        VehicleResDTO vehicleResDTO = new VehicleResDTO();

        vehicleResDTO.setVehicleCode( entity.getVehicleCode() );
        vehicleResDTO.setVehicleNumber( entity.getVehicleNumber() );
        vehicleResDTO.setVehicleType( entity.getVehicleType() );
        vehicleResDTO.setDeptCode( entity.getDeptCode() );
        vehicleResDTO.setDeptName( entity.getDeptName() );
        vehicleResDTO.setEmpCode( entity.getEmpCode() );
        vehicleResDTO.setEmpName( entity.getEmpName() );
        vehicleResDTO.setAvailability( entity.getAvailability() );
        vehicleResDTO.setDistance( entity.getDistance() );
        vehicleResDTO.setBusinessDistance( entity.getBusinessDistance() );
        vehicleResDTO.setBusinessUsageRatio( entity.getBusinessUsageRatio() );

        return vehicleResDTO;
    }

    @Override
    public List<VehicleResDTO> toDto(List<VehicleEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<VehicleResDTO> list = new ArrayList<VehicleResDTO>( entities.size() );
        for ( VehicleEntity vehicleEntity : entities ) {
            list.add( toDto( vehicleEntity ) );
        }

        return list;
    }
}
