package ute.hibook.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import ute.hibook.dto.AuthorDTO;
import ute.hibook.dto.BookDTO;
import ute.hibook.dto.PublisherDTO;
import ute.hibook.dto.SearchDTO;
import ute.hibook.dto.SupplierDTO;
import ute.hibook.service.impl.BookServiceImpl;
import ute.hibook.service.impl.SearchBookServiceImpl;
import ute.hibook.service.impl.SpecialServiceImpl;

@Controller
public class Page1Controller {
	@Autowired
	SearchBookServiceImpl searchSer;
	@Autowired
	SpecialServiceImpl specialSer;
	@Autowired 
	BookServiceImpl bookSer;

	@GetMapping({"/search-author/{idAuthor}"})
	public String searchAuthor(@PathVariable int idAuthor, Model model) {
		List<BookDTO> books = searchSer.searchAuthor(idAuthor);
		if(books.isEmpty()) {
			model.addAttribute("lstBookSearch", null);
		}else {
			model.addAttribute("lstBookSearch", books);
		}
		return "listbook";
	}
	
	@GetMapping({"/search-supplier/{idSupplier}"})
	public String searchSupplier(@PathVariable int idSupplier, Model model) {
		List<BookDTO> books = searchSer.searchSupplier(idSupplier);
		if(books.isEmpty()) {
			model.addAttribute("lstBookSearch", null);
		}else {
			model.addAttribute("lstBookSearch", books);
		}
		return "listbook";
	}
	
	@GetMapping({"/search-key"})
	public String searchKey(@RequestParam(value = "key") String keyword, Model model) {
		List<BookDTO> books = searchSer.searchByKey(keyword, -1, 6);
		SearchDTO searchDTO = paginationListBook(books, (1-1)*6, 6);
		if(searchDTO == null) {
			model.addAttribute("search", null);
		}else {
			model.addAttribute("search", searchDTO);
		}
		return "listbook";
	}
	
	@GetMapping({"/search-type/{idType}"})
	public String searchType(@PathVariable int idType, Model model) {
		List<BookDTO> books = searchSer.searchType(idType, -1, 6);
		SearchDTO searchDTO = paginationListBook(books, (1-1)*6, 6);
		if(searchDTO == null) {
			model.addAttribute("search", null);
		}else {
			model.addAttribute("search", searchDTO);
		}
		return "listbook";
	}
	
	@GetMapping({"/search-bestsells"})
	public String searchBestsells(Model model) {
		List<BookDTO> bookall = specialSer.getBestSellBooksLimit(-1, 6);
		SearchDTO searchDTO = paginationListBook(bookall, (1-1)*6, 6);
		
		if(searchDTO == null) {
			model.addAttribute("search", null);
		}else {
			model.addAttribute("search", searchDTO);
		}
		return "listbook";
	}
	
	@GetMapping({"/search-newbook"})
	public String searchBookPage(Model model) {
		
		List<BookDTO> bookall = specialSer.getNewBooksLimit(-1, 6);
		SearchDTO searchDTO = paginationListBook(bookall, (1-1)*6, 6);
		
		if(searchDTO == null) {
			model.addAttribute("search", null);
		}else {
			model.addAttribute("search", searchDTO);
		}
		return "listbook";
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
		
		List<SupplierDTO> lstSupplier = new ArrayList<SupplierDTO>();
		List<PublisherDTO> lstPublisher = new ArrayList<PublisherDTO>();
		//
		List<AuthorDTO> lstAuthor = new ArrayList<AuthorDTO>();
		for (int t=0; t<bookall.size(); t++) {
			BookDTO bookDTO = bookall.get(t);
			//Supplier
			boolean flag = false;
			for (int i=0; i < lstSupplier.size(); i++) {
				if(lstSupplier.get(i).getIdSupplier() == bookDTO.getSupplier().getIdSupplier())
				{
					lstSupplier.get(i).setNumBookSearch(lstSupplier.get(i).getNumBookSearch()+1);
					flag = true;
					break;
				}
			}
			if(flag == false) {
				bookDTO.getSupplier().setNumBookSearch(1);
				lstSupplier.add(bookDTO.getSupplier());
			}
			//publisher
			flag = false;
			for (int i=0; i < lstPublisher.size(); i++) {
				if(lstPublisher.get(i).getNamePublisher().equals(bookDTO.getPublisher()))
				{
					lstPublisher.get(i).setNumBookSearch(lstPublisher.get(i).getNumBookSearch()+1);
					flag = true;
					break;
				}
			}
			if(flag == false) {
				PublisherDTO publisher = new PublisherDTO(bookDTO.getPublisher(), 1);
				lstPublisher.add(publisher);
			}
			
			//author
			for (int j=0; j < bookDTO.getAuthors().size(); j++) {
				
				if(lstAuthor.size() == 0) {
					lstAuthor.add(bookDTO.getAuthors().get(j));
					lstAuthor.get(0).setNumBookSearch(1);
				}else {
					flag=false;
					for (int i=0; i < lstAuthor.size(); i++) {
						if(bookDTO.getAuthors().get(j).getIdAuthor() == lstAuthor.get(i).getIdAuthor())
						{
							lstAuthor.get(i).setNumBookSearch(lstAuthor.get(i).getNumBookSearch()+1);
							flag = true;
							break;
						}else {
							flag = false;
						}
					}
					if(flag == false) {
						lstAuthor.add(bookDTO.getAuthors().get(j));
						lstAuthor.get(lstAuthor.size()-1).setNumBookSearch(1);
					}
				}
			}
			
		}
		searchDTO.setLstAuthor(lstAuthor);
		searchDTO.setLstSupplier(lstSupplier);
		searchDTO.setLstPublisher(lstPublisher);
		//searchDTO.setAllBooks(bookall);//// add 09-06-19 to using multi filter
		return searchDTO;
	}
}
