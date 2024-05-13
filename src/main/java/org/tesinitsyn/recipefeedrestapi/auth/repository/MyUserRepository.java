package org.tesinitsyn.recipefeedrestapi.auth.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.tesinitsyn.recipefeedrestapi.auth.entity.MyUser;

import java.util.Optional;

@Repository
public interface MyUserRepository extends CrudRepository<MyUser, Long> {
    Optional<MyUser> findByEmail(String email);
}
