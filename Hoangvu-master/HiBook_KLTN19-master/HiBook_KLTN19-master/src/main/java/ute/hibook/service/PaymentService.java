package ute.hibook.service;

import java.util.List;

import ute.hibook.dto.PaymentDTO;


public interface PaymentService {

	public void addPayment(PaymentDTO paymentDTO);
	public void updatePayment(PaymentDTO paymentDTO);
	public void deletePayment(int idPayment);
	public PaymentDTO getPaymentById(int idPayment);
	public List<PaymentDTO> getAllPayment();
}
