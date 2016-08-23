<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="br.ifrn.meutcc.modelo.Tema, br.ifrn.meutcc.modelo.Orientador"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Meu TCC</title>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
  </head>
  <body>
  	<div class="container">
  	
		<h1>Detalhes do Tema</h1>

  		<%
			Tema tema = (Tema) request.getAttribute("tema");
			Orientador orientador = (Orientador) request.getAttribute("orientador");
			if (tema != null) {
				out.println("<h3>"+tema.getTitulo()+"</h3>");
				out.println("<ul>");
				out.println("<li> ID = "+tema.getId()+"</li>");
				out.println("<li> Descrição = "+tema.getDescricao()+"</li>");
				if(tema.getAceito()) {
					out.println("<li> Candidatos: " + tema.countCandidatos() + "</li>");
				}
				out.println("</ul>");
				if(tema.getAceito()) {
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
							<button class="btn btn-success" type="submit">Candidatar-se</button>
						</form>
						<%
					}
				} else {
					// tema proposto.
					%>
						<form action="/MeuTCC/CancelarTemaProposto" method="POST">
							<input type="hidden" name="idTema" value="<%= tema.getId() %>">
							<button class="btn btn-success" type="submit" onClick="return confirm('Você deseja mesmo cancelar a sua proposta?')")>Cancelar proposta</button>
						</form>
					<%
				}
				
			} else {
				out.println("<p>Não há nenhum tema para mostrar!</p>");
			}
		%>
				  	
  	</div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  </body>
</html>