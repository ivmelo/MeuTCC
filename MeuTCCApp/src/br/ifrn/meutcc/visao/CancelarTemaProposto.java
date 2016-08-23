package br.ifrn.meutcc.visao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ifrn.meutcc.modelo.Orientador;
import br.ifrn.meutcc.modelo.Tema;

@WebServlet("/CancelarTemaProposto")
public class CancelarTemaProposto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CancelarTemaProposto() {
		super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("idTema");
		int idTema = -1;
		try {
			idTema = Integer.parseInt(id);
		} catch (NumberFormatException nfex) {
			nfex.printStackTrace();
		}
		
		// Tema model = new Tema();
		Tema tema = Tema.getTema(idTema);
		try {
			tema.delete();
		} catch (Exception e) {
			System.out.println("ERROR DELETING TEMA!");
		}
		
		response.sendRedirect(request.getContextPath() + "/ListTemasPropostos");

	}
}
