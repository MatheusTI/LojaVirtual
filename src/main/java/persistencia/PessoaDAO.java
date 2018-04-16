package persistencia;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.FacesComponent;


import org.hibernate.*;

import beans.Fone;
import beans.Pessoa;



public class PessoaDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	public static void inserir(Pessoa pessoa) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction   t = sessao.beginTransaction();
		sessao.save(pessoa);
		t.commit();
		sessao.close();
	}

	public static void alterar(Pessoa pessoa) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.update(pessoa);
		t.commit();
		sessao.close();
	}

	public static void excluir(Pessoa pessoa) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.delete(pessoa);
		t.commit();
		sessao.close();
	}
	
	public List<Pessoa> buscarTodos() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta;
		consulta = sessao.createQuery("from Pessoa");
		List lista = consulta.list();
		sessao.close();
		return lista;
}
	
	
	public static List<Pessoa> listagem(String filtro) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta;
		if (filtro.trim().length() == 0) {
			consulta = sessao.createQuery("from Pessoa order by pes_nome");
		} else {
			consulta = sessao.createQuery("from Pessoa WHERE pes_nome like :filtro").setParameter("filtro", "%"+filtro+"%");
		}
		List lista = consulta.list();
		sessao.close();
		return lista;
	}
}
