package ute.hibook.dto;

import java.util.List;

public class BookDTO {

	private int idBook;
	private String cover;
	private int discount;
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
	private String tagList;
	private List<AuthorDTO> authors;
	private SupplierDTO supplier;
	private TypebookDTO typebook;
	private List<CartDTO> carts;
	private List<DetailbillDTO> detailbills;
	private List<PromotionDTO> promotions;
	private List<UserreviewDTO> userreviews;

	
	public BookDTO() {
		super();
	}

	public BookDTO(int idBook, int discount, String nameBook, String picBook, int price, int quantity, int status
			) {
		super();
		this.idBook = idBook;
		this.discount = discount;
		this.nameBook = nameBook;
		this.picBook = picBook;
		this.price = price;
		this.quantity = quantity;
		this.status = status;
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

	public List<AuthorDTO> getAuthors() {
		return authors;
	}

	public void setAuthors(List<AuthorDTO> authors) {
		this.authors = authors;
	}

	public SupplierDTO getSupplier() {
		return supplier;
	}

	public void setSupplier(SupplierDTO supplier) {
		this.supplier = supplier;
	}

	public TypebookDTO getTypebook() {
		return typebook;
	}

	public void setTypebook(TypebookDTO typebook) {
		this.typebook = typebook;
	}

	public List<CartDTO> getCarts() {
		return carts;
	}

	public void setCarts(List<CartDTO> carts) {
		this.carts = carts;
	}

	public List<DetailbillDTO> getDetailbills() {
		return detailbills;
	}

	public void setDetailbills(List<DetailbillDTO> detailbills) {
		this.detailbills = detailbills;
	}

	public List<PromotionDTO> getPromotions() {
		return promotions;
	}

	public void setPromotions(List<PromotionDTO> promotions) {
		this.promotions = promotions;
	}

	public List<UserreviewDTO> getUserreviews() {
		return userreviews;
	}

	public void setUserreviews(List<UserreviewDTO> userreviews) {
		this.userreviews = userreviews;
	}

}
