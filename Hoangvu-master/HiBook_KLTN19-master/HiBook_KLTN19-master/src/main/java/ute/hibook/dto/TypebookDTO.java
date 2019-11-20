package ute.hibook.dto;

import java.util.List;

public class TypebookDTO {

	private int idType;
	private String imgType;
	private String nameType;
	private List<BookDTO> books;

	
	public TypebookDTO() {
		super();
	}

	public TypebookDTO(int idType, String imgType, String nameType) {
		super();
		this.idType = idType;
		this.imgType = imgType;
		this.nameType = nameType;
	}

	public int getIdType() {
		return this.idType;
	}

	public void setIdType(int idType) {
		this.idType = idType;
	}

	public String getImgType() {
		return this.imgType;
	}

	public void setImgType(String imgType) {
		this.imgType = imgType;
	}

	public String getNameType() {
		return this.nameType;
	}

	public void setNameType(String nameType) {
		this.nameType = nameType;
	}

	public List<BookDTO> getBooks() {
		return this.books;
	}

	public void setBooks(List<BookDTO> books) {
		this.books = books;
	}
}
