package ute.hibook.dao;

import java.util.List;

import ute.hibook.entity.Author;

public interface AuthorDao {

	public void addAuthor(Author author);
	public void updateAuthor(Author author);
	public void deleteAuthor(int idAuthor);
	public Author getAuthorById(int idAuthor);
	public List<Author> getAllAuthor();
}
