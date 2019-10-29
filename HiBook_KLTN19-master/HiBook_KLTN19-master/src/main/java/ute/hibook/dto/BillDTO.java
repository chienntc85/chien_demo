package ute.hibook.dto;

import java.util.List;

public class BillDTO {

	private int idBill;
	private String dateCreate;
	private String deliveryAdress;
	private String nameReceiver;
	private String numberphone;
	private int total;
	private PaymentDTO payment;
	private OrderstatusDTO orderstatus;
	private TransportDTO transport;
	private UserDTO user;
	private List<DetailbillDTO> detailbills;

	public BillDTO(int idBill, String dateCreate, String deliveryAdress, String nameReceiver, String numberphone,
			int total) {
		super();
		this.idBill = idBill;
		this.dateCreate = dateCreate;
		this.deliveryAdress = deliveryAdress;
		this.nameReceiver = nameReceiver;
		this.numberphone = numberphone;
		this.total = total;
	}

	public BillDTO() {
		super();
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

	public PaymentDTO getPayment() {
		return payment;
	}

	public void setPayment(PaymentDTO payment) {
		this.payment = payment;
	}

	public OrderstatusDTO getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(OrderstatusDTO orderstatus) {
		this.orderstatus = orderstatus;
	}

	public TransportDTO getTransport() {
		return transport;
	}

	public void setTransport(TransportDTO transport) {
		this.transport = transport;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public List<DetailbillDTO> getDetailbills() {
		return detailbills;
	}

	public void setDetailbills(List<DetailbillDTO> detailbills) {
		this.detailbills = detailbills;
	}
}
