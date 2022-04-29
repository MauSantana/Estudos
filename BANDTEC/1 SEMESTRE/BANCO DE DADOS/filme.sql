-- Como estamos logados como usuário teste
-- não temos permissão para criar database
-- o comando abaixo dará erro
create database teste;

-- o nosso usuário teste tem permissão de usar
-- apenas o schema (database) exemplofilme
use exemplofilme;
create table Filme (
   idFilme int primary key,
   titulo varchar(50),
   genero varchar(30),
   diretor varchar(40)
   );
select * from Filme;
-- exibe a estrutura da tabela
desc Filme;
describe Filme;
desc filme;

-- Inserir dado de um filme
insert into Filme values (1, 'Fuga das Galinhas', 'Infantil', 'Nick Park');

-- Inserir dado de outro filme, mas somente o id e o título
insert into Filme (idFilme, titulo) values (2, 'Crepúsculo');
insert into Filme (titulo, idFilme) values ('Pulp Fiction', 3),
                                           ('Clube da Luta', 4);
-- Inserir dado de outro filme, mas somente o id, o titulo, e o genero
insert into Filme (idFilme, titulo, genero) values (5, 'Bastardos Inglórios', 'Ação'),
                                                   (6, 'Lua Nova', 'Romance');
select * from Filme;                                                   

-- Completar os dados da tabela que estão faltando
-- Para isso, não podemos usar o insert, pois o insert é usado para inserir um novo registro
update Filme set diretor = 'Catherine Hardwicke' where idFilme = 2 or idFilme = 6;
update Filme set diretor = 'Catherine Hardwicke' where idFilme in (2, 6); 

-- Utilizando o update para alterar o valor de 2 campos de uma mesma linha
update Filme set genero = 'Drama', diretor = 'David Fincher' where idFilme = 4; 

update Filme set diretor = 'Quentin Tarantino' where idFilme in (3, 5);
update Filme set genero = 'Romance' where idFilme = 2;
update Filme set genero = 'Drama policial' where idFilme = 3; 

-- Exibir os dados da tabela ordenados por uma ou mais colunas
select * from Filme order by titulo;
select * from Filme order by diretor;
select * from Filme order by diretor, titulo;
select * from Filme order by diretor asc, titulo desc;
-- asc = ascendente (crescente, alfabetico)   
-- desc = descendente (decrescente, ordem inversa à alfabetica)
select * from Filme order by diretor desc, titulo asc;

-- Criação de uma nova tabela, para o uso do auto_increment
create table Pessoa (
   idPessoa int primary key auto_increment,
   nome varchar(50),
   dataNascimento date
);
select * from Pessoa;
desc Pessoa;
-- Inserindo dados com o auto_increment
-- Se não especificar os campos que estão sendo inseridos, devemos colocar null no lugar do idPessoa
insert into Pessoa values (null, 'Ana Sousa', '2000-03-10'),
                          (null, 'Mario Bros', '1990/10/02');

insert into Pessoa values (0, 'Claudio Ramos', '1995-03-01');

insert into Pessoa (nome, dataNascimento) values ('Maria da Silva', '2001-12-08'),
                                                 ('Fulano Teixeira', '2002-01-13');                           

delete from Pessoa where idPessoa >= 6; 
insert into Pessoa (nome, dataNascimento) values ('Mickey', '1950-11-10');                         
   
insert into Pessoa values (6, 'Pateta', '1955-05-10'); 
insert into Pessoa values (12, 'Minnie', '1960-02-01');
select * from Pessoa;
insert into Pessoa values (null, 'Pluto', '1956-03-15');
-- configurando o número inicial do auto_increment de uma tabela que já existe 
alter table Pessoa auto_increment = 20; 
-- RA da Bandtec
-- 2 primeiros dígitos são o curso, sendo 01 = ADS, 02 = CCO
-- 3 prox digitos são o ano que vc entrou e o semestre que vc entrou : 202
-- 3 ultimos digitos é sequencial a partir da matricula
-- período letivo atual é 20202

-- Criando tabela com auto_increment, mas especificando o número inicial do auto_increment
-- no momento da criação da tabela]
-- Preço do produto máximo 1000,00 - 6 dígitos no total e 2 após a vírgula - 9999,99
-- decimal (4,2)    99,99
create table Produto (
  idProduto int primary key auto_increment,
  nome varchar(40),
  preco decimal(6,2)
) auto_increment = 100;
insert into Produto values (null, 'Notebook HP', 3000),
                           (null, 'Mouse Logitech', 60.99);
select * from Produto;                           
  
-- Alterar o nome de uma coluna
-- Qualquer versão do MySQL
alter table Pessoa change nome nomePessoa varchar(40);
-- Versões posteriores ao MySQL 8.0
alter table Pessoa rename column nomePessoa to nome; 

desc Pessoa;
-- comandos DML e DDL
-- comandos DDL - Data Definition Language - grupo de comandos usados para definir ou alterar
-- a estrutura da tabela (create table, drop table, alter table)
-- comandos DML - Data Manipulation Language - grupo de comandos usados para modificar os dados da tabela
-- comandos DML: insert, delete, update, select   
   
-- Alterar o tamnho da coluna sem renomear a coluna - os 2 comandos abaixo são equivalentes
alter table Pessoa modify nomePessoa varchar(70);
alter table Pessoa modify column nomePessoa varchar(70);   
desc Pessoa;   
 
-- Acrescentar uma coluna nova em uma tabela já existente
alter table Pessoa add sexo char(1); 
alter table Pessoa add column sexo char(1); 
   
select * from Pessoa; 

-- Remover a coluna que acabamos de acrescentar
alter table Pessoa drop sexo;
alter table Pessoa drop column sexo; 

select * from Pessoa order by dataNascimento; 
   