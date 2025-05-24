package com.example.Bustime.Controller;

import com.example.Bustime.Model.Pasajeros;
import com.example.Bustime.Services.Pasajeros_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pasajeros")
public class Pasajeros_Controller {

    @Autowired
    private Pasajeros_Service service;

    @GetMapping
    public List<Pasajeros> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pasajeros> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Pasajeros create(@RequestBody Pasajeros pasajero) {
        return service.create(pasajero);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pasajeros> update(@PathVariable Long id, @RequestBody Pasajeros pasajero) {
        return service.update(id, pasajero)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.delete(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
