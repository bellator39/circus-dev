package com.circus.repository.implementation;

import com.circus.domain.Contacts;
 import com.circus.repository.api.ContactRepositoryApi;
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
public class ContactRepositoryImpl implements ContactRepositoryApi {

    private final JdbcTemplate dataBase;

    private final static String SAVE_CONTACT = "insert into contact(name, soname, email, message, date_send) \n" +
            "values(?,?,?,?,?)";
    private final static String UPDATE_CONTACT = "update contact set name=?,soname=?,message=?,email=? where id=?";
    private final static String GET_BY_ID_CONTACT = "select * from contact where id=?";
    private final static String DELETE_CONTACT = "delete from contact where id=?";
    private final static String FIND_ALL_CONTACT = "select * from contact";

    @Override
    public boolean saveContact(Contacts contactSave) {
        log.info("Save contact with name {} in {}",contactSave.getName() + " " + contactSave.getSoname(),new Date());
        return dataBase.update(SAVE_CONTACT,contactSave.getName(),contactSave.getSoname(),contactSave.getEmail(),
                contactSave.getMessage(),contactSave.getDate_send())>0;
    }

    @Override
    public boolean updateContact(Contacts contactUpdate) {
        log.info("Update contact with name {} and id {} in {}",contactUpdate.getName() + " " + contactUpdate.getSoname(),contactUpdate.getId(),new Date());
        return dataBase.update(UPDATE_CONTACT,contactUpdate.getName(),contactUpdate.getSoname(),
                contactUpdate.getMessage(),contactUpdate.getEmail(),contactUpdate.getId())>0;
    }

    @Override
    public Contacts getContactById(Long idContact) {
        try {
            log.info("Get contact by id - {} in {}",idContact,new Date());
            return dataBase.queryForObject(GET_BY_ID_CONTACT, new BeanPropertyRowMapper<>(Contacts.class), idContact);
        }catch (DataAccessException exception){
            log.error(exception.getMessage());
            return null;
        }
    }

    @Override
    public List<Contacts> findAllContact() {
        log.info("Get all contact in {}", new Date());
        return dataBase.query(FIND_ALL_CONTACT,new BeanPropertyRowMapper<>(Contacts.class));
    }

    @Override
    public boolean deleteContact(Long idContact) {
        log.warn("Delete contact with id {}",idContact);
        return dataBase.update(DELETE_CONTACT,idContact)>0;
    }
}
