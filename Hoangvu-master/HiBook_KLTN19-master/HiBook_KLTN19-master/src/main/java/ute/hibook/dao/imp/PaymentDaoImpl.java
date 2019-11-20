package ute.hibook.dao.imp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ute.hibook.dao.PaymentDao;
import ute.hibook.entity.Payment;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
@Transactional
public class PaymentDaoImpl  implements PaymentDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public void addPayment(Payment payment) {
		sessionFactory.getCurrentSession().save(payment);
	}

	public void updatePayment(Payment payment) {
		sessionFactory.getCurrentSession().update(payment);
	}

	public void deletePayment(int idPayment) {
		sessionFactory.getCurrentSession().delete(getPaymentById(idPayment));
	}

	public Payment getPaymentById(int idPayment) {
		return sessionFactory.getCurrentSession().get(Payment.class, idPayment);
	}

	public List<Payment> getAllPayment() {
		return sessionFactory.getCurrentSession().createQuery("from payment").getResultList();
	}

}
