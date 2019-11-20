package ute.hibook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ute.hibook.dao.imp.PaymentDaoImpl;
import ute.hibook.dto.PaymentDTO;
import ute.hibook.entity.Payment;
import ute.hibook.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	PaymentDaoImpl paymentDao;
	
	public void addPayment(PaymentDTO paymentDTO) {
		Payment payment= new Payment();
		payment.setNamePayment(paymentDTO.getNamePayment());
		
		paymentDao.addPayment(payment);		
		System.out.println("add Payment successful!");
	}

	public void updatePayment(PaymentDTO paymentDTO) {
		Payment payment= paymentDao.getPaymentById(paymentDTO.getIdPayment());
		if(payment!=null) {
			payment.setNamePayment(paymentDTO.getNamePayment());
			
			paymentDao.updatePayment(payment);
			System.out.println("update Payment successful!");
		}
	}

	public void deletePayment(int idPayment) {
		Payment payment= paymentDao.getPaymentById(idPayment);
		if(payment!=null) {
			paymentDao.deletePayment(idPayment);
			System.out.println("delete Payment successful!");
		}
	}

	public PaymentDTO getPaymentById(int idPayment) {
		Payment payment= paymentDao.getPaymentById(idPayment);
		
		PaymentDTO paymentDTO= new PaymentDTO();
		paymentDTO.setIdPayment(payment.getIdPayment());
		paymentDTO.setNamePayment(payment.getNamePayment());
		//System.out.println(paymentDTO.getBills().get(0).getNameReceiver());
		
		return paymentDTO;
	}

	public List<PaymentDTO> getAllPayment() {
		List<Payment> lstPayment= paymentDao.getAllPayment();
		
		List<PaymentDTO> lstPaymentDTO= new ArrayList<PaymentDTO>();
		for (Payment payment : lstPayment) {
			
			PaymentDTO PaymentDTO= new PaymentDTO();
			PaymentDTO.setIdPayment(payment.getIdPayment());
			PaymentDTO.setNamePayment(payment.getNamePayment());
		
			lstPaymentDTO.add(PaymentDTO);
		}
		return lstPaymentDTO;
	}

}
