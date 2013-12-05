package ro.zerotohero.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ro.zerotohero.model.RoleEntity;

@Repository
public class RoleDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<RoleEntity> findAll(){
		Session session = sessionFactory.getCurrentSession();
		List<RoleEntity> roleList = session.createQuery("from RoleEntity").list();
		return roleList;
	}
	
	@Transactional
	public void save(RoleEntity role){
		Session session = sessionFactory.getCurrentSession();
		RoleEntity dbRole = findById(role.getRoleId());
		
		if (dbRole != null){
			dbRole.setName(role.getName());
			dbRole.setAuthority(role.getAuthority());
			session.update(dbRole);
		}else{
			session.save(role);
		}
	}
	
	@Transactional
	public RoleEntity findById( int roleId){
		Session session = sessionFactory.getCurrentSession();
		RoleEntity role = (RoleEntity) session.createQuery("from RoleEntity where roleId = :id").setParameter("id", roleId).uniqueResult();
		return role;
	}
	
	
	@Transactional
	public void delete(RoleEntity role){
		Session session = sessionFactory.getCurrentSession();
		RoleEntity dbRole = findById(role.getRoleId());
		session.delete(dbRole);
	}
}
