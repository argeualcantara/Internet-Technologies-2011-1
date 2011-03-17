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
<a href="http://localhost:8080/Trabalho_TI/">Início</a>
	<c:if test="${sessionScope.login == null || sessionScope.login == ''}">
		<c:redirect
			url="http://localhost:8080/Trabalho_TI/pages/erroLogin.jsp"></c:redirect>
	</c:if>
	<c:if test="${sessionScope.login != null}">
		<table align="right" cellpadding="2">
			<tr>
				<td>Você está logado como</td>
				<td>${sessionScope.login}</td>
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

<center><html:form action="Produtos.do?method=inserir">
	<table cellpadding="2" align="center" style="padding-top: 200px;">
			<c:if test="${msg!=''}">
		<tr>
			<td>
			
			</td>
			<td align="right" >
				<div align="right" id="msg" style="color: red; visibility: visible;">
				${msg}</div>
			</td>
		</tr>
			</c:if>
	
		<tr>
			<td colspan="2">Produto inserido por ${sessionScope.login}</td>
		</tr>
		<!-- INSERT INTO PRODUTO (NOME, DESCRICAO, COD_AREA, VALOR_UNITARIO, LOGIN) VALUES (?,?)";  -->
		<tr>
			<td>Nome:</td>
			<td><html:text property="nome"></html:text></td>
		</tr>
		<tr>
			<td>Descricao:</td>
			<td><html:textarea property="descricao"></html:textarea></td>
		</tr>
		<tr>
			<td>Valor Unitário:</td>
			<td><html:text property="valor_unitario"></html:text></td>
		</tr>
		<tr>
			<td>Quantidade:</td>
			<td><html:text property="quantidade"></html:text></td>
		</tr>
		<tr>
			<td>Área:</td>
			<td>
			<html:select property="cod_area">
				<html:option value="" disabled="true"> Selecione uma área</html:option>
				<html:options collection="listaArea" property="id_area"
					labelProperty="descricao" />
			</html:select></td>
		</tr>
		<tr>
			<td colspan="2">
			<div align="right"><html:submit styleId="botao"
				value="Inserir" /></div>
			</td>
		</tr>
	</table>
</html:form></center>



</body>
</html>