package ute.hibook.dto;

public class RoleDTO {

	private int idRole;
	private String nameRole;
	
	

	public RoleDTO() {
		super();
	}

	public RoleDTO(int idRole, String nameRole) {
		super();
		this.idRole = idRole;
		this.nameRole = nameRole;
	}

	public int getIdRole() {
		return this.idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public String getNameRole() {
		return this.nameRole;
	}

	public void setNameRole(String nameRole) {
		this.nameRole = nameRole;
	}

}
