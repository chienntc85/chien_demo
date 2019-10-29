package ute.hibook.dao;

import java.util.List;

import ute.hibook.entity.Role;

public interface RoleDao {

	public void addRole(Role Role);
	public void updateRole(Role Role);
	public void deleteRole(int idRole);
	public Role getRoleById(int idRole);
	public List<Role> getAllRole();
}
