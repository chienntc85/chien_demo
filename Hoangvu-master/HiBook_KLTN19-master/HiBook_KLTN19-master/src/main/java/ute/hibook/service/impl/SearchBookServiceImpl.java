package ute.hibook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ute.hibook.dao.imp.SearchBookDaoImpl;
import ute.hibook.dto.AuthorDTO;
import ute.hibook.dto.BookDTO;
import ute.hibook.entity.Author;
import ute.hibook.entity.Book;
import ute.hibook.service.SearchBookService;

@Service
public class SearchBookServiceImpl implements SearchBookService{
	@Autowired
	SearchBookDaoImpl searchDao;
	@Autowired
	BookServiceImpl bookSer;
	
	public List<BookDTO> searchIndex(String key) {
		List<Book> books = searchDao.searchIndex(key);
		
		List<BookDTO> lstBookDTO= new ArrayList<BookDTO>();
		for (Book book : books) {
			BookDTO bookDTO=new BookDTO();
			
			bookDTO.setIdBook(book.getIdBook());
			bookDTO.setNameBook(book.getNameBook());
			bookDTO.setDiscount(book.getDiscount());
			bookDTO.setPicBook(book.getPicBook());
			bookDTO.setPrice(book.getPrice());
			bookDTO.setProofread(book.getProofread());
			bookDTO.setPublisher(book.getPublisher());
			bookDTO.setQuantity(book.getQuantity());
			bookDTO.setStatus(book.getStatus());
			bookDTO.setTagList(book.getTagList());
			
			List<AuthorDTO> lstAuthor=new ArrayList<AuthorDTO>();
			for (Author author : book.getAuthors()) {
				AuthorDTO authorDTO=new AuthorDTO();
				authorDTO.setIdAuthor(author.getIdAuthor());
				authorDTO.setNameAuthor(author.getNameAuthor());
				lstAuthor.add(authorDTO);
			}
			bookDTO.setAuthors(lstAuthor);
			
			lstBookDTO.add(bookDTO);
		}
		return lstBookDTO;
	}

	public List<BookDTO> searchIndexType(String key, String type) {
		List<Book> books = searchDao.searchIndexType(key, type);
		
		List<BookDTO> lstBookDTO= new ArrayList<BookDTO>();
		for (Book book : books) {
			BookDTO bookDTO=new BookDTO();
			
			bookDTO.setIdBook(book.getIdBook());
			bookDTO.setNameBook(book.getNameBook());
			bookDTO.setDiscount(book.getDiscount());
			bookDTO.setPicBook(book.getPicBook());
			bookDTO.setPrice(book.getPrice());
			bookDTO.setProofread(book.getProofread());
			bookDTO.setPublisher(book.getPublisher());
			bookDTO.setQuantity(book.getQuantity());
			bookDTO.setStatus(book.getStatus());
			bookDTO.setTagList(book.getTagList());
			
			List<AuthorDTO> lstAuthor=new ArrayList<AuthorDTO>();
			for (Author author : book.getAuthors()) {
				AuthorDTO authorDTO=new AuthorDTO();
				authorDTO.setIdAuthor(author.getIdAuthor());
				authorDTO.setNameAuthor(author.getNameAuthor());
				lstAuthor.add(authorDTO);
			}
			bookDTO.setAuthors(lstAuthor);
			
			lstBookDTO.add(bookDTO);
		}
		return lstBookDTO;
	}

	public List<BookDTO> searchFirstKey(String firstKey) {
		List<Book> books = searchDao.searchFirstKey(firstKey);

		List<BookDTO> lstBookDTO= new ArrayList<BookDTO>();
		for (Book book : books) {
			BookDTO bookDTO=new BookDTO();
			
			bookDTO.setIdBook(book.getIdBook());
			bookDTO.setNameBook(book.getNameBook());
			bookDTO.setDiscount(book.getDiscount());
			bookDTO.setPicBook(book.getPicBook());
			bookDTO.setPrice(book.getPrice());
			bookDTO.setProofread(book.getProofread());
			bookDTO.setPublisher(book.getPublisher());
			bookDTO.setQuantity(book.getQuantity());
			bookDTO.setStatus(book.getStatus());
			bookDTO.setTagList(book.getTagList());
			
			List<AuthorDTO> lstAuthor=new ArrayList<AuthorDTO>();
			for (Author author : book.getAuthors()) {
				AuthorDTO authorDTO=new AuthorDTO();
				authorDTO.setIdAuthor(author.getIdAuthor());
				authorDTO.setNameAuthor(author.getNameAuthor());
				lstAuthor.add(authorDTO);
			}
			bookDTO.setAuthors(lstAuthor);
			
			lstBookDTO.add(bookDTO);
		}
		return lstBookDTO;
	}

