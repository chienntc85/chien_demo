package ute.hibook.dao;

import java.util.List;

import ute.hibook.entity.Promotion;

public interface PromotionDao {

	public void addPromotion(Promotion promotion);

	public void updatePromotion(Promotion promotion);

	public void deletePromotion(int idPromotion);

	public Promotion getPromotionById(int idPromotion);

	public List<Promotion> getAllPromotion();

	public List<Promotion> getAllPromotionDate();
	
}
