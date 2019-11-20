package ute.hibook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ute.hibook.dto.BookDTO;
import ute.hibook.service.impl.SpecialServiceImpl;

@RestController
@RequestMapping(value = "/api/v1")
public class SpecialController {

	@Autowired
	SpecialServiceImpl specialSer;
	
	@GetMapping("/bestsells")
	public ResponseEntity<List<BookDTO>> getBestSellBooks() {
		List<BookDTO> lstBestSellBook= specialSer.getBestSellBooks();
		
		if(lstBestSellBook.isEmpty()) {
			return new ResponseEntity<List<BookDTO>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<BookDTO>>(lstBestSellBook,HttpStatus.OK);
	}
	@GetMapping("/booklimit")
	public ResponseEntity<List<BookDTO>> getBookLimit() {
		List<BookDTO> lstBookLimit= specialSer.getBookLimit(0, 8);
		
		if(lstBookLimit.isEmpty()) {
			return new ResponseEntity<List<BookDTO>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<BookDTO>>(lstBookLimit,HttpStatus.OK);
	}
	
	@GetMapping("/newbook")
	public ResponseEntity<List<BookDTO>> getNewBooks() {
		List<BookDTO> lstNewBook= specialSer.getNewBooks();
		
		if(lstNewBook.isEmpty()) {
			return new ResponseEntity<List<BookDTO>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<BookDTO>>(lstNewBook,HttpStatus.OK);
	}
	
}
