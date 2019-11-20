package ute.hibook.dto;

import java.util.List;

public class TransportDTO {

	private int idTransport;
	private String describes;
	private int fee;
	private String nameTransport;
	private List<BillDTO> bills;

	public TransportDTO() {
		super();
	}

	public TransportDTO(int idTransport, String describes, int fee, String nameTransport) {
		super();
		this.idTransport = idTransport;
		this.describes = describes;
		this.fee = fee;
		this.nameTransport = nameTransport;
	}

	public int getIdTransport() {
		return this.idTransport;
	}

	public void setIdTransport(int idTransport) {
		this.idTransport = idTransport;
	}

	public String getDescribes() {
		return this.describes;
	}

	public void setDescribes(String describes) {
		this.describes = describes;
	}

	public int getFee() {
		return this.fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public String getNameTransport() {
		return this.nameTransport;
	}

	public void setNameTransport(String nameTransport) {
		this.nameTransport = nameTransport;
	}

	public List<BillDTO> getBills() {
		return this.bills;
	}

	public void setBills(List<BillDTO> bills) {
		this.bills = bills;
	}
}
