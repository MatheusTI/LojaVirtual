package persistencia;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.FacesComponent;


import org.hibernate.*;
import beans.Produto;



public class ProdutoDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	public static void inserir(Produto produto) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.save(produto);
		t.commit();
		sessao.close();
	}

	public static void alterar(Produto produto) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.update(produto);
		t.commit();
		sessao.close();
	}

	public static void excluir(Produto produto) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.delete(produto);
		t.commit();
		sessao.close();
	}

	
	public List<Produto> buscarTodos() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta;
		consulta = sessao.createQuery("from Produto");
		List lista = consulta.list();
		sessao.close();
		return lista;
}
	
	
	public static List<Produto> listagem(String filtro) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta;
		if (filtro.trim().length() == 0) {
			consulta = sessao.createQuery("from Produto order by produtonome");
		} else {
			consulta = sessao.createQuery("from Produto WHERE produtonome like :filtro").setParameter("filtro", "%"+filtro+"%");
		}
		List lista = consulta.list();
		sessao.close();
		return lista;
	}
}
