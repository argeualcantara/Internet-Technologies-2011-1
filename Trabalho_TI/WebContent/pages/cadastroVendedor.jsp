<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="images/favicon.png" type="image/png" />
<LINK rel="stylesheet" href="css/estilo.css" type="text/css">
<style type="text/css">
.tableAlign {
	vertical-align: middle;
}
</style>
<script type="text/javascript" src="js/funcoes.js">

</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mercado Livre 2.0</title>
</head>
<body class="bgStyle">
<a href="http://localhost:8080/Trabalho_TI/Index.do">Início</a>
<div style="padding-top: 200px;">
<center>
<html:form action="Cadastro.do?method=cadastrar">
	<table align="right" cellpadding="2">
		<tr>
			<td>
				Login:
			</td>
			<td>
				<html:text styleId="login" property="login"></html:text>
			</td>
			<td>
				<c:if test="${vendedorForm.login==''}">
					<div align="left" id="msg" style="color: red; visibility:visible;" >
					Login Existente ou Inválido</div>
				</c:if>
				
			</td>
		</tr>
		
		<tr>
			<td>
				Senha:
			</td>
			<td>
				<html:password property="senha" styleId="senha"></html:password>
			</td>
			<td>
				<c:if test="${vendedorForm.senha==''}">
					<div align="left" id="msg" style="color: red; visibility:visible;" >
					Senha é obrigatório</div>
				</c:if>
			</td>
		</tr>
		
		<tr>
			<td>
				Confirmar Senha:
			</td>
			<td>
				<html:password property="senhaCheck" onkeyup="compararSenha();" styleId="senhaConf"></html:password>
			</td>
			<td>
				<div align="left" id="seq" style="color: red; visibility:hidden;" >Senhas não conferem</div>
			</td>
		</tr>
		
		<tr>
			<td colspan="2">
				<div align="right"><html:submit styleId="botao" value="Cadastrar"/></div>
			</td>
		</tr>
	</table>
</html:form>
</center>
</div>
</body>
</html>