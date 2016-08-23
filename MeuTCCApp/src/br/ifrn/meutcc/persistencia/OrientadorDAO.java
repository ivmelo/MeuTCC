package br.ifrn.meutcc.persistencia;

import br.ifrn.meutcc.modelo.Orientador;

public interface OrientadorDAO {
	public Orientador getOrientadorPorTema(int idTema);
}
