package ute.hibook.dao.imp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ute.hibook.dao.TransportDao;
import ute.hibook.entity.Transport;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
@Transactional
public class TransportDaoImpl implements TransportDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public void addTransport(Transport transport) {
		sessionFactory.getCurrentSession().save(transport);
	}

	public void updateTransport(Transport transport) {
		sessionFactory.getCurrentSession().update(transport);
	}

	public void deleteTransport(int idTransport) {
		sessionFactory.getCurrentSession().delete(getTransportById(idTransport));
	}

	public Transport getTransportById(int idTransport) {
		return sessionFactory.getCurrentSession().get(Transport.class, idTransport);
	}

	public List<Transport> getAllTransport() {
		return sessionFactory.getCurrentSession().createQuery("from transport").getResultList();
	}

	
}
