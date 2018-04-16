package persistencia;

import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.Fone;

public class FoneDAO {

	public static void excluirFone(Fone fone) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.delete(fone);
		t.commit();
		sessao.close();
	}
	
}
