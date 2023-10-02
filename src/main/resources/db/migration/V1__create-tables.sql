set timezone to -3;

create table Entidade (
    id serial not null primary key,
    nome varchar(50) not null unique,
    cpf varchar (14) unique check ( cpf is not null and cnpj is null),
    cnpj varchar(18) unique check ( cnpj is not null and cpf is null),
    ie varchar(13) unique,
    email varchar(50) unique,
    telefone varchar(14) not null unique,
    cep varchar(10) not null,
    rua varchar(60) not null,
    numero int,
    complemento varchar(20),
    bairro varchar(40) not null,
    cidade varchar(40) not null,
    uf varchar(2) not null
);

create table Prestador (
    idPrestador int not null primary key references Entidade(id),
    senha varchar(100)
);
create unique index idx_prestador ON Prestador(idPrestador);

create table Cliente (
    idCliente int not null primary key references Entidade(id),
    ativo bool default true
);
create unique index idx_cliente on Cliente(idCliente);

create table TipoServico (
    id serial not null primary key,
    nome varchar(30)
);

create table Servico (
    id serial not null primary key,
    idPrestador int not null references Prestador(idPrestador),
    idCliente int not null references Cliente(idCliente),
    idTipo int not null references TipoServico(id),
    dataInicio timestamp default now(),
    dataFim timestamp default null,
    total float not null default 0,
    arquivado bool not null default false,
    descricao varchar(2000)
);

create table UnidadeMedida (
    id serial not null primary key,
    nome varchar(20) not null,
    nomeAbv varchar(3) unique not null
);

create table Item (
    id serial not null primary key,
    nome varchar(40) not null unique,
    descricao varchar(100),
    idUnidadeMedida int not null references UnidadeMedida(id)
);

create table PrecoItem (
    idItem int not null references Item(id),
    preco float not null default 0,
    data timestamp not null default now(),
    primary key (idItem, preco, data)
);

create table Item_Servico (
    idServico int not null references Servico(id),
    idItem int not null references Item(id),
    quantidade float not null default 1,
    subtotal float not null,
    primary key (idServico, idItem)
);