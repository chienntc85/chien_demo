package ute.hibook.dao.imp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ute.hibook.dao.SupplierDao;
import ute.hibook.entity.Supplier;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
@Transactional
public class SupplierDaoImpl implements SupplierDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public void addSupplier(Supplier supplier) {
		sessionFactory.getCurrentSession().save(supplier);
	}

	public void updateSupplier(Supplier supplier) {
		sessionFactory.getCurrentSession().update(supplier);
	}

	public void deleteSupplier(int idSupplier) {
		sessionFactory.getCurrentSession().delete(getSupplierById(idSupplier));
	}

	public Supplier getSupplierById(int idSupplier) {
		return sessionFactory.getCurrentSession().get(Supplier.class, idSupplier);
	}

	public List<Supplier> getAllSupplier() {
		return sessionFactory.getCurrentSession().createQuery("from supplier").getResultList();
	}

}
