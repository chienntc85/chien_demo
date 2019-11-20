package ute.hibook.service;

import java.util.List;

import ute.hibook.dto.AuthorDTO;

public interface AuthorService {

	public void addAuthor(AuthorDTO authorDTO);
	public void updateAuthor(AuthorDTO authorDTO);
	public void deleteAuthor(int idAuthor);
	public AuthorDTO getAuthorById(int idAuthor);
	public List<AuthorDTO> getAllAuthor();
}
