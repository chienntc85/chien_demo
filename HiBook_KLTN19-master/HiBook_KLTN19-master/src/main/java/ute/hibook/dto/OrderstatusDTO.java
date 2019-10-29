package ute.hibook.dto;

import java.util.List;

public class OrderstatusDTO {

	private int idStatus;
	private String nameStatus;
	private List<BillDTO> bills;

	
	public OrderstatusDTO() {
		super();
	}

	public OrderstatusDTO(int idStatus, String nameStatus) {
		super();
		this.idStatus = idStatus;
		this.nameStatus = nameStatus;
	}

	public int getIdStatus() {
		return this.idStatus;
	}

	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}

	public String getNameStatus() {
		return this.nameStatus;
	}

	public void setNameStatus(String nameStatus) {
		this.nameStatus = nameStatus;
	}

	public List<BillDTO> getBills() {
		return this.bills;
	}

	public void setBills(List<BillDTO> bills) {
		this.bills = bills;
	}
}
