package ute.hibook.dto;

import java.util.Date;
import java.util.List;

public class PromotionDTO {

	private int idPromotion;
	private String contentPromotion;
	private String picPromotion;
	private int saleOff;
	private Date timeEnd;
	private Date timeStart;
	private String titlePromotion;
	private List<BookDTO> books;
	
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

	public void setTimeEnd(Date date) {
		this.timeEnd = date;
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

	public List<BookDTO> getBooks() {
		return this.books;
	}

	public void setBooks(List<BookDTO> books) {
		this.books = books;
	}
}
