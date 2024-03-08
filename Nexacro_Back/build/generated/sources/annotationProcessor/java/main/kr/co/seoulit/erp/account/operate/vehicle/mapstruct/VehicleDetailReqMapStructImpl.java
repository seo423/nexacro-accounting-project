package kr.co.seoulit.erp.account.operate.vehicle.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import kr.co.seoulit.erp.account.operate.vehicle.entity.VehicleDetailEntity;
import kr.co.seoulit.erp.account.operate.vehicle.to.VehicleDetailReqDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-08T18:47:43+0900",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.1.jar, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class VehicleDetailReqMapStructImpl implements VehicleDetailReqMapStruct {

    @Override
    public VehicleDetailEntity toEntity(VehicleDetailReqDTO dto) {
        if ( dto == null ) {
            return null;
        }

        VehicleDetailEntity vehicleDetailEntity = new VehicleDetailEntity();

        vehicleDetailEntity.setVehicleCode( dto.getVehicleCode() );
        vehicleDetailEntity.setAccountCode( dto.getAccountCode() );
        vehicleDetailEntity.setAccountName( dto.getAccountName() );
        vehicleDetailEntity.setAssetCode( dto.getAssetCode() );
        vehicleDetailEntity.setAssetName( dto.getAssetName() );
        vehicleDetailEntity.setAcquisitionDate( dto.getAcquisitionDate() );
        vehicleDetailEntity.setDisposalDate( dto.getDisposalDate() );
        vehicleDetailEntity.setExpenseCategory( dto.getExpenseCategory() );
        vehicleDetailEntity.setInsuranceStatus( dto.getInsuranceStatus() );
        vehicleDetailEntity.setCustomerCode( dto.getCustomerCode() );
        vehicleDetailEntity.setInsuranceCompany( dto.getInsuranceCompany() );
        vehicleDetailEntity.setInsuranceStartPeriod( dto.getInsuranceStartPeriod() );
        vehicleDetailEntity.setInsuranceEndPeriod( dto.getInsuranceEndPeriod() );
        vehicleDetailEntity.setLeaseType( dto.getLeaseType() );
        vehicleDetailEntity.setLeaseStartPeriod( dto.getLeaseStartPeriod() );
        vehicleDetailEntity.setLeaseEndPeriod( dto.getLeaseEndPeriod() );
        vehicleDetailEntity.setUsageType( dto.getUsageType() );

        return vehicleDetailEntity;
    }

    @Override
    public List<VehicleDetailEntity> toEntity(List<VehicleDetailReqDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<VehicleDetailEntity> list = new ArrayList<VehicleDetailEntity>( dtos.size() );
        for ( VehicleDetailReqDTO vehicleDetailReqDTO : dtos ) {
            list.add( toEntity( vehicleDetailReqDTO ) );
        }

        return list;
    }
}
