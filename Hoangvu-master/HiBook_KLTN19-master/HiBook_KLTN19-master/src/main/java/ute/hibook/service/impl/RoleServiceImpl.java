package ute.hibook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ute.hibook.dao.imp.RoleDaoImpl;
import ute.hibook.dto.RoleDTO;
import ute.hibook.entity.Role;
import ute.hibook.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleDaoImpl roleDao;
	
	public void addRole(RoleDTO roleDTO) {
		Role role= new Role();
		role.setNameRole(roleDTO.getNameRole());
		roleDao.addRole(role);		
		System.out.println("add Role successful!");
	}

	public void updateRole(RoleDTO roleDTO) {
		Role role= roleDao.getRoleById(roleDTO.getIdRole());
		if(role!=null) {
			role.setNameRole(roleDTO.getNameRole());
			roleDao.updateRole(role);
			System.out.println("update Role successful!");
		}
	}

	public void deleteRole(int idRole) {
		Role role= roleDao.getRoleById(idRole);
		if(role!=null) {
			roleDao.deleteRole(idRole);
			System.out.println("delete Role successful!");
		}
	}

	public RoleDTO getRoleById(int idRole) {
		Role role= roleDao.getRoleById(idRole);
		
		RoleDTO roleDTO= new RoleDTO();
		roleDTO.setIdRole(role.getIdRole());
		roleDTO.setNameRole(role.getNameRole());
		//System.out.println(role.getUsers().get(0).getEmail());
		
		return roleDTO;
	}

	public List<RoleDTO> getAllRole() {
		List<Role> lstRole= roleDao.getAllRole();
		
		List<RoleDTO> lstRoleDTO= new ArrayList<RoleDTO>();
		for (Role role : lstRole) {
			
			RoleDTO roleDTO= new RoleDTO();
			roleDTO.setIdRole(role.getIdRole());
			roleDTO.setNameRole(role.getNameRole());
		
			lstRoleDTO.add(roleDTO);
		}
		return lstRoleDTO;
	}

}
