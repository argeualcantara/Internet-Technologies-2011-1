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

<script type="text/javascript" src="js/funcoes.js">
	
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${nome} - Mercado Livre 2.0</title>
</head>
<body class="bgStyle">
<a href="http://localhost:8080/Trabalho_TI/">Início</a>
<a href="http://localhost:8080/Trabalho_TI/BuscarCompras.do">Buscar Compras</a>
<a href="javascript:history.back();" >Voltar</a>

<div style="padding-top: 200px;">
<html:form action="Compra.do?method=comprar&cod_produto=${cod_produto}" onsubmit="return validarQtde();" >
	<table style="padding-left: 30%;">
		<tr>
			<td colspan="3" align="right"> 
				<h1>${nome}</h1>
			</td>
		</tr>
		<tr>
			<td colspan="3" align="right">
				${descricao}
			</td>
		</tr>
		<tr>
			<td colspan="3" align="right"><br/>
				Preço:R$ ${valor_unitario}
			</td>
		</tr>
		<tr>
		<td colspan="3" align="right">
		CPF:
		</td>
		<td colspan="3">
		<html:text styleId="cpf" property="cpf"/>
		</td>
		</tr>
		<tr>
		<td colspan="3" align="right">
		Quantidade:
		</td>
		<td>
		<html:text styleId="qtde" onkeyup="calcularValor();"  onkeypress="mascara(this,soNumeros)" property="qtde"/>
		</td>
		<td>
		<label id="div1"  style="visibility: hidden;"></label>
		</td>
		</tr>
		<tr>
		<td colspan="3" align="right">
		<html:submit value="Comprar" />
		</td>
		</tr>
	</table>
	
</html:form>
</div>


</body>
</html>