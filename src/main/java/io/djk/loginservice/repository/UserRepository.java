package io.djk.loginservice.repository;

import io.djk.loginservice.domain.User;
import org.springframework.data.repository.Repository;

/**
 * Created by dkothari on 2/24/19.
 */
public interface UserRepository extends Repository<User, Long> {

    void save(User user);

}
