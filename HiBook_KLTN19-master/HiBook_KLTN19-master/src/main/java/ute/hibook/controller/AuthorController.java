package ute.hibook.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ute.hibook.dto.AuthorDTO;
import ute.hibook.service.impl.AuthorServiceImpl;

@RestController
@RequestMapping(value = "/api/v1")
public class AuthorController {

	@Autowired
	AuthorServiceImpl authorSer;
	
	@GetMapping("/authors")
	public ResponseEntity<List<AuthorDTO>> getAllAuthor() {
		
		List<AuthorDTO> authors= authorSer.getAllAuthor();

		if(authors.isEmpty()) {
			return new ResponseEntity<List<AuthorDTO>>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<List<AuthorDTO>>(authors,HttpStatus.OK);
	}
	
	@GetMapping("/authors/{idAuthor}")
	public ResponseEntity<AuthorDTO> getAuthorById(@PathVariable int idAuthor) {
		
		AuthorDTO author= authorSer.getAuthorById(idAuthor);
		if(Objects.isNull(author)) {
			return new ResponseEntity<AuthorDTO>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<AuthorDTO>(author,HttpStatus.OK);
	}
	
	@PostMapping(value="/authors")
	public ResponseEntity<?> addAuthor(@RequestParam String nameAuthor){
		AuthorDTO author=new AuthorDTO();
		author.setNameAuthor(nameAuthor);
		authorSer.addAuthor(author);
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
	@PutMapping(value="/authors/{idAuthor}")
	public ResponseEntity<?> updateAuthor(@PathVariable int idAuthor, @RequestBody AuthorDTO author){
		author.setIdAuthor(idAuthor);
		authorSer.updateAuthor(author);
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/authors/{idAuthor}")
	public ResponseEntity<?> deleteAuthor(@PathVariable int idAuthor){
		authorSer.deleteAuthor(idAuthor);
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}
