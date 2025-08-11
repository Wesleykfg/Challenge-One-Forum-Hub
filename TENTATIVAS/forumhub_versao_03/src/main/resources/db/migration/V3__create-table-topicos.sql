create table topicos (
     id bigint not null auto_increment,
     titulo varchar(255) not null,
     mensagem text not null,
     status varchar(20) not null,
     data_criacao timestamp not null default current_timestamp,
     data_atualizacao timestamp not null default current_timestamp on update current_timestamp,
     usuario_id bigint not null,
     cursos_id bigint not null,
     primary key (id),
     foreign key (usuario_id) references usuarios(id),
     foreign key (cursos_id) references cursos(id)
 );