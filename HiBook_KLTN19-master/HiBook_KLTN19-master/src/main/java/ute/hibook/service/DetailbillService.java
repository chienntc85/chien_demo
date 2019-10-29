package ute.hibook.service;

import java.util.List;

import ute.hibook.dto.DetailbillDTO;


public interface DetailbillService {

	public void addDetailbill(DetailbillDTO detailbillDTO);
	public void updateDetailbill(DetailbillDTO detailbillDTO);
	public void deleteDetailbill(int idDetailbill);
	public DetailbillDTO getDetailbillById(int idDetailbill);
	public List<DetailbillDTO> getAllDetailbill();
}
