create database Sprint1;
create table Health_Analytics (id int primary key,
                              nome varchar (40),
                              valor int  );
                              
insert into Health_Analytics values (1, 'Mauricio Santana dos Santos', '1'),
                                    (2, 'Vivian Silva', '2');
select * from Health_Analytics;
select * from Health_Analytics where nome like '%a';
update Health_Analytics set nome = 'Professora Vivian' where id = 2;
delete from Health_Analytics where id = 2;