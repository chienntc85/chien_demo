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

import ute.hibook.dao.CartDao;
import ute.hibook.entity.Cart;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
@Transactional
public class CartDaoImpl implements CartDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public void addCart(Cart cart) {
		sessionFactory.getCurrentSession().save(cart);
	}

	public void updateCart(Cart cart) {
		sessionFactory.getCurrentSession().update(cart);
	}

	public void deleteCart(int idCart) {
		sessionFactory.getCurrentSession().delete(getCartById(idCart));
	}

	public Cart getCartById(int idCart) {
		return sessionFactory.getCurrentSession().get(Cart.class, idCart);
	}

	public List<Cart> getAllCart() {
		return sessionFactory.getCurrentSession().createQuery("from cart").getResultList();
	}

	public List<Cart> getAllCartOfUser(int idUser) {
		Session session=sessionFactory.getCurrentSession();
		Query q = session.createQuery("from cart where idUser = :idUser");
		q.setParameter("idUser", idUser);
		List<Cart> carts= q.getResultList();
		return carts;
	}

}
