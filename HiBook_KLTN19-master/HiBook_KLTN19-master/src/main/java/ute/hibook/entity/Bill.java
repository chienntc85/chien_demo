package ute.hibook.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the bill database table.
 * 
 */
@Entity(name="bill")
public class Bill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idBill;

	private String dateCreate;

	private String deliveryAdress;

	private String nameReceiver;

	private String numberphone;

	private int total;

	//bi-directional many-to-one association to Payment
	@ManyToOne
	@JoinColumn(name="idPayment")
	private Payment payment;

	//bi-directional many-to-one association to Orderstatus
	@ManyToOne
	@JoinColumn(name="idStatus")
	private Orderstatus orderstatus;

	//bi-directional many-to-one association to Transport
	@ManyToOne
	@JoinColumn(name="idTransport")
	private Transport transport;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="idUser")
	private User user;

	//bi-directional many-to-one association to Detailbill
	@OneToMany(mappedBy="bill", fetch = FetchType.EAGER)
	private List<Detailbill> detailbills;

	public Bill() {
	}

	public int getIdBill() {
		return this.idBill;
	}

	public void setIdBill(int idBill) {
		this.idBill = idBill;
	}

	public String getDateCreate() {
		return this.dateCreate;
	}

	public void setDateCreate(String dateCreate) {
		this.dateCreate = dateCreate;
	}

	public String getDeliveryAdress() {
		return this.deliveryAdress;
	}

	public void setDeliveryAdress(String deliveryAdress) {
		this.deliveryAdress = deliveryAdress;
	}

	public String getNameReceiver() {
		return this.nameReceiver;
	}

	public void setNameReceiver(String nameReceiver) {
		this.nameReceiver = nameReceiver;
	}

	public String getNumberphone() {
		return this.numberphone;
	}

	public void setNumberphone(String numberphone) {
		this.numberphone = numberphone;
	}

	public int getTotal() {
		return this.total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Payment getPayment() {
		return this.payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Orderstatus getOrderstatus() {
		return this.orderstatus;
	}

	public void setOrderstatus(Orderstatus orderstatus) {
		this.orderstatus = orderstatus;
	}

	public Transport getTransport() {
		return this.transport;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Detailbill> getDetailbills() {
		return this.detailbills;
	}

	public void setDetailbills(List<Detailbill> detailbills) {
		this.detailbills = detailbills;
	}

	public Detailbill addDetailbill(Detailbill detailbill) {
		getDetailbills().add(detailbill);
		detailbill.setBill(this);

		return detailbill;
	}

	public Detailbill removeDetailbill(Detailbill detailbill) {
		getDetailbills().remove(detailbill);
		detailbill.setBill(null);

		return detailbill;
	}

}