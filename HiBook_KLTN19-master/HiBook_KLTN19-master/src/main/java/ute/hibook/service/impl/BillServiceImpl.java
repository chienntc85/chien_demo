package ute.hibook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ute.hibook.dao.imp.BillDaoImpl;
import ute.hibook.dao.imp.OrderstatusDaoImpl;
import ute.hibook.dao.imp.PaymentDaoImpl;
import ute.hibook.dao.imp.TransportDaoImpl;
import ute.hibook.dao.imp.UserDaoImpl;
import ute.hibook.dto.BillDTO;
import ute.hibook.dto.BookDTO;
import ute.hibook.dto.DetailbillDTO;
import ute.hibook.dto.OrderstatusDTO;
import ute.hibook.dto.PaymentDTO;
import ute.hibook.dto.TransportDTO;
import ute.hibook.dto.UserDTO;
import ute.hibook.entity.Bill;
import ute.hibook.entity.Detailbill;
import ute.hibook.entity.Orderstatus;
import ute.hibook.entity.Payment;
import ute.hibook.entity.Transport;
import ute.hibook.entity.User;
import ute.hibook.service.BillService;

@Service
public class BillServiceImpl implements BillService{

	@Autowired
	BillDaoImpl billDao;
	@Autowired
	PaymentDaoImpl paymentDao;
	@Autowired
	OrderstatusDaoImpl orderstatusDao;
	@Autowired
	TransportDaoImpl transportDao;
	@Autowired
	UserDaoImpl userDao;
	
	public int addBill(BillDTO billDTO) {
		Bill bill= new Bill();
		bill.setDateCreate(billDTO.getDateCreate());
		bill.setDeliveryAdress(billDTO.getDeliveryAdress());
		bill.setNameReceiver(billDTO.getNameReceiver());
		bill.setNumberphone(billDTO.getNumberphone());
		bill.setTotal(billDTO.getTotal());
		Orderstatus orderstatus= orderstatusDao.getOrderstatusById(billDTO.getOrderstatus().getIdStatus());
		bill.setOrderstatus(orderstatus);
		User user= userDao.getUserById(billDTO.getUser().getIdUser());
		bill.setUser(user);
		
		System.out.println("add Bill successful!");
		return billDao.addBill(bill);		
	}

	public void updateBill(BillDTO billDTO) {
		Bill bill= billDao.getBillById(billDTO.getIdBill());
		if(bill!=null) {
			bill.setDateCreate(billDTO.getDateCreate());
			bill.setDeliveryAdress(billDTO.getDeliveryAdress());
			bill.setNameReceiver(billDTO.getNameReceiver());
			bill.setNumberphone(billDTO.getNumberphone());
			bill.setTotal(billDTO.getTotal());
			Payment payment=paymentDao.getPaymentById(billDTO.getPayment().getIdPayment());
			bill.setPayment(payment);
			Orderstatus orderstatus= orderstatusDao.getOrderstatusById(billDTO.getOrderstatus().getIdStatus());
			bill.setOrderstatus(orderstatus);
			Transport transport= transportDao.getTransportById(billDTO.getTransport().getIdTransport());
			bill.setTransport(transport);
			User user= userDao.getUserById(billDTO.getUser().getIdUser());
			bill.setUser(user);
			
			billDao.updateBill(bill);
			System.out.println("update Bill successful!");
		}
	}

	public void deleteBill(int idBill) {
		Bill bill= billDao.getBillById(idBill);
		if(bill!=null) {
			billDao.deleteBill(idBill);
			System.out.println("delete Bill successful!");
		}
	}

	public BillDTO getBillById(int idBill) {
		Bill bill= billDao.getBillById(idBill);
		
		BillDTO billDTO= new BillDTO();
		billDTO.setIdBill(bill.getIdBill());
		billDTO.setDateCreate(bill.getDateCreate());
		billDTO.setDeliveryAdress(bill.getDeliveryAdress());
		billDTO.setNameReceiver(bill.getNameReceiver());
		billDTO.setNumberphone(bill.getNumberphone());
		billDTO.setTotal(bill.getTotal());
		
		PaymentDTO paymentDTO=new PaymentDTO(bill.getPayment().getIdPayment(), bill.getPayment().getNamePayment());
		billDTO.setPayment(paymentDTO);
		
		OrderstatusDTO orderstatusDTO=new OrderstatusDTO(bill.getOrderstatus().getIdStatus(), bill.getOrderstatus().getNameStatus());
		billDTO.setOrderstatus(orderstatusDTO);
		
		TransportDTO transportDTO= new TransportDTO(bill.getTransport().getIdTransport()
				,bill.getTransport().getDescribes(),bill.getTransport().getFee(),bill.getTransport().getNameTransport());
		billDTO.setTransport(transportDTO);
		
		UserDTO userDTO= new UserDTO(bill.getUser().getIdUser(), bill.getUser().getAddress(),
				bill.getUser().getEmail(), bill.getUser().getNameUser(), bill.getUser().getNumberphone());
		billDTO.setUser(userDTO);
		
		List<DetailbillDTO> lstDetailDTO = new ArrayList<DetailbillDTO>();
		for(Detailbill detail : bill.getDetailbills()) {
			DetailbillDTO detailDTO = new DetailbillDTO();
			detailDTO.setIdDetailBill(detail.getIdDetailBill());
			detailDTO.setPrice(detail.getPrice());
			detailDTO.setQuantityBuy(detail.getQuantityBuy());
			BookDTO book =new BookDTO();
			book.setIdBook(detail.getBook().getIdBook());
			book.setNameBook(detail.getBook().getNameBook());
			book.setPicBook(detail.getBook().getPicBook());
			detailDTO.setBook(book);
			lstDetailDTO.add(detailDTO);
		}
		billDTO.setDetailbills(lstDetailDTO);
		
		return billDTO;
	}

