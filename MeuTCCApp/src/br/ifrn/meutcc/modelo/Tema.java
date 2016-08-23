package br.ifrn.meutcc.modelo;

import java.util.List;

import br.ifrn.meutcc.persistencia.FabricaDAO;
import br.ifrn.meutcc.persistencia.TemaDAO;

public class Tema {
	private int id;
	private String titulo;
	private String descricao;
	private TemaDAO dao;
	public Tema() {
		super();
		dao = FabricaDAO.getInstancia("mysql").createTemaDAO();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Tema> listTemas(int idCurso) {
		return dao.listTemas(idCurso);
	}
	public Tema getTema(int idTema) {
		return dao.getTema(idTema);
	}
	
	public int countCandidatos() {
		return dao.countCandidatos(this.id);
	}
	
	public boolean addCandidato(int idTema, int idCandidato) throws Exception {
		return dao.addCandidato(idTema, idCandidato);
	}
	
	public boolean isCandidato(int idTema, int idCandidato) {
		return dao.isCandidato(idTema, idCandidato);
	}
}
