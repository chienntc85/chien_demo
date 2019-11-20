package ute.hibook.service;

import java.util.List;

import ute.hibook.dto.CartDTO;


public interface CartService {

	public void addCart(CartDTO cartDTO);
	public void updateCart(CartDTO cartDTO);
	public void deleteCart(int idCart);
	public CartDTO getCartById(int idCart);
	public List<CartDTO> getAllCart();
	public List<CartDTO> getAllCartOfUser(int idUser);
}
