create table topicos(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    mensagem varchar(500) not null unique,
    data datetime not null,
    autor_id bigint not null,
    curso_id bigint not null,
    ativo tinyint,
    primary key (id),

    constraint fk_consultas_autor_id foreign key(autor_id) references autores(id),
    constraint fk_consultas_curso_id foreign key(curso_id) references cursos(id)

);