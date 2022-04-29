-- como estamos logados como usuário teste
-- não temos permissão para criar database 
-- o comando abaixo dará erro
create database teste;

-- o nosso usuárrio teste tem permissão de usar 
-- apenas o schema (database) exemplofilme
create table Filme (
	idFilme int primary key,
    titulo varchar (50),
    genero varchar (30),
    diretor varchar (40)
    );
    
    select * from Filme;
    
    -- exibe a estrutura da tabela 
desc Filme;
describe Filme;

-- inserir dado de um filme
insert into Filme values (1, 'A fuga das galinha', 'Infantil', 'Nick Park');

-- Inserir dado de outro filme, mas somente o id e o título
insert into Filme (idFilme, titulo) values (2, 'Crepúsculo');
insert into Filme (titulo, idFilme) values ('Pulp Fiction', 3),
										   ('Clube da Luta', 4);
                                           
-- Inserir dado de outro filme, mas somente o id, o titulo, e o genero
insert into Filme (idfilme, titulo, genero) values (5, 'Bastardos Inglórios', 'Ação'),
												   (6, 'Lua nova', 'Romance');
                                                   
select * from Filme;

-- Completar os dados da tabela que estão faltando
-- Para isso, não podemos usar o insert, pois o insert é usado para inseriri um novo registro
update Filme set diretor = 'Catherine Hardwicke' where idFilme = 2 or ifFilme = 6;
update Filme set diretor = 'Catherine Hardwicke' where idFilme in (2, 6);

-- Utilizando o update para alterar o valor de 2 campos de uma mesma linha
update Filme set genero = 'Drama', diretor = 'David Fincher' where idFilme = 4;
update Filme set diretor = 'Quentin Tarantino' where idFilme in (3, 5);
update Filme set genero = 'Romance' where idFilme = 2;
update Filme set genero = 'Drama policial' where idFilme = 3;
update Filme set titulo = 'Fuga das galinhas' where idFilme = 1;

-- Exibir os dados da tabela ordenados por uma ou mais colunas 
-- asc = ascendente (crescente)
-- desc = descendente (decrescente)
select * from Filme order by titulo;
select * from Filme order by diretor;
select * from Filme order by diretor asc, titulo desc;
select * from Filme order by diretor desc, titulo asc;

