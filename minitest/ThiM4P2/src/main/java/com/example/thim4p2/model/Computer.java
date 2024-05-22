package com.example.thim4p2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String codeComputer;

    String nameComputer;

    String producer;
    @ManyToOne()
    @JoinColumn(name = "id_loai_sp")
    TypeComputer typeComputer;


}
