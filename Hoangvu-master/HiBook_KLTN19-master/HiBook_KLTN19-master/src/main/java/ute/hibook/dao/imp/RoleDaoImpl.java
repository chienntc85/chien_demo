package ute.hibook.dao.imp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ute.hibook.dao.RoleDao;
import ute.hibook.entity.Role;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
@Transactional
public class RoleDaoImpl implements RoleDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public void addRole(Role role) {
		sessionFactory.getCurrentSession().save(role);
	}

	public void updateRole(Role role) {
		sessionFactory.getCurrentSession().update(role);
	}

	public void deleteRole(int idRole) {
		sessionFactory.getCurrentSession().delete(getRoleById(idRole));
	}

	public Role getRoleById(int idRole) {
		return sessionFactory.getCurrentSession().get(Role.class, idRole);
	}

	public List<Role> getAllRole() {
		return sessionFactory.getCurrentSession().createQuery("from role").getResultList();
	}

}
