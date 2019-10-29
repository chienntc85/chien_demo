package ute.hibook.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@RestController
@RequestMapping(value = "/api/v1")
public class UploadController {

	@Autowired
	ServletContext context;
	
	/*======================Upload Image================= */
	@PostMapping(value = "/upload-img")
	public ResponseEntity<String> UploadImg(MultipartHttpServletRequest request){
		
		Iterator<String> listName= request.getFileNames();
		MultipartFile multipartFile=request.getFile(listName.next());
		
		String nameFile= multipartFile.getOriginalFilename();
		String nameFileConvert = (new SimpleDateFormat("yyyyMMdd_hhmmss_").format(new Date()))+nameFile;
		
		String pathsave=context.getRealPath("/resources/images/");
		if(multipartFile.getContentType().equals("image/jpeg")||multipartFile.getContentType().equals("image/png")){
			pathsave+="book/";
		}else{
			System.out.println(multipartFile.getContentType());
			pathsave+="file/";
		}
		System.out.println(pathsave);
		
		File filesave= new File(pathsave+nameFileConvert);
		try {
			multipartFile.transferTo(filesave);
		} catch (IllegalStateException e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		
		System.out.println(pathsave+nameFileConvert);
		return new ResponseEntity<String>(nameFileConvert,HttpStatus.OK);
	}
	/*======================Upload Image of Promotion================= */
	@PostMapping(value = "/upload-img-promotion")
	public ResponseEntity<String> UploadImgPromotion(MultipartHttpServletRequest request){
		
		Iterator<String> listName= request.getFileNames();
		MultipartFile multipartFile=request.getFile(listName.next());
		
		String nameFile= multipartFile.getOriginalFilename();
		String nameFileConvert = (new SimpleDateFormat("yyyyMMdd_hhmmss_").format(new Date()))+nameFile;
		
		String pathsave=context.getRealPath("/resources/images/banner/");
		
		File filesave= new File(pathsave+nameFileConvert);
		try {
			multipartFile.transferTo(filesave);
		} catch (IllegalStateException e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		
		System.out.println(pathsave+nameFileConvert);
		return new ResponseEntity<String>(nameFileConvert,HttpStatus.OK);
	}
}
