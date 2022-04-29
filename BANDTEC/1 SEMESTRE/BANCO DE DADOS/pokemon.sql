create database ac2Mauricio;

use ac2Mauricio;

create table treinador (
idTreinador int primary key auto_increment,
nome varchar (40),
idade int,
cidade varchar (40),
insignias int check (insignias >= 0 and insignias <=8)   -- no desenho Pokemon só se é possível ter no máximo 8 insignias por treinador
)auto_increment = 10;

insert into treinador values (null, 'Ash', 10, 'Pallet', 3),
							 (null, 'Misty', 12, 'Cerulean City', 1),
                             (null, 'Brock', 14, 'Pewter City', 1);
                             
select * from treinador;
select sum(insignias) from treinador;

create table pokemon (
idPokemon int primary key auto_increment,
nome varchar (40),
tipo varchar (20),
medidaAltura decimal(4,2),    -- medida foi modelado como atributo composto
medidaLargura decimal(4,2),   -- 2 colunas: medidaAltura e medidaLargura
evolução1 varchar (20),       -- evolução foi modelado como atributo multivalorado
evolução2 varchar (20),       -- 2 colunas: evolução1 e evolução2
fkTreinador int,
foreign key(fkTreinador) references treinador(idTreinador)
) auto_increment = 100;


insert into pokemon values (null, 'Pikachu', 'elétrico', 0.4, 6.0, 'Raichu', 'Alolan Raichu', 10),
						   (null, 'Charmander', 'fogo', 0.6, 8.5, 'Charmeleon', 'Charizard', 10),
                           (null, 'Bulbasaur', 'selva', 0.7, 6.9, 'Ivysaur', 'Venusaur', 10),
                           (null, 'Squirtle', 'agua', 0.5, 9.0, 'Wartortle', 'Blastoise', 10),
                           (null, 'Krabby', 'agua', 0.4, 6.5, 'Kingler',null, 10),
                           
                           (null, 'Azurill', 'normal', 0.2, 2.0, 'Marill', 'Azumarill', 11),
                           (null, 'Togepi', 'fada', 0.3, 1.5, 'Torgetic', 'Togekiss', 11),
                           (null, 'Staryu', 'agua', 0.8, 34.5, 'Starmie', null,  11),
                           
                           (null, 'Bonsly', 'rocha', 0.5, 15.0, 'Sudowoodo', null, 12),
                           (null, 'Happiny', 'normal', 0.6, 24.4, 'Chansey', 'Blissey', 12),
                           (null, 'Croagunk', 'veneno', 0.7, 23.0, 'Toxicroak', null, 12);
                           
select * from pokemon;     

select * from pokemon, treinador where fkTreinador = idTreinador and tipo = 'agua';
                 
select sum(insignias) from treinador;                           

