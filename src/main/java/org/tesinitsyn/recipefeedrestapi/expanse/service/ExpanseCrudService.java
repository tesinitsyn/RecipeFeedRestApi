package org.tesinitsyn.recipefeedrestapi.expanse.service;

import org.springframework.stereotype.Service;
import org.tesinitsyn.recipefeedrestapi.expanse.repository.ExpanseRepository;
import org.tesinitsyn.recipefeedrestapi.expanse.entity.Expanse;

import java.util.List;
import java.util.Optional;

@Service
public class ExpanseCrudService {
    private final ExpanseRepository expanseRepository;


    public ExpanseCrudService(ExpanseRepository expanseRepository) {
        this.expanseRepository = expanseRepository;
    }

    public List<Expanse> getAllExpanses() {
        return expanseRepository.findAll();
    }

    public Expanse createExpanse(Expanse expanse) {
        return expanseRepository.save(expanse);
    }

    public Optional<List<Expanse>> getExpanseByName(String name) {
        return expanseRepository.findAllByNameLikeIgnoreCase("%" + name + "%");
    }
}
