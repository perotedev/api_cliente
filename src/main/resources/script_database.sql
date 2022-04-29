-- Apagar o banco de dados
drop database db_cliente;
-- Criar o banco de dados
create database db_cliente;
-- Atribuir os privilégios de acesso aos objetos do banco
-- para o usuário root
GRANT ALL PRIVILEGES ON db_cliente.* TO 'root' @'localhost';
-- Acesar o banco de dados: db_cliente
USE db_cliente;
-- Criar a tabela: cliente
CREATE TABLE cliente(
    id int AUTO_INCREMENT,
    cpf varchar(20) NOT NULL,
    nome varchar(50) NOT NULL,
    sexo char NOT NULL,
    data_nascimento date NOT NULL,
    PRIMARY KEY (id)
);