package com.example.Bustime.Services;

import com.example.Bustime.Model.Pasajeros;
import com.example.Bustime.Repository.Pasajeros_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Pasajeros_Service {

    @Autowired
    private Pasajeros_Repository repository;

    public List<Pasajeros> getAll() {
        return repository.findAll();
    }

    public Optional<Pasajeros> getById(Long id) {
        return repository.findById(id);
    }

    public Pasajeros create(Pasajeros pasajero) {
        return repository.save(pasajero);
    }

    public Optional<Pasajeros> update(Long id, Pasajeros details) {
        return repository.findById(id).map(pasajero -> {
            pasajero.setNombre(details.getNombre());
            pasajero.setCorreo(details.getCorreo());
            pasajero.setTelefono(details.getTelefono());
            return repository.save(pasajero);
        });
    }

    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
