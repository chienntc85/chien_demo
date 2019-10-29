package ute.hibook.dao;

import java.util.List;

import ute.hibook.entity.Orderstatus;

public interface OrderstatusDao {

	public void addOrderstatus(Orderstatus orderstatus);
	public void updateOrderstatus(Orderstatus orderstatus);
	public void deleteOrderstatus(int idOrderstatus);
	public Orderstatus getOrderstatusById(int idOrderstatus);
	public List<Orderstatus> getAllOrderstatus();
}
