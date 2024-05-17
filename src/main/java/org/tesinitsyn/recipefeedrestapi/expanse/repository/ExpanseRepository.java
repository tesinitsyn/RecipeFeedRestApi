package org.tesinitsyn.recipefeedrestapi.expanse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tesinitsyn.recipefeedrestapi.expanse.entity.Expanse;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExpanseRepository extends JpaRepository<Expanse, Long> {
    Optional<List<Expanse>> findAllByNameLikeIgnoreCase(String name);
}
