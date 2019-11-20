package ute.hibook.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


/**
 * The persistent class for the book database table.
 * 
 */
@Entity(name="book")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idBook;

	private String cover;

	private int discount;

	@Lob
	private String introBook;

	private String nameBook;

	private int numberPage;

	private String picBook;

	private int price;

	private String proofread;

	private String publicationDate;

	private String publisher;

	private int quantity;

	private String size;

	private int status;

	@Lob
	private String tagList;

	//bi-directional many-to-many association to Author
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name="authorbook",
		joinColumns=@JoinColumn(name="idBook"),
		inverseJoinColumns=@JoinColumn(name="idAuthor"))
	private List<Author> authors;

	//bi-directional many-to-one association to Supplier
	@ManyToOne
	@JoinColumn(name="idSupplier")
	private Supplier supplier;

	//bi-directional many-to-one association to Typebook
	@ManyToOne
	@JoinColumn(name="idType")
	private Typebook typebook;

	//bi-directional many-to-one association to Cart
	@OneToMany(mappedBy="book", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Cart> carts;

	//bi-directional many-to-one association to Detailbill
	@OneToMany(mappedBy="book", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Detailbill> detailbills;

	//bi-directional many-to-many association to Promotion
	@ManyToMany(mappedBy="books", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Promotion> promotions;

	//bi-directional many-to-one association to Userreview
	@OneToMany(mappedBy="book", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Userreview> userreviews;

	public Book() {
	}

	public int getIdBook() {
		return this.idBook;
	}

	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}

	public String getCover() {
		return this.cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public int getDiscount() {
		return this.discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getIntroBook() {
		return this.introBook;
	}

	public void setIntroBook(String introBook) {
		this.introBook = introBook;
	}

	public String getNameBook() {
		return this.nameBook;
	}

	public void setNameBook(String nameBook) {
		this.nameBook = nameBook;
	}

	public int getNumberPage() {
		return this.numberPage;
	}

	public void setNumberPage(int numberPage) {
		this.numberPage = numberPage;
	}

	public String getPicBook() {
		return this.picBook;
	}

	public void setPicBook(String picBook) {
		this.picBook = picBook;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getProofread() {
		return this.proofread;
	}

	public void setProofread(String proofread) {
		this.proofread = proofread;
	}

	public String getPublicationDate() {
		return this.publicationDate;
	}

	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getSize() {
		return this.size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getTagList() {
		return this.tagList;
	}

	public void setTagList(String tagList) {
		this.tagList = tagList;
	}

	public List<Author> getAuthors() {
		return this.authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Typebook getTypebook() {
		return this.typebook;
	}

	public void setTypebook(Typebook typebook) {
		this.typebook = typebook;
	}

	public List<Cart> getCarts() {
		return this.carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public Cart addCart(Cart cart) {
		getCarts().add(cart);
		cart.setBook(this);

		return cart;
	}

	public Cart removeCart(Cart cart) {
		getCarts().remove(cart);
		cart.setBook(null);

		return cart;
	}

	public List<Detailbill> getDetailbills() {
		return this.detailbills;
	}

	public void setDetailbills(List<Detailbill> detailbills) {
		this.detailbills = detailbills;
	}

	public Detailbill addDetailbill(Detailbill detailbill) {
		getDetailbills().add(detailbill);
		detailbill.setBook(this);

		return detailbill;
	}

	public Detailbill removeDetailbill(Detailbill detailbill) {
		getDetailbills().remove(detailbill);
		detailbill.setBook(null);

		return detailbill;
	}

	public List<Promotion> getPromotions() {
		return this.promotions;
	}

	public void setPromotions(List<Promotion> promotions) {
		this.promotions = promotions;
	}

	public List<Userreview> getUserreviews() {
		return this.userreviews;
	}

	public void setUserreviews(List<Userreview> userreviews) {
		this.userreviews = userreviews;
	}

	public Userreview addUserreview(Userreview userreview) {
		getUserreviews().add(userreview);
		userreview.setBook(this);

		return userreview;
	}

	public Userreview removeUserreview(Userreview userreview) {
		getUserreviews().remove(userreview);
		userreview.setBook(null);

		return userreview;
	}

}