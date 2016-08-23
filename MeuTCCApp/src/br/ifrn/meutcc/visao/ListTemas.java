package br.ifrn.meutcc.visao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ifrn.meutcc.modelo.Tema;

@WebServlet("/ListTemas")
public class ListTemas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListTemas() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recuperar o identificador do curso
		String curso = request.getParameter("idCurso");
		int idCurso = 1;
		try {
			idCurso = Integer.parseInt(curso);
			System.out.println(idCurso);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
//		Tema modelo = new Tema();
		List<Tema> temas = Tema.listTemas(idCurso);
		request.setAttribute("temas", temas);
		request.getRequestDispatcher("listaTemas.jsp").forward(request, response);
	}
}
