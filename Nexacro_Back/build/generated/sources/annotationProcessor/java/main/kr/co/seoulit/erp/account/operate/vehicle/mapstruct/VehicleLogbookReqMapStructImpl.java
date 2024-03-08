package kr.co.seoulit.erp.account.operate.vehicle.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import kr.co.seoulit.erp.account.operate.vehicle.entity.VehicleLogbookEntity;
import kr.co.seoulit.erp.account.operate.vehicle.to.VehicleLogbookReqDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-08T18:14:25+0900",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.1.jar, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class VehicleLogbookReqMapStructImpl implements VehicleLogbookReqMapStruct {

    @Override
    public VehicleLogbookEntity toEntity(VehicleLogbookReqDTO dto) {
        if ( dto == null ) {
            return null;
        }

        VehicleLogbookEntity vehicleLogbookEntity = new VehicleLogbookEntity();

        vehicleLogbookEntity.setVehicleCode( dto.getVehicleCode() );
        vehicleLogbookEntity.setUseDate( dto.getUseDate() );
        vehicleLogbookEntity.setStartTime( dto.getStartTime() );
        vehicleLogbookEntity.setEmpCode( dto.getEmpCode() );
        vehicleLogbookEntity.setEmpName( dto.getEmpName() );
        vehicleLogbookEntity.setDeptCode( dto.getDeptCode() );
        vehicleLogbookEntity.setDeptName( dto.getDeptName() );
        vehicleLogbookEntity.setDistance( dto.getDistance() );
        vehicleLogbookEntity.setBusinessDistance( dto.getBusinessDistance() );
        vehicleLogbookEntity.setPersonalDistance( dto.getPersonalDistance() );
        vehicleLogbookEntity.setBeforeOdometer( dto.getBeforeOdometer() );
        vehicleLogbookEntity.setAfterOdometer( dto.getAfterOdometer() );
        vehicleLogbookEntity.setNotes( dto.getNotes() );

        return vehicleLogbookEntity;
    }

    @Override
    public List<VehicleLogbookEntity> toEntity(List<VehicleLogbookReqDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<VehicleLogbookEntity> list = new ArrayList<VehicleLogbookEntity>( dtos.size() );
        for ( VehicleLogbookReqDTO vehicleLogbookReqDTO : dtos ) {
            list.add( toEntity( vehicleLogbookReqDTO ) );
        }

        return list;
    }
}
