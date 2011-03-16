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
		<table align="right" cellpadding="2">
			<tr>
				<td>Usu�rio:</td>
				<td><html:text property="login" />
			</tr>
			<tr>
				<td>Senha:</td>
				<td><html:password property="senha" />
			</tr>
			<tr>

				<td colspan="2">
				<div align="left"><a onclick="" href="CadastroVendedor.do">Registar</a>
				<html:submit value="Entrar" /></div>
				</td>
			</tr>
		</table>
	</c:if>
	<c:if test="${sessionScope.login != null}">
		<table align="right" cellpadding="2">
			<tr>
				<td>Voc� est� logado como</td>
				<td>${login}</td>
			</tr>
			<tr>
				<td colspan="2">
				<div align="left"><a onclick="" href="http://localhost:8080/Trabalho_TI/Produtos.do?method=sessao">Produtos</a>
				<a onclick="" href="VendedorLogin.do?method=deslogar">Sair</a>
				</div>
				
				</td>
			</tr>
		</table>
	</c:if>
</html:form>
	<div style="padding-top: 200px;">
	<center>
	
	Buscar Produtos<br/>
	Inserir Produtos<br/>
		
	</center>
	</div>

</body>
</html>