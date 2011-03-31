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
	<center>
		<div style="padding-top: 200px;">
			<html:form action="Compra.do?method=buscarCompras">
				<table>
					<tr>
					<td>
					CPF: 
					</td>
					<td>
					<html:text property="cpf" onkeypress="mascara(this,soNumeros)"/>
					</td>
					<td>
					<html:submit value="Procurar"/>
					</td>
					</tr>
				</table>
			</html:form>
		</div>
	</center>
</body>
</html>