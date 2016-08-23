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
		// Orientador model = new Orientador();
		List<Orientador> orientadores = Orientador.listOrientadores();
		
		request.setAttribute("orientadores", orientadores);
		request.getRequestDispatcher("proporTema.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idOr = request.getParameter("orientador");
		String titulo = request.getParameter("titulo");
		String descricao = request.getParameter("descricao");
		
		if (idOr.trim() == "" || titulo.trim() == "" || descricao.trim() == "") {
			// empty field.
			// redirect back with validation errors...
			response.sendRedirect(request.getContextPath() + "/ProporTema");
		} else {
			int idOrientador = -1;
			
			try {
				idOrientador = Integer.parseInt(idOr);
			} catch (NumberFormatException nfex) {
				nfex.printStackTrace();
			}
			
			Tema t = new Tema();
			t.setTitulo(titulo);
			t.setDescricao(descricao);
			t.setAceito(false);
						
			// Orientador oriModel = new Orientador();
			Orientador o = Orientador.find(idOrientador);
			
			t.setOrientador(o);
			
			t.save();
			
			System.out.println(t.getId());
			
			response.sendRedirect(request.getContextPath() + "/ViewTema?id=" + t.getId());
		}
		
		

	}
}
