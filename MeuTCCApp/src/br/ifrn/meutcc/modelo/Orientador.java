package br.ifrn.meutcc.modelo;

import br.ifrn.meutcc.persistencia.FabricaDAO;
import br.ifrn.meutcc.persistencia.OrientadorDAO;
import java.util.List;

public class Orientador extends Usuario{
	
	private static OrientadorDAO dao = FabricaDAO.getInstancia("mysql").createOrientadorDAO();
	
	public Orientador() {
		super();
		dao = FabricaDAO.getInstancia("mysql").createOrientadorDAO();
	}
	
	public static Orientador getOrientadorPorTema(int idTema) {
		return dao.getOrientadorPorTema(idTema);
	}
	
	public static List<Orientador> listOrientadores() {
		return dao.listOrientadores();
	}
	
	public static Orientador find(int idOrientador) {
		return dao.findOriendator(idOrientador);
	}
}
