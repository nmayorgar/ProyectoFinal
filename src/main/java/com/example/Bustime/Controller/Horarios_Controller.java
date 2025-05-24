package com.example.Bustime.Controller;

import com.example.Bustime.Model.Horarios;
import com.example.Bustime.Services.Horarios_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horarios")
public class Horarios_Controller {

    @Autowired
    private Horarios_Service service;

    @GetMapping
    public List<Horarios> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Horarios> getById(@PathVariable Integer id) {
        return service.getById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Horarios create(@RequestBody Horarios horario) {
        return service.create(horario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Horarios> update(@PathVariable Integer id, @RequestBody Horarios details) {
        return service.update(id, details).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        return service.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
