insert into funcionarios (id, nome, salario, departamento) values (1, 'Fernando', 1400, 'TI');
insert into funcionarios (id, nome, salario, departamento) values (2, 'Guilherme', 2500, 'analista junior');
insert into funcionarios (nome, salario, departamento) values ('Fabio', 3700, 'analista pleno');
insert into funcionarios (id, nome, salario, departamento) values (4, 'Ana', 6300, 'gerente');
insert into funcionarios (nome, salario, departamento) values ('Douglas', 1400, 'estagiario');

select * from funcionarios;
select * from funcionarios where salario > 2000;
select * from funcionarios where id = 2;

update funcionarios set salario = salario * 1.1 where id = 1;

update funcionarios set departamento = 'estagiario' where id = 1;

set sql_safe_updates = 0;
/* set sql_safe_updates = 1; */
update funcionarios set salario = salario * 1.1;

update funcionarios set salario = round(salario * 1.1, 2);

delete from funcionarios where id = 4;

insert into veiculos (funcionario_id, veiculo, placa) values (1, 'carro', 'SB-0001');
insert into veiculos (funcionario_id, veiculo, placa) values (1, 'carro', 'SB-0002');

select * from veiculos;

update veiculos set funcionario_id = 5 where id = 2;

insert into salarios (faixa, inicio, fim) values ('estagiario', 1000, 2000);
insert into salarios (faixa, inicio, fim) values ('analista junior', 2500, 3500);
insert into salarios (faixa, inicio, fim) values ('analista pleno', 4000, 5000);

select * from salarios;
select * from funcionarios f where salario > 3000;
select nome, salario from funcionarios f where f.salario > 3000;
select nome AS 'funcionario', salario from funcionarios f where f.salario > 3000;

select * from funcionarios where nome = 'Guilherme'
union
select * from funcionarios where id = 5;

select * from funcionarios where nome = 'Guilherme'
union all
select * from funcionarios where nome = 'Guilherme';