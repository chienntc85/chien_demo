package ute.hibook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ute.hibook.dto.TagsearchDTO;
import ute.hibook.service.impl.TagsearchServiceImpl;

@RestController
@RequestMapping(value = "/api/v1")
public class TagsearchController {

	@Autowired
	TagsearchServiceImpl tagSer;
	
	@GetMapping({"/tagsearchs"})
	public ResponseEntity<?> searchKey() {
		
		List<TagsearchDTO> tags= tagSer.getAllTag();
		
		if(tags.isEmpty()) {
			return new ResponseEntity<List<TagsearchDTO>>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<List<TagsearchDTO>>(tags,HttpStatus.OK);
	}
	
	@GetMapping({"/tag-limit"})
	public ResponseEntity<?> getSearchKeyLimit() {
		
		List<TagsearchDTO> tags= tagSer.getTagHotLimit();
		
		if(tags.isEmpty()) {
			return new ResponseEntity<List<TagsearchDTO>>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<List<TagsearchDTO>>(tags,HttpStatus.OK);
	}
	
}
