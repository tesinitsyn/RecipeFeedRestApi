package org.tesinitsyn.recipefeedrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tesinitsyn.recipefeedrestapi.model.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name);
}
