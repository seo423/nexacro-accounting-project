package kr.co.seoulit.erp.account.operate.vehicle.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import kr.co.seoulit.erp.account.operate.vehicle.entity.VehicleLogbookEntity;
import kr.co.seoulit.erp.account.operate.vehicle.to.VehicleLogbookResDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-08T18:47:44+0900",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.1.jar, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class VehicleLogbookResMapStructImpl implements VehicleLogbookResMapStruct {

    @Override
    public VehicleLogbookResDTO toDto(VehicleLogbookEntity entity) {
        if ( entity == null ) {
            return null;
        }

        VehicleLogbookResDTO vehicleLogbookResDTO = new VehicleLogbookResDTO();

        vehicleLogbookResDTO.setVehicleCode( entity.getVehicleCode() );
        vehicleLogbookResDTO.setUseDate( entity.getUseDate() );
        vehicleLogbookResDTO.setStartTime( entity.getStartTime() );
        vehicleLogbookResDTO.setEmpCode( entity.getEmpCode() );
        vehicleLogbookResDTO.setEmpName( entity.getEmpName() );
        vehicleLogbookResDTO.setDeptCode( entity.getDeptCode() );
        vehicleLogbookResDTO.setDeptName( entity.getDeptName() );
        vehicleLogbookResDTO.setDistance( entity.getDistance() );
        vehicleLogbookResDTO.setBusinessDistance( entity.getBusinessDistance() );
        vehicleLogbookResDTO.setPersonalDistance( entity.getPersonalDistance() );
        vehicleLogbookResDTO.setBeforeOdometer( entity.getBeforeOdometer() );
        vehicleLogbookResDTO.setAfterOdometer( entity.getAfterOdometer() );
        vehicleLogbookResDTO.setNotes( entity.getNotes() );

        return vehicleLogbookResDTO;
    }

    @Override
    public List<VehicleLogbookResDTO> toDto(List<VehicleLogbookEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<VehicleLogbookResDTO> list = new ArrayList<VehicleLogbookResDTO>( entities.size() );
        for ( VehicleLogbookEntity vehicleLogbookEntity : entities ) {
            list.add( toDto( vehicleLogbookEntity ) );
        }

        return list;
    }
}
