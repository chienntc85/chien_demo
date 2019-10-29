package ute.hibook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ute.hibook.dao.imp.BookDaoImpl;
import ute.hibook.dao.imp.CartDaoImpl;
import ute.hibook.dao.imp.UserDaoImpl;
import ute.hibook.dto.BookDTO;
import ute.hibook.dto.CartDTO;
import ute.hibook.dto.UserDTO;
import ute.hibook.entity.Book;
import ute.hibook.entity.Cart;
import ute.hibook.entity.User;
import ute.hibook.service.CartService;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	CartDaoImpl cartDao;
	@Autowired
	UserDaoImpl userDao;
	@Autowired
	BookDaoImpl bookDao;
	
	public void addCart(CartDTO cartDTO) {
		Cart cart= new Cart();
		cart.setPrice(cartDTO.getPrice());
		cart.setQuantity(cartDTO.getQuantity());
		User user= userDao.getUserById(cartDTO.getUser().getIdUser());
		cart.setUser(user);
		Book book= bookDao.getBookById(cartDTO.getBook().getIdBook());
		cart.setBook(book);
		
		cartDao.addCart(cart);		
		System.out.println("add Cart successful!");
	}

	public void updateCart(CartDTO cartDTO) {
		Cart cart= cartDao.getCartById(cartDTO.getIdCart());
		if(cart != null) {
			cart.setPrice(cartDTO.getPrice());
			cart.setQuantity(cartDTO.getQuantity());
			User user= userDao.getUserById(cartDTO.getUser().getIdUser());
			cart.setUser(user);
			Book book= bookDao.getBookById(cartDTO.getBook().getIdBook());
			cart.setBook(book);
			
			cartDao.updateCart(cart);
			System.out.println("update Cart successful!");
		}
	}

	public void deleteCart(int idCart) {
		Cart cart= cartDao.getCartById(idCart);
		if(cart!=null) {
			cartDao.deleteCart(idCart);
			System.out.println("delete Cart successful!");
		}
	}

	public CartDTO getCartById(int idCart) {
		Cart cart= cartDao.getCartById(idCart);
		
		CartDTO cartDTO= new CartDTO();
		cartDTO.setIdCart(cart.getIdCart());
		cartDTO.setPrice(cart.getPrice());
		cartDTO.setQuantity(cart.getQuantity());
		UserDTO userDTO=new UserDTO(cart.getUser().getIdUser(), cart.getUser().getAddress(),
				cart.getUser().getEmail(), cart.getUser().getNameUser(), cart.getUser().getNumberphone());
		cartDTO.setUser(userDTO);
		BookDTO bookDTO=new BookDTO(cart.getBook().getIdBook(), cart.getBook().getDiscount(), cart.getBook().getNameBook()
				, cart.getBook().getPicBook(), cart.getBook().getPrice(), cart.getBook().getQuantity(), cart.getBook().getStatus());
		cartDTO.setBook(bookDTO);
		//System.out.println(cart.getUsers().get(0).getEmail());
		
		return cartDTO;
	}

	public List<CartDTO> getAllCart() {
		List<Cart> lstCart= cartDao.getAllCart();
		
		List<CartDTO> lstCartDTO= new ArrayList<CartDTO>();
		for (Cart cart : lstCart) {
			
			CartDTO cartDTO= new CartDTO();
			cartDTO.setIdCart(cart.getIdCart());
			cartDTO.setPrice(cart.getPrice());
			cartDTO.setQuantity(cart.getQuantity());
			UserDTO userDTO=new UserDTO(cart.getUser().getIdUser(), cart.getUser().getAddress(),
					cart.getUser().getEmail(), cart.getUser().getNameUser(), cart.getUser().getNumberphone());
			cartDTO.setUser(userDTO);
			BookDTO bookDTO=new BookDTO(cart.getBook().getIdBook(), cart.getBook().getDiscount(), cart.getBook().getNameBook()
					, cart.getBook().getPicBook(), cart.getBook().getPrice(), cart.getBook().getQuantity(), cart.getBook().getStatus());
			cartDTO.setBook(bookDTO);
		
			lstCartDTO.add(cartDTO);
		}
		return lstCartDTO;
	}

	public List<CartDTO> getAllCartOfUser(int idUser) {
		List<Cart> lstCart= cartDao.getAllCartOfUser(idUser);
		
		List<CartDTO> lstCartDTO= new ArrayList<CartDTO>();
		for (Cart cart : lstCart) {
			
			CartDTO cartDTO= new CartDTO();
			cartDTO.setIdCart(cart.getIdCart());
			cartDTO.setPrice(cart.getPrice());
			cartDTO.setQuantity(cart.getQuantity());
			UserDTO userDTO=new UserDTO(cart.getUser().getIdUser(), cart.getUser().getAddress(),
					cart.getUser().getEmail(), cart.getUser().getNameUser(), cart.getUser().getNumberphone());
			cartDTO.setUser(userDTO);
			BookDTO bookDTO=new BookDTO(cart.getBook().getIdBook(), cart.getBook().getDiscount(), cart.getBook().getNameBook()
					, cart.getBook().getPicBook(), cart.getBook().getPrice(), cart.getBook().getQuantity(), cart.getBook().getStatus());
			cartDTO.setBook(bookDTO);
		
			lstCartDTO.add(cartDTO);
		}
		return lstCartDTO;
	}

}
