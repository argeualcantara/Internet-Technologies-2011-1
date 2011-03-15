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
<a href="http://localhost:8080/Trabalho_TI/Index.do">In�cio</a>
<div style="padding-top: 200px;">
<html:form action="ProdutoCadastrado.do?method=inserir">
	<html:hidden property="${login}" />
	<table cellpadding="2" align="center" style="padding-top: 200px;">
		<tr>
			<td>Login:</td>
			<td><html:text styleId="login" property="login"></html:text></td>
			<td><c:if test="${vendedorForm.login==''}">
				<div align="left" id="msg" style="color: red; visibility: visible;">
				Login Existente ou Inv�lido</div>
			</c:if></td>
		</tr>
		<tr>
			<td>Senha:</td>
			<td><html:password property="senha" styleId="senha"></html:password>
			</td>
			<td><c:if test="${vendedorForm.senha==''}">
				<div align="left" id="msg" style="color: red; visibility: visible;">
				Senha � obrigat�rio</div>
			</c:if></td>
		</tr>
		<tr>
			<td>Confirmar Senha:</td>
			<td><html:password property="senha" onkeyup="compararSenha();"
				styleId="senhaConf"></html:password></td>
			<td>
			<div align="left" id="seq" style="color: red; visibility: hidden;">Senhas
			n�o conferem</div>
			</td>
		</tr>
		<tr>
			<td colspan="2">
			<div align="right"><html:submit value="Cadastrar" /></div>
			</td>
		</tr>
	</table>
</html:form>
</div>
</body>
</html>