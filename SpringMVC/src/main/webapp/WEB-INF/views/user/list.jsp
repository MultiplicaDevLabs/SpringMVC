<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring MVC</title>
<spring:url var="css" value="/static/css/bootstrap.css"/>
<link type="text/css" rel="stylesheet" href="${css }">
</head>
<body>

	<div class="container">
		<h1>List de Usuarios</h1>
		<hr>
		<div>
			<spring:url value="/usuario/cadastro" var="cadastro"/>
			<a class="btn btn-default" href="${cadastro }">Novo Usuario</a>
		</div>
		<hr>
		<div>
			<div>
				<spring:url var="act_sexo" value="/usuario/sexo"/>
				<form action="${act_sexo}" method="get">
				    <div class="form-group">
				      <label for="tipoSexo">Busca por Sexo</label>
				      <select name="tipoSexo" class="form-control">
				         <c:forEach var="sexo" items="${sexos}">
				           <option value="${sexo.desc}">${sexo.desc}</option>
				         </c:forEach>
				      </select>
				    </div>
				    <div class="form-group">
				       <button type="submit" class="btn btn-default">Localizar</button>
				    </div>
 				</form>
			</div>
			
			<div>
				<spring:url var="act_nome" value="/usuario/nome"/>
				<form action="${act_nome}" method="get">
				    <div class="form-group">
				      <label for="nome">Busca por Nome ou Sobrenome</label>
				      <input name="nome" type="text" class="form-control">
				    </div>
				    <div class="form-group">
				       <button type="submit" class="btn btn-default">Localizar</button>
				    </div>
 				</form>
			</div>
		</div>
		<hr>
		<div class="${message == null ? 'panel-default' : 'panel-success'}">
			<div class="panel-heading">
				<span>${message == null ? '&nbsp;' : message}</span>
			</div>			
			<table class="table table-striped table-condensed">
				<thead>
					<tr>
						<th>ID</th>
						<th>NOMBRE</th>
						<th>FECHA DE NASCIMENTO</th>
						<th>SEXO</th>
						<th>ACCION</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="usuario" items="${usuarios }">
						<tr>
							<td>${usuario.id }</td>
							<td>${usuario.nome }&nbsp;${usuario.sobrenome }</td>
							<td>
								<f:parseDate var="date" value="${usuario.dtNascimento }" pattern="yyyy-MM-dd" type="date"></f:parseDate>
								<f:formatDate value="${date }" pattern="dd/MM/yyyy" type="date"/>
							</td>
							<td>${usuario.sexo.desc }</td>
							<td>
								<spring:url value="/usuario/update/${usuario.id }" var="update"/>
								<a class="btn btn-info" href="${update }">Editar</a>
								<spring:url value="/usuario/delete/${usuario.id }" var="delete"/>
								<a class="btn btn-danger" href="${delete }">Borrar</a>	
							</td>	
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<hr>
		<footer class="footer">
			<p>&copy; Multiplica</p>
		</footer>
	</div>
</body>
</html>