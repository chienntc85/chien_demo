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

import ute.hibook.dto.TransportDTO;
import ute.hibook.service.impl.TransportServiceImpl;

@RestController
@RequestMapping(value = "/api/v1")
public class TransportController {
	
	@Autowired
	TransportServiceImpl transportSer;
	
	@GetMapping(value="/transports")
	public ResponseEntity<List<TransportDTO>> getAllTransport(){
		
		List<TransportDTO> transportDTOs= transportSer.getAllTransport();
		
		if(transportDTOs.isEmpty()) {
			return new ResponseEntity<List<TransportDTO>>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<List<TransportDTO>>(transportDTOs,HttpStatus.OK);
	}
	/*======================ADD Transport================= */
	@PostMapping(value="/transports")
	public ResponseEntity<?> addTransport(@RequestParam String nameTransport, @RequestParam String describes, @RequestParam int fee){
		TransportDTO transport=new TransportDTO();
		transport.setNameTransport(nameTransport);
		transport.setDescribes(describes);
		transport.setFee(fee);
		transportSer.addTransport(transport);
		
		return new ResponseEntity<Integer>(1, HttpStatus.OK);
	}
	/*======================UPDATE Transport================= */
	@PutMapping(value="/transports/{idTransport}")
	public ResponseEntity<?> updateTransport(@PathVariable int idTransport, @RequestBody TransportDTO transport){
		transport.setIdTransport(idTransport);
		transportSer.updateTransport(transport);
	
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	/*======================DELETE Transport by ID================= */
	@DeleteMapping(value="transports/{idTransport}")
	public ResponseEntity<?> deleteTransport(@PathVariable int idTransport){
		transportSer.deleteTransport(idTransport);
		
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}
