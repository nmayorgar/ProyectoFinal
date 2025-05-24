package com.example.Bustime.Services;

import com.example.Bustime.Model.Autobuses;
import com.example.Bustime.Repository.Autobuses_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Autobuses_Service {

    @Autowired
    private Autobuses_Repository repository;

    public List<Autobuses> getAll() {
        return repository.findAll();
    }

    public Optional<Autobuses> getById(Integer id) {
        return repository.findById(id);
    }

    public Autobuses create(Autobuses bus) {
        return repository.save(bus);
    }

    public Optional<Autobuses> update(Integer id, Autobuses details) {
        return repository.findById(id).map(bus -> {
            bus.setPlaca(details.getPlaca());
            bus.setModelo(details.getModelo());
            bus.setCapacidad(details.getCapacidad());
            bus.setConductor(details.getConductor());
            return repository.save(bus);
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
