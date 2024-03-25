package org.tesinitsyn.recipefeedrestapi.user.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tesinitsyn.recipefeedrestapi.user.model.User;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByName(String username);
}
