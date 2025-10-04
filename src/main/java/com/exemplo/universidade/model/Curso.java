package com.exemplo.universidade.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Integer cargaHoraria;
}