package ute.hibook.dao.imp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ute.hibook.dao.TypebookDao;
import ute.hibook.entity.Typebook;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
@Transactional
public class TypebookDaoImpl implements TypebookDao{

	@Autowired
	SessionFactory sessionFactory;

	public void addTypebook(Typebook typebook) {
		sessionFactory.getCurrentSession().save(typebook);
	}

	public void updateTypebook(Typebook typebook) {
		sessionFactory.getCurrentSession().update(typebook);
	}

	public void deleteTypebook(int idTypebook) {
		sessionFactory.getCurrentSession().delete(getTypebookById(idTypebook));
	}

	public Typebook getTypebookById(int idTypebook) {
		return sessionFactory.getCurrentSession().get(Typebook.class, idTypebook);
	}

	public List<Typebook> getAllTypebook() {
		return sessionFactory.getCurrentSession().createQuery("from typebook").getResultList();
	}
}
