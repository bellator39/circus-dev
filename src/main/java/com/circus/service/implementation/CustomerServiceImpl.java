package com.circus.service.implementation;


import com.circus.domain.Customer;
import com.circus.domain.RoleUser;
import com.circus.repository.api.CustomerRepositoryApi;
import com.circus.service.api.CustomerServiceApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerServiceApi {

    private final CustomerRepositoryApi customerRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    @Override
    public boolean saveCustomer(Customer customerSave) {
        Customer customerByUsername = customerRepository.findCustomerByUsername(customerSave.getUsername());
        Customer customerByEmail = customerRepository.findAllCustomer().stream().filter(o1->o1.getEmail().equals(customerSave.getEmail())).findFirst().orElse(null);
        if(customerByUsername==null && customerByEmail==null){
            log.info("Save customer with service, name {} in {}",customerSave.getName(),new Date());
            customerSave.setPassword(passwordEncoder.encode(customerSave.getPassword()));
            customerSave.setRolename(RoleUser.CUSTOMER);
            customerSave.setDate_registration(LocalDateTime.now());
            return customerRepository.saveCustomer(customerSave);
        }else{
            log.error("Customer with username {} already exists in {}",customerSave.getUsername(),new Date());
            return false;
        }
    }

    @Override
    public boolean updateCustomer(Customer customerUpdate) {
        if(customerUpdate.getId()!=null){
            log.info("Update customer with service, id {} in {}",customerUpdate.getId(),new Date());
            return customerRepository.updateCustomer(customerUpdate);
        }else{
            log.error("Cannot update customer,id equals null in {}",new Date());
            return false;
        }
    }

    @Override
    public Customer getCustomerById(Long idCustomer) {
        if(idCustomer!=null){
            log.info("Get customer by id with service, id {} in {}",idCustomer,new Date());
            return customerRepository.getCustomerById(idCustomer);
        }else{
            log.error("Cannot get customer,id equals null in {}",new Date());
            return null;
        }
    }

    @Override
    public List<Customer> findAllCustomer() {
        log.info("Get all customer with service in {}",new Date());
        return customerRepository.findAllCustomer();
    }

    @Override
    public boolean deleteCustomer(Long idCustomer) {
        if(idCustomer!=null){
            log.info("Delete customer by id with service, id {} in {}",idCustomer,new Date());
            return customerRepository.deleteCustomer(idCustomer);
        }else{
            log.error("Cannot delete customer,id equals null in {}",new Date());
            return false;
        }
    }

    @Override
    public Customer findCustomerByUsername(String username) {
        if(!username.equals("")){
            log.info("Get customer by username with service, in {}",new Date());
            return customerRepository.findCustomerByUsername(username);
        }else{
            log.error("Cannot get customer by username, equals null in {}",new Date());
            return null;
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Customer> optionalCustomer = Optional.ofNullable
                (customerRepository.findCustomerByUsername(username));
        if(optionalCustomer.isPresent()){
            return optionalCustomer.get();
        }else{
            throw new UsernameNotFoundException("Customer with username not found");
        }
    }
}
