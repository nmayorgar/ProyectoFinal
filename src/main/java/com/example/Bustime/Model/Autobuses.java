package com.example.Bustime.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Autobuses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_bus;
    private String placa;
    private String modelo;
    private Integer capacidad;

    @ManyToOne
    @JoinColumn(name = "id_conductor", referencedColumnName = "id_conductor")
    private Conductores conductor;

}
