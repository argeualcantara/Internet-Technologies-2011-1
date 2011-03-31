function compararSenha() {

	var senha1 = document.getElementById("senha").value;
	var senha2 = document.getElementById("senhaConf").value;
	var obj = document.getElementById("seq");

	if (senha1 == senha2) {
		obj.setAttribute("style", "color: red; visibility:hidden;");
	} else {
		obj.setAttribute("style", "color: red; visibility:visible;");
	}

	if (senha2 == "") {
		obj.setAttribute("style", "color: red; visibility:hidden;");
	}

}

function marcarTodos() {
	var value = 1;
	if (document.getElementById("selecionador").elements[0].checked == 0) {
		value = 0;
	}
	for (i = 1; i < document.getElementById("selecionador").length; i++) {
		if (document.getElementById("selecionador").elements[i].type == "checkbox") {
			document.getElementById("selecionador").elements[i].checked = value;
		}
	}
}

function validarQtde() {
	var qtde = $
	{
		qtde
	}
	;
	var qtdeCompra = document.getElementById('qtde').value;
	var cpf = document.getElementById('cpf').value;
	var msg = "";
	if (qtdeCompra <= qtde && qtdeCompra != 0 && cpf != 0 && cpf > 0
			&& cpf != null) {
		return true;
	}
	if (cpf == 0 || cpf < 0 || cpf == null) {
		msg += 'Por favor, digite um CPF.\n';
	}
	if (qtdeCompra > qtde || qtdeCompra == 0) {
		msg += 'Quantidade máxima ultrapassada.';
	}
	if (msg != '') {
		alert(msg);
		return false;
	}
}

function calcularValor() {
	var qtde = $
	{
		qtde
	}
	;
	var preco = $
	{
		valor_unitario
	}
	;
	var qtdeCompra = document.getElementById('qtde').value;
	var div1 = document.getElementById('div1');
	if (qtdeCompra == '' || qtdeCompra == null || qtdeCompra == 0) {
		div1.setAttribute('style', 'color: red; visibility:hidden;');
		return;
	}

	if (qtdeCompra > qtde) {
		div1.setAttribute('style', 'color: red; visibility:visible;');
		div1.innerHTML = 'Quantidade indisponível no momento';
	} else {
		div1.setAttribute('style', 'color: red; visibility:visible;');
		div1.innerHTML = 'Total: ' + qtdeCompra * preco;
		return;
	}
}

function mascara(o, f) {
	v_obj = o;
	v_fun = f;
	setTimeout("execmascara()", 1);
}

function execmascara() {
	v_obj.value = v_fun(v_obj.value);
}

function soNumeros(v) {
	return v.replace(/\D/g, "");
}
