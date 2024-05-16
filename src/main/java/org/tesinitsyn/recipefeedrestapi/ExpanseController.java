package org.tesinitsyn.recipefeedrestapi;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/expanse/")
public class ExpanseController {
    private final ExpanseCrudService expanseCrudService;

    public ExpanseController(ExpanseCrudService expanseCrudService) {
        this.expanseCrudService = expanseCrudService;
    }

    @GetMapping("getAll")
    public List<Expanse> getExpanses() {
        return expanseCrudService.getAllExpanses();
    }

    @PostMapping("createExpanse")
    public ResponseEntity<Expanse> addExpanse(@RequestBody Expanse expanse) {
        System.out.println(expanse.getName());
        Expanse newExpanse = expanseCrudService.createExpanse(expanse);
        return ResponseEntity.status(HttpStatus.CREATED).body(newExpanse);
    }

    @GetMapping("getByName/{name}")
    public ResponseEntity<List<Expanse>> getExpanseByName(@PathVariable String name) {
        Optional<List<Expanse>> recipeList = expanseCrudService.getExpanseByName(name);
        return recipeList.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
