create database Televisãoo;
create table Programa (
idPrograma int primary key,
Nome varchar(40),
Gênero varchar (30),
Emissora varchar (20)
);

insert into Programa values ('101', 'Eliana', 'Auditório', 'SBT'),
                            ('102', 'MasterChef', 'Culinária', 'Band'),
                            ('103', 'Largados e Pelados', 'Reality', 'Discovery Channel'),
                            ('104', 'TV Globinho', 'Infantil', 'Rede Globo'),
                            ('105', 'Bom Dia & Cia', 'Infantil', 'SBT'),
                            ('106', 'Quintal da Cultura', 'Infantil', 'TV Cultura'),
                            ('107', 'Jogo Aberto', 'Esportivo', 'Band'),
                            ('108', 'Globo Esporte','Esportivo', 'Rede Globo'),
                            ('109', 'Jornal Nacional', 'Telejornal', 'Rede Globo'),
							('110', 'Jornal da Band', 'Telejornal', 'Band'),
                            ('111', 'Silvio Santos', 'Auditório', 'SBT'),
                            ('112', 'Domingo Espetacular', 'Jornalístico', 'RecordTV'),
                            ('113', 'Big Brother Brasil', 'Reality', 'Rede Globo');
select * from Programa;
select * from Programa where gênero = 'Esportivo';
select * from Programa order by nome desc;
select * from Programa where nome like '%a_';
update Programa set emissora = 'Fora do ar' where idPrograma ='104';
delete from programa where idprograma = '104';
insert into Programa values ('104', 'TV Globinho', 'Infantil', 'Rede Globo');
drop table programa;