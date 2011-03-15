package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Teste;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import persistencia.TesteBD;
import form.TesteForm;

public class TesteAction extends DispatchAction{
	
	public ActionForward buscar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int id=Integer.parseInt(request.getParameter("id"));
		if (TesteBD.getInstance().buscar(id)!=null){
			Teste teste=TesteBD.getInstance().buscar(id);
			TesteForm tform= (TesteForm) form;
			tform.setDesc(teste.getDesc());
			
			request.setAttribute("testeForm", form);
		}
		
		return mapping.findForward("mostrar"); 
	}
}
