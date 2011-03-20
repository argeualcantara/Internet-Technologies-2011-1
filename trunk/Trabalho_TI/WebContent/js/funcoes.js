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
	if(document.getElementById("selecionador").elements[0].checked == 0){
		value = 0;
	}
	for (i = 1; i < document.getElementById("selecionador").length; i++){
		if (document.getElementById("selecionador").elements[i].type == "checkbox"){
			document.getElementById("selecionador").elements[i].checked = value;
		}
	}
}

