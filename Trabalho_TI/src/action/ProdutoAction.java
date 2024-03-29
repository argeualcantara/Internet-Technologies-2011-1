package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Area;
import model.Compra;
import model.Produto;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import persistencia.CompraBD;
import persistencia.ProdutoBD;
import form.CompraForm;
import form.ProdutoForm;

public class ProdutoAction extends DispatchAction {

	public ActionForward listarArea(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<Area> list = ProdutoBD.getInstance().listarAreas();
		request.setAttribute("listaArea", list);
		return mapping.findForward("inicio");
	}

	public ActionForward carregar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		List<Area> list = ProdutoBD.getInstance().listarAreas();
		request.setAttribute("listaArea", list);

		String forward = "cadastrar";

		if(request.getParameter("indice") != null){
			Produto produto = ProdutoBD.getInstance().buscarProduto(Integer.parseInt(request.getParameter("indice")));
			((ProdutoForm)form).setCod_area(produto.getCod_area());
			((ProdutoForm)form).setCod_produto(produto.getCod_produto());
			((ProdutoForm)form).setDescricao(produto.getDescricao());
			((ProdutoForm)form).setLogin(produto.getLogin());
			((ProdutoForm)form).setNome(produto.getNome());
			((ProdutoForm)form).setQuantidade(produto.getQuantidade());
			((ProdutoForm)form).setValor_unitario(produto.getValor_unitario());
		}
		if (request.getParameter("buscar") != null) {
			forward = "buscar";
		}	
		

		return mapping.findForward(forward);
	}
	
	public ActionForward remover(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String marcados[] = ((ProdutoForm) form).getMarcados();
		
		ProdutoBD.getInstance().remover(marcados);
		
		return buscar(mapping, form, request, response);
	}

	public ActionForward inserir(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String msg = "";
		Produto produto = new Produto();

		produto.setCod_produto(((ProdutoForm) form).getCod_produto());
		produto.setCod_area(((ProdutoForm) form).getCod_area());
		produto.setDescricao(((ProdutoForm) form).getDescricao().trim());
		produto.setLogin(request.getSession().getAttribute("login").toString());
		produto.setNome(((ProdutoForm) form).getNome().trim());
		produto.setQuantidade(((ProdutoForm) form).getQuantidade());
		produto.setValor_unitario(((ProdutoForm) form).getValor_unitario());

		if (produto.getNome().trim() != null && produto.getQuantidade() > 0
				&& produto.getDescricao().trim() != null
				&& produto.getValor_unitario() > 0.0
				&& produto.getCod_area() != 0) {
			if(produto.getCod_produto() > 0){
				ProdutoBD.getInstance().alterar(produto);
			}else{
				ProdutoBD.getInstance().inserir(produto);
			}
		} else {

			if (produto.getNome().trim() == null
					|| produto.getQuantidade() <= 0
					|| produto.getDescricao().trim() == null
					|| produto.getValor_unitario() == 0.0
					|| produto.getCod_area() == 0) {
				msg = "Todos os campos s�o obrigat�rios";

			}

			request.setAttribute("msg", msg);
			List<Area> lista = ProdutoBD.getInstance().listarAreas();
			request.setAttribute("listaArea", lista);
			return carregar(mapping, form, request, response);
		}

		request.setAttribute("msg", msg);

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
		ProdutoForm pf = new ProdutoForm();

		request.setAttribute("produtoForm", pf);
		request.setAttribute("tamanho", 1);

		return mapping.findForward("listarVendedor");
	}

	public ActionForward buscar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String login = request.getSession().getAttribute("login").toString();

		int cod_area = ((ProdutoForm) form).getCod_area();
		String nome = ((ProdutoForm) form).getNome();

		List<Produto> list = null;

		if (cod_area > 0 && nome != null) {
			list = ProdutoBD.getInstance()
					.listarProdutos(login, cod_area, nome);
		} else if (cod_area > 0) {
			list = ProdutoBD.getInstance().listarProdutos(login, cod_area);
		} else if (nome != null && cod_area <= 0) {
			list = ProdutoBD.getInstance().listarProdutos(login, nome);
		} else {
			list = ProdutoBD.getInstance().listarProdutos(login);
		}

		request.setAttribute("listaProduto", list);
		if (list.size() > 0) {
			request.setAttribute("tamanho", 1);
		} else
			request.setAttribute("tamanho", 0);

		List<Area> lista = ProdutoBD.getInstance().listarAreas();
		request.setAttribute("listaArea", lista);

		return mapping.findForward("listarVendedor");
	}

	public ActionForward buscaCliente(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		int cod_area = ((ProdutoForm) form).getCod_area();
		String nome = ((ProdutoForm) form).getNome();

		List<Produto> list = null;

		if (cod_area > 0 && (!(nome.equals("")) || nome != null)) {
			list = ProdutoBD.getInstance()
					.listarProdutosCliente(cod_area, nome);
		} else if (cod_area > 0 && nome == null) {
			list = ProdutoBD.getInstance().listarProdutosCliente(cod_area);
		} else if (cod_area == 0 && nome != null) {
			list = ProdutoBD.getInstance().listarProdutosCliente(nome);
		}

		if (list.size() > 0) {
			request.setAttribute("listaProduto", list);
			request.setAttribute("tamanho", 1);
		} else
			request.setAttribute("tamanho", 0);

		List<Area> lista = ProdutoBD.getInstance().listarAreas();
		request.setAttribute("listaArea", lista);

		return mapping.findForward("listarCliente");
	}

	public ActionForward mostrar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CompraForm cf = new CompraForm();

		Produto produto = ProdutoBD.getInstance().buscarProduto(
				Integer.parseInt(request.getParameter("cod_produto")));

		request.setAttribute("cod_area",produto.getCod_area());
		request.setAttribute("cod_produto",produto.getCod_produto());
		request.setAttribute("nome",produto.getNome());
		request.setAttribute("qtde",produto.getQuantidade());
		request.setAttribute("valor_unitario",produto.getValor_unitario());
		request.setAttribute("descricao",produto.getDescricao());
		request.setAttribute("compraForm", cf);

		return mapping.findForward("mostrar");
	}

}
