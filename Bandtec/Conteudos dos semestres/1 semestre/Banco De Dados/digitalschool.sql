create database digitalschool;
use digitalschool;
-- Criação da tabela curso, que será referenciada pela fkcurso da tabela aluno
-- Por isso, a tabela curso deve ser criada primeiro
create table Curso (
	idCurso int primary key auto_increment,
	nomeCurso char (5),
	coordenador varchar (15)
)auto_increment = 100;
-- Criação da tabela Aluno, já configurando uma coluna como fkCurso
create table Aluno (
	ra int primary key auto_increment,
    nomeAluno varchar(40),
    bairro varchar(30),
    fkCurso int,
    foreign key(fkCurso) references Curso(idCurso)
    ) auto_increment = 50000;
-- Inserção de dados da tab Curso
insert into Curso (nomeCurso, coordenador) values ('ADS', 'Gerson'),
												  ('CCO', 'Marise'),
                                                  ('Redes', 'ALEX');
select * from Aluno;
select * from Curso;

-- Inserção de dados da tab Aluno
insert into Aluno (nomeAluno, bairro, fkCurso) values ('Maria','Paraíso', 100),
                                                      ('João', 'Consolação', 101),
                                                      ('Mickey', 'Disney', 100),
                                                      ('Pateta', 'Florida', 102);
                                                      
-- Como a tabela curso esta sendo referenciada pela tabela Aluno, não é possivel
-- "dropar" a tabela Curso, a não ser que a tabela Aluno seja "dropada" antes
drop table Curso;

-- JEITO ERRADO DE FAZER
select * from Aluno,Curso;
-- JEITO CERTO DE FAZER 
select * from Aluno, Curso where fkCurso = idCurso;

-- Exibir os dados dos alunos e do curso correspondente, mas somente do curso 'ADS'
select * from Aluno, Curso where fkCurso = idCurso and nomeCurso= 'ADS';

-- Exibir os dados dos alunos e do curso correspondente, mas sem repetir a informação do idCurso
select Aluno.*, nomeCurso, coordenador from Aluno, Curso where fkCurso = idCurso and nomeCurso= 'ADS';
