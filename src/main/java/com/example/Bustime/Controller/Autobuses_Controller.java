package com.example.Bustime.Controller;

import com.example.Bustime.Model.Autobuses;
import com.example.Bustime.Services.Autobuses_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autobuses")
public class Autobuses_Controller {

    @Autowired
    private Autobuses_Service service;

    @GetMapping
    public List<Autobuses> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autobuses> getById(@PathVariable Integer id) {
        return service.getById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Autobuses create(@RequestBody Autobuses bus) {
        return service.create(bus);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autobuses> update(@PathVariable Integer id, @RequestBody Autobuses details) {
        return service.update(id, details).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        return service.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