	public List<BookDTO> searchAuthor(int idAuthor) {
		List<Book> books = searchDao.searchAuthor(idAuthor);
		
		List<BookDTO> lstBookDTO= new ArrayList<BookDTO>();
		for (Book book : books) {
			BookDTO bookDTO=new BookDTO();
			
			bookDTO.setIdBook(book.getIdBook());
			bookDTO.setNameBook(book.getNameBook());
			bookDTO.setDiscount(book.getDiscount());
			bookDTO.setPicBook(book.getPicBook());
			bookDTO.setPrice(book.getPrice());
			bookDTO.setProofread(book.getProofread());
			bookDTO.setPublisher(book.getPublisher());
			bookDTO.setQuantity(book.getQuantity());
			bookDTO.setStatus(book.getStatus());
			bookDTO.setTagList(book.getTagList());
			
			List<AuthorDTO> lstAuthor=new ArrayList<AuthorDTO>();
			for (Author author : book.getAuthors()) {
				AuthorDTO authorDTO=new AuthorDTO();
				authorDTO.setIdAuthor(author.getIdAuthor());
				authorDTO.setNameAuthor(author.getNameAuthor());
				lstAuthor.add(authorDTO);
			}
			bookDTO.setAuthors(lstAuthor);
			
			lstBookDTO.add(bookDTO);
		}
		return lstBookDTO;
	}

	public List<BookDTO> searchSupplier(int idSupplier) {
		List<Book> books = searchDao.searchSupplier(idSupplier);
		
		List<BookDTO> lstBookDTO= new ArrayList<BookDTO>();
		for (Book book : books) {
			BookDTO bookDTO=new BookDTO();
			
			bookDTO.setIdBook(book.getIdBook());
			bookDTO.setNameBook(book.getNameBook());
			bookDTO.setDiscount(book.getDiscount());
			bookDTO.setPicBook(book.getPicBook());
			bookDTO.setPrice(book.getPrice());
			bookDTO.setProofread(book.getProofread());
			bookDTO.setPublisher(book.getPublisher());
			bookDTO.setQuantity(book.getQuantity());
			bookDTO.setStatus(book.getStatus());
			bookDTO.setTagList(book.getTagList());
			
			List<AuthorDTO> lstAuthor=new ArrayList<AuthorDTO>();
			for (Author author : book.getAuthors()) {
				AuthorDTO authorDTO=new AuthorDTO();
				authorDTO.setIdAuthor(author.getIdAuthor());
				authorDTO.setNameAuthor(author.getNameAuthor());
				lstAuthor.add(authorDTO);
			}
			bookDTO.setAuthors(lstAuthor);
			
			lstBookDTO.add(bookDTO);
		}
		return lstBookDTO;
	}

	//
	public List<BookDTO> searchType(int idType, int offsets, int limits) {
		List<Book> books = searchDao.searchType(idType, offsets, limits);
		
		List<BookDTO> lstBookDTO= new ArrayList<BookDTO>();
		for (Book book : books) {
			
			BookDTO bookDTO=bookSer.getBookById(book.getIdBook());
			lstBookDTO.add(bookDTO);
		}
		return lstBookDTO;
	}

	//
	public List<BookDTO> searchByKey(String key, int offsets, int limits) {
		List<Book> books = searchDao.searchByKey(key, offsets, limits);
		
		List<BookDTO> lstBookDTO= new ArrayList<BookDTO>();
		for (Book book : books) {
			
			BookDTO bookDTO=bookSer.getBookById(book.getIdBook());
			lstBookDTO.add(bookDTO);
		}
		return lstBookDTO;
	}

}
