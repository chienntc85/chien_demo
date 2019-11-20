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

import ute.hibook.dto.OrderstatusDTO;
import ute.hibook.service.impl.OrderstatusServiceImpl;


/*===================DETAIL OrderStatus================ */
@RestController
@RequestMapping(value = "/api/v1")
public class OrderStatusController {

	@Autowired
	OrderstatusServiceImpl orderStatusSer;
	
	/*======================GET all OrderStatus================= */
	@GetMapping(value = "/status")
	public ResponseEntity<?> loadAllOrderStatus(){
		List<OrderstatusDTO> lstOrderStatus=orderStatusSer.getAllOrderstatus();
		
		if(lstOrderStatus.isEmpty()) {
			return new ResponseEntity<List<OrderstatusDTO>>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<List<OrderstatusDTO>>(lstOrderStatus,HttpStatus.OK);
	}
	/*======================ADD OrderStatus================= */
	@PostMapping(value="/status")
	public ResponseEntity<?> addOrderStatus(@RequestParam String nameStatus){
		OrderstatusDTO orderStatus=new OrderstatusDTO();
		orderStatus.setNameStatus(nameStatus);
		orderStatusSer.addOrderstatus(orderStatus);
		
		return new ResponseEntity<Integer>(1, HttpStatus.OK);
	}
	/*======================UPDATE OrderStatus================= */
	@PutMapping(value="/status/{idStatus}")
	public ResponseEntity<?> updateOrderStatus(@PathVariable int idStatus, @RequestBody OrderstatusDTO orderStatus){
		orderStatus.setIdStatus(idStatus);
		orderStatusSer.updateOrderstatus(orderStatus);
		
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	/*======================DELETE OrderStatus by ID================= */
	@DeleteMapping(value="status/{idStatus}")
	public ResponseEntity<?> deleteOrderStatus(@PathVariable int idStatus){
		orderStatusSer.deleteOrderstatus(idStatus);
		
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}