	public List<BillDTO> getAllBill() {
		List<Bill> lstBill= billDao.getAllBill();
		
		List<BillDTO> lstBillDTO= new ArrayList<BillDTO>();
		for (Bill bill : lstBill) {
			
			BillDTO billDTO= new BillDTO();
			billDTO.setIdBill(bill.getIdBill());
			billDTO.setDateCreate(bill.getDateCreate());
			billDTO.setDeliveryAdress(bill.getDeliveryAdress());
			billDTO.setNameReceiver(bill.getNameReceiver());
			billDTO.setNumberphone(bill.getNumberphone());
			billDTO.setTotal(bill.getTotal());
			
			OrderstatusDTO orderstatusDTO=new OrderstatusDTO(bill.getOrderstatus().getIdStatus(), bill.getOrderstatus().getNameStatus());
			billDTO.setOrderstatus(orderstatusDTO);			
			UserDTO userDTO= new UserDTO(bill.getUser().getIdUser(), bill.getUser().getAddress(),
					bill.getUser().getEmail(), bill.getUser().getNameUser(), bill.getUser().getNumberphone());
			billDTO.setUser(userDTO);
			
			List<DetailbillDTO> lstDetailDTO = new ArrayList<DetailbillDTO>();
			for(Detailbill detail : bill.getDetailbills()) {
				DetailbillDTO detailDTO = new DetailbillDTO();
				detailDTO.setIdDetailBill(detail.getIdDetailBill());
				detailDTO.setPrice(detail.getPrice());
				detailDTO.setQuantityBuy(detail.getQuantityBuy());
				BookDTO book =new BookDTO();
				book.setIdBook(detail.getBook().getIdBook());
				book.setNameBook(detail.getBook().getNameBook());
				detailDTO.setBook(book);
				lstDetailDTO.add(detailDTO);
			}
			billDTO.setDetailbills(lstDetailDTO);
		
			lstBillDTO.add(billDTO);
		}
		return lstBillDTO;
	}

	public List<BillDTO> getBillsByIdUser(int idUser) {
		List<Bill> lstBill= billDao.getBillsByIdUser(idUser);
		
		List<BillDTO> lstBillDTO= new ArrayList<BillDTO>();
		for (Bill bill : lstBill) {
			
			BillDTO billDTO= new BillDTO();
			billDTO.setIdBill(bill.getIdBill());
			billDTO.setDateCreate(bill.getDateCreate());
			billDTO.setDeliveryAdress(bill.getDeliveryAdress());
			billDTO.setNameReceiver(bill.getNameReceiver());
			billDTO.setNumberphone(bill.getNumberphone());
			billDTO.setTotal(bill.getTotal());
			
			PaymentDTO paymentDTO=new PaymentDTO(bill.getPayment().getIdPayment(), bill.getPayment().getNamePayment());
			billDTO.setPayment(paymentDTO);
			
			OrderstatusDTO orderstatusDTO=new OrderstatusDTO(bill.getOrderstatus().getIdStatus(), bill.getOrderstatus().getNameStatus());
			billDTO.setOrderstatus(orderstatusDTO);
			
			TransportDTO transportDTO= new TransportDTO(bill.getTransport().getIdTransport()
					,bill.getTransport().getDescribes(),bill.getTransport().getFee(),bill.getTransport().getNameTransport());
			billDTO.setTransport(transportDTO);
			
			List<DetailbillDTO> lstDetailDTO = new ArrayList<DetailbillDTO>();
			for(Detailbill detail : bill.getDetailbills()) {
				DetailbillDTO detailDTO = new DetailbillDTO();
				detailDTO.setIdDetailBill(detail.getIdDetailBill());
				detailDTO.setPrice(detail.getPrice());
				detailDTO.setQuantityBuy(detail.getQuantityBuy());
				BookDTO book =new BookDTO();
				book.setIdBook(detail.getBook().getIdBook());
				book.setNameBook(detail.getBook().getNameBook());
				detailDTO.setBook(book);
				lstDetailDTO.add(detailDTO);
			}
			billDTO.setDetailbills(lstDetailDTO);
		
			lstBillDTO.add(billDTO);
		}
		return lstBillDTO;
	}

	public boolean updateStatusBill(int idBill, int idStatus) {
		return billDao.updateStatusBill(idBill, idStatus);
	}

}
