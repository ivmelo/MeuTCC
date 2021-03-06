package br.ifrn.meutcc.persistencia;

import java.util.List;

import br.ifrn.meutcc.modelo.Tema;

public interface TemaDAO {
	public List<Tema> listTemas(int idCurso);
	public Tema getTema(int idTema);
	public int countCandidatos(int idTema);
	public boolean addCandidato(int idTema, int idCandidato) throws Exception;
	public boolean isCandidato(int idTema, int idCandidato);
	public List<Tema> listTemasPropostos();
	public void deleteTema(int idTema);
	public void save(Tema tema);
}