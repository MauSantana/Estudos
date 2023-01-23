create database curso_sql;

use curso_sql;
create table funcionarios
(
	id int unsigned not null auto_increment,
    nome varchar(45) not null,
    salario double not null default '0',
    departamento  varchar(45) not null,
    primary key (id)
);

create table veiculos 
(
	id int unsigned not null auto_increment,
    funcionario_id int unsigned default null,
    veiculo varchar(45) not null default '',
    placa varchar(10) not null default '',
    primary key (id),
    constraint fk_veiculos_funcionarios foreign key (funcionario_id) references funcionarios (id)
);

create table salarios
(
	faixa varchar(45) not null,
    inicio double not null,
    fim double not null,
    primary key (faixa)
);

alter table funcionarios change column nome  nome_func varchar (50) not null;
alter table funcionarios change column nome_func nome varchar (45) not null;

drop table salarios;

create index departamentos on funcionarios (departamento);
create index nomes on funcionarios (nome(6));

CREATE TABLE ACESSORIOS (
  ID int unsigned NOT NULL,
  VALOR double NOT NULL default '0',
  FORNECEDOR varchar(45) NOT NULL,
  PRIMARY KEY (ID)
);

CREATE TABLE EMBLEMAS (
  ID int NOT NULL,
  FORNECEDOR varchar(45) NULL,
  EMBLEMA varchar(10) NOT NULL,
  VALOR double NOT NULL default '0',
  PRIMARY KEY (ID)
);


