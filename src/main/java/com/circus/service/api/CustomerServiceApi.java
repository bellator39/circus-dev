package com.circus.service.api;

import com.circus.domain.Customer;

import java.util.List;

public interface CustomerServiceApi {
    boolean saveCustomer(Customer customerSave);
    boolean updateCustomer(Customer customerUpdate);
    Customer getCustomerById(Long idCustomer);
    List<Customer> findAllCustomer();
    boolean deleteCustomer(Long idCustomer);
    Customer findCustomerByUsername(String username);
}
