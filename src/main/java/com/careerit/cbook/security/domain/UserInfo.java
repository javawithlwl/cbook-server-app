package com.careerit.cbook.security.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user_info")
@Getter
@Setter
public class UserInfo {
    @Id
    private String id;
    private String username;
    private String password;
    private String roles;
}
