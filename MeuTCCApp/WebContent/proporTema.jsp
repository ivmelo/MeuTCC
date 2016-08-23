<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="br.ifrn.meutcc.modelo.Tema, br.ifrn.meutcc.modelo.Orientador, java.util.List"%>

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
  	
		<h1>Propor Tema</h1>
		
		<form action="ProporTema" method="POST">
			<div class="form-group">
				<label for="titulo">Título do Tema:</label>
				<input type="text" name="titulo" class="form-control" placeholder="Título do seu tema proposto...">
			</div>
			<div class="form-group">
				<label for="descricao">Descrição:</label>
				<textarea name="descricao" class="form-control" placeholder="Descrição do seu tema proposto. Seja claro e objetivo para facilitar o entendimento..."></textarea>
			</div>
			<div class="form-group">
				<label for="orientador">Orientador Sugerido:</label>
				<select name="orientador" class="form-control">
		 		<%
					List<Orientador> orientadores = (List<Orientador>) request.getAttribute("orientadores");
					if (orientadores != null && !orientadores.isEmpty()) {
						for(Orientador o: orientadores) {
							out.println("<option value=\"" + o.getId() + "\">" + o.getNome() + "</option>");
						}
					} else {
						out.println("<option value=\"-1\">-</option>");
					}
				%>				
				</select>
			</div>
			<div>
				<%
				String mensagemErro = (String) request.getAttribute("msgErr");
				if (mensagemErro != null) {
					out.println("<p>" + mensagemErro + "</p>");
				}
				%>
			</div>
			<div>
				<button type="submit" class="btn btn-info">Enviar Proposta</button>
			</div>
		</form>
				  	
  	</div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  </body>
</html>