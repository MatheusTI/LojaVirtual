package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table (name = "pessoa")
public class Pessoa implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "pes_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int pes_id;
	
	@Column(name = "pes_nome", length = 60, nullable = true)
	private String pes_nome;
	
	@Column(name = "pes_cpf", length = 14, nullable = true)	
	private String cpf;
	
	@Column(name = "pes_rg", length = 20, nullable = true)	
	private String rg;
	
	@Column(name = "pes_data_nasc")
	private Date data_nasc;	
	
	@Column(name = "pes_rua", length = 60, nullable = true)	
	private String pes_rua;
	
	@Column(name = "pes_bairro", length = 30, nullable = true)	
	private String pes_bairro;
	
	@Column(name = "pes_cidade", length = 30, nullable = true)		
	private String pes_cidade;
	
	@Column(name = "pes_uf", length = 2, nullable = true)		
	private char pes_uf;
	
	@Column(name = "pes_cep")		
	private int pes_cep;
	
	@Column(name = "pes_email", length = 40, nullable = true)		
	private String pes_email;
	
	@Column(name = "pes_senha", length = 32, nullable = true)		
	private String pes_senha;
	
	@Column(name = "pes_tipo", length = 30, nullable = true)		
	private String pes_tipo;
	
	public int getPes_id() {
		return pes_id;
	}
	public void setPes_id(int pes_id) {
		this.pes_id = pes_id;
	}
	public String getPes_nome() {
		return pes_nome;
	}
	public void setPes_nome(String pes_nome) {
		this.pes_nome = pes_nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Date getData_nasc() {
		return data_nasc;
	}
	
	public void setData_nasc(Date data_nasc) {
		this.data_nasc = data_nasc;
	}
	public String getPes_rua() {
		return pes_rua;
	}
	public void setPes_rua(String pes_rua) {
		this.pes_rua = pes_rua;
	}
	public String getPes_bairro() {
		return pes_bairro;
	}
	public void setPes_bairro(String pes_bairro) {
		this.pes_bairro = pes_bairro;
	}
	public String getPes_cidade() {
		return pes_cidade;
	}
	public void setPes_cidade(String pes_cidade) {
		this.pes_cidade = pes_cidade;
	}
	
	public String getPes_email() {
		return pes_email;
	}
	public void setPes_email(String pes_email) {
		this.pes_email = pes_email;
	}
	public String getPes_senha() {
		return pes_senha;
	}
	public void setPes_senha(String pes_senha) {
		this.pes_senha = pes_senha;
	}
	public String getPes_tipo() {
		return pes_tipo;
	}
	public void setPes_tipo(String pes_tipo) {
		this.pes_tipo = pes_tipo;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public char getPes_uf() {
		return pes_uf;
	}
	public void setPes_uf(char pes_uf) {
		this.pes_uf = pes_uf;
	}
	public int getPes_cep() {
		return pes_cep;
	}
	public void setPes_cep(int pes_cep) {
		this.pes_cep = pes_cep;
	}
	
	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Fone> fones = new ArrayList<Fone>();
	
	public List<Fone> getFones(){
		return fones;
	}
	
	public void setFones(List<Fone> fones) {
		this.fones = fones;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pes_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (pes_id != other.id)
			return false;
		return true;
	}
	
	
}
