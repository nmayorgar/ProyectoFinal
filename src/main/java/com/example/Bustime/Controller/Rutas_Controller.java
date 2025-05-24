package com.example.Bustime.Controller;

import com.example.Bustime.Model.Rutas;
import com.example.Bustime.Repository.Rutas_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rutas")
public class Rutas_Controller {

    @Autowired
    private Rutas_Repository rutasRepository;

    @GetMapping
    public List<Rutas> getAllRutas() {
        return rutasRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rutas> getRutaById(@PathVariable Integer id) {
        Optional<Rutas> ruta = rutasRepository.findById(id);
        return ruta.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Rutas create(@RequestBody Rutas ruta) {
        return rutasRepository.save(ruta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rutas> updateRuta(@PathVariable Integer id, @RequestBody Rutas rutaDetails) {
        Optional<Rutas> rutaOptional = rutasRepository.findById(id);

        if (rutaOptional.isPresent()) {
            Rutas ruta = rutaOptional.get();
            ruta.setOrigen(rutaDetails.getOrigen());
            ruta.setDestino(rutaDetails.getDestino());
            ruta.setDistancia_km(rutaDetails.getDistancia_km());
            ruta.setDuracion(rutaDetails.getDuracion());
            return ResponseEntity.ok(rutasRepository.save(ruta));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRuta(@PathVariable Integer id) {
        if (rutasRepository.existsById(id)) {
            rutasRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

