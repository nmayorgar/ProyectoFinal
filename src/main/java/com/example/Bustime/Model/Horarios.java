package com.example.Bustime.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Horarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_horario;
    private LocalTime salida;
    private LocalTime llegada;
    private String dia_semana;

    @ManyToOne
    @JoinColumn(name = "id_ruta", referencedColumnName = "id_ruta")
    private Rutas ruta;

    @ManyToOne
    @JoinColumn(name = "id_bus", referencedColumnName = "id_bus")
    private Autobuses bus;


}
