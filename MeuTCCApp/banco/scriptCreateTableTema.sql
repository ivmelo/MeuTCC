CREATE TABLE `tema` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(256) DEFAULT NULL,
  `descricao` varchar(256) DEFAULT NULL,
  `idCurso` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- encontrar numero de candidatos registrados em um tema.
-- select count(usuario.`id`) as count from usuario join aluno_tema on aluno_tema.user_id = usuario.id where tema_id = 1;
