<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<LINK rel="stylesheet" href="css/estilo.css" type="text/css">
<link rel="shortcut icon" href="images/favicon.png" type="image/png" />
<script type="text/javascript" src="js/funcoes.js">
	
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mercado Livre 2.0</title>
</head>
<body class="bgStyle">
<html:form action="VendedorLogin.do?method=logar">
	<c:if test="${sessionScope.login == null || sessionScope.login == ''}">
		<c:redirect
			url="http://localhost:8080/Trabalho_TI/pages/erroLogin.jsp"></c:redirect>
	</c:if>
	<c:if test="${sessionScope.login != null}">
		<table align="right" cellpadding="2">
			<tr>
				<td>Você está logado como</td>
				<td>${login}</td>
			</tr>
			<tr>
				<td colspan="2">
				<div align="left"><a onclick=""
					href="http://localhost:8080/Trabalho_TI/pages/produtos.jsp">Produtos</a>
				<a onclick="" href="VendedorLogin.do?method=deslogar">Sair</a></div>

				</td>
			</tr>
		</table>
	</c:if>
</html:form>
<div style="padding-top: 200px;">
<center>
<table cellpadding="2" align="center" style="padding-top: 200px;">
	<tr>
		<td>Login:</td>
		<td><html:text styleId="login" property="login"></html:text></td>
		<td><c:if test="${vendedorForm.login==''}">
			<div align="left" id="msg" style="color: red; visibility: visible;">
			Login Existente ou Inválido</div>
		</c:if></td>
	</tr>

</table>

</center>
</div>

</body>
</html>