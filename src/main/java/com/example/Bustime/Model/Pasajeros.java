package com.example.Bustime.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pasajeros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pasajero;
    private String nombre;
    private String correo;
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "id_ruta", referencedColumnName = "id_ruta")
    private Rutas rutas;

}
