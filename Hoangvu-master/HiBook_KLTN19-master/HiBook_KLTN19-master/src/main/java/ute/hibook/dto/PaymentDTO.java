package ute.hibook.dto;

import java.util.List;

public class PaymentDTO {
	
	private int idPayment;
	private String namePayment;
	private List<BillDTO> bills;
	
	public PaymentDTO() {
		super();
	}

	public PaymentDTO(int idPayment, String namePayment) {
		super();
		this.idPayment = idPayment;
		this.namePayment = namePayment;
	}

	public int getIdPayment() {
		return this.idPayment;
	}

	public void setIdPayment(int idPayment) {
		this.idPayment = idPayment;
	}

	public String getNamePayment() {
		return this.namePayment;
	}

	public void setNamePayment(String namePayment) {
		this.namePayment = namePayment;
	}

	public List<BillDTO> getBills() {
		return this.bills;
	}

	public void setBills(List<BillDTO> bills) {
		this.bills = bills;
	}
}
