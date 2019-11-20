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

import ute.hibook.dto.TypebookDTO;
import ute.hibook.service.impl.TypebookServiceImpl;

@RestController
@RequestMapping(value = "/api/v1")
public class TypeBookController {

	@Autowired
	TypebookServiceImpl typebookSer;

	/*======================GET all TypeBook================= */
	@GetMapping(value="/typebooks")
	public ResponseEntity<List<TypebookDTO>> getAllTypeBook(){
		
		List<TypebookDTO> lstTypeBook= typebookSer.getAllTypebook();
		
		if(lstTypeBook.isEmpty()) {
			return new ResponseEntity<List<TypebookDTO>>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<List<TypebookDTO>>(lstTypeBook,HttpStatus.OK);
	}
	/*======================ADD TypeBook================= */
	@PostMapping(value="/typebooks")
	public ResponseEntity<?> addTypeBook(@RequestParam String nameType){
		TypebookDTO typeBook=new TypebookDTO();
		typeBook.setNameType(nameType);
		typebookSer.addTypebook(typeBook);
		
		return new ResponseEntity<Integer>(1, HttpStatus.OK);
	}
	/*======================UPDATE TypeBook================= */
	@PutMapping(value="/typebooks/{idType}")
	public ResponseEntity<?> updateTypeBook(@PathVariable int idType, @RequestBody TypebookDTO typeBook){
		typeBook.setIdType(idType);
		typebookSer.updateTypebook(typeBook);
		
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	/*======================DELETE TypeBook by ID================= */
	@DeleteMapping(value="typebooks/{idType}")
	public ResponseEntity<?> deleteTypeBook(@PathVariable int idType){
		typebookSer.deleteTypebook(idType);
		
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}
