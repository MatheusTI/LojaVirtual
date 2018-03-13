package negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;

import beans.Produto;
import persistencia.HibernateUtil;
import persistencia.ProdutoDAO;

@ManagedBean
@SessionScoped
public class ProdutoCtrl implements Serializable{

	ProdutoDAO d = new ProdutoDAO();
	
	private	static final long serialVersionUID = 1L;
	private Produto produto;
	private String pesquisa;
	
	private List<Produto> produtos = new ArrayList<Produto>();

	private List<Produto> lista;
		
		
	public List<Produto> getProdutos() {
		this.produtos = d.buscarTodos();
		return produtos;
	}
	
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		if(produto == null) {
			this.produto = new Produto();
		}else {
			ProdutoDAO.alterar(produto);
		}
	}
	
	
	
	public String getPesquisa() {
		return this.pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}

	public String buscarPorNome() {
		this.lista = ProdutoDAO.listagem(pesquisa);
		produto = new Produto();
		return "";
	}
	
	public void limpar() {
		produto = new Produto();
	}
	
	
	public String actionGravar() {
		if(produto.getId() == 0) {
			ProdutoDAO.inserir(produto);
			return "listaProduto";
		}else {
			ProdutoDAO.alterar(produto);
			return "listaProduto";
		}
	}
		
	public String lista(){
		return "listaProduto";
	}
	
	
	public String actionInserir() {
		produto = new Produto();
		return "formProduto";
	}
	
	public String actionExcluir() {
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		produto.setId(Integer.parseInt((params.get("id"))));
		ProdutoDAO.excluir(produto);
		produto = new Produto();
		return "listaProduto";
	}
	
	/*public String actionExcluir(Produto p) {
		ProdutoDAO.excluir(p);
		return "listaProduto";
	}*/
	
	public String actionAlterar(Produto p) {
		produto = p;
		return "formProduto";
	}
	
	public String voltar() {
		return "index";
	}

	public List<Produto> getLista() {
		return lista;
	}

	public void setLista(List<Produto> lista) {
		this.lista = lista;
	}

	
}
