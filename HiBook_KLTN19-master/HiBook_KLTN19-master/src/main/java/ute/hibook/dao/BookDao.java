package ute.hibook.dao;

import java.util.List;

import ute.hibook.entity.Book;

public interface BookDao {

	public void addBook(Book book);
	public void updateBook(Book book);
	public void deleteBook(int idBook);
	public Book getBookById(int idBook);
	public List<Book> getAllBook();
}
