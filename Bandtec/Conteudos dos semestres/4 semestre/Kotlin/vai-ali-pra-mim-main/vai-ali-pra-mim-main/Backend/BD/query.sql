create table Usuario
(idUsuario int identity(1,1)primary key,
nomeCompleto varchar(60) NOT NULL,
CEP varchar(8) NOT NULL,
email varchar(50) NOT NULL,
senha varchar(8) NOT NULL,
complemento varchar(45) NOT NULL,
CPF varchar(11) NOT NULL,
telefone varchar(13) NOT NULL,
saldo float,
RG varchar(9),
fkEntregadorFavorito int NOT NULL foreign key references Usuario(idUsuario),
);

create table Cartao
(idCartao int identity(1,1)primary key,
numeroDoCartao varchar(16) NOT NULL,
tipo varchar(20) NOT NULL,
bandeira varchar(10) NOT NULL,
CVV varchar(4) NOT NULL,
cpfTitular varchar(11) NOT NULL,
dataValidade date NOT NULL,
fkUsuario int NOT NULL foreign key references Usuario(idUsuario),
);

create table Post
(idPost int identity(1,1)primary key,
titulo varchar(45) NOT NULL,
dataHora datetime NOT NULL,
descricao varchar(100) NOT NULL,
taxaDeEntrega float NOT NULL,
limiteQtdItem int NOT NULL,
localtarefa varchar(45) NOT NULL,
tempoEstimadoRealizacao time NOT NULL
);

create table UsuarioTemPost
(idUsuarioTemPost int identity(1,1)primary key,
fkUsuario int NOT NULL foreign key references Usuario(idUsuario),
fkPost int NOT NULL foreign key references Post(idPost)
);

create table Pedido
(idPedido int identity(1,1)primary key,
dataHora datetime NOT NULL,
taxaEntrega float NOT NULL,
estabelecimento varchar(45) NOT NULL,
fkUsuario int NOT NULL foreign key references Usuario(idUsuario),
);

create table Produto
(idProduto int identity(1,1)primary key,
nomeProduto varchar(45) NOT NULL,
valor float NOT NULL,
marca varchar(45) NOT NULL
);

create table ProdutoTemPedido
(idProdutoTemPedido int identity(1,1)primary key,
fkProduto int NOT NULL foreign key references Produto(idProduto),
fkPedido int NOT NULL foreign key references Pedido(idPedido)
);