package br.ifrn.meutcc.visao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ifrn.meutcc.modelo.Orientador;
import br.ifrn.meutcc.modelo.Tema;
import java.util.List;

@WebServlet("/ProporTema")
public class ProporTema extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProporTema() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recuperar o id do tema
		Orientador model = new Orientador();
		List<Orientador> orientadores = model.listOrientadores();
		

		
		request.setAttribute("orientadores", orientadores);
		request.getRequestDispatcher("proporTema.jsp").forward(request, response);
	}
	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String id = request.getParameter("idTema");
//		int idTema = -1;
//		try {
//			idTema = Integer.parseInt(id);
//		} catch (NumberFormatException nfex) {
//			nfex.printStackTrace();
//		}
//		
//		Tema model = new Tema();
//		Tema tema = model.getTema(idTema);
//		try {
//			tema.addCandidato(tema.getId(), 3);
//		} catch (Exception e) {
//			System.out.println("ERROR!");
//		}
//		
//		Orientador orModel = new Orientador();
//		Orientador orientador = orModel.getOrientadorPorTema(tema.getId());
//				
//		System.out.println("POST: " + id);
//		System.out.println("ORIENTADOR: " + orientador.getNome());
//		
//		response.sendRedirect(request.getContextPath() + "/ViewTema?id=" + idTema);
//
//	}
}
