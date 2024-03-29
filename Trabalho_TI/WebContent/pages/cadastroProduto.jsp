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
<script type="text/javascript" src="js/jquery-1.5.1.js">
	
</script>
<script type="text/javascript" src="js/jquery.price_format.1.3.js">
	
</script>
<script type="text/javascript">
	$(function() {	
		$('#dinheiro').priceFormat( {
			prefix: '',
			centsSeparator : ',',
			thousandsSeparator : '.',
			centsLimit: 2
		});
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mercado Livre 2.0</title>
</head>
<body class="bgStyle">
<html:form action="VendedorLogin.do?method=logar">
	<a href="http://localhost:8080/Trabalho_TI/">In�cio</a>
	<c:if test="${sessionScope.login == null || sessionScope.login == ''}">
		<c:redirect url="http://localhost:8080/Trabalho_TI/ErroLogin.do"></c:redirect>
	</c:if>
	<c:if test="${sessionScope.login != null}">
		<table align="right" cellpadding="2">
			<tr>
				<td>Voc� est� logado como</td>
				<td>${sessionScope.login}</td>
			</tr>
			<tr>
				<td colspan="2">
				<div align="left"><a onclick=
	;;
href="http://localhost:8080/Trabalho_TI/Produto.do">Produtos</a> <a
					onclick=
	;;
href="VendedorLogin.do?method=deslogar">Sair</a></div>

				</td>
			</tr>
		</table>
	</c:if>
</html:form>

<html:form action="Produtos.do?method=inserir">
	<html:hidden property="cod_produto" />
	<table cellpadding="2" align="center"
		style="padding-left: 120px; padding-top: 200px;">
		<c:if test="${msg!=''}">
			<tr>
				<td></td>
				<td align="right">
				<div align="right" id="msg" style="color: red; visibility: visible;">
				${msg}</div>
				</td>
			</tr>
		</c:if>

		<tr>
			<td></td>
			<td colspan="2">Produto inserido por ${sessionScope.login}</td>
		</tr>
		<tr>
			<td>Nome:</td>
			<td><html:text property="nome"></html:text></td>
		</tr>
		<tr>
			<td>Descricao:</td>
			<td><html:textarea property="descricao"></html:textarea></td>
		</tr>
		<tr>
			<td>Valor Unit�rio:</td>
			<td><html:text property="valor_unitario"><!-- styleId="dinheiro"  --></html:text></td>
		</tr>
		<tr>
			<td>Quantidade:</td>
			<td><html:text property="quantidade"></html:text></td>
		</tr>
		<tr>
			<td>�rea:</td>
			<td><html:select property="cod_area">
				<html:option value="" disabled="true"> Selecione uma �rea</html:option>
				<html:options collection="listaArea" property="id_area"
					labelProperty="descricao" />
			</html:select></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><html:submit styleId="botao"
				value="Salvar" /> <html:button property="" value="Cancelar"
				onclick="javascript:history.back();"></html:button></td>
		</tr>
	</table>

</html:form>

</body>
</html>