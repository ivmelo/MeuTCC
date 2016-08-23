<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, br.ifrn.meutcc.modelo.Tema" %>

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
  	
  	    <h1>Temas Propostos para TCC.</h1>
  	    
   		<ul class="nav nav-tabs">
		  <li role="presentation"><a href="ListTemas">Temas Disponíveis</a></li>
		  <li role="presentation" class="active"><a href="ListTemasPropostos">Temas Propostos</a></li>
		</ul>

  		<div class="list-group">
		  <%
				List<Tema> temas = (List<Tema>) request.getAttribute("temas");
				if (temas != null && !temas.isEmpty()) {
					for(Tema t: temas) {
						out.println("<a class=\"list-group-item\" href=\"/MeuTCC/ViewTema?id="+t.getId()+
										"\">["+t.getId()+"] "+t.getTitulo()+"</a>");
						System.out.println(t.getAceito());
					}
				} else {
					out.println("<p>Nenhum tema cadastrado para o referido curso!</p>");
				}
			%>
		</div>
		  	
  	</div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  </body>
</html>