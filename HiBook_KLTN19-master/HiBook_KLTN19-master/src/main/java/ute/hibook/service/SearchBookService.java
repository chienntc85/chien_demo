package ute.hibook.service;

import java.util.List;

import ute.hibook.dto.BookDTO;

public interface SearchBookService {

	public List<BookDTO> searchIndex(String key);
	public List<BookDTO> searchIndexType(String key, String type);
	public List<BookDTO> searchFirstKey(String firstKey);
	public List<BookDTO> searchAuthor(int idAuthor);
	public List<BookDTO> searchSupplier(int idSupplier);
	public List<BookDTO> searchType(int idType, int offsets, int limits);
	public List<BookDTO> searchByKey(String key, int offsets, int limits);
}
