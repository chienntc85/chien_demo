package ute.hibook.dao;

import java.util.List;

import ute.hibook.entity.Bill;

public interface BillDao {

	public int addBill(Bill bill);
	public void updateBill(Bill bill);
	public void deleteBill(int idBill);
	public Bill getBillById(int idBill);
	public List<Bill> getBillsByIdUser(int idUser);
	public List<Bill> getAllBill();
	public boolean updateStatusBill(int idBill, int idStatus);
}
