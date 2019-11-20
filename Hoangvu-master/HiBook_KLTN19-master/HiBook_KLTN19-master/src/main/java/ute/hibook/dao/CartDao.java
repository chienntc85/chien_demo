package ute.hibook.dao;

import java.util.List;

import ute.hibook.entity.Cart;

public interface CartDao {

	public void addCart(Cart cart);
	public void updateCart(Cart cart);
	public void deleteCart(int idCart);
	public Cart getCartById(int idCart);
	public List<Cart> getAllCart();
	public List<Cart> getAllCartOfUser(int idUser);
}
