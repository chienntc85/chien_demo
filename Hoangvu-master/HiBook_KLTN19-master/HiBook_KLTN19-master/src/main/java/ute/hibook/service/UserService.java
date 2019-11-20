package ute.hibook.service;

import java.util.List;

import ute.hibook.dto.UserDTO;

public interface UserService {

	public void addUser(UserDTO userDTO);
	public void updateUser(UserDTO userDTO);
	public void deleteUser(int idUser);
	public UserDTO getUserById(int idUser);
	public List<UserDTO> getAllUser();
	public UserDTO getUserByEmail(String email);
	public boolean updateRoleUser(int idUser, int idRole);
}
