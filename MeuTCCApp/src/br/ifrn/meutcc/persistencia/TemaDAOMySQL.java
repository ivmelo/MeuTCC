package br.ifrn.meutcc.persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ifrn.meutcc.modelo.Tema;

public class TemaDAOMySQL implements TemaDAO {
	private static TemaDAOMySQL instancia = null;
	private ConexaoMySQL conexao;
	
	private TemaDAOMySQL() {
		super();
		conexao = new ConexaoMySQL();
	}

	public static TemaDAO getInstancia() {
		if (instancia == null) {
			instancia = new TemaDAOMySQL();
		}
		return instancia;
	}
	
	public List<Tema> listTemas(int idCurso) {
		Connection conn = conexao.getConexaoBD();
		if (conn != null) {
			try {
				Statement stListaTema = conn.createStatement();
				ResultSet rsTemas = stListaTema.executeQuery("SELECT * FROM tema as t WHERE t.idCurso = "+idCurso);
				List<Tema> temas = new ArrayList<Tema>();
				while (rsTemas.next()) {
					Tema tema = new Tema();
					tema.setId(rsTemas.getInt("id"));
					tema.setTitulo(rsTemas.getString("titulo"));
					tema.setDescricao(rsTemas.getString("descricao"));
					temas.add(tema);
				}
				return temas;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return null;
	}
	
	public Tema getTema(int idTema) {
		Connection conn = conexao.getConexaoBD();
		if (conn != null) {
			try {
				Statement stListaTema = conn.createStatement();
				ResultSet rsTemas = stListaTema.executeQuery("SELECT * FROM tema as t WHERE t.id = "+idTema);
				Tema tema = null;
				if (rsTemas.next()) {
					tema = new Tema();
					tema.setId(rsTemas.getInt("id"));
					tema.setTitulo(rsTemas.getString("titulo"));
					tema.setDescricao(rsTemas.getString("descricao"));
				}
				return tema;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public int countCandidatos(int idTema) {
		
		Connection conn = conexao.getConexaoBD();
		if (conn != null) {
			try {
				Statement stCountCandidatos = conn.createStatement();
				ResultSet rsCountCandidatos = stCountCandidatos.executeQuery("select count(usuario.`id`) as numCandidatos from usuario join aluno_tema on aluno_tema.user_id = usuario.id where tema_id = "+idTema);
				int countCandidatos = -1;
				if (rsCountCandidatos.next()) {
					countCandidatos = rsCountCandidatos.getInt("numCandidatos");
	
				}
				return countCandidatos;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return -1; // Erro ao encontrar candidatos.

	}
	
	// adiciona candidato a tema
	public boolean addCandidato(int idTema, int idCandidato) throws Exception {
		
		if (this.isCandidato(idTema, idCandidato)) {
			throw new Exception();
		} else {
			Connection conn = conexao.getConexaoBD();
			if (conn != null) {
				try {
					Statement stAddCandidato = conn.createStatement();
					int itWorks = stAddCandidato.executeUpdate("insert into aluno_tema (user_id, tema_id) values ('" + idCandidato + "', '" + idTema + "')");
					
					if (itWorks == 1) {
						return true;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return false; // Erro ao inserir candidato.
		}
		
		
	}
	
	// diz se um candidato está registrado em um tema
	private boolean isCandidato(int idTema, int idCandidato) {
		Connection conn = conexao.getConexaoBD();
		if (conn != null) {
			try {
				Statement stCountCandidatos = conn.createStatement();
				ResultSet rsCountCandidatos = stCountCandidatos.executeQuery("select count(usuario.`id`) as numCandidatos from usuario join aluno_tema on aluno_tema.user_id = usuario.id where tema_id = " + idTema + " and usuario.id = " + idCandidato);
				if (rsCountCandidatos.next()) {
					if(rsCountCandidatos.getInt("numCandidatos") == 1) {
						return true;
					}
	
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

}
