create database Revista;
create table Revista (
idRevista int primary key auto_increment,
nome varchar (40),
categoria varchar (30)
);
insert into Revista (idRevista,nome) values (null, 'Recreio'),
											(null, 'Época'),
                                            (null, 'Tititi'),
                                            (null, 'Viva Mais');
select * from Revista;
desc Revista;
update Revista set categoria = 'Infantil' where idRevista = 1;
update Revista set categoria = 'Notícias' where idRevista = 2;
update Revista set categoria = 'Telenovelas' where idRevista = 3;

insert into Revista values (null, 'IstoÉ', 'Notícias'),(null, 'Ana Maria','Moda'),(null, 'Caras','Celebridades');

desc Revista;

alter table Revista modify column categoria varchar(40);

alter table Revista add periodicidade varchar(15);
alter table Revista drop column periodicidade; 

create table Editora (
idEditora int primary key auto_increment,
nomeEditora varchar (40),
dataFund date
)auto_increment = 1000;

insert into Editora values (null, 'Abril', '1950-05-10'),
						   (null, 'Globo', '1986-07-02'),
                           (null, 'Símbolo', '1987-12-01');
                           
select * from Editora;
