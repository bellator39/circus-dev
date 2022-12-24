package com.circus.repository.implementation;

import com.circus.domain.Contacts;
import com.circus.domain.Customer;
import com.circus.repository.api.CustomerRepositoryApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@Slf4j
@RequiredArgsConstructor
public class CustomerRepositoryApiImpl implements CustomerRepositoryApi {

    private final JdbcTemplate database;

    private final String SAVE_CUSTOMER="insert into customer(name, soname, username, password, email, rolename, date_registration)" +
            "values(?,?,?,?,?,?,?)";
    private final String UPDATE_CUSTOMER="update customer set name=?,soname=?,username=?,password=?,email=?,rolename=? where id=?";
    private final String GET_CUSTOMER_BY_ID="select * from customer where id=?";
    private final String FIND_ALL_CUSTOMER="select * from customer";
    private final String DELETE_CUSTOMER="delete from customer where id=?";
    private final String FIND_CUSTOMER_BY_USERNAME="select * from customer where username=?";


    @Override
    public boolean saveCustomer(Customer customerSave) {
        log.info("Save customer with name {} in {}",customerSave.getName() + " " + customerSave.getSoname(),new Date());
        return database.update(SAVE_CUSTOMER,customerSave.getName(),customerSave.getSoname(),customerSave.getUsername(),customerSave.getPassword(),
                customerSave.getEmail(),customerSave.getRolename().name(),customerSave.getDate_registration())>0;
    }

    @Override
    public boolean updateCustomer(Customer customerUpdate) {
        log.info("Update customer with id {} in {}",customerUpdate.getId(),new Date());
        return database.update(UPDATE_CUSTOMER,customerUpdate.getName(),customerUpdate.getSoname(),customerUpdate.getUsername(),customerUpdate.getPassword(),
                customerUpdate.getEmail(),customerUpdate.getRolename(),customerUpdate.getId())>0;
    }

    @Override
    public Customer getCustomerById(Long idCustomer) {
        try {
            log.info("Get customer by id {} in {}",idCustomer,new Date());
            return database.queryForObject(GET_CUSTOMER_BY_ID,new BeanPropertyRowMapper<>(Customer.class),idCustomer);
        }catch (DataAccessException exception){
            log.error("Error get customer by id {} with {} in {}",idCustomer,exception.getMessage(),new Date());
            return null;
        }
    }

    @Override
    public List<Customer> findAllCustomer() {
        log.info("Get all customer in {}",new Date());
        return database.query(FIND_ALL_CUSTOMER,new BeanPropertyRowMapper<>(Customer.class));
    }

    @Override
    public boolean deleteCustomer(Long idCustomer) {
        log.warn("Delete customer with id {} in {}",idCustomer,new Date());
        return database.update(DELETE_CUSTOMER,idCustomer)>0;
    }

    @Override
    public Customer findCustomerByUsername(String username) {
        try {
            log.info("Get customer by username {} in {}",username,new Date());
            return database.queryForObject(FIND_CUSTOMER_BY_USERNAME,new BeanPropertyRowMapper<>(Customer.class),username);
        }catch (DataAccessException exception){
            log.warn("Not find customer by username {} with {} in {}",username,exception.getMessage(),new Date());
            return null;
        }
    }
}
