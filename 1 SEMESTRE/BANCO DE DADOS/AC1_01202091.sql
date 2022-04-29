create database AC1__01202091;
create table Clientes (
Contrato int primary key,
Nome varchar (60),
Email varchar (40),
CPF char (11),
Telefone varchar (14),
Bairro varchar (40)
);
insert into Clientes values (100, 'Marcos Alonso Ferreira', 'Alonsoferreira@gmail.com', '44359841202', '(11)23569852', 'Grajaú'),
                     (101, 'Carlos Henrique', 'Carlos.1221@gmail.com', '48552452336', '(11)26956847', 'Sapopemba'),
                     (102, 'Mauricio Ramos', 'Ramos3784@hotmail.com', '44322123220', '(11)24561021', 'Brasilândia'),
                     (103, 'Luiz Eduardo Ramalho', 'Eduramalho@yahoo.com.br', '40025185232', '(11)25263221', 'Cambuci'),
					 (104, 'Matheus Ramalho de Jesus', 'Mmmjesus@gmail.com', '43458465802', '(11)25215484', 'Grajaú'),
                     (105, 'Pedro Ricardo Santos', 'Pedrorsrs@hotmail.com', '42356584201', '(11)25144758', 'Vila Matilde');
select * from clientes;

select * from clientes order by nome desc;
select nome from clientes;

select * from clientes where bairro like '%a';
select * from clientes where nome like 'm%';
select * from clientes where bairro like '%d_';
update clientes set bairro = 'Cambuci' where contrato = 100;
delete from clientes where contrato = 100;




                     