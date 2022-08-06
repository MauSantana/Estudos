create database musicas;
use musicas;
create table Musica (
idMusica int primary key auto_increment,
titulo varchar (40),
Artista varchar (40),
Gênero varchar (40)
)auto_increment = 100;
insert into Musica values
                           (null, 'Leal', 'Djonga', 'Rap'),
                           (null, 'Solto', 'Djonga', 'Rap'),
						   (null, 'Bené', 'Djonga', 'Rap'),
                           (null, 'Bença', 'Djonga', 'Rap'),
                           (null, 'Falcão', 'Djonga', 'Rap'),
                           (null, 'Sensasional', 'Huzz', 'Trap'),
                           (null, 'Temperamento mortal', 'Huzz', 'Trap'),
                           (null, 'Te amar demais', 'Sodré', 'Acústico'),
                           (null, 'Amor de gelo', 'San Joe', 'Rap'),
                           (null, 'Repeito é pra quem tem', 'Sabotage', 'Rap'),
                           (null, 'Rap é compromisso', 'Sabotage', 'Rap'),
                           (null, 'Saudades do tempo', 'Maneva', 'Reggae'),
                           (null, 'Cabelo Pixain', 'Maneva', 'Reggae');

select * from Musica;


create table Album (
idAlbum int primary key auto_increment,
nome varchar (40),
gravadora varchar (40)
)auto_increment= 10;

insert into Album values   (null,'Ladrão','MACACOLAB' ),
						   (null,'Pankas','MafiaEternum'),
						   (null,'Love', 'Pineapple'),
                           (null,'Um bom lugar', 'Maestro do Canão'),
                           (null,'Tempo de Paz', 'Universal Music Group');
                           
select * from Album;
                           
alter table Musica add fkAlbum int; 
alter table Musica add foreign key(fkAlbum) references Album (idAlbum);          

update Musica set fkAlbum = 10 where idMusica <= 104;
update Musica set fkAlbum = 11 where idMusica = 105 and 106;
update Musica set fkAlbum = 12 where idMusica = 107 and 108;
update Musica set fkAlbum = 13 where idMusica = 109 and 110;
update Musica set fkAlbum = 14 where idMusica = 111 and 112;

select Musica.*, Album.nome, gravadora from Musica, Album where fkAlbum = idAlbum;
select Musica.*, Album.nome, gravadora from Musica, Album where fkAlbum = idAlbum and gravadora = 'MafiaEternum';


select atleta.*, Pais.nome, capital from atleta, Pais where fkPais = idPais and Pais.nome= 'Brasil';

