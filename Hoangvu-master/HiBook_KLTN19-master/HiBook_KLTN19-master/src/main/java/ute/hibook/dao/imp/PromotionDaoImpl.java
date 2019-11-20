package ute.hibook.dao.imp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ute.hibook.dao.PromotionDao;
import ute.hibook.entity.Promotion;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
@Transactional
public class PromotionDaoImpl implements PromotionDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public void addPromotion(Promotion promotion) {
		sessionFactory.getCurrentSession().save(promotion);
	}

	public void updatePromotion(Promotion promotion) {
		sessionFactory.getCurrentSession().update(promotion);
	}

	public void deletePromotion(int idPromotion) {
		sessionFactory.getCurrentSession().delete(getPromotionById(idPromotion));
	}

	public Promotion getPromotionById(int idPromotion) {
		return sessionFactory.getCurrentSession().get(Promotion.class, idPromotion);
	}

	public List<Promotion> getAllPromotion() {
		return sessionFactory.getCurrentSession().createQuery("from promotion").getResultList();
	}

	public List<Promotion> getAllPromotionDate() {
		Session session=sessionFactory.getCurrentSession();
		Query q = session.createQuery("from promotion where timeEnd > now() and timeStart < now() ").setFirstResult(0).setMaxResults(1);
		
		List<Promotion> listPromotiondate=q.getResultList();
		return listPromotiondate;
	}
	
	
	

}
