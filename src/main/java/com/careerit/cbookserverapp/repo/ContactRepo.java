package com.careerit.cbookserverapp.repo;

import com.careerit.cbookserverapp.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepo extends JpaRepository<Contact,String> {
}
