create database Musica;
create table Músicas (
idMúsica int primary key,
Título varchar (40),
Artista varchar (40),
Gênero varchar (40)
);
insert into Músicas values
                           (100, 'Leal', 'Djonga', 'Rap'),
                           (101, 'Solto', 'Djonga', 'Rap'),
                           (102, 'Sensasional', 'Huzz', 'Trap'),
                           (103, 'Temperamento mortal', 'Huzz', 'Trap'),
                           (104, 'Te amar demais', 'Sodré', 'Acústico'),
                           (105, 'Amor de gelo', 'San Joe', 'Rap'),
                           (106, 'Senho do tempo', 'Charlie Brown Jr', 'Rock'),
                           (107, 'Saudades do tempo', 'Maneva', 'Reggae'),
                           (108, 'Bença', 'Djonga', 'Rap'),
                           (109, 'Repeito é pra quem tem', 'Sabotage', 'Rap'),
                           (110, 'Canção pro tempo', 'Projota', 'Rap'),
                           (111, 'Flack Jack', 'Recayd Mob', 'Trap'),
                           (112, 'Rap é compromisso', 'Sabotage', 'Rap'),
                           (113, 'Meu novo mundo', 'Charlie Brown Jr', 'Rock'),
                           (114, 'Do for love', '2pac', 'Rap'),
                           (115, 'Gostava tanto de você', 'Tim Maia', 'MPB'),
                           (116, 'Griot', 'Marechal', 'Rap'),
                           (117, 'Captain', 'Wiz Khalifa', 'Rap'),
                           (118, 'Tira de giro', 'MC Hariel', 'Funk'),
                           (119, 'Capital das notas', 'MC Menor MR', 'Funk'),
                           (120, 'Face oculta', 'Trilha sonora do Gueto', 'Rap');
select * from Músicas;
select * from Músicas where Título like '%a_';
drop table Músicaas;
drop table Músicas;
				