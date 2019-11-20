package ute.hibook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ute.hibook.dao.imp.SupplierDaoImpl;
import ute.hibook.dto.SupplierDTO;
import ute.hibook.entity.Supplier;
import ute.hibook.service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService{

	@Autowired
	SupplierDaoImpl supplierDao;
	
	public void addSupplier(SupplierDTO supplierDTO) {
		Supplier supplier= new Supplier();
		supplier.setNameSupplier(supplierDTO.getNameSupplier());
		
		supplierDao.addSupplier(supplier);		
		System.out.println("add Supplier successful!");
	}

	public void updateSupplier(SupplierDTO supplierDTO) {
		Supplier supplier= supplierDao.getSupplierById(supplierDTO.getIdSupplier());
		if(supplier!=null) {
			supplier.setNameSupplier(supplierDTO.getNameSupplier());
			
			supplierDao.updateSupplier(supplier);
			System.out.println("update Supplier successful!");
		}
	}

	public void deleteSupplier(int idSupplier) {
		Supplier supplier= supplierDao.getSupplierById(idSupplier);
		if(supplier!=null) {
			supplierDao.deleteSupplier(idSupplier);
			System.out.println("delete Supplier successful!");
		}
	}

	public SupplierDTO getSupplierById(int idSupplier) {
		Supplier supplier= supplierDao.getSupplierById(idSupplier);
		
		SupplierDTO supplierDTO= new SupplierDTO();
		supplierDTO.setIdSupplier(supplier.getIdSupplier());
		supplierDTO.setNameSupplier(supplier.getNameSupplier());
		//System.out.println(supplier.getBooks().get(0).getNameBook());
		
		return supplierDTO;
	}

	public List<SupplierDTO> getAllSupplier() {
		List<Supplier> lstSupplier= supplierDao.getAllSupplier();
		
		List<SupplierDTO> lstSupplierDTO= new ArrayList<SupplierDTO>();
		for (Supplier supplier : lstSupplier) {
			
			SupplierDTO supplierDTO= new SupplierDTO();
			supplierDTO.setIdSupplier(supplier.getIdSupplier());
			supplierDTO.setNameSupplier(supplier.getNameSupplier());
		
			lstSupplierDTO.add(supplierDTO);
		}
		return lstSupplierDTO;
	}

}
