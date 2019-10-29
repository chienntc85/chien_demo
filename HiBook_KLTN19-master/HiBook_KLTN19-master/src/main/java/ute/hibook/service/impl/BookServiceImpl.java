package ute.hibook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ute.hibook.dao.imp.AuthorDaoImpl;
import ute.hibook.dao.imp.BookDaoImpl;
import ute.hibook.dao.imp.SupplierDaoImpl;
import ute.hibook.dao.imp.TypebookDaoImpl;
import ute.hibook.dto.AuthorDTO;
import ute.hibook.dto.BookDTO;
import ute.hibook.dto.BookUpdateDTO;
import ute.hibook.dto.PromotionDTO;
import ute.hibook.dto.SupplierDTO;
import ute.hibook.dto.TagsearchDTO;
import ute.hibook.dto.TypebookDTO;
import ute.hibook.dto.UserDTO;
import ute.hibook.dto.UserreviewDTO;
import ute.hibook.entity.Author;
import ute.hibook.entity.Book;
import ute.hibook.entity.Promotion;
import ute.hibook.entity.Supplier;
import ute.hibook.entity.Typebook;
import ute.hibook.entity.Userreview;
import ute.hibook.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookDaoImpl bookDao;
	@Autowired
	TypebookDaoImpl typeDao;
	@Autowired
	SupplierDaoImpl supplierDao;
	@Autowired
	AuthorDaoImpl authorDao;
	@Autowired
	TagsearchServiceImpl tagSearchSer;
	
	public void addBook(Book book) {
		bookDao.addBook(book);		
		System.out.println("add Book successful!");
	}

	public void updateBook(BookUpdateDTO bookDTO) {
		Book book= bookDao.getBookById(bookDTO.getIdBook());
		if(book!=null) {
			book.setNameBook(bookDTO.getNameBook());
			book.setCover(bookDTO.getCover());
			book.setDiscount(bookDTO.getDiscount());
			book.setIntroBook(bookDTO.getIntro());
			book.setNumberPage(bookDTO.getNumberPage());
			book.setPicBook(bookDTO.getFileimg());
			book.setPrice(bookDTO.getPrice());
			book.setProofread(bookDTO.getFileproofread());
			book.setPublicationDate(bookDTO.getPublicationDate());
			book.setPublisher(bookDTO.getPublisher());
			book.setQuantity(bookDTO.getQuantity());
			book.setSize(bookDTO.getSize());
			//book.setStatus(bookDTO.getStatus());
			book.setTagList(bookDTO.getTags());
			
			//if have tag difference, add them in table tagsearch
			//cut String by ','
			String[] arr_tags = bookDTO.getTags().split(",");
			for (String tag : arr_tags) {
				if(tag.trim().equals("")||tag.trim() == "") {
					continue;
				}
				TagsearchDTO tagDTO = new TagsearchDTO();
				tagDTO.setValue(tag);
				tagDTO.setNumOfSearch(0);
				tagSearchSer.addTag(tagDTO);
			}
			
			Typebook type = typeDao.getTypebookById(bookDTO.getIdType());
			book.setTypebook(type);
			
			Supplier supplier = supplierDao.getSupplierById(bookDTO.getIdSupplier());
			book.setSupplier(supplier);
			
//			List<Author> authors=new ArrayList<Author>();
//			for (int author : bookDTO.getArr_author()) {
//				Author auth = authorDao.getAuthorById(author);
//				authors.add(auth);
//			}
//			book.setAuthors(authors);
			
			bookDao.updateBook(book);
			System.out.println("update Book successful!");
		}
	}

	public void deleteBook(int idBook) {
	
		Book book= bookDao.getBookById(idBook);
		if(book!=null) {
			bookDao.deleteBook(idBook);
			System.out.println("delete Book successful!");
		}
	}

	public BookDTO getBookById(int idBook) {
		Book book= bookDao.getBookById(idBook);
		
		BookDTO bookDTO= new BookDTO();
		bookDTO.setIdBook(book.getIdBook());
		bookDTO.setNameBook(book.getNameBook());
		bookDTO.setCover(book.getCover());
		bookDTO.setDiscount(book.getDiscount());
		bookDTO.setIntroBook(book.getIntroBook());
		bookDTO.setNumberPage(book.getNumberPage());
		bookDTO.setPicBook(book.getPicBook());
		bookDTO.setPrice(book.getPrice());
		bookDTO.setProofread(book.getProofread());
		bookDTO.setPublicationDate(book.getPublicationDate());
		bookDTO.setPublisher(book.getPublisher());
		bookDTO.setQuantity(book.getQuantity());
		bookDTO.setSize(book.getSize());
		bookDTO.setStatus(book.getStatus());
		bookDTO.setTagList(book.getTagList());
		TypebookDTO type=new TypebookDTO(book.getTypebook().getIdType(), book.getTypebook().getImgType()
				, book.getTypebook().getNameType());
		bookDTO.setTypebook(type);
		SupplierDTO supplier=new SupplierDTO(book.getSupplier().getIdSupplier(), book.getSupplier().getNameSupplier());
		bookDTO.setSupplier(supplier);
		  
		List<AuthorDTO> lstAuthor=new ArrayList<AuthorDTO>();
		for (Author author : book.getAuthors()) {
			lstAuthor.add(new AuthorDTO(author.getIdAuthor(), author.getNameAuthor()));
		}
		bookDTO.setAuthors(lstAuthor);
		
		List<UserreviewDTO> reviews=new ArrayList<UserreviewDTO>();
		for (Userreview userreview : book.getUserreviews()) {
			UserreviewDTO userreviewDTO= new UserreviewDTO();
			userreviewDTO.setIdReview(userreview.getIdReview());
			userreviewDTO.setContent(userreview.getContent());
			userreviewDTO.setReportNum(userreview.getReportNum());
			userreviewDTO.setStar(userreview.getStar());
			userreviewDTO.setTimeReview(userreview.getTimeReview());
			userreviewDTO.setTitle(userreview.getTitle());
			UserDTO user=new UserDTO();
			user.setIdUser(userreview.getUser().getIdUser());
			user.setNameUser(userreview.getUser().getNameUser());
			userreviewDTO.setUser(user);
			reviews.add(userreviewDTO);
		}
		bookDTO.setUserreviews(reviews);
		
		return bookDTO;
	}

	public List<BookDTO> getAllBook() {
		List<Book> lstBook= bookDao.getAllBook();
		
		List<BookDTO> lstBookDTO= new ArrayList<BookDTO>();
		for (Book book : lstBook) {
			
			BookDTO bookDTO= new BookDTO();
			bookDTO.setIdBook(book.getIdBook());
			bookDTO.setNameBook(book.getNameBook());
			bookDTO.setCover(book.getCover());
			bookDTO.setDiscount(book.getDiscount());
			bookDTO.setIntroBook(book.getIntroBook());
			bookDTO.setNumberPage(book.getNumberPage());
			bookDTO.setPicBook(book.getPicBook());
			bookDTO.setPrice(book.getPrice());
			bookDTO.setProofread(book.getProofread());
			bookDTO.setPublicationDate(book.getPublicationDate());
			bookDTO.setPublisher(book.getPublisher());
			bookDTO.setQuantity(book.getQuantity());
			bookDTO.setSize(book.getSize());
			bookDTO.setStatus(book.getStatus());
			bookDTO.setTagList(book.getTagList());
			
			TypebookDTO typeDTO = new TypebookDTO();
			typeDTO.setIdType(book.getTypebook().getIdType());
			typeDTO.setNameType(book.getTypebook().getNameType());
			bookDTO.setTypebook(typeDTO);
			
			SupplierDTO supplierDTO = new SupplierDTO();
			supplierDTO.setIdSupplier(book.getSupplier().getIdSupplier());
			supplierDTO.setNameSupplier(book.getSupplier().getNameSupplier());
			bookDTO.setSupplier(supplierDTO);
			
			List<AuthorDTO> authors=new ArrayList<AuthorDTO>();
			for (Author author : book.getAuthors()) {
				AuthorDTO authDTO = new AuthorDTO();
				authDTO.setIdAuthor(author.getIdAuthor());
				authDTO.setNameAuthor(author.getNameAuthor());
				authors.add(authDTO);
			}
			List<PromotionDTO> promotionDTOs=new ArrayList<PromotionDTO>();
			for(Promotion promotion:book.getPromotions()) {
				PromotionDTO pDto=new PromotionDTO();
				pDto.setIdPromotion(promotion.getIdPromotion());
				pDto.setContentPromotion(promotion.getContentPromotion());
				promotionDTOs.add(pDto);
			}
			bookDTO.setPromotions(promotionDTOs);
			bookDTO.setAuthors(authors);
		
			lstBookDTO.add(bookDTO);
		}
		return lstBookDTO;
	}

}
