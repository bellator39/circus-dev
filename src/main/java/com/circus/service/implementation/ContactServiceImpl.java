package com.circus.service.implementation;

import com.circus.domain.Contacts;
import com.circus.repository.api.ContactRepositoryApi;
import com.circus.service.api.ContactServiceApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactServiceApi {

    private final ContactRepositoryApi contactRepository;

    @Override
    public boolean saveContact(Contacts contactSave) {
        if (contactSave != null) {
            contactSave.setDate_send(LocalDateTime.now());
            log.info("Save contact with service, with name {} in {}",contactSave.getName(), new Date());
            return contactRepository.saveContact(contactSave);
        } else {
            log.error("Cannot save contact, equals null in {}", new Date());
            return false;
        }
    }

    @Override
    public boolean updateContact(Contacts contactUpdate) {
        if (contactUpdate.getId() != null) {
            log.info("Update contact with service, with name {} in {}",contactUpdate.getName(), new Date());
            return contactRepository.updateContact(contactUpdate);
        } else {
            log.error("Cannot update contact id, equals null in {}", new Date());
            return false;
        }
    }

    @Override
    public Contacts getContactById(Long idContact) {
        if (idContact != null) {
            log.info("Get contact with service, with id {} in {}",idContact, new Date());
            return contactRepository.getContactById(idContact);
        } else {
            log.error("Cannot get contact by id, equals null in {}", new Date());
            return null;
        }
    }

    @Override
    public List<Contacts> findAllContact() {
        log.info("Get all contacts with service in {}", new Date());
        return contactRepository.findAllContact();
    }

    @Override
    public boolean deleteContact(Long idContact) {
        if (idContact != null) {
            log.info("Delete contact with service, with id {} in {}",idContact, new Date());
            return contactRepository.deleteContact(idContact);
        } else {
            log.error("Cannot delete contact by id, equals null in {}", new Date());
            return false;
        }
    }
}
