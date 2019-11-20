package ute.hibook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ute.hibook.dao.imp.RoleDaoImpl;
import ute.hibook.dao.imp.UserDaoImpl;
import ute.hibook.dto.RoleDTO;
import ute.hibook.dto.UserDTO;
import ute.hibook.entity.Role;
import ute.hibook.entity.User;
import ute.hibook.service.UserService;
/*
 * 
 * Chú ý hàm delete đã sử dụng lại hàm getXXXById() 2 lần
 *  User - Role cần chú ý khi lấy Role truyền vào UserDTO
 *  qua việc xét Role vô roleDTO
 *  
 *  */

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDaoImpl userDao;
	@Autowired
	RoleDaoImpl roleDao;
	
	public void addUser(UserDTO userDTO) {
		User user= new User();
		user.setNameUser(userDTO.getNameUser());
		user.setAddress(userDTO.getAddress());
		user.setBirthday(userDTO.getBirthday());
		user.setEmail(userDTO.getEmail());
		user.setNumberphone(userDTO.getNumberphone());
		user.setPassword(userDTO.getPassword());
		user.setSex(userDTO.getSex());
		
		Role role=roleDao.getRoleById(userDTO.getRole().getIdRole());
		user.setRole(role);
		
		userDao.addUser(user);		
		System.out.println("add User successful!");
	}

	public void updateUser(UserDTO userDTO) {
		User user= userDao.getUserById(userDTO.getIdUser());
		if(user!=null) {
			user.setNameUser(userDTO.getNameUser());
			user.setAddress(userDTO.getAddress());
			user.setBirthday(userDTO.getBirthday());
			user.setEmail(userDTO.getEmail());
			user.setNumberphone(userDTO.getNumberphone());
//			user.setPassword(userDTO.getPassword());
			user.setSex(userDTO.getSex());
//			Role role=roleDao.getRoleById(userDTO.getRole().getIdRole());
//			user.setRole(role);
			
			userDao.updateUser(user);
			System.out.println("update User successful!");
		}
	}
	
	public void updatePassUser(UserDTO userDTO) {
		User user= userDao.getUserById(userDTO.getIdUser());
		if(user!=null) {
			user.setPassword(userDTO.getPassword());			
			userDao.updateUser(user);
			System.out.println("update User successful!");
		}
	}

	public void deleteUser(int idUser) {
		User user= userDao.getUserById(idUser);
		if(user!=null) {
			userDao.deleteUser(idUser);
			
			System.out.println("delete User successful!");
		}
	}

	public UserDTO getUserById(int idUser) {
		User user= userDao.getUserById(idUser);
		
		UserDTO userDTO= new UserDTO();
		userDTO.setIdUser(user.getIdUser());
		userDTO.setNameUser(user.getNameUser());
		userDTO.setAddress(user.getAddress());
		userDTO.setBirthday(user.getBirthday());
		userDTO.setEmail(user.getEmail());
		userDTO.setNumberphone(user.getNumberphone());
		userDTO.setPassword(user.getPassword());
		userDTO.setSex(user.getSex());
		RoleDTO roleDTO=new RoleDTO(user.getRole().getIdRole(), user.getRole().getNameRole());
		userDTO.setRole(roleDTO);
		
		return userDTO;
	}

	public List<UserDTO> getAllUser() {
		List<User> lstUser= userDao.getAllUser();
		
		List<UserDTO> lstUserDTO= new ArrayList<UserDTO>();
		for (User user : lstUser) {
			
			UserDTO userDTO= new UserDTO();
			userDTO.setIdUser(user.getIdUser());
			userDTO.setNameUser(user.getNameUser());
			userDTO.setAddress(user.getAddress());
			userDTO.setBirthday(user.getBirthday());
			userDTO.setEmail(user.getEmail());
			userDTO.setNumberphone(user.getNumberphone());
			userDTO.setPassword(user.getPassword());
			userDTO.setSex(user.getSex());
			
			RoleDTO roleDTO=new RoleDTO(user.getRole().getIdRole(), user.getRole().getNameRole());
			userDTO.setRole(roleDTO);
		
			lstUserDTO.add(userDTO);
		}
		return lstUserDTO;
	}

	public UserDTO getUserByEmail(String email) {
		User user= userDao.getUserByEmail(email);
		if(null != user) {
			UserDTO userDTO= new UserDTO();
			userDTO.setIdUser(user.getIdUser());
			userDTO.setNameUser(user.getNameUser());
			userDTO.setAddress(user.getAddress());
			userDTO.setBirthday(user.getBirthday());
			userDTO.setEmail(user.getEmail());
			userDTO.setNumberphone(user.getNumberphone());
			userDTO.setPassword(user.getPassword());
			userDTO.setSex(user.getSex());
			RoleDTO roleDTO=new RoleDTO(user.getRole().getIdRole(), user.getRole().getNameRole());
			userDTO.setRole(roleDTO);
			
			return userDTO;
		}else {
			return null;
		}
	}

	public boolean updateRoleUser(int idUser, int idRole) {
		return userDao.updateRoleUser(idUser, idRole);
	}

}
