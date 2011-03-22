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
<a href="http://localhost:8080/Trabalho_TI/BuscarCompras.do">Buscar Compras</a>
<center>
<div style="padding-top: 200px;">
<html:form action="Produtos.do?method=buscaCliente">
	<html:text property="nome" />
	
	<html:select property="cod_area">
		<html:option value="0" disabled="false"> Selecione uma área</html:option>
		<html:options collection="listaArea" property="id_area"
			labelProperty="descricao" />
	</html:select>
	<html:submit styleId="botao" value="Buscar" />
</html:form>
</div>
</center>

<c:if test="${tamanho==0}">
<font color="red">Sua Consulta não gerou resultados</font>
</c:if>

<c:if test="${tamanho==1 }">
<c:forEach var="produto" items="${listaProduto}">
<div style="padding-left: 50px;">
<h2><a href="Produtos.do?method=mostrar&cod_produto=${produto.cod_produto}">${produto.nome}</a></h2>

Vendedor: ${produto.login }
<br/>
${produto.descricao}
<br/>
Qtde restante: <font color="red">${produto.quantidade}</font>
<br/>
Valor unitário: R$ ${produto.valor_unitario}
<br/>
<br/>
</div>
</c:forEach>
</c:if>
</body>
</html>