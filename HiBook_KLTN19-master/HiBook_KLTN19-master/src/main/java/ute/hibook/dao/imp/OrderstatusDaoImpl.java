package ute.hibook.dao.imp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ute.hibook.dao.OrderstatusDao;
import ute.hibook.entity.Orderstatus;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
@Transactional
public class OrderstatusDaoImpl implements OrderstatusDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public void addOrderstatus(Orderstatus orderstatus) {
		sessionFactory.getCurrentSession().save(orderstatus);
	}

	public void updateOrderstatus(Orderstatus orderstatus) {
		sessionFactory.getCurrentSession().update(orderstatus);
	}

	public void deleteOrderstatus(int idOrderstatus) {
		sessionFactory.getCurrentSession().delete(getOrderstatusById(idOrderstatus));
	}

	public Orderstatus getOrderstatusById(int idOrderstatus) {
		return sessionFactory.getCurrentSession().get(Orderstatus.class, idOrderstatus);
	}

	public List<Orderstatus> getAllOrderstatus() {
		return sessionFactory.getCurrentSession().createQuery("from orderstatus").getResultList();
	}

}
