package ute.hibook.dao;

import java.util.List;

import ute.hibook.entity.Userreview;

public interface UserreviewDao {

	public void addUserreview(Userreview userreview);
	public void updateUserreview(Userreview userreview);
	public void deleteUserreview(int idUserreview);
	public Userreview getUserreviewById(int idUserreview);
	public List<Userreview> getAllUserreview();
}
