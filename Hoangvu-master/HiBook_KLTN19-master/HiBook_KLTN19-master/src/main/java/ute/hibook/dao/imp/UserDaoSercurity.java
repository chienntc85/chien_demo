package ute.hibook.dao.imp;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ute.hibook.entity.User;
@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class UserDaoSercurity{
	
	SessionFactory sessionFactory;
	
	@Transactional
	public List<User> Loaduser() {
		Session session=sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<User> loaduser=(List<User>) session.createQuery("from user").getResultList();
		// TODO Auto-generated method stub
		return loaduser;
	}
	@Transactional
	public User loadUserEmail(String email) {
		Session session=sessionFactory.getCurrentSession();

		try {
			Query query = session.createQuery("FROM user WHERE email = :email");
			query.setParameter("email", email);
			User user = (User) query.getSingleResult();
			System.out.println(user.getNameUser());
			return user;
		} catch(Exception se) {
			System.out.println(se.getMessage());
			return null;
		}
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


}
