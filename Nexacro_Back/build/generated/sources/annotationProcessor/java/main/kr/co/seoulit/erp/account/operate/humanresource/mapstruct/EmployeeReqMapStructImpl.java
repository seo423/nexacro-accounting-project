package kr.co.seoulit.erp.account.operate.humanresource.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import kr.co.seoulit.erp.account.operate.entity.EmployeeEntity;
import kr.co.seoulit.erp.account.operate.humanresource.to.EmployeeReqDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-05T21:32:50+0900",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.1.jar, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class EmployeeReqMapStructImpl implements EmployeeReqMapStruct {

    @Override
    public EmployeeEntity toEntity(EmployeeReqDTO dto) {
        if ( dto == null ) {
            return null;
        }

        EmployeeEntity employeeEntity = new EmployeeEntity();

        employeeEntity.setStatus( dto.getStatus() );
        employeeEntity.setEmpCode( dto.getEmpCode() );
        employeeEntity.setEmpName( dto.getEmpName() );
        employeeEntity.setUserPw( dto.getUserPw() );
        employeeEntity.setPositionName( dto.getPositionName() );
        employeeEntity.setEmail( dto.getEmail() );
        employeeEntity.setDeptName( dto.getDeptName() );
        employeeEntity.setSocialSecurityNumber( dto.getSocialSecurityNumber() );
        employeeEntity.setBasicAddress( dto.getBasicAddress() );
        employeeEntity.setUserOrNot( dto.getUserOrNot() );
        employeeEntity.setGender( dto.getGender() );
        employeeEntity.setPhoneNumber( dto.getPhoneNumber() );
        employeeEntity.setBirthDate( dto.getBirthDate() );
        employeeEntity.setCompanyCode( dto.getCompanyCode() );
        employeeEntity.setWorkplaceCode( dto.getWorkplaceCode() );
        employeeEntity.setDeptCode( dto.getDeptCode() );
        employeeEntity.setPositionCode( dto.getPositionCode() );
        employeeEntity.setZipCode( dto.getZipCode() );
        employeeEntity.setLevelOfEducation( dto.getLevelOfEducation() );
        employeeEntity.setDetailAddress( dto.getDetailAddress() );

        return employeeEntity;
    }

    @Override
    public List<EmployeeEntity> toEntity(List<EmployeeReqDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<EmployeeEntity> list = new ArrayList<EmployeeEntity>( dtos.size() );
        for ( EmployeeReqDTO employeeReqDTO : dtos ) {
            list.add( toEntity( employeeReqDTO ) );
        }

        return list;
    }
}
