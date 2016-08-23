package br.ifrn.meutcc.persistencia;

public class FabricaMySQL extends FabricaDAO {
	private static FabricaMySQL instancia = null;
	
	private FabricaMySQL() {
		super();
	}

	public static FabricaDAO getInstancia() {
		if (instancia == null) {
			instancia = new FabricaMySQL();
		}
		return instancia;
	}

	@Override
	public TemaDAO createTemaDAO() {
		return TemaDAOMySQL.getInstancia();
	}

	@Override
	public CandidatoDAO createCadidatoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrientadorDAO createOrientadorDAO() {
		return OrientadorDAOMySQL.getInstancia();
	}

}
