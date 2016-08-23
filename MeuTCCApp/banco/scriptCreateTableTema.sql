CREATE TABLE `tema` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(256) DEFAULT NULL,
  `descricao` varchar(256) DEFAULT NULL,
  `idCurso` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- encontrar numero de candidatos registrados em um tema.
select count(usuario.`id`) as count from usuario join aluno_tema on aluno_tema.user_id = usuario.id where tema_id = 1;

-- query para saber se um candidato já se registrou a um tema.
-- retorna 1 caso positivo, 0 caso negativo
select count(usuario.`id`) as count from usuario join aluno_tema on aluno_tema.user_id = usuario.id where tema_id = 2 and usuario.id = 1;

-- query para adicionar candidato a tema
insert into aluno_tema (user_id, tema_id) values (1, 3);

-- query para pegar orientador a partir do id do tema
select * from usuario 
join orientador on orientador.idUsuario = usuario.id
join tema on tema.idOrientador = orientador.id
where tema.id = 3;

-- query acima apenas com campos relevantes
select orientador.id, usuario.nome, usuario.email, usuario.senha, usuario.matricula 
from usuario 
join orientador on orientador.idUsuario = usuario.id 
join tema on tema.idOrientador = orientador.id 
where tema.id = 1