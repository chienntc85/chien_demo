package ute.hibook.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the transport database table.
 * 
 */
@Entity(name="transport")
public class Transport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTransport;

	private String describes;

	private int fee;

	private String nameTransport;

	//bi-directional many-to-one association to Bill
	@OneToMany(mappedBy="transport", fetch = FetchType.EAGER)
	private List<Bill> bills;

	public Transport() {
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

	public List<Bill> getBills() {
		return this.bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}

	public Bill addBill(Bill bill) {
		getBills().add(bill);
		bill.setTransport(this);

		return bill;
	}

	public Bill removeBill(Bill bill) {
		getBills().remove(bill);
		bill.setTransport(null);

		return bill;
	}

}