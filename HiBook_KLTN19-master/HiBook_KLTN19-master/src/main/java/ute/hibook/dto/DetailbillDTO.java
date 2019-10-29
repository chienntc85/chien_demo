package ute.hibook.dto;

public class DetailbillDTO {

	private int idDetailBill;
	private int price;
	private int quantityBuy;
	private BillDTO bill;
	private BookDTO book;

	public int getIdDetailBill() {
		return this.idDetailBill;
	}

	public void setIdDetailBill(int idDetailBill) {
		this.idDetailBill = idDetailBill;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantityBuy() {
		return this.quantityBuy;
	}

	public void setQuantityBuy(int quantityBuy) {
		this.quantityBuy = quantityBuy;
	}

	public BillDTO getBill() {
		return this.bill;
	}

	public void setBill(BillDTO bill) {
		this.bill = bill;
	}

	public BookDTO getBook() {
		return this.book;
	}

	public void setBook(BookDTO book) {
		this.book = book;
	}
}
