package ute.hibook.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ute.hibook.dto.BookDTO;
import ute.hibook.dto.SearchDTO;
import ute.hibook.service.impl.SearchBookServiceImpl;
import ute.hibook.service.impl.SpecialServiceImpl;

@RestController
@RequestMapping(value = "/api/v1")
public class SearchBookController {

	@Autowired
	SpecialServiceImpl specialSer;
	@Autowired
	SearchBookServiceImpl searchSer;
	
	@GetMapping("/booklimit-author")
	public ResponseEntity<List<SearchDTO>> getInforDifferent() {
		List<SearchDTO> searchs =new ArrayList<SearchDTO>();
		if(searchs.isEmpty()) {
			return new ResponseEntity<List<SearchDTO>>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<List<SearchDTO>>(searchs,HttpStatus.OK);
	}
	
	@GetMapping({"/search-bestsells"})
	public ResponseEntity<?> searchBestsells() {
		List<BookDTO> bookall = specialSer.getBestSellBooksLimit(-1, 6);
		SearchDTO searchDTO = paginationListBook(bookall, (1-1)*6, 6);
		
		if(bookall.isEmpty()) {
			return new ResponseEntity<SearchDTO>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<SearchDTO>(searchDTO, HttpStatus.OK);
	}
	
	@GetMapping({"/search-type/{idType}"})
	public ResponseEntity<?> searchType(@PathVariable int idType, Model model) {
		List<BookDTO> bookall = searchSer.searchType(idType, -1, 6);
		SearchDTO searchDTO = paginationListBook(bookall, (1-1)*6, 6);
		if(bookall.isEmpty()) {
			return new ResponseEntity<SearchDTO>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<SearchDTO>(searchDTO, HttpStatus.OK);
	}
	
	@GetMapping({"/search-by-type"})
	public ResponseEntity<?> searchTypeByType(@RequestParam int type, Model model) {
		List<BookDTO> bookall = searchSer.searchType(type, 0, 8);
		if(bookall.isEmpty()) {
			return new ResponseEntity<SearchDTO>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<List<BookDTO>>(bookall, HttpStatus.OK);
	}
	
	@GetMapping({"/search-newbook"})
	public ResponseEntity<?> searchBookPage() {
		
		List<BookDTO> bookall = specialSer.getNewBooksLimit(-1, 6);
		SearchDTO searchDTO = paginationListBook(bookall, (1-1)*6, 6);
		
		if(bookall.isEmpty()) {
			return new ResponseEntity<SearchDTO>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<SearchDTO>(searchDTO, HttpStatus.OK);
	}
	@GetMapping({"/search-key"})
	public ResponseEntity<?> searchKey(@RequestParam(value = "key") String keyword, Model model) {
		List<BookDTO> bookall = searchSer.searchByKey(keyword, -1, 6);
		SearchDTO searchDTO = paginationListBook(bookall, (1-1)*6, 6);
		
		if(bookall.isEmpty()) {
			return new ResponseEntity<SearchDTO>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<SearchDTO>(searchDTO, HttpStatus.OK);
	}
	
	public SearchDTO paginationListBook(List<BookDTO> bookall, int offsets, int limit) {
		SearchDTO searchDTO = new SearchDTO();
		
		//total page
		if((bookall.size() % limit)==0) {
			searchDTO.setTotalpage(bookall.size()/limit);
		}else {
			searchDTO.setTotalpage(bookall.size()/limit + 1);
		}
		//get currentpage
		if(offsets == -1) {
			searchDTO.setCurrentpage(1);
			
		}else {
			int num_current = offsets/limit+1;
			searchDTO.setCurrentpage(num_current);
		}
		searchDTO.setAllBooks(bookall);
		return searchDTO;
	}
	
}
