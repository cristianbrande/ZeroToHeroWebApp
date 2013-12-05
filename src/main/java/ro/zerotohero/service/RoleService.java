package ro.zerotohero.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.zerotohero.dao.RoleDao;
import ro.zerotohero.model.RoleEntity;

@Service
public class RoleService {

	@Autowired
	private RoleDao roleDao;

	@Transactional
	public List<RoleEntity> findAll(){
		return roleDao.findAll();
	}
	
	@Transactional
	public void save(RoleEntity role){
		roleDao.save(role);
	}
	
	@Transactional
	public RoleEntity findById(int roleId){
		return roleDao.findById(roleId);
	}
	
	@Transactional
	public void delete(RoleEntity role){
		roleDao.delete(role);
	}
}
