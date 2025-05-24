package com.example.Bustime.Services;

import com.example.Bustime.Model.Horarios;
import com.example.Bustime.Repository.Horarios_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Horarios_Service {

    @Autowired
    private Horarios_Repository repository;

    public List<Horarios> getAll() {
        return repository.findAll();
    }

    public Optional<Horarios> getById(Integer id) {
        return repository.findById(id);
    }

    public Horarios create(Horarios horario) {
        return repository.save(horario);
    }

    public Optional<Horarios> update(Integer id, Horarios details) {
        return repository.findById(id).map(horario -> {
            horario.setRuta(details.getRuta());
            horario.setBus(details.getBus());
            horario.setSalida(details.getSalida());
            horario.setLlegada(details.getLlegada());
            horario.setDia_semana(details.getDia_semana());
            return repository.save(horario);
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
