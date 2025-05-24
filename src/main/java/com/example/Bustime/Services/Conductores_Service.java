package com.example.Bustime.Services;

import com.example.Bustime.Model.Conductores;
import com.example.Bustime.Repository.Conductores_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Conductores_Service {

    @Autowired
    private Conductores_Repository repository;

    public List<Conductores> getAll() {
        return repository.findAll();
    }

    public Optional<Conductores> getById(Integer id) {
        return repository.findById(id);
    }

    public Conductores create(Conductores conductor) {
        return repository.save(conductor);
    }

    public Optional<Conductores> update(Integer id, Conductores details) {
        return repository.findById(id).map(conductor -> {
            conductor.setNombre(details.getNombre());
            conductor.setLicencia(details.getLicencia());
            conductor.setTelefono(details.getTelefono());
            return repository.save(conductor);
        });
    }

    public boolean delete(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
