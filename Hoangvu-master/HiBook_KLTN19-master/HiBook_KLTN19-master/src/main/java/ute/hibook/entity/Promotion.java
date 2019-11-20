package ute.hibook.entity;

import java.io.Serializable;
import java.util.Date;
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


/**
 * The persistent class for the promotion database table.
 * 
 */
@Entity(name="promotion")
public class Promotion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPromotion;

	@Lob
	private String contentPromotion;

	private String picPromotion;

	private int saleOff;

	private Date timeEnd;

	private Date timeStart;

	private String titlePromotion;

	//bi-directional many-to-many association to Book
	
	@ManyToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable( name="detailpromotion"
		, joinColumns={ @JoinColumn(name="idPromotion") }
		, inverseJoinColumns={ @JoinColumn(name="idBook") }
		)
	private List<Book> books;

	public Promotion() {
	}

	public int getIdPromotion() {
		return this.idPromotion;
	}

	public void setIdPromotion(int idPromotion) {
		this.idPromotion = idPromotion;
	}

	public String getContentPromotion() {
		return this.contentPromotion;
	}

	public void setContentPromotion(String contentPromotion) {
		this.contentPromotion = contentPromotion;
	}

	public String getPicPromotion() {
		return this.picPromotion;
	}

	public void setPicPromotion(String picPromotion) {
		this.picPromotion = picPromotion;
	}

	public int getSaleOff() {
		return this.saleOff;
	}

	public void setSaleOff(int saleOff) {
		this.saleOff = saleOff;
	}

	public Date getTimeEnd() {
		return this.timeEnd;
	}

	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}

	public Date getTimeStart() {
		return this.timeStart;
	}

	public void setTimeStart(Date timeStart) {
		this.timeStart = timeStart;
	}

	public String getTitlePromotion() {
		return this.titlePromotion;
	}

	public void setTitlePromotion(String titlePromotion) {
		this.titlePromotion = titlePromotion;
	}

	public List<Book> getBooks() {
		return this.books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}