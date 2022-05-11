package com.ifam.api_cliente.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(updatable = false, name = "cpf", unique = true)
    @NotBlank(message = "CPF é obrigatório")
    @Length(message = "No máximo 11 caracteres", max = 11)
    @CPF
    String cpf;

    @Column(name = "nome")
    @NotBlank(message = "Nome é obrigatório")
    @Length(message = "Nome com no máximo 50 caracteres", max = 50)
    String nome;

    @Column(name = "nascimento")
    Date nascimento;

    @Column(name = "sexo")
    @NotBlank(message = "Sexo é obrigatório")
    @Length(message = "No 1 caracter", max = 1)
    @Pattern(regexp = "[FM]")
    String sexo;

    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "enderecoId")
	Endereco endereco;

}
