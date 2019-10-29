package ute.hibook.dto;

import java.util.List;

public class SupplierDTO {

	private int idSupplier;
	private String nameSupplier;
	private List<BookDTO> books;
	private int numBookSearch;
	
	public SupplierDTO() {
		super();
	}

	public SupplierDTO(int idSupplier, String nameSupplier) {
		super();
		this.idSupplier = idSupplier;
		this.nameSupplier = nameSupplier;
	}

	public int getIdSupplier() {
		return this.idSupplier;
	}

	public void setIdSupplier(int idSupplier) {
		this.idSupplier = idSupplier;
	}

	public String getNameSupplier() {
		return this.nameSupplier;
	}

	public void setNameSupplier(String nameSupplier) {
		this.nameSupplier = nameSupplier;
	}

	public List<BookDTO> getBooks() {
		return this.books;
	}

	public void setBooks(List<BookDTO> books) {
		this.books = books;
	}

	public int getNumBookSearch() {
		return numBookSearch;
	}

	public void setNumBookSearch(int numBookSearch) {
		this.numBookSearch = numBookSearch;
	}
	
}
