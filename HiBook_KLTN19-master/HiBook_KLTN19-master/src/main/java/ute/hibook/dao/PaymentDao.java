package ute.hibook.dao;

import java.util.List;

import ute.hibook.entity.Payment;

public interface PaymentDao {

	public void addPayment(Payment payment);
	public void updatePayment(Payment payment);
	public void deletePayment(int idPayment);
	public Payment getPaymentById(int idPayment);
	public List<Payment> getAllPayment();
}
