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
<html:form action="VendedorLogin.do?method=logar">
<a  href="http://localhost:8080/Trabalho_TI/Index.do">Início</a>
	<table align="right" cellpadding="2">
		<c:if test="${sessionScope.login == null || sessionScope.login == ''}">
			<tr>
				<td>Usuário:</td>
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
		</c:if>
		<c:if test="${sessionScope.login != null}">

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

		</c:if>
	</table>
</html:form>
<div style="padding-top: 200px;">
<center>
Buscar Produtos<br />
<a onclick="" href="http://localhost:8080/Trabalho_TI/Produtos.do?method=carregar">Inserir Produtos</a><br />

</center>
</div>

</body>
</html>