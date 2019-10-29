package ute.hibook.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ute.hibook.dto.BookDTO;
import ute.hibook.dto.TagsearchDTO;
import ute.hibook.dto.UserDTO;
import ute.hibook.entity.History;
import ute.hibook.service.impl.BookServiceImpl;
import ute.hibook.service.impl.HistoryServiceImpl;
import ute.hibook.service.impl.UserServiceImpl;

@RestController
@RequestMapping(value = "/api/v1")
public class HistoryController {

	@Autowired
	HistoryServiceImpl historySer;

	@Autowired
	UserServiceImpl userSer;
	@Autowired
	BookServiceImpl bookSer;

	@GetMapping({"/histories"})
	public ResponseEntity<?> getAllHistory() {

		List<History> histories= historySer.getAllHistory();

		if(histories.isEmpty()) {
			return new ResponseEntity<List<TagsearchDTO>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<History>>(histories,HttpStatus.OK);
	}
	@GetMapping({"/history"})
	public ResponseEntity<?> getHistoryByIdUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth.getPrincipal() instanceof User) { 
			User us=(User)(auth.getPrincipal()); 
			//get id from email 
			UserDTO user = userSer.getUserByEmail(us.getUsername());
			List<History> histories= historySer.getHistoryByidUser(user.getIdUser());
			List<BookDTO> books = new ArrayList<BookDTO>();
			for (History history : histories) {
				BookDTO bookDTO=bookSer.getBookById(history.getIdBook());
				books.add(bookDTO);
			}
			return new ResponseEntity<List<BookDTO>>(books,HttpStatus.OK);
		}

		return new ResponseEntity<List<BookDTO>>(HttpStatus.NOT_FOUND);
	}

}
