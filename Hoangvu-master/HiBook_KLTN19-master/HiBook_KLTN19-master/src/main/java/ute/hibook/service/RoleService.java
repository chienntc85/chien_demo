package ute.hibook.service;

import java.util.List;

import ute.hibook.dto.RoleDTO;

public interface RoleService {

	public void addRole(RoleDTO roleDTO);
	public void updateRole(RoleDTO roleDTO);
	public void deleteRole(int idRole);
	public RoleDTO getRoleById(int idRole);
	public List<RoleDTO> getAllRole();
}
