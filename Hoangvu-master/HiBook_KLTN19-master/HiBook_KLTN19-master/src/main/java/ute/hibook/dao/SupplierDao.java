package ute.hibook.dao;

import java.util.List;

import ute.hibook.entity.Supplier;

public interface SupplierDao {

	public void addSupplier(Supplier supplier);
	public void updateSupplier(Supplier supplier);
	public void deleteSupplier(int idSupplier);
	public Supplier getSupplierById(int idSupplier);
	public List<Supplier> getAllSupplier();
}
