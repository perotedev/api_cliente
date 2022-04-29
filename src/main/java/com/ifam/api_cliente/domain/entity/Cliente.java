package com.ifam.api_cliente.domain.entity;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cliente")
public class Cliente {
    @Id
    @Column(updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "cpf")
    @NotBlank(message = "CPF é obrigatório")
    @Length(message = "No máximo 11 caracteres", max = 11)
    String cpf;

    @Column(name = "nome")
    @NotBlank(message = "Nome é obrigatório")
    @Length(message = "No máximo 100 caracteres", max = 100)
    String nome;

    @Column(name = "sexo")
    @NotBlank(message = "Sexo é obrigatório")
    @Length(message = "No 1 caracter", max = 1)
    String sexo;

    @Column(name = "data_nascimento")
    @NotNull(message = "Data de Nascimento é obrigatório")
    Date data_nascimento;
}
