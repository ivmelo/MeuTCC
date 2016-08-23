package br.ifrn.meutcc.persistencia;

import br.ifrn.meutcc.modelo.Orientador;
import java.util.List;

public interface OrientadorDAO {
	public Orientador getOrientadorPorTema(int idTema);
	public List<Orientador> listOrientadores();
}
