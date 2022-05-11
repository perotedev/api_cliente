-- Apagar o banco de dados
drop database db_cliente;
-- Criar o banco de dados
create database db_cliente;

-- Atribuir os privilégios de acesso aos objetos do banco para o usuário root
GRANT ALL PRIVILEGES ON db_cliente.* TO 'root'@'localhost';

-- Acesar o banco de dados
USE db_cliente;

-- Criar a tabela: cliente
CREATE TABLE cliente(
    id int AUTO_INCREMENT,
    id_endereco int,
    nome varchar(50) NOT NULL,
    cpf varchar(11) NOT NULL,
    sexo varchar(1) NOT NULL,
    nascimento date NOT NULL,
    enderecoId int NOT NULL,
    PRIMARY KEY (id) 
);

CREATE TABLE endereco(
    id int AUTO_INCREMENT ,
    cep varchar(8) NOT NULL,
    rua varchar(50) NOT NULL,
    bairro varchar(50) NOT NULL,
    numero int NOT NULL,
    cidade varchar(50) NOT NULL,
    uf varchar(2) NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE cliente ADD CONSTRAINT FK_EnderecoId FOREIGN KEY (enderecoId) REFERENCES endereco(id) ON DELETE RESTRICT ON UPDATE CASCADE;

