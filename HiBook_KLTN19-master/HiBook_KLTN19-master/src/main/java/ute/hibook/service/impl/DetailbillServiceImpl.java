package ute.hibook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ute.hibook.dao.imp.BillDaoImpl;
import ute.hibook.dao.imp.BookDaoImpl;
import ute.hibook.dao.imp.DetailbillDaoImpl;
import ute.hibook.dto.BillDTO;
import ute.hibook.dto.BookDTO;
import ute.hibook.dto.DetailbillDTO;
import ute.hibook.entity.Bill;
import ute.hibook.entity.Book;
import ute.hibook.entity.Detailbill;
import ute.hibook.service.DetailbillService;

@Service
public class DetailbillServiceImpl implements DetailbillService{

	@Autowired
	DetailbillDaoImpl detailbillDao;
	@Autowired
	BookDaoImpl bookDao;
	@Autowired
	BillDaoImpl billDao;
	
	public void addDetailbill(DetailbillDTO detailbillDTO) {
		Detailbill detailbill= new Detailbill();
		detailbill.setPrice(detailbillDTO.getPrice());
		detailbill.setQuantityBuy(detailbillDTO.getQuantityBuy());
		Bill bill= billDao.getBillById(detailbillDTO.getBill().getIdBill());
		detailbill.setBill(bill);
		Book book= bookDao.getBookById(detailbillDTO.getBook().getIdBook());
		detailbill.setBook(book);
		
		detailbillDao.addDetailbill(detailbill);		
		System.out.println("add Detailbill successful!");
	}

	public void updateDetailbill(DetailbillDTO detailbillDTO) {
		Detailbill detailbill= detailbillDao.getDetailbillById(detailbillDTO.getIdDetailBill());
		if(detailbill!=null) {
			detailbill.setPrice(detailbillDTO.getPrice());
			detailbill.setQuantityBuy(detailbillDTO.getQuantityBuy());
			Bill bill= billDao.getBillById(detailbillDTO.getBill().getIdBill());
			detailbill.setBill(bill);
			Book book= bookDao.getBookById(detailbillDTO.getBook().getIdBook());
			detailbill.setBook(book);
			
			detailbillDao.updateDetailbill(detailbill);
			System.out.println("update Detailbill successful!");
		}
	}

	public void deleteDetailbill(int idDetailbill) {
		Detailbill detailbill= detailbillDao.getDetailbillById(idDetailbill);
		if(detailbill!=null) {
			detailbillDao.deleteDetailbill(idDetailbill);
			System.out.println("delete Detailbill successful!");
		}
	}

	public DetailbillDTO getDetailbillById(int idDetailbill) {
		Detailbill detailbill= detailbillDao.getDetailbillById(idDetailbill);
		
		DetailbillDTO detailbillDTO= new DetailbillDTO();
		detailbillDTO.setIdDetailBill(detailbill.getIdDetailBill());
		detailbillDTO.setPrice(detailbill.getPrice());
		detailbillDTO.setQuantityBuy(detailbill.getQuantityBuy());
		BillDTO billDTO=new BillDTO(detailbill.getBill().getIdBill(),detailbill.getBill().getDateCreate()
				, detailbill.getBill().getDeliveryAdress(), detailbill.getBill().getNameReceiver()
				, detailbill.getBill().getNumberphone(), detailbill.getBill().getTotal());
		detailbillDTO.setBill(billDTO);
		BookDTO bookDTO=new BookDTO(detailbill.getBook().getIdBook(), detailbill.getBook().getDiscount(), detailbill.getBook().getNameBook()
				, detailbill.getBook().getPicBook(), detailbill.getBook().getPrice(), detailbill.getBook().getQuantity(), detailbill.getBook().getStatus());
		detailbillDTO.setBook(bookDTO);
		
		//System.out.println(Detailbill.getUsers().get(0).getEmail());
		
		return detailbillDTO;
	}

	public List<DetailbillDTO> getAllDetailbill() {
		List<Detailbill> lstDetailbill= detailbillDao.getAllDetailbill();
		
		List<DetailbillDTO> lstDetailbillDTO= new ArrayList<DetailbillDTO>();
		for (Detailbill detailbill : lstDetailbill) {
			
			DetailbillDTO detailbillDTO= new DetailbillDTO();
			detailbillDTO.setIdDetailBill(detailbill.getIdDetailBill());
			detailbillDTO.setPrice(detailbill.getPrice());
			detailbillDTO.setQuantityBuy(detailbill.getQuantityBuy());
			BillDTO billDTO=new BillDTO(detailbill.getBill().getIdBill(),detailbill.getBill().getDateCreate()
					, detailbill.getBill().getDeliveryAdress(), detailbill.getBill().getNameReceiver()
					, detailbill.getBill().getNumberphone(), detailbill.getBill().getTotal());
			detailbillDTO.setBill(billDTO);
			BookDTO bookDTO=new BookDTO(detailbill.getBook().getIdBook(), detailbill.getBook().getDiscount(), detailbill.getBook().getNameBook()
					, detailbill.getBook().getPicBook(), detailbill.getBook().getPrice(), detailbill.getBook().getQuantity(), detailbill.getBook().getStatus());
			detailbillDTO.setBook(bookDTO);
		
			lstDetailbillDTO.add(detailbillDTO);
		}
		return lstDetailbillDTO;
	}

}
