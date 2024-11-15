package br.com.gestaoportifolio.model;

import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;

@Entity
public class Membro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String atribuicao;

    @ManyToOne
    private Projeto projeto;

}
