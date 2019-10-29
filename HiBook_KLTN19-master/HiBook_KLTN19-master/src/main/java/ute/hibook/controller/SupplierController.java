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

import ute.hibook.dto.SupplierDTO;
import ute.hibook.service.impl.SupplierServiceImpl;

/*===================DETAIL Supplier================ */
@RestController
@RequestMapping(value = "/api/v1")
public class SupplierController {
	
	@Autowired
	SupplierServiceImpl supplierSer;

	@GetMapping(value = "/suppliers")
	public ResponseEntity<?> loadSupplier(){
		List<SupplierDTO> suppliers=supplierSer.getAllSupplier();
		
		if(suppliers.isEmpty()) {
			return new ResponseEntity<List<SupplierDTO>>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<List<SupplierDTO>>(suppliers,HttpStatus.OK);
	}
	
	/*======================ADD Supplier================= */
	@PostMapping(value="/suppliers")
	public ResponseEntity<?> addSupplier(@RequestParam String nameSupplier){
		SupplierDTO supplier=new SupplierDTO();
		supplier.setNameSupplier(nameSupplier);
		supplierSer.addSupplier(supplier);
		
		return new ResponseEntity<Integer>(1, HttpStatus.OK);
	}
	/*======================UPDATE Supplier================= */
	@PutMapping(value="/suppliers/{idSupplier}")
	public ResponseEntity<?> updateSupplier(@PathVariable int idSupplier, @RequestBody SupplierDTO supplier){
		supplier.setIdSupplier(idSupplier);
		supplierSer.updateSupplier(supplier);
		
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	/*======================DELETE Supplier by ID================= */
	@DeleteMapping(value="suppliers/{idSupplier}")
	public ResponseEntity<?> deleteSupplier(@PathVariable int idSupplier){
		supplierSer.deleteSupplier(idSupplier);
		
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}
