
	function compararSenha(){
	
	var senha1=document.getElementById("senha").value;
	var senha2=document.getElementById("senhaConf").value;
	var obj = document.getElementById("seq");
	var botao = document.getElementById("botao");
	
	if(senha1 == senha2){
		obj.setAttribute("style", "color: red; visibility:hidden;");
	}else{
		//botao.setAttribute("disabled", "true");
		obj.setAttribute("style", "color: red; visibility:visible;");
	}

	if(senha2==""){
		//botao.setAttribute("disabled", "false");
		obj.setAttribute("style", "color: red; visibility:hidden;");
	}	
		
	}