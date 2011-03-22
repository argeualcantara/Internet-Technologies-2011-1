<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@page isELIgnored="false"%>
<html>
<head>
<link rel="shortcut icon" href="images/favicon.png" type="image/png" />
<LINK rel="stylesheet" href="css/estilo.css" type="text/css">
<style type="text/css">
.tableAlign {
	vertical-align: middle;
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mercado Livre 2.0</title>
</head>
<body class="bgStyle">
<a href="http://localhost:8080/Trabalho_TI/">Início</a>

<div style="padding-top: 200px;">
<center>
<html:form action="Compra.do?method=buscarCompras">
				<table>
					<tr>
					<td>
					CPF: 
					</td>
					<td>
					<html:text property="cpf"/>
					</td>
					<td>
					<html:submit value="Procurar"/>
					</td>
					</tr>
					
				</table>
			</html:form>
		<c:if test="${tamanho==0}">
			<tr>
				<td><font color="red">Sua Consulta não gerou resultados</font>
				</td>
			</tr>
		</c:if>

		<c:if test="${tamanho==1}">
	<table border="1" cellpadding="2" cellspacing="2">
			<tr>
				<td><b>Nome</b></td>
				<td><b>Descricao</b></td>
				<td><b>Valor Unitário</b></td>
				<td><b>Valor Pago</b></td>
				<td><b>Quantidade</b></td>
			</tr>
			<c:forEach var="produto" items="${listCompras}">
				<tr>
				<td>
				${produto.nome} 
				</td>
				<td>
				${produto.descricao}
				</td>
				<td>
				${produto.valor_unitario}
				</td>
				<td>
				${produto.valor_unitario*produto.quantidade}
				</td>
				<td>
				${produto.quantidade}
				</td>
				</tr>				
			</c:forEach>
	</table>
		</c:if>
</center>
</div>
</body>
</html>