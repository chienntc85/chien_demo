package ute.hibook.dao.imp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ute.hibook.dao.UserreviewDao;
import ute.hibook.entity.Userreview;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
@Transactional
public class UserreviewDaoImpl implements UserreviewDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public void addUserreview(Userreview userreview) {
		sessionFactory.getCurrentSession().save(userreview);
	}

	public void updateUserreview(Userreview userreview) {
		sessionFactory.getCurrentSession().update(userreview);
	}

	public void deleteUserreview(int idUserreview) {
		sessionFactory.getCurrentSession().delete(getUserreviewById(idUserreview));
	}

	public Userreview getUserreviewById(int idUserreview) {
		return sessionFactory.getCurrentSession().get(Userreview.class, idUserreview);
	}

	public List<Userreview> getAllUserreview() {
		return sessionFactory.getCurrentSession().createQuery("from userreview").getResultList();
	}

}
