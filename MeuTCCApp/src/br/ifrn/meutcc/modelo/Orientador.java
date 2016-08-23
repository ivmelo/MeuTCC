package br.ifrn.meutcc.modelo;

import br.ifrn.meutcc.persistencia.FabricaDAO;
import br.ifrn.meutcc.persistencia.OrientadorDAO;
import java.util.List;

public class Orientador extends Usuario{
	
	private OrientadorDAO dao;
	
	public Orientador() {
		super();
		dao = FabricaDAO.getInstancia("mysql").createOrientadorDAO();
	}
	
	public Orientador getOrientadorPorTema(int idTema) {
		return dao.getOrientadorPorTema(idTema);
	}
	
	public List<Orientador> listOrientadores() {
		return dao.listOrientadores();
	}
}
