package ute.hibook.dao;

import java.util.List;

import ute.hibook.entity.Book;

public interface SearchBookDao {
	
	public List<Book> searchByKey(String key, int offsets, int limits);
	public List<Book> searchIndex(String key);
	public List<Book> searchIndexType(String key, String type);
	public List<Book> searchFirstKey(String firstKey);
	public List<Book> searchAuthor(int idAuthor);
	public List<Book> searchSupplier(int idSupplier);
	public List<Book> searchType(int idType, int offsets, int limits);
}
