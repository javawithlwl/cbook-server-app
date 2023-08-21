package com.careerit.cbook.repo;

import com.careerit.cbook.domain.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


import java.util.List;

public interface ContactRepo extends MongoRepository<Contact, String> {

        @Query("{'name':{$regex:?0,$options:'i'}}")
        List<Contact> search(String str);
}
