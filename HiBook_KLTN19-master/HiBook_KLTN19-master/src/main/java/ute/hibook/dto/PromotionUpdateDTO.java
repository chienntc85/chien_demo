package ute.hibook.dto;

import java.util.List;

public class PromotionUpdateDTO {

	private int idPromotion;
	private String title;
	private String discount;
	private String dateStart;
	private String dateEnd;
	private String intro;
	private String fileimg;
	private List<String> arr_books;
	
	
	public PromotionUpdateDTO() {
		super();
	}
	public PromotionUpdateDTO(String title, String discount, String dateStart, String dateEnd, String intro,
			String fileimg, List<String> arr_books) {
		super();
		this.title = title;
		this.discount = discount;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.intro = intro;
		this.fileimg = fileimg;
		this.arr_books = arr_books;
	}
	public int getIdPromotion() {
		return idPromotion;
	}
	public void setIdPromotion(int idPromotion) {
		this.idPromotion = idPromotion;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getDateStart() {
		return dateStart;
	}
	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}
	public String getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
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
	public List<String> getArr_books() {
		return arr_books;
	}
	public void setArr_books(List<String> arr_books) {
		this.arr_books = arr_books;
	}
	
	
}
