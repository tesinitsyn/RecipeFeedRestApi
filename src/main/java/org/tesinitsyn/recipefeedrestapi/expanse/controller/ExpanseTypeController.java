package org.tesinitsyn.recipefeedrestapi.expanse.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tesinitsyn.recipefeedrestapi.expanse.entity.Expanse;
import org.tesinitsyn.recipefeedrestapi.expanse.service.ExpanseTypeService;
import org.tesinitsyn.recipefeedrestapi.expanse.variables.ExpanseGlobalVariables;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/expanse/categories/")
public class ExpanseTypeController {

    ExpanseTypeService expanseTypeService;

    public ExpanseTypeController(ExpanseTypeService expanseTypeService) {
        this.expanseTypeService = expanseTypeService;
    }


    @GetMapping("/getAllTypes")
    public ResponseEntity<List<String>> getAllType() {
        return ResponseEntity.ok(ExpanseGlobalVariables.expanseTypes);
    }

    @GetMapping("/getAllExpansesAmountByType")
    public ResponseEntity<Map<String, Integer>> getExpansesAmountByType(){
        return ResponseEntity.ok(expanseTypeService.getExpansesAmountByType());
    }

    @GetMapping("/getExpansesByType/{type}")
    public ResponseEntity<List<Expanse>> getExpansesByType(@PathVariable String type){
        return ResponseEntity.ok(expanseTypeService.getExpanseByType(type));
    }


}
