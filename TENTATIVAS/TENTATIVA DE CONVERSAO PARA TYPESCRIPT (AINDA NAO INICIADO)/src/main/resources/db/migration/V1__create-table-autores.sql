create table autores(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    perfil varchar(100) not null,
    ativo tinyint,

    primary key(id)

);