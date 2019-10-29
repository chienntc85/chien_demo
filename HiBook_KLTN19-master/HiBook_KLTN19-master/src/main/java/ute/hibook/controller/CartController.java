package ute.hibook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ute.hibook.dto.BookDTO;
import ute.hibook.dto.CartDTO;
import ute.hibook.dto.UserDTO;
import ute.hibook.service.impl.CartServiceImpl;
import ute.hibook.service.impl.UserServiceImpl;
@RestController
@RequestMapping(value = "/api/v1")
public class CartController {
	@Autowired
	CartServiceImpl cartSer;
	@Autowired
	UserServiceImpl userSer;
	
	@GetMapping(value="/carts")
	public ResponseEntity<List<CartDTO>> getallCart(){
		List<CartDTO> carts= cartSer.getAllCart();
		
		if(carts.isEmpty()) {
			return new ResponseEntity<List<CartDTO>>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<List<CartDTO>>(carts,HttpStatus.OK);
	}
	
	@GetMapping(value="/numCart")
	public int getNumCartsByidUser(){
		int num = 0;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if(auth.getPrincipal() instanceof User) { 
			 User us=(User)(auth.getPrincipal()); 
			 //get id from email 
			 UserDTO user = userSer.getUserByEmail(us.getUsername());
    			 
        	List<CartDTO> carts=cartSer.getAllCartOfUser(user.getIdUser());
        	num= carts.size();
    	}
		return num;
	}
	@GetMapping(value = "/numCart/{idBook}")
	public int clickBuyBook(@PathVariable int idBook, @RequestParam int price, @RequestParam int amount) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if(auth.getPrincipal() instanceof User) { 
			 User us=(User)(auth.getPrincipal()); 
			 //get id "user current" from email 
			 UserDTO user = userSer.getUserByEmail(us.getUsername());
			 
			 //create CartDTO
			CartDTO cartDTO=new CartDTO();
			cartDTO.setUser(user);
			cartDTO.setPrice(price);
			BookDTO book=new BookDTO();
			book.setIdBook(idBook);
			cartDTO.setBook(book);
    			 
			 //get list cart of user current
        	List<CartDTO> carts=cartSer.getAllCartOfUser(user.getIdUser());
        	for(int i = 0 ; i < carts.size();i++) {
				if(carts.get(i).getBook().getIdBook() == idBook && carts.get(i).getUser().getIdUser() == user.getIdUser()) {
					cartDTO.setIdCart(carts.get(i).getIdCart());
					cartDTO.setQuantity(carts.get(i).getQuantity() + amount);
					//exist this book in cart
					cartSer.updateCart(cartDTO);
					//return number book in cart
					return carts.size();
				}
			}
        	//not exist, add book
        	cartDTO.setQuantity(amount);
			cartSer.addCart(cartDTO);
			//return number book in cart(old) + new book added
			return (carts.size() + 1);
    	}	
    	return -1;
	}
	@DeleteMapping(value = "/carts/{idCart}")
	public ResponseEntity<?> deleteCartById(@PathVariable int idCart){
		cartSer.deleteCart(idCart);
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
	@PutMapping(value = "/carts/{idCart}")
	public ResponseEntity<?> updateQuantityInCart(@PathVariable int idCart, @RequestBody CartDTO cartDTO){
		CartDTO cart = cartSer.getCartById(idCart);
		cart.setQuantity(cartDTO.getQuantity());
		
		cartSer.updateCart(cart);
		 
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	

}
