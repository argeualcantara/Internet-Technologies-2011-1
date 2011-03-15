package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import persistencia.ProdutoBD;
import form.ProdutoForm;

public class ProdutoAction  extends DispatchAction{
	
	public ActionForward carregar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
//		if(request.getParameter("id_produto") != null || Integer.parseInt(request.getParameter("id_produto")) != 0 ){
//			
//		}
		
		request.setAttribute("listaArea", ProdutoBD.getInstance().buscarAreas());
		
		return mapping.findForward("cadastro"); 
	}
	
	public ActionForward inserir(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		Produto produto = new Produto();
		produto.setCod_area(((ProdutoForm)form).getCod_area());
		produto.setDescricao(((ProdutoForm)form).getDescricao());
		produto.setNome(((ProdutoForm)form).getNome());
		produto.setQuantidade(((ProdutoForm)form).getQuantidade());
		produto.setValor_unitario(((ProdutoForm)form).getValor_unitario());
		produto.setLogin((String)request.getSession().getAttribute("login"));
		
		ProdutoBD.getInstance().inserir(produto);
		
		return listarVendedor(mapping, form, request, response);
	}

	public ActionForward listarVendedor(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
//		if(request.getParameter("id_produto") != null || Integer.parseInt(request.getParameter("id_produto")) != 0 ){
//			
//		}
		
		return mapping.findForward("erro"); 
	}
	
}
