package com.treino.mok.model;

import lombok.*;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 60)
    private String login;

    @Column(length = 60)
    private String senha;
}
