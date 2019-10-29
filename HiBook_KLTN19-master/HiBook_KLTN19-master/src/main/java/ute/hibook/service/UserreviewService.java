package ute.hibook.service;

import java.util.List;

import ute.hibook.dto.UserreviewDTO;

public interface UserreviewService {

	public void addUserreview(UserreviewDTO userreviewDTO);
	public void updateUserreview(UserreviewDTO userreviewDTO);
	public void deleteUserreview(int idUserreview);
	public UserreviewDTO getUserreviewById(int idUserreview);
	public List<UserreviewDTO> getAllUserreview();
}
