
	function compararSenha(){
	
	var senha1=document.getElementById("senha").value;
	var senha2=document.getElementById("senhaConf").value;
	var obj = document.getElementById("seq");
	
	if(senha1 == senha2){
		obj.setAttribute("style", "color: red; visibility:hidden;");
	}else{
		obj.setAttribute("style", "color: red; visibility:visible;");
	}

	if(senha2==""){
		obj.setAttribute("style", "color: red; visibility:hidden;");
	}	
		
	}