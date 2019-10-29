package ute.hibook.dao.imp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ute.hibook.dao.DetailbillDao;
import ute.hibook.entity.Detailbill;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
@Transactional
public class DetailbillDaoImpl implements DetailbillDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public void addDetailbill(Detailbill detailbill) {
		sessionFactory.getCurrentSession().save(detailbill);
	}

	public void updateDetailbill(Detailbill detailbill) {
		sessionFactory.getCurrentSession().update(detailbill);
	}

	public void deleteDetailbill(int idDetailbill) {
		sessionFactory.getCurrentSession().delete(getDetailbillById(idDetailbill));
	}

	public Detailbill getDetailbillById(int idDetailbill) {
		return sessionFactory.getCurrentSession().get(Detailbill.class, idDetailbill);
	}

	public List<Detailbill> getAllDetailbill() {
		return sessionFactory.getCurrentSession().createQuery("from detailbill").getResultList();
	}

}
