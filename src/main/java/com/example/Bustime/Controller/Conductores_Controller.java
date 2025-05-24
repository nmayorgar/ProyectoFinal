package com.example.Bustime.Controller;

import com.example.Bustime.Model.Conductores;
import com.example.Bustime.Services.Conductores_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conductores")
public class Conductores_Controller {

    @Autowired
    private Conductores_Service service;

    @GetMapping
    public List<Conductores> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conductores> getById(@PathVariable Integer id) {
        return service.getById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Conductores create(@RequestBody Conductores conductor) {
        return service.create(conductor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Conductores> update(@PathVariable Integer id, @RequestBody Conductores details) {
        return service.update(id, details).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        return service.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
