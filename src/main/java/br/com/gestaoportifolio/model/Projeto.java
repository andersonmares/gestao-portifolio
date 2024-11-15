package br.com.gestaoportifolio.model;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.DecimalMin;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotNull
    private LocalDate dataInicio;

    @NotBlank
    private String gerente;

    private LocalDate previsaoTermino;

    private LocalDate dataRealTermino;

    @NotNull
    @DecimalMin("0.0")
    private BigDecimal orcamento;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private Status status;

}
