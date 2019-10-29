package ute.hibook.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the typebook database table.
 * 
 */
@Entity(name="typebook")
public class Typebook implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idType;

	@Lob
	private String imgType;

	private String nameType;

	//bi-directional many-to-one association to Book
	@OneToMany(mappedBy="typebook", fetch = FetchType.EAGER)
	private List<Book> books;

	public Typebook() {
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

	public List<Book> getBooks() {
		return this.books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Book addBook(Book book) {
		getBooks().add(book);
		book.setTypebook(this);

		return book;
	}

	public Book removeBook(Book book) {
		getBooks().remove(book);
		book.setTypebook(null);

		return book;
	}

}