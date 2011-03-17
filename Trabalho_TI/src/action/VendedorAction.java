package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Area;
import model.Vendedor;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import persistencia.ProdutoBD;
import persistencia.VendedorBD;
import form.VendedorForm;

public class VendedorAction extends DispatchAction{
	
	public ActionForward logar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String login=request.getParameter("login");
		String senha=request.getParameter("senha");
		
		if(VendedorBD.getInstance().logar(login, senha)){
			request.getSession().setAttribute("login", login);
			request.setAttribute("login", login);
			List<Area> lista = ProdutoBD.getInstance().listarAreas();
			request.setAttribute("listaArea", lista);
			return mapping.findForward("valido"); 
		}
		
		return mapping.findForward("erroLogin"); 
	}
	
	public ActionForward deslogar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		request.getSession().setAttribute("login", null);
		request.setAttribute("login", null);
		List<Area> lista = ProdutoBD.getInstance().listarAreas();
		request.setAttribute("listaArea", lista);
		request.setAttribute("metodo", "deslogar");
		
		return mapping.findForward("valido"); 
	}
	
	public ActionForward cadastrar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String senha=((VendedorForm) form).getSenha();
		String login=((VendedorForm) form).getLogin();
		String senha2=((VendedorForm) form).getSenhaCheck();
		
		if(VendedorBD.getInstance().validarNomeLogin(login) && login!= null &&
				!(login.equals("") && (senha==null || (senha.equals("")))) && (senha.equals(senha2))){
			Vendedor vendedor=new Vendedor();
			vendedor.setLogin(login);
			vendedor.setSenha(senha);
			VendedorBD.getInstance().inserir(vendedor);
			VendedorForm vf=new VendedorForm();
			request.setAttribute("vendedorForm", vf);
			return mapping.findForward("valido"); 
		}
		if(!(VendedorBD.getInstance().validarNomeLogin(login) && !(login.equals("")) && login!=null))
			((VendedorForm) form).setLogin("");
		
		if(senha!="" && (senha.equals(senha2))){
			((VendedorForm) form).setSenha(null);
			((VendedorForm) form).setSenhaCheck("");
		}
		else{
			((VendedorForm) form).setSenha("");
			((VendedorForm) form).setSenhaCheck("");
		}
		request.setAttribute("vendedorForm", form);
		
		return mapping.findForward("erro");
	}
}
