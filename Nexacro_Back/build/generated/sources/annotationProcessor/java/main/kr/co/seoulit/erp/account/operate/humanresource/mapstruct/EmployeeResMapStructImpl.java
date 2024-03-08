package kr.co.seoulit.erp.account.operate.humanresource.mapstruct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.processing.Generated;
import kr.co.seoulit.erp.account.operate.entity.EmployeeEntity;
import kr.co.seoulit.erp.account.operate.humanresource.to.EmployeeResDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-08T18:47:44+0900",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.1.jar, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class EmployeeResMapStructImpl implements EmployeeResMapStruct {

    @Override
    public EmployeeResDTO toDto(EmployeeEntity entity) {
        if ( entity == null ) {
            return null;
        }

        EmployeeResDTO employeeResDTO = new EmployeeResDTO();

        employeeResDTO.setStatus( entity.getStatus() );
        employeeResDTO.setEmpCode( entity.getEmpCode() );
        employeeResDTO.setEmpName( entity.getEmpName() );
        employeeResDTO.setUserPw( entity.getUserPw() );
        employeeResDTO.setPositionName( entity.getPositionName() );
        employeeResDTO.setEmail( entity.getEmail() );
        employeeResDTO.setDeptName( entity.getDeptName() );
        employeeResDTO.setSocialSecurityNumber( entity.getSocialSecurityNumber() );
        employeeResDTO.setBasicAddress( entity.getBasicAddress() );
        employeeResDTO.setUserOrNot( entity.getUserOrNot() );
        employeeResDTO.setGender( entity.getGender() );
        employeeResDTO.setPhoneNumber( entity.getPhoneNumber() );
        employeeResDTO.setBirthDate( entity.getBirthDate() );
        byte[] image = entity.getImage();
        if ( image != null ) {
            employeeResDTO.setImage( Arrays.copyOf( image, image.length ) );
        }
        employeeResDTO.setCompanyCode( entity.getCompanyCode() );
        employeeResDTO.setWorkplaceCode( entity.getWorkplaceCode() );
        employeeResDTO.setDeptCode( entity.getDeptCode() );
        employeeResDTO.setPositionCode( entity.getPositionCode() );
        employeeResDTO.setZipCode( entity.getZipCode() );
        employeeResDTO.setLevelOfEducation( entity.getLevelOfEducation() );
        employeeResDTO.setDetailAddress( entity.getDetailAddress() );

        return employeeResDTO;
    }

    @Override
    public List<EmployeeResDTO> toDto(List<EmployeeEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<EmployeeResDTO> list = new ArrayList<EmployeeResDTO>( entities.size() );
        for ( EmployeeEntity employeeEntity : entities ) {
            list.add( toDto( employeeEntity ) );
        }

        return list;
    }
}
