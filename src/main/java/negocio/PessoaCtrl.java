package negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import beans.Pessoa;
import persistencia.PessoaDAO;

@ManagedBean
@SessionScoped
public class PessoaCtrl implements Serializable{

	PessoaDAO d = new PessoaDAO();
	
	private static final long serialVersionUID = 1L;
	private Pessoa pessoa;
	private String pesquisa;
	
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	private List<Pessoa> lista;
	
	
	public List<Pessoa> getPessoas(){
		this.pessoas = d.buscarTodos();
		return pessoas;
	}
	
	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		if(pessoa == null) {
			this.pessoa = new Pessoa();
		}else {
			PessoaDAO.alterar(pessoa);
		}
	}
	
	public String getPesquisa() {
		return this.pesquisa;
	}
	
	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}
	
	public String buscarPorNome() {
		this.lista = PessoaDAO.listagem(pesquisa);
		pessoa = new Pessoa();
		return "";
	}
	
	public void limpar() {
		pessoa = new Pessoa();
	}
	
	public String actionGravar() {
		if(pessoa.getPes_id() == 0) {
			PessoaDAO.inserir(pessoa);
			return "listaPessoa";
		}else {
			PessoaDAO.alterar(pessoa);
			return "listaPessoa";
		}
	}
	
	public String lista() {
		return "listaPessoa";
	}
	
	public String actionInserir() {
		pessoa = new Pessoa();
		return "formPessoa";
	}
	
	public String actionExcluir() {
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		pessoa.setPes_id(Integer.parseInt((params.get("pes_id"))));
		d.excluir(pessoa);
		pessoa = new Pessoa();
		return "listaPessoa";
	}
	
	public String actionAlterar(Pessoa p) {
		pessoa = p;
		return "formPessoa";
	}
	
	public String voltar() {
		return "index";
	}
	
	public List<Pessoa> getLista(){
		return lista;
	}
	
	public void setLista(List<Pessoa> lista) {
		this.lista = lista;
	}
	
}
