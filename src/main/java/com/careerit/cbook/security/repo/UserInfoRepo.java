package com.careerit.cbook.security.repo;
import com.careerit.cbook.security.domain.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface UserInfoRepo extends MongoRepository<UserInfo, String> {

    Optional<UserInfo> findByUsername(String username);
}
