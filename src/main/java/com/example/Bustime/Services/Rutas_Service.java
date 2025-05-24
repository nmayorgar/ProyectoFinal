package com.example.Bustime.Services;

import com.example.Bustime.Model.Rutas;
import com.example.Bustime.Repository.Rutas_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Rutas_Service {

    @Autowired
    private Rutas_Repository rutasRepository;

    public List<Rutas> getAllRutas() {
        return rutasRepository.findAll();
    }

    public Optional<Rutas> getRutaById(Integer id) {
        return rutasRepository.findById(id);
    }

    public Rutas create(Rutas ruta) {
        return rutasRepository.save(ruta);
    }

    public Optional<Rutas> updateRuta(Integer id, Rutas rutaDetails) {
        return rutasRepository.findById(id).map(ruta -> {
            ruta.setOrigen(rutaDetails.getOrigen());
            ruta.setDestino(rutaDetails.getDestino());
            ruta.setDistancia_km(rutaDetails.getDistancia_km());
            ruta.setDuracion(rutaDetails.getDuracion());
            return rutasRepository.save(ruta);
        });
    }

    public boolean deleteRuta(Integer id) {
        if (rutasRepository.existsById(id)) {
            rutasRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

