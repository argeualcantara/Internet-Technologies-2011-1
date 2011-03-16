package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Area;
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
		
		List<Area> list = ProdutoBD.getInstance().listarAreas();
		request.setAttribute("listaArea", list);
		
//		if(request.getParameter("id_produto") != null || Integer.parseInt(request.getParameter("id_produto")) != 0 ){
//			
//		}
		
		return mapping.findForward("cadastrar"); 
	}
	
	public ActionForward inserir(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
			Produto produto = new Produto();
			
			produto.setCod_area(((ProdutoForm)form).getCod_area());
			produto.setDescricao(((ProdutoForm)form).getDescricao());
			produto.setLogin(request.getSession().getAttribute("login").toString());
			produto.setNome(((ProdutoForm)form).getNome());
			produto.setQuantidade(((ProdutoForm)form).getQuantidade());
			produto.setValor_unitario(((ProdutoForm)form).getValor_unitario());
			
			ProdutoBD.getInstance().inserir(produto);
		
		return listarVendedor(mapping, form, request, response);
	}

	public ActionForward listarVendedor(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//TODO fazer método de listar produtos
		return mapping.findForward("erro"); 
	}
	
}
