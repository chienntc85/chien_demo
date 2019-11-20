package ute.hibook.controller;

import java.sql.Date;
import java.util.ArrayList;
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

import ute.hibook.dto.BookDTO;
import ute.hibook.dto.ConvertPromotionDTO;
import ute.hibook.dto.PromotionDTO;
import ute.hibook.dto.PromotionUpdateDTO;
import ute.hibook.service.impl.PromotionServiceImpl;

@RestController
@RequestMapping(value = "/api/v1")
public class PromotionController {
	@Autowired
	PromotionServiceImpl promotionServiceImpl;

	@GetMapping(value = "/promotionDate")
	public ResponseEntity<List<PromotionDTO>> getallPromotionDate() {

		List<PromotionDTO> lPromotionDTOs = promotionServiceImpl.getAllPromotiondate();

		if (lPromotionDTOs.isEmpty()) {
			return new ResponseEntity<List<PromotionDTO>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<PromotionDTO>>(lPromotionDTOs, HttpStatus.OK);
	}
	/*======================Get all Promotion =================*/
	@GetMapping(value = "/promotions")
	public ResponseEntity<List<ConvertPromotionDTO>> getallPromotion() {
		List<ConvertPromotionDTO> promotionDTOs = promotionServiceImpl.getAllPromotion();
		if (promotionDTOs.isEmpty()) {
			return new ResponseEntity<List<ConvertPromotionDTO>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<ConvertPromotionDTO>>(promotionDTOs, HttpStatus.OK);
	}

	/*======================Get Promotion by ID =================*/
	@GetMapping(value = "/promotions/{idPromotion}")
	public ResponseEntity<ConvertPromotionDTO> getPromotionbyID(@PathVariable int idPromotion) {
		ConvertPromotionDTO promotionDTOs = promotionServiceImpl.getPromotionById(idPromotion);
		if (promotionDTOs==null) {
			return new ResponseEntity<ConvertPromotionDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ConvertPromotionDTO>(promotionDTOs, HttpStatus.OK);
	}
	/*======================ADD Promotion================= */
	@PostMapping(value="/promotions")
	public ResponseEntity<?> addPromotion(@RequestParam String title, @RequestParam String discount,  
			@RequestParam String dateStart, @RequestParam String dateEnd, @RequestParam String intro, @RequestParam String fileimg,
			@RequestParam(value="arr_books[]") List<String> arr_books){
		
		//System.out.println("__"+title+"__"+discount+"__"+dateStart+"__"+dateEnd+"__"+intro+"__" +fileimg);
		System.out.println(arr_books);
		
		PromotionDTO promotionDTO = new PromotionDTO();
		promotionDTO.setTitlePromotion(title);
		promotionDTO.setSaleOff(Integer.parseInt(discount));
		promotionDTO.setTimeStart(Date.valueOf(dateStart));
		promotionDTO.setTimeEnd(Date.valueOf(dateEnd));
		promotionDTO.setContentPromotion(intro);
		promotionDTO.setPicPromotion(fileimg);
		
		List<BookDTO> lstBooks = new ArrayList<BookDTO>();
		
		for (String idbook : arr_books) {
			BookDTO book = new BookDTO();
			book.setIdBook(Integer.parseInt(idbook));
			
			lstBooks.add(book);
		}
		promotionDTO.setBooks(lstBooks);
		promotionServiceImpl.addPromotion(promotionDTO);

		return new ResponseEntity<Integer>(1, HttpStatus.OK);
	}
	/*======================UPDATE Promotion by ID================= */
	@PutMapping(value="/promotions/{idPromotion}")
	public ResponseEntity<?> updateBook(@PathVariable int idPromotion, @RequestBody PromotionUpdateDTO promotionUpdateDTO){
	
		promotionUpdateDTO.setIdPromotion(idPromotion);
		promotionServiceImpl.updatePromotion(promotionUpdateDTO);
		return new ResponseEntity<Integer>(idPromotion, HttpStatus.OK);
	}
	/*======================DELETE Promotion by ID================= */
	@DeleteMapping(value="/promotions/{idPromotion}")
	public ResponseEntity<?> deleteBook(@PathVariable int idPromotion){
		promotionServiceImpl.deletePromotion(idPromotion);
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}

}
