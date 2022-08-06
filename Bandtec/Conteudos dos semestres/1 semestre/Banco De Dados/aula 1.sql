create database aluno;
use aluno;
-- isso é um comentário
-- criação da tabela aluno
create table aluno (
  ra int primary key,  -- ra é a chave primária da tabela aluno
  nome varchar(50),
  bairro varchar(40)
);
  -- se criou a tabela com nome "aluco", como renomear ?
alter table aluco rename to aluno;
  -- ou também é possivel excluir a tabela aluco, e refazer com o nome certo
drop table aluco;
  -- exibir os dados da tabela
  select * from aluno;
  -- exibir apenas a coluna nome da tabela aluno
  select ra from aluno;
  -- exibir apenas a coluna nome da tabela aluno
  select nome from aluno;
  -- exibir apenas as colunas ra e nome
  select ra, nome from aluno;
  -- exibir apenas as colunas nome e ra
  select nome, ra from aluno;
  
  -- inserir dados de um aluno no banco
  insert into aluno values (01202091, 'Mauricio', 'Vila Progresso');
  
  -- inserir dados de mais alunos
  insert into aluno values (01202086, 'Luiz Gustavo', 'Jardim Primavera'),
						   (01202023, 'Lais', 'Umuarama'),
                           (01203086, 'Luiz Fernando', 'Jd.Iracema'),
                           (01202003, 'Caio', 'Taboão'),
                           (01202099, 'Vinícius', 'Pirituba'),
                           (01202079, 'Jorge Uliam', 'Parque Casa da Pedra');
                           
-- exibir os dados dos alunos do bairro Pirituba
select * from aluno where bairro = 'pirituba';
-- exibir os dados dos alunos de RA > 01202030
select * from aluno where ra > 01202030;
-- o mesmo vale para >=, <, <=

-- exibir tabela aluno ordenada pelo nome
select * from aluno order by nome;	
-- exibir tabela aluno ordenada pelo bairro			     
select * from aluno order by bairro;
-- exibir tabela aluno ordenada pelo nome, em ordem decrescente
select * from aluno order by nome desc;
-- exibir os dados dos alunos cujo nome comece com a letra L 
select * from aluno where nome like 'L%'; 
-- exibir os dados dos alunos cujo nome termine com a letra O  
select * from aluno where nome like '%O';
-- exibir os dados doa alunos cujo nome tenha a letra U com segunda letra
select * from aluno where nome like '_u%'; 
-- idem para 3° letra do nome = i
select * from aluno where nome like '__i%';
-- idem para bairro com penultima letra = m
select * from aluno where bairro like '%m_';

-- Alterar o bairro do Mauricio para 'Alphaville'
update aluno set bairro = 'Alphaville' where ra = 01202091;
  
-- Excluir um aluno
delete from aluno where ra = 1202079;
  
-- Excluir a tabela aluno
drop table aluno;

-- Excluir banco de dados aluno
drop database aluno;




