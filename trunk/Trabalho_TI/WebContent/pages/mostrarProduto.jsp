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
<title>${produtoForm.nome} - Mercado Livre 2.0</title>
</head>
<body class="bgStyle">
<a href="http://localhost:8080/Trabalho_TI/">Início</a>
<a href="">Voltar</a>
<center>
<div style="padding-top: 200px;">
<html:form action="Produtos.do?method=comprar&cod_produto=${produtoForm.cod_produto}">
	<table>
		<tr>
			<td>
				<h1>${produtoForm.nome}</h1>
			</td>
		</tr>
		<tr>
			<td>
				${produtoForm.descricao}
			</td>
		</tr>
		<tr>
			<td><br/>
				Preço:R$ ${produtoForm.valor_unitario}
			</td>
		</tr>
		<tr>
		<td align="right">
		<html:submit styleId="botao" value="Comprar" />
		</td>
		</tr>
	</table>
	
</html:form>
</div>
</center>

</body>
</html>