package ute.hibook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ute.hibook.dao.imp.AuthorDaoImpl;
import ute.hibook.dto.AuthorDTO;
import ute.hibook.dto.BookDTO;
import ute.hibook.entity.Author;
import ute.hibook.entity.Book;
import ute.hibook.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService{

	@Autowired
	AuthorDaoImpl authorDao;

	public void addAuthor(AuthorDTO authorDTO) {
		Author author= new Author();
		author.setNameAuthor(authorDTO.getNameAuthor());
		authorDao.addAuthor(author);		
		System.out.println("add Author successful!");
	}

	public void updateAuthor(AuthorDTO authorDTO) {
		Author author= authorDao.getAuthorById(authorDTO.getIdAuthor());
		if(author!=null) {
			author.setNameAuthor(authorDTO.getNameAuthor());
			authorDao.updateAuthor(author);
			System.out.println("update Author successful!");
		}
		
	}

	public void deleteAuthor(int idAuthor) {
		Author author= authorDao.getAuthorById(idAuthor);
		if(author!=null) {
			authorDao.deleteAuthor(idAuthor);
			System.out.println("delete Author successful!");
		}
	}

	public AuthorDTO getAuthorById(int idAuthor) {
		Author author= authorDao.getAuthorById(idAuthor);
		
		AuthorDTO authorDTO= new AuthorDTO();
		authorDTO.setIdAuthor(author.getIdAuthor());
		authorDTO.setNameAuthor(author.getNameAuthor());
		System.out.println(author.getBooks().get(0).getNameBook());
		
		return authorDTO;
	}

	public List<AuthorDTO> getAllAuthor() {
		List<Author> lstAuthor= authorDao.getAllAuthor();
		
		List<AuthorDTO> lstAuthorDTO= new ArrayList<AuthorDTO>();
		for (Author author : lstAuthor) {
			
			AuthorDTO authorDTO= new AuthorDTO();
			authorDTO.setIdAuthor(author.getIdAuthor());
			authorDTO.setNameAuthor(author.getNameAuthor());

			List<BookDTO> books = new ArrayList<BookDTO>();
			for(Book book : author.getBooks()) {
				BookDTO bookDTO = new BookDTO();
				bookDTO.setIdBook(book.getIdBook());
				bookDTO.setNameBook(book.getNameBook());
				books.add(bookDTO);
			}
			
			authorDTO.setBooks(books);
		
			lstAuthorDTO.add(authorDTO);
		}
		return lstAuthorDTO;
	}
	
	
}
