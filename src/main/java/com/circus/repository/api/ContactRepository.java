package com.circus.repository.api;


import com.circus.domain.Contacts;

import java.util.List;

public interface ContactRepository {
    boolean saveContact(Contacts contactSave);
    boolean updateContact(Contacts contactUpdate);
    Contacts getContactById(Long idContact);
    List<Contacts>findAllContact();

    boolean deleteContact(Long idContact);
}
