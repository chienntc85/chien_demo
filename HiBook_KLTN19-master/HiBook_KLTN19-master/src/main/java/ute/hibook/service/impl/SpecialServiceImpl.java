package ute.hibook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ute.hibook.dao.imp.SpecialDao;
import ute.hibook.dto.AuthorDTO;
import ute.hibook.dto.BookDTO;
import ute.hibook.entity.Author;
import ute.hibook.entity.Book;
@Service
public class SpecialServiceImpl {

	@Autowired
	SpecialDao specialDao;
	
	@Autowired
	BookServiceImpl bookSer;
	
	public List<BookDTO> getBookLimit(int begin, int num) {
		List<Book> lstBookLimit= specialDao.getBookLimit(begin, num);
		
		List<BookDTO> lstBookDTO= new ArrayList<BookDTO>();
		for (Book book : lstBookLimit) {
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
	
	public List<BookDTO> getBestSellBooks() {
		List<Book> lstBookBestSell= specialDao.getBestSellBooks();
		
		List<BookDTO> lstBookDTO= new ArrayList<BookDTO>();
		for (Book book : lstBookBestSell) {
			
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
			
			lstBookDTO.add(bookDTO);
		}
		return lstBookDTO;
	}
	
	public List<BookDTO> getBestSellBooksLimit(int offsets, int limits) {
		List<Book> lstBookBestSell= specialDao.getBestSellBooksLimit(offsets, limits);
		
		List<BookDTO> lstBookDTO= new ArrayList<BookDTO>();
		for (Book book : lstBookBestSell) {
			
			BookDTO bookDTO=bookSer.getBookById(book.getIdBook());
			
			lstBookDTO.add(bookDTO);
		}
		return lstBookDTO;
	}
	
	public List<BookDTO> getNewBooks() {
		List<Book> lstNewBooks= specialDao.getNewBooks();
		
		List<BookDTO> lstBookDTO= new ArrayList<BookDTO>();
		for (Book book : lstNewBooks) {
			
			BookDTO bookDTO=bookSer.getBookById(book.getIdBook());
			
			lstBookDTO.add(bookDTO);
		}
		return lstBookDTO;
	}
	public List<BookDTO> getNewBooksLimit(int offsets, int limits) {
		List<Book> lstNewBooks= specialDao.getNewBooksLimit(offsets, limits);
		
		List<BookDTO> lstBookDTO= new ArrayList<BookDTO>();
		for (Book book : lstNewBooks) {
			
			BookDTO bookDTO=bookSer.getBookById(book.getIdBook());
			
			lstBookDTO.add(bookDTO);
		}
		return lstBookDTO;
	}
	
}
