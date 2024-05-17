package org.tesinitsyn.recipefeedrestapi.expanse.service;

import org.springframework.stereotype.Service;
import org.tesinitsyn.recipefeedrestapi.expanse.entity.Expanse;
import org.tesinitsyn.recipefeedrestapi.expanse.repository.ExpanseRepository;
import org.tesinitsyn.recipefeedrestapi.expanse.variables.ExpanseGlobalVariables;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ExpanseTypeService {

    ExpanseRepository expanseRepository;

    public ExpanseTypeService(ExpanseRepository expanseRepository) {
        this.expanseRepository = expanseRepository;
    }

    public Map<String, Integer> getExpansesAmountByType() {
        Map<String, Integer> expansesAmountByType = new HashMap<>();
        ExpanseGlobalVariables.expanseTypes.forEach(expanseType -> {
            List<Expanse> expansesByExpanseType = expanseRepository.findAllByType(expanseType);
            AtomicInteger amount = new AtomicInteger();
            expansesByExpanseType.forEach(expanse -> {
                amount.addAndGet(expanse.getValue());
            });
            expansesAmountByType.put(expanseType, amount.intValue());
        });
        return expansesAmountByType;
    }

    public List<Expanse> getExpanseByType(String expanseType) {
        return expanseRepository.findAllByType(expanseType);
    }
}
