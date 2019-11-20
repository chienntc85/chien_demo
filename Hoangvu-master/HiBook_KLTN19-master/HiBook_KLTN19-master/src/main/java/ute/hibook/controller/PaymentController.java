package ute.hibook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ute.hibook.dto.PaymentDTO;
import ute.hibook.service.impl.PaymentServiceImpl;


/*===================DETAIL Payment================ */
@RestController
@RequestMapping(value = "/api/v1")
public class PaymentController {

	@Autowired
	PaymentServiceImpl paymentSer;
	
	/*======================GET all Payment================= */
	@GetMapping(value = "/payments")
	public ResponseEntity<?> loadAllPayment(){
		List<PaymentDTO> payments=paymentSer.getAllPayment();
		
		if(payments.isEmpty()) {
			return new ResponseEntity<List<PaymentDTO>>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<List<PaymentDTO>>(payments,HttpStatus.OK);
	}
	/*======================ADD Payment================= */
	@PostMapping(value="/payments")
	public ResponseEntity<?> addPayment(@RequestParam String namePayment){
		PaymentDTO payment=new PaymentDTO();
		payment.setNamePayment(namePayment);
		paymentSer.addPayment(payment);
		
		return new ResponseEntity<Integer>(1, HttpStatus.OK);
	}
	/*======================UPDATE Payment================= */
	@PutMapping(value="/payments/{idPayment}")
	public ResponseEntity<?> updatePayment(@PathVariable int idPayment, @RequestBody PaymentDTO payment){
		payment.setIdPayment(idPayment);
		paymentSer.updatePayment(payment);
		
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	/*======================DELETE Payment by ID================= */
	@DeleteMapping(value="payment/{idPayment}")
	public ResponseEntity<?> deletePayment(@PathVariable int idPayment){
		paymentSer.deletePayment(idPayment);
		
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}
