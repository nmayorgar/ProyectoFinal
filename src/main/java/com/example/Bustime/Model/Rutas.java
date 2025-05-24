package com.example.Bustime.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Rutas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ruta;
    private String origen;
    private String destino;
    private Double distancia_km;
    private Integer duracion;
}
