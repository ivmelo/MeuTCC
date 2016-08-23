<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="br.ifrn.meutcc.modelo.Tema, br.ifrn.meutcc.modelo.Orientador"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Meu TCC</title>
</head>
<body>
<h1>Detalhes do Tema</h1>
<%
	Tema tema = (Tema) request.getAttribute("tema");
	Orientador orientador = (Orientador) request.getAttribute("orientador");
	if (tema != null) {
		out.println("<h3>"+tema.getTitulo()+"</h3>");
		out.println("<ul>");
		out.println("<li> ID = "+tema.getId()+"</li>");
		out.println("<li> Descrição = "+tema.getDescricao()+"</li>");
		out.println("<li> Candidatos: " + tema.countCandidatos() + "</li>");
		out.println("</ul>");
		if(tema.isCandidato(tema.getId(), 3)){
			%>
			<p>Você já se candidatou a este tema.</p>
			<p>Orientador: <%= orientador.getNome() %></p>
			<p>Email: <%= orientador.getEmail() %></p>
			<%
		} else {
			%>
			<form action="/MeuTCC/ViewTema" method="POST">
				<input type="hidden" name="idTema" value="<%= tema.getId() %>">
				<button type="submit">Candidatar-se</button>
			</form>
			<%
		}
	} else {
		out.println("<h3>Não há nenhum tema para mostrar!</h3>");
	}
%>

</body>
</html>