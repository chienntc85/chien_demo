package ute.hibook.dto;

import java.util.List;

public class BookUpdateDTO {

	private int idBook;
	private String publisher;
	private String nameBook;
	private int price;
	private int discount;
	private String size;
	private int numberPage;
	private String publicationDate;
	private int quantity;
	private String cover;
	private String intro;
	private String fileimg;
	private String fileproofread;
	private int idType;
	private int idSupplier;
	private List<Integer> arr_author;
	private List<String> arr_nameauthor;
	private String tags;
	
	public BookUpdateDTO(String publisher, String nameBook, int price, int discount, String size, int numberPage,
			String publicationDate, int quantity, String cover, String intro, String fileimg, String fileproofread,
			int idType, int idSupplier, List<Integer> arr_author, String tags) {
		super();
		this.publisher = publisher;
		this.nameBook = nameBook;
		this.price = price;
		this.discount = discount;
		this.size = size;
		this.numberPage = numberPage;
		this.publicationDate = publicationDate;
		this.quantity = quantity;
		this.cover = cover;
		this.intro = intro;
		this.fileimg = fileimg;
		this.fileproofread = fileproofread;
		this.idType = idType;
		this.idSupplier = idSupplier;
		this.arr_author = arr_author;
		this.tags = tags;
	}
	public BookUpdateDTO() {
		super();
	}
	
	public int getIdBook() {
		return idBook;
	}
	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}
	public List<String> getArr_nameauthor() {
		return arr_nameauthor;
	}
	public void setArr_nameauthor(List<String> arr_nameauthor) {
		this.arr_nameauthor = arr_nameauthor;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getNameBook() {
		return nameBook;
	}
	public void setNameBook(String nameBook) {
		this.nameBook = nameBook;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getNumberPage() {
		return numberPage;
	}
	public void setNumberPage(int numberPage) {
		this.numberPage = numberPage;
	}
	public String getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getFileimg() {
		return fileimg;
	}
	public void setFileimg(String fileimg) {
		this.fileimg = fileimg;
	}
	public String getFileproofread() {
		return fileproofread;
	}
	public void setFileproofread(String fileproofread) {
		this.fileproofread = fileproofread;
	}
	public int getIdType() {
		return idType;
	}
	public void setIdType(int idType) {
		this.idType = idType;
	}
	public int getIdSupplier() {
		return idSupplier;
	}
	public void setIdSupplier(int idSupplier) {
		this.idSupplier = idSupplier;
	}
	public List<Integer> getArr_author() {
		return arr_author;
	}
	public void setArr_author(List<Integer> arr_author) {
		this.arr_author = arr_author;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
}

