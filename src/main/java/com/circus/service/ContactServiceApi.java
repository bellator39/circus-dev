package com.circus.service;


import com.circus.domain.Contacts;

import java.util.List;

public interface ContactServiceApi {
    boolean saveContact(Contacts contactSave);
    boolean updateContact(Contacts contactUpdate);
    Contacts getContactById(Long idContact);
    List<Contacts>findAllContact();
    boolean deleteContact(Long idContact);
}
