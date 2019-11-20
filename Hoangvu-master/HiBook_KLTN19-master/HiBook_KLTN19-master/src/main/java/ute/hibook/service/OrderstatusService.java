package ute.hibook.service;

import java.util.List;

import ute.hibook.dto.OrderstatusDTO;

public interface OrderstatusService {

	public void addOrderstatus(OrderstatusDTO orderstatusDTO);
	public void updateOrderstatus(OrderstatusDTO orderstatusDTO);
	public void deleteOrderstatus(int idOrderstatus);
	public OrderstatusDTO getOrderstatusById(int idOrderstatus);
	public List<OrderstatusDTO> getAllOrderstatus();
}
