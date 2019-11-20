package ute.hibook.dto;

import java.util.Date;
import java.util.List;

public class ConvertPromotionDTO {
	private int idPromotion;
	private String contentPromotion;
	private String picPromotion;
	private int saleOff;
	private String timeEnd;
	private String timeStart;
	private String titlePromotion;
	private List<BookDTO> books;
	
	public String getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
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
	public String getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(String timeStart) {
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
