package kr.co.seoulit.erp.account.operate.system.service;

import kr.co.seoulit.erp.account.operate.system.dao.CustomerDAO;
import kr.co.seoulit.erp.account.operate.system.entity.Customer;
import kr.co.seoulit.erp.account.operate.system.repository.CustomerMRepository;
import kr.co.seoulit.erp.account.operate.system.to.CustomerUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

     CustomerMRepository customerRepository;

    EntityManager em;

    private final CustomerDAO customerDAO;



    @Autowired
    public CustomerServiceImpl(CustomerMRepository customerRepository,
                               EntityManager em,
                               CustomerDAO customerDAO) {
        this.customerRepository = customerRepository;
        this.em = em;
        this.customerDAO = customerDAO;
    }

    @Override
    public List<Customer> findCustomerList() {
        return customerRepository.findAll();
    }


    @Override
    public void registerCustomer(CustomerUpdateRequest customerUpdateRequest) {
        customerDAO.insertCustomer(customerUpdateRequest);
    }

    @Override
    public void updateCustomer(CustomerUpdateRequest customerUpdateRequest) {
        customerDAO.updateCustomer(customerUpdateRequest);
    }

    @Override
    public void removeCustomer(String customerCode) {
        customerDAO.deleteCustomer(customerCode);
        System.out.println("거래처삭제완료 : " + customerCode);
    }



                                     //아래의 코드는 사용하지 않는 코드들




    //    @Override
//    @Transactional
//    public void registerCustomer(CustomerUpdateRequest customerUpdateRequest){
//        Customer customerEntity = em.find(Customer.class, customer.getCustomerCode());
//        if (customerEntity.getCustomerCode() == null) {
//            em.persist(customerEntity);
//        }
//        System.out.println(" --------------------");
//        CustomerUpdateRequest customerUpdateRequest = customerMapper.toCustomerDTO(customerEntity);
//        System.out.println(" = ++++++++++");
//        em.persist(customerUpdateRequest);
//
//        Customer customer = customerRepository.findByCustomerCode(customerUpdateRequest.getCustomerCode());
//        customer.updateCustomer(customerUpdateRequest.getCustomerCeo());
//    }






    /*@Override
    public void registerCustomers(CustomerUpdateRequest customerUpdateRequest) {
        customerDAO.insertCustomer(customerUpdateRequest);
    }*/

     /*@Override
     @Transactional
     public void registerCustomers(List<CustomerUpdateRequest> customerUpdateRequestList) {
         List<String> customerCodes = customerUpdateRequestList.stream()
                 .map(CustomerUpdateRequest::getCustomerCode)
                 .collect(Collectors.toList());

         List<Customer> customerList = customerRepository.findAllByCustomerCode(customerCodes);

         customerList.forEach(customer -> customerUpdateRequestList.stream()
                 .filter(updateRequest -> customer.getCustomerCode().equals(updateRequest.getCustomerCode()))
                 .findFirst()
                 .ifPresent(updateRequest -> {
                     customer.updateCustomer(updateRequest.getCustomerCeo());
                     // 필요한 다른 필드도 업데이트 작업 수행 가능
                     // customer.updateXXX(updateRequest.getXXX());
                 }));
     }*/
}
