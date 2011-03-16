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
		
		String forward = "cadastrar";
		
		if(request.getParameter("buscar")!= null){
			forward = "buscar";
		}

		return mapping.findForward(forward); 
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
		
		String login = request.getSession().getAttribute("login").toString();
		
		List<Produto> list = ProdutoBD.getInstance().listarProdutos(login);
		request.setAttribute("listaProduto", list);
		
		List<Area> lista = ProdutoBD.getInstance().listarAreas();
		request.setAttribute("listaArea", lista);
		
		return mapping.findForward("listarVendedor"); 
	}
	
	public ActionForward buscar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String login = request.getSession().getAttribute("login").toString();
		
		int cod_area = ((ProdutoForm)form).getCod_area();
		String nome = ((ProdutoForm)form).getNome();
		
		List<Produto> list = null;
		
		if(cod_area > 0 && nome != null){
			list = ProdutoBD.getInstance().listarProdutos(login, cod_area, nome);
		}else if(cod_area > 0){
			list = ProdutoBD.getInstance().listarProdutos(login, cod_area);
		}else if(nome != null){
			list = ProdutoBD.getInstance().listarProdutos(login, nome);
		}else{
			list = ProdutoBD.getInstance().listarProdutos(login);
		}
			
		request.setAttribute("listaProduto", list);
		
		List<Area> lista = ProdutoBD.getInstance().listarAreas();
		request.setAttribute("listaArea", lista);
		
		return mapping.findForward("listarVendedor"); 
	}
	
}
