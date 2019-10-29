package ute.hibook.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the payment database table.
 * 
 */
@Entity(name="payment")
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPayment;

	private String namePayment;

	//bi-directional many-to-one association to Bill
	@OneToMany(mappedBy="payment", fetch = FetchType.EAGER)
	private List<Bill> bills;

	public Payment() {
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

	public List<Bill> getBills() {
		return this.bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}

	public Bill addBill(Bill bill) {
		getBills().add(bill);
		bill.setPayment(this);

		return bill;
	}

	public Bill removeBill(Bill bill) {
		getBills().remove(bill);
		bill.setPayment(null);

		return bill;
	}

}