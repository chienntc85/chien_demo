package ute.hibook.service;

import java.util.List;

import ute.hibook.dto.BookDTO;
import ute.hibook.dto.BookUpdateDTO;
import ute.hibook.entity.Book;

public interface BookService {

	public void addBook(Book bookDTO);
	public void updateBook(BookUpdateDTO bookDTO);
	public void deleteBook(int idBook);
	public BookDTO getBookById(int idBook);
	public List<BookDTO> getAllBook();
}
