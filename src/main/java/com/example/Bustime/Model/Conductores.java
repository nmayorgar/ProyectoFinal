package com.example.Bustime.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Conductores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_conductor;
    private String nombre;
    private String licencia;
    private String telefono;
}
