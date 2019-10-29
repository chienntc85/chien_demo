package ute.hibook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ute.hibook.dao.imp.BookDaoImpl;
import ute.hibook.dao.imp.UserDaoImpl;
import ute.hibook.dao.imp.UserreviewDaoImpl;
import ute.hibook.dto.BookDTO;
import ute.hibook.dto.UserDTO;
import ute.hibook.dto.UserreviewDTO;
import ute.hibook.entity.Book;
import ute.hibook.entity.User;
import ute.hibook.entity.Userreview;
import ute.hibook.service.UserreviewService;

@Service
public class UserreviewServiceImpl implements UserreviewService{

	@Autowired
	UserreviewDaoImpl userreviewDao;
	@Autowired
	UserDaoImpl userDao;
	@Autowired
	BookDaoImpl bookDao;
	
	public void addUserreview(UserreviewDTO userreviewDTO) {
		Userreview userreview= new Userreview();
		userreview.setContent(userreviewDTO.getContent());
		userreview.setReportNum(0);
		userreview.setStar(userreviewDTO.getStar());
		userreview.setTimeReview(userreviewDTO.getTimeReview());
		userreview.setTitle(userreviewDTO.getTitle());
		Book book= bookDao.getBookById(userreviewDTO.getBook().getIdBook());
		userreview.setBook(book);
		User user= userDao.getUserById(userreviewDTO.getUser().getIdUser());
		userreview.setUser(user);
		
		userreviewDao.addUserreview(userreview);		
		System.out.println("add Userreview successful!");
	}

	public void updateUserreview(UserreviewDTO userreviewDTO) {
		Userreview userreview= userreviewDao.getUserreviewById(userreviewDTO.getIdReview());
		if(userreview!=null) {
			userreview.setContent(userreviewDTO.getContent());
			userreview.setReportNum(userreviewDTO.getReportNum());
			userreview.setStar(userreviewDTO.getStar());
			userreview.setTimeReview(userreviewDTO.getTimeReview());
			userreview.setTitle(userreviewDTO.getTitle());
			Book book= bookDao.getBookById(userreviewDTO.getBook().getIdBook());
			userreview.setBook(book);
			User user= userDao.getUserById(userreviewDTO.getUser().getIdUser());
			userreview.setUser(user);
			
			userreviewDao.updateUserreview(userreview);
			System.out.println("update Userreview successful!");
		}
	}

	public void deleteUserreview(int idUserreview) {
		Userreview userreview= userreviewDao.getUserreviewById(idUserreview);
		if(userreview!=null) {
			userreviewDao.deleteUserreview(idUserreview);
			System.out.println("delete Userreview successful!");
		}
	}

	public UserreviewDTO getUserreviewById(int idUserreview) {
		Userreview userreview= userreviewDao.getUserreviewById(idUserreview);
		
		UserreviewDTO userreviewDTO= new UserreviewDTO();
		userreviewDTO.setIdReview(userreview.getIdReview());
		userreviewDTO.setContent(userreview.getContent());
		userreviewDTO.setReportNum(userreview.getReportNum());
		userreviewDTO.setStar(userreview.getStar());
		userreviewDTO.setTimeReview(userreview.getTimeReview());
		userreviewDTO.setTitle(userreview.getTitle());
		BookDTO bookDTO=new BookDTO(userreview.getBook().getIdBook(), userreview.getBook().getDiscount(), userreview.getBook().getNameBook()
				, userreview.getBook().getPicBook(), userreview.getBook().getPrice(), userreview.getBook().getQuantity(), userreview.getBook().getStatus());
		userreviewDTO.setBook(bookDTO);
		
		UserDTO userDTO= new UserDTO(userreview.getUser().getIdUser(), userreview.getUser().getAddress(),
				userreview.getUser().getEmail(), userreview.getUser().getNameUser(), userreview.getUser().getNumberphone());
		userreviewDTO.setUser(userDTO);
		
		return userreviewDTO;
	}

	public List<UserreviewDTO> getAllUserreview() {
		List<Userreview> lstUserreview= userreviewDao.getAllUserreview();
		
		List<UserreviewDTO> lstUserreviewDTO= new ArrayList<UserreviewDTO>();
		for (Userreview userreview : lstUserreview) {
			
			UserreviewDTO userreviewDTO= new UserreviewDTO();
			userreviewDTO.setIdReview(userreview.getIdReview());
			userreviewDTO.setContent(userreview.getContent());
			userreviewDTO.setReportNum(userreview.getReportNum());
			userreviewDTO.setStar(userreview.getStar());
			userreviewDTO.setTimeReview(userreview.getTimeReview());
			userreviewDTO.setTitle(userreview.getTitle());
			BookDTO bookDTO=new BookDTO(userreview.getBook().getIdBook(), userreview.getBook().getDiscount(), userreview.getBook().getNameBook()
					, userreview.getBook().getPicBook(), userreview.getBook().getPrice(), userreview.getBook().getQuantity(), userreview.getBook().getStatus());
			userreviewDTO.setBook(bookDTO);
			
			UserDTO userDTO= new UserDTO(userreview.getUser().getIdUser(), userreview.getUser().getAddress(),
					userreview.getUser().getEmail(), userreview.getUser().getNameUser(), userreview.getUser().getNumberphone());
			userreviewDTO.setUser(userDTO);
		
			lstUserreviewDTO.add(userreviewDTO);
		}
		return lstUserreviewDTO;
	}

}
