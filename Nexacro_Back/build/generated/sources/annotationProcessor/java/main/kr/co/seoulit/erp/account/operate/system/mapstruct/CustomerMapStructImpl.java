package kr.co.seoulit.erp.account.operate.system.mapstruct;

import javax.annotation.processing.Generated;
import kr.co.seoulit.erp.account.operate.system.entity.Customer;
import kr.co.seoulit.erp.account.operate.system.to.CustomerUpdateRequest;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-08T18:14:24+0900",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.1.jar, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class CustomerMapStructImpl implements CustomerMapStruct {

    @Override
    public CustomerUpdateRequest toCustomerDTO(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerUpdateRequest.CustomerUpdateRequestBuilder customerUpdateRequest = CustomerUpdateRequest.builder();

        customerUpdateRequest.customerCode( customer.getCustomerCode() );
        customerUpdateRequest.workplaceCode( customer.getWorkplaceCode() );
        customerUpdateRequest.customerName( customer.getCustomerName() );
        customerUpdateRequest.customerType( customer.getCustomerType() );
        customerUpdateRequest.customerCeo( customer.getCustomerCeo() );
        customerUpdateRequest.businessLicenseNumber( customer.getBusinessLicenseNumber() );
        customerUpdateRequest.socialSecurityNumber( customer.getSocialSecurityNumber() );
        customerUpdateRequest.customerBusinessConditions( customer.getCustomerBusinessConditions() );
        customerUpdateRequest.customerBusinessItems( customer.getCustomerBusinessItems() );
        customerUpdateRequest.customerZipCode( customer.getCustomerZipCode() );
        customerUpdateRequest.customerBasicAddress( customer.getCustomerBasicAddress() );
        customerUpdateRequest.customerDetailAddress( customer.getCustomerDetailAddress() );
        customerUpdateRequest.customerTelNumber( customer.getCustomerTelNumber() );
        customerUpdateRequest.customerFaxNumber( customer.getCustomerFaxNumber() );

        return customerUpdateRequest.build();
    }
}
