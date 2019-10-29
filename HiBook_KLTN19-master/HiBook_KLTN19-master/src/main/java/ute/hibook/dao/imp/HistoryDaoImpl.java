package ute.hibook.dao.imp;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ute.hibook.dao.HistoryDao;
import ute.hibook.entity.History;
import ute.hibook.entity.User;
@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
@Transactional
public class HistoryDaoImpl implements HistoryDao {
	@Autowired
	SessionFactory sessionFactory;
	public void addHistory(History history) {
		sessionFactory.getCurrentSession().save(history);		
	}
	
	public void deleteUser(int idUserHistory) {
		//session.saveOrUpdate(null);
		sessionFactory.getCurrentSession().delete(getidUserHistoryByidBook(idUserHistory));
		
	}
	public History getidUserHistoryByidBook(int idBook) {
		Session session=sessionFactory.getCurrentSession();
		try {
			Query query = session.createQuery("FROM history WHERE idBook = :idBook");
			query.setParameter("idBook", idBook);
			History userHistory = (History) query.getSingleResult();
			return userHistory;
		} catch(Exception se) {
			return null;
		}
	}
	
	public List<History> getHistoryByidUser(int idUser) {
		Session session=sessionFactory.getCurrentSession();
		try {
			Query query = session.createQuery("FROM history WHERE idUser = :idUser ORDER BY idhistory DESC");
			query.setParameter("idUser", idUser);
			List<History> userHistory = query.getResultList();
			return userHistory;
		} catch(Exception se) {
			return null;
		}
	}

	public List<History> getAllHistory() {
		return sessionFactory.getCurrentSession().createQuery("from history").getResultList();
	}
	

}
