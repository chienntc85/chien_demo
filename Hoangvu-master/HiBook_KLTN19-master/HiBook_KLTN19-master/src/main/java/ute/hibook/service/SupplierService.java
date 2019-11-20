package ute.hibook.service;

import java.util.List;

import ute.hibook.dto.SupplierDTO;


public interface SupplierService {

	public void addSupplier(SupplierDTO supplierDTO);
	public void updateSupplier(SupplierDTO supplierDTO);
	public void deleteSupplier(int idSupplier);
	public SupplierDTO getSupplierById(int idSupplier);
	public List<SupplierDTO> getAllSupplier();
}
