package ute.hibook.dao;

import java.util.List;

import ute.hibook.entity.Detailbill;

public interface DetailbillDao {

	public void addDetailbill(Detailbill detailbill);
	public void updateDetailbill(Detailbill detailbill);
	public void deleteDetailbill(int idDetailbill);
	public Detailbill getDetailbillById(int idDetailbill);
	public List<Detailbill> getAllDetailbill();
}
