package ute.hibook.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ute.hibook.dto.BookDTO;
import ute.hibook.dto.UserDTO;
import ute.hibook.dto.UserreviewDTO;
import ute.hibook.service.impl.UserServiceImpl;
import ute.hibook.service.impl.UserreviewServiceImpl;

@RestController
@RequestMapping(value = "/api/v1")
public class UserReviewController {

	@Autowired
	UserreviewServiceImpl userReviewSer;
	@Autowired
	UserServiceImpl userSer;
	
//	Load userreview admin
	@GetMapping(value = "/reviews")
	public ResponseEntity<List<UserreviewDTO>> loadUserReview(){
		List<UserreviewDTO> listReview=userReviewSer.getAllUserreview();
		
		if(listReview.isEmpty()) {
			return new ResponseEntity<List<UserreviewDTO>>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<List<UserreviewDTO>>(listReview,HttpStatus.OK);
		
	}
	/*======================ADD user================= */
	@PostMapping(value="/userreiew/{idBook}")
	public ResponseEntity<?> addUserReview(@PathVariable int idBook, @RequestParam String star, @RequestParam String title,
			@RequestParam String content){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if(auth.getPrincipal() instanceof User) { 
    		User us=(User)(auth.getPrincipal()); 
			 //get id from email 
			 UserDTO user = userSer.getUserByEmail(us.getUsername());
			 //get Date Now
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");  
		    Date date = new Date();  
			
			UserreviewDTO userreviewDTO = new UserreviewDTO();
			userreviewDTO.setStar(Integer.parseInt(star));
			userreviewDTO.setTitle(title);
			userreviewDTO.setContent(content);
			userreviewDTO.setTimeReview(formatter.format(date));
			BookDTO bookDTO = new BookDTO();
			bookDTO.setIdBook(idBook);
			userreviewDTO.setBook(bookDTO);
			userreviewDTO.setUser(user);
			
			userReviewSer.addUserreview(userreviewDTO);
			return new ResponseEntity<Integer>(1, HttpStatus.OK);
    	}
		return new ResponseEntity<Integer>(-1, HttpStatus.OK);
	}
	/*======================DELETE Review by ID================= */
	@DeleteMapping(value="/reviews/{idReview}")
	public ResponseEntity<?> deleteReview(@PathVariable int idReview){
		System.out.println(idReview);
		userReviewSer.deleteUserreview(idReview);
		
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}
