package br.ifrn.meutcc.modelo;

import java.util.List;

import br.ifrn.meutcc.persistencia.FabricaDAO;
import br.ifrn.meutcc.persistencia.TemaDAO;
import br.ifrn.meutcc.persistencia.OrientadorDAO;

public class Tema {
	private int id;
	private String titulo;
	private String descricao;
	private static TemaDAO dao = FabricaDAO.getInstancia("mysql").createTemaDAO();
	private boolean aceito;
	private Orientador orientador;
	private OrientadorDAO orientadorDao;
	
	public Tema() {
		super();
		dao = FabricaDAO.getInstancia("mysql").createTemaDAO();
		orientadorDao = FabricaDAO.getInstancia("mysql").createOrientadorDAO();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setAceito(boolean aceito) {
		this.aceito = aceito;
	}
	public boolean getAceito() {
		return this.aceito;
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
	public static List<Tema> listTemas(int idCurso) {
		return dao.listTemas(idCurso);
	}
	public static Tema getTema(int idTema) {
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
	
	public static List<Tema> listTemasPropostos() {
		return dao.listTemasPropostos();
	}
	
	public void delete() {
		dao.deleteTema(this.id);
	}
	
	public void setOrientador(Orientador o) {
		this.orientador = o;
	}
	
	public Orientador getOrientador() {
		if (orientador == null) {
			this.orientador = orientadorDao.getOrientadorPorTema(this.id);
		}
		return this.orientador;
	}
	public void save() {
		dao.save(this);
	}
}
