create database atletas;
use atletas;
create table Pais (
idPais int primary key auto_increment,
nome varchar (40),
capital varchar (40)
)auto_increment = 1000;

insert into Pais (nome, capital) values 
('Brasil', 'Brasília'),
('EUA', 'Washington'),
('Rússia', 'Moscou'),
('Jamaica', 'Kingston'),
('Finlândia', 'Helsinque');

select * from Pais;

create table atleta (
idAtleta int primary key auto_increment,
nome varchar (40),
modalidade varchar (40),
qtdMedalha int,
fkPais int,
foreign key(fkPais) references Pais(idPais)
) auto_increment = 100;
                                  
insert into atleta (nome, modalidade, qtdMedalha, fkPais) values 
('Neymar da Silva Santos Junior', 'Futebol', 3, 1000),
('Gustavo Borges', 'Natação', 4, 1000),
('Sérgio Dutra Borges', 'Vôlei', 4, 1000),
('Michael Phelps', 'Natação', 28, 1001),
('Larissa Latynina', 'Ginástica Artística', 18, 1002),
('Usain Bolt', 'Atletismo', 9, 1003),
('Paavo Nurmi', 'Atletismo', 12, 1004),
('Robert Scheidt', 'Vela', 5, 1000);

select * from atleta;

-- Exibir os dados dos atletas correspondentes, sem duplicar o fkCurso/idCurso
select atleta.*, Pais.nome, capital from atleta, Pais where fkPais = idPais;

-- Exibir os dados dos atletas correspondentes, porém somente de um determinado país
select atleta.*, Pais.nome, capital from atleta, Pais where fkPais = idPais and Pais.nome= 'Brasil';


-- FIM PRIMEIRO DATABASE---------------------------------





