package ute.hibook.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ute.hibook.dto.BookDTO;
import ute.hibook.dto.BookUpdateDTO;
import ute.hibook.dto.CartDTO;
import ute.hibook.dto.TagsearchDTO;
import ute.hibook.dto.UserDTO;
import ute.hibook.entity.Author;
import ute.hibook.entity.Book;
import ute.hibook.entity.History;
import ute.hibook.entity.Supplier;
import ute.hibook.entity.Typebook;
import ute.hibook.service.impl.BookServiceImpl;
import ute.hibook.service.impl.CartServiceImpl;
import ute.hibook.service.impl.HistoryServiceImpl;
import ute.hibook.service.impl.TagsearchServiceImpl;
import ute.hibook.service.impl.UserServiceImpl;
@RestController
@RequestMapping(value = "/api/v1")
public class BookController {

	@Autowired
	BookServiceImpl bookSer;
	@Autowired
	TagsearchServiceImpl tagsearchSer;
	@Autowired
	HistoryServiceImpl historySer;
	@Autowired
	UserServiceImpl userSer;
	@Autowired
	CartServiceImpl cartSer;

	@GetMapping(value="/books")
	public ResponseEntity<List<BookDTO>> getAllBook(){
		ArrayList<BookDTO> arrayListBook=(ArrayList<BookDTO>) bookSer.getAllBook();

		if(arrayListBook.isEmpty()) {
			return new ResponseEntity<List<BookDTO>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<BookDTO>>(arrayListBook,HttpStatus.OK);
	}

	@GetMapping(value="/books/{idBook}")
	public ResponseEntity<BookDTO> getBookById(@PathVariable int idBook){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		boolean them = false;
		if(auth.getPrincipal() instanceof User) { 
			User us=(User)(auth.getPrincipal()); 
			//get id from email 
			UserDTO user = userSer.getUserByEmail(us.getUsername());
			// getallhisstory
			List<History> getHis=historySer.getAllHistory();
			History history=new History();
			if(getHis.size()==0) {
				them = false;
			}
			else {
				for (History gethistory : getHis) {
					if(((gethistory.getIdBook())==idBook)&&gethistory.getIdUser()==user.getIdUser()){		
						them = true;
					}
				}
			}
			if(!them) {
				history.setIdBook(idBook);
				history.setStatus(0);
				history.setIdUser(user.getIdUser());
				historySer.addHistory(history);
				System.out.println(history);
			}
		}
		BookDTO book=bookSer.getBookById(idBook);

		if(null == book) {
			return new ResponseEntity<BookDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<BookDTO>(book,HttpStatus.OK);
	}


	/*======================ADD Book================= */
	@PostMapping(value="/books")
	public ResponseEntity<?> addBook(@RequestParam String publisher,@RequestParam String nameBook, @RequestParam int price, @RequestParam int discount, 
			@RequestParam String size, @RequestParam int numberPage, @RequestParam String publicationDate,
			@RequestParam int quantity, @RequestParam String cover, @RequestParam String intro, @RequestParam String fileimg,
			@RequestParam String fileproofread, @RequestParam int idType, @RequestParam int idSupplier, 
			@RequestParam(value="arr_author[]") List<Integer> arr_author, @RequestParam(value="tags") String tags){

		Book book=new Book();
		book.setNameBook(nameBook);
		book.setCover(cover);
		book.setPublisher(publisher);
		book.setSize(size);
		book.setNumberPage(numberPage);
		book.setPublicationDate(publicationDate);
		book.setQuantity(quantity);
		book.setIntroBook(intro);
		book.setDiscount(discount);
		book.setPrice(price);
		book.setPicBook(fileimg);
		book.setProofread(fileproofread);
		//set status 0: new add, haven't bill
		book.setStatus(0);
		//list tag using search
		book.setTagList(tags);

		Typebook type = new Typebook();
		type.setIdType(idType);
		book.setTypebook(type);

		Supplier supplier = new Supplier();
		supplier.setIdSupplier(idSupplier);
		book.setSupplier(supplier);

		List<Author> authors=new ArrayList<Author>();
		for (int author : arr_author) {
			Author auth = new Author();
			auth.setIdAuthor(author);
			authors.add(auth);
		}
		book.setAuthors(authors);

		bookSer.addBook(book);

		//cut String taglist in book, save into tagsearch table
		//cut String by ','
		String[] arr_tags = tags.split(",");
		for (String tag : arr_tags) {
			TagsearchDTO tagDTO = new TagsearchDTO();
			tagDTO.setValue(tag);
			tagDTO.setNumOfSearch(0);
			tagsearchSer.addTag(tagDTO);
		}
		return new ResponseEntity<Integer>(1, HttpStatus.OK);
	}

	/*======================UPDATE Book================= */
	@PutMapping(value="/books/{idBook}")
	public ResponseEntity<?> updateBook(@PathVariable int idBook, @RequestBody BookUpdateDTO bookdto){

		bookdto.setIdBook(idBook);

		bookSer.updateBook(bookdto);
		return new ResponseEntity<Integer>(idBook, HttpStatus.OK);
	}
	/*======================DELETE book by ID================= */
	@DeleteMapping(value="/books/{idBook}")
	public ResponseEntity<?> deleteBook(@PathVariable int idBook){
		bookSer.deleteBook(idBook);

		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}

}
