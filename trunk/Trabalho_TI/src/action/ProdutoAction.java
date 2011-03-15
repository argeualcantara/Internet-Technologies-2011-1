package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import form.VendedorForm;

public class ProdutoAction  extends DispatchAction{
	
	public ActionForward carregar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		if(request.getParameter("id_produto") != null || Integer.parseInt(request.getParameter("id_produto")) != 0 ){
			
		}
		
		return mapping.findForward("erro"); 
	}
	
	public ActionForward sessao(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		VendedorForm vf= (VendedorForm)form;
		String login = vf.getLogin();
		request.setAttribute("login", login);
		
		return mapping.findForward("produtos"); 
	}
	
	public ActionForward inserir(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		return listarVendedor(mapping, form, request, response);
	}

	public ActionForward listarVendedor(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		if(request.getParameter("id_produto") != null || Integer.parseInt(request.getParameter("id_produto")) != 0 ){
			
		}
		
		return mapping.findForward("erro"); 
	}
	
}
