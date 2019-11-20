package ute.hibook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ute.hibook.dto.RoleDTO;
import ute.hibook.service.impl.RoleServiceImpl;

@RestController
@RequestMapping(value = "/api/v1")
public class RoleController {

	@Autowired
	RoleServiceImpl roleSer;
	
	@GetMapping("/roles")
	public ResponseEntity<List<RoleDTO>> getAllRole() {
		
		List<RoleDTO> roles= roleSer.getAllRole();
		if(roles.isEmpty()) {
			return new ResponseEntity<List<RoleDTO>>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<List<RoleDTO>>(roles,HttpStatus.OK);
	}
	
	@GetMapping("/roles/{idRole}")
	public String getRoleById(@PathVariable int idRole) {
		
		RoleDTO role= roleSer.getRoleById(1);
		System.out.println(role.getNameRole());
		return "<h1>Hello!!!</h1>";
	}
	
	@GetMapping("/roles/add")
	public String addRole() {
		
		RoleDTO role= new RoleDTO();
		role.setNameRole("STAFF1");
		roleSer.addRole(role);
		return "<h1>Hello!!!</h1>";
	}
	
	@GetMapping("/roles/update")
	public String updateRole() {
		
		RoleDTO role= new RoleDTO();
		role.setIdRole(4);
		role.setNameRole("STAFFF");
		roleSer.updateRole(role);
		return "<h1>Hello!!!</h1>";
	}
}
