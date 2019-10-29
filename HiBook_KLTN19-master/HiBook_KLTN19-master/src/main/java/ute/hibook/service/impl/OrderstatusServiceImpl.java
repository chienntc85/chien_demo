package ute.hibook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ute.hibook.dao.imp.OrderstatusDaoImpl;
import ute.hibook.dto.OrderstatusDTO;
import ute.hibook.entity.Orderstatus;
import ute.hibook.service.OrderstatusService;

@Service
public class OrderstatusServiceImpl implements OrderstatusService{

	@Autowired
	OrderstatusDaoImpl orderstatusDao;
	
	public void addOrderstatus(OrderstatusDTO orderstatusDTO) {
		Orderstatus orderstatus= new Orderstatus();
		orderstatus.setNameStatus(orderstatusDTO.getNameStatus());
		
		orderstatusDao.addOrderstatus(orderstatus);		
		System.out.println("add Orderstatus successful!");
	}

	public void updateOrderstatus(OrderstatusDTO orderstatusDTO) {
		Orderstatus orderstatus= orderstatusDao.getOrderstatusById(orderstatusDTO.getIdStatus());
		if(orderstatus!=null) {
			orderstatus.setNameStatus(orderstatusDTO.getNameStatus());
			
			orderstatusDao.updateOrderstatus(orderstatus);
			System.out.println("update Orderstatus successful!");
		}
	}

	public void deleteOrderstatus(int idOrderstatus) {
		Orderstatus orderstatus= orderstatusDao.getOrderstatusById(idOrderstatus);
		if(orderstatus!=null) {
			orderstatusDao.deleteOrderstatus(idOrderstatus);
			System.out.println("delete Orderstatus successful!");
		}
	}

	public OrderstatusDTO getOrderstatusById(int idOrderstatus) {
		Orderstatus orderstatus= orderstatusDao.getOrderstatusById(idOrderstatus);
		
		OrderstatusDTO orderstatusDTO= new OrderstatusDTO();
		orderstatusDTO.setIdStatus(orderstatus.getIdStatus());
		orderstatusDTO.setNameStatus(orderstatus.getNameStatus());
		//System.out.println(orderstatus.getBills().get(0).getNameReceiver());
		
		return orderstatusDTO;
	}

	public List<OrderstatusDTO> getAllOrderstatus() {
		List<Orderstatus> lstOrderstatus= orderstatusDao.getAllOrderstatus();
		
		List<OrderstatusDTO> lstOrderstatusDTO= new ArrayList<OrderstatusDTO>();
		for (Orderstatus orderstatus : lstOrderstatus) {
			
			OrderstatusDTO orderstatusDTO= new OrderstatusDTO();
			orderstatusDTO.setIdStatus(orderstatus.getIdStatus());
			orderstatusDTO.setNameStatus(orderstatus.getNameStatus());
		
			lstOrderstatusDTO.add(orderstatusDTO);
		}
		return lstOrderstatusDTO;
	}

}
