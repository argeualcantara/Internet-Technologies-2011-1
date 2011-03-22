package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Compra;
import model.Produto;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import persistencia.CompraBD;
import form.CompraForm;

public class CompraAction extends DispatchAction{
	
	public ActionForward comprar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CompraForm cf= (CompraForm) form;
		Compra compra=new Compra();
		compra.setCod_produto(Integer.parseInt(request.getParameter("cod_produto")));
		compra.setCpf(cf.getCpf());
		compra.setQtde(cf.getQtde());
		
		CompraBD.getInstance().comprar(compra);
		
		List<Produto> lista=CompraBD.getInstance().buscarCompras(cf.getCpf());
		request.setAttribute("listCompras", lista);
		request.setAttribute("tamanho",1);
		
		return mapping.findForward("listarCompras");
	}
	
	public ActionForward buscarCompras(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		CompraForm cf=(CompraForm) form;
		if(cf.getCpf()!=0){
			List<Produto> list = CompraBD.getInstance().buscarCompras(cf.getCpf());
			if(list.size()>0){
				request.setAttribute("listCompras", list);
				request.setAttribute("tamanho", 1);
			}
		}else
			request.setAttribute("tamanho", 0);
			
		return mapping.findForward("listarCompras");
	}

}
