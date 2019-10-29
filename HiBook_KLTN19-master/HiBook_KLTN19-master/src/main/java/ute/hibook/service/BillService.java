package ute.hibook.service;

import java.util.List;

import ute.hibook.dto.BillDTO;


public interface BillService {

	public int addBill(BillDTO billDTO);
	public void updateBill(BillDTO billDTO);
	public void deleteBill(int idBill);
	public BillDTO getBillById(int idBill);
	public List<BillDTO> getBillsByIdUser(int idUser);
	public List<BillDTO> getAllBill();
	public boolean updateStatusBill(int idBill, int idStatus);
}
