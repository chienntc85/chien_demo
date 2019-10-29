package ute.hibook.service;

import java.util.List;

import ute.hibook.dto.ConvertPromotionDTO;
import ute.hibook.dto.PromotionDTO;
import ute.hibook.dto.PromotionUpdateDTO;


public interface PromotionService {

	public void addPromotion(PromotionDTO promotionDTO);
	public void updatePromotion(PromotionUpdateDTO promotionDTO);
	public void deletePromotion(int idPromotion);
	public ConvertPromotionDTO getPromotionById(int idPromotion);
	public List<ConvertPromotionDTO> getAllPromotion();
	public List<PromotionDTO> getAllPromotions();
	public List<PromotionDTO> getAllPromotiondate();
}
