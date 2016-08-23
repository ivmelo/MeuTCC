package br.ifrn.meutcc.persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.ifrn.meutcc.modelo.Orientador;

public class OrientadorDAOMySQL implements OrientadorDAO {

	private static OrientadorDAOMySQL instancia = null;
	private ConexaoMySQL conexao;
	
	private OrientadorDAOMySQL() {
		super();
		conexao = new ConexaoMySQL();
	}

	public static OrientadorDAOMySQL getInstancia() {
		if (instancia == null) {
			instancia = new OrientadorDAOMySQL();
		}
		return instancia;
	}
	
	@Override
	public Orientador getOrientadorPorTema(int idTema) {
		// TODO Auto-generated method stub
		Connection conn = conexao.getConexaoBD();
		if (conn != null) {
			try {
				Statement stListaOrientador = conn.createStatement();
				ResultSet rsOrientador = stListaOrientador.executeQuery("select orientador.id, usuario.nome, usuario.email, usuario.senha, usuario.matricula from usuario join orientador on orientador.idUsuario = usuario.id join tema on tema.idOrientador = orientador.id where tema.id = "+idTema);
				Orientador orientador = null;
				if (rsOrientador.next()) {
					orientador = new Orientador();
					orientador.setId(rsOrientador.getInt("id"));
					orientador.setNome(rsOrientador.getString("nome"));
					orientador.setEmail(rsOrientador.getString("email"));
					orientador.setSenha(rsOrientador.getString("senha"));
					orientador.setMatricula(rsOrientador.getString("matricula"));
				}
				return orientador;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
		
	}

}