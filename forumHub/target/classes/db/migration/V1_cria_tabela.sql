create table topicos(
 id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensagem varchar(500) not null unique,
    dataCriacao date not null,
    status varchar(100),
    autor varchar(200),
    curso varchar(100),
    respostas varchar(500)
    )