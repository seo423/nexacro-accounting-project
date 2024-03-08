package kr.co.seoulit.erp.account.operate.vehicle.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import kr.co.seoulit.erp.account.operate.vehicle.entity.VehicleDetailEntity;
import kr.co.seoulit.erp.account.operate.vehicle.to.VehicleDetailResDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-05T21:32:50+0900",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.1.jar, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class VehicleDetailResMapStructImpl implements VehicleDetailResMapStruct {

    @Override
    public VehicleDetailResDTO toDto(VehicleDetailEntity entity) {
        if ( entity == null ) {
            return null;
        }

        VehicleDetailResDTO vehicleDetailResDTO = new VehicleDetailResDTO();

        vehicleDetailResDTO.setVehicleCode( entity.getVehicleCode() );
        vehicleDetailResDTO.setAccountCode( entity.getAccountCode() );
        vehicleDetailResDTO.setAccountName( entity.getAccountName() );
        vehicleDetailResDTO.setAssetCode( entity.getAssetCode() );
        vehicleDetailResDTO.setAssetName( entity.getAssetName() );
        vehicleDetailResDTO.setAcquisitionDate( entity.getAcquisitionDate() );
        vehicleDetailResDTO.setDisposalDate( entity.getDisposalDate() );
        vehicleDetailResDTO.setExpenseCategory( entity.getExpenseCategory() );
        vehicleDetailResDTO.setInsuranceStatus( entity.getInsuranceStatus() );
        vehicleDetailResDTO.setCustomerCode( entity.getCustomerCode() );
        vehicleDetailResDTO.setInsuranceCompany( entity.getInsuranceCompany() );
        vehicleDetailResDTO.setInsuranceStartPeriod( entity.getInsuranceStartPeriod() );
        vehicleDetailResDTO.setInsuranceEndPeriod( entity.getInsuranceEndPeriod() );
        vehicleDetailResDTO.setLeaseType( entity.getLeaseType() );
        vehicleDetailResDTO.setLeaseStartPeriod( entity.getLeaseStartPeriod() );
        vehicleDetailResDTO.setLeaseEndPeriod( entity.getLeaseEndPeriod() );
        vehicleDetailResDTO.setUsageType( entity.getUsageType() );

        return vehicleDetailResDTO;
    }

    @Override
    public List<VehicleDetailResDTO> toDto(List<VehicleDetailEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<VehicleDetailResDTO> list = new ArrayList<VehicleDetailResDTO>( entities.size() );
        for ( VehicleDetailEntity vehicleDetailEntity : entities ) {
            list.add( toDto( vehicleDetailEntity ) );
        }

        return list;
    }
}
