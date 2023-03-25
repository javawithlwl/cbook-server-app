package com.careerit.cbookserverapp.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
@Entity
@Table(name = "contact")
public class Contact {
  @Id
  @Column(name = "id")
  private String id;
  @Column(name = "name")
  private String name;
  @Column(name = "email")
  private String email;
  @Column(name = "mobile", unique = true)
  private String mobile;
  @Column(name = "is_deleted")
  private boolean isDeleted;

  @PrePersist
  public void init() {
    if (StringUtils.isEmpty(this.id)) {
        this.id = "CB_"+ ThreadLocalRandom.current().nextLong(1000000,9999999);
    }
  }


}
