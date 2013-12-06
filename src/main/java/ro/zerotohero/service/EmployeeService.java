package ro.zerotohero.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.zerotohero.dao.EmployeeDao;
import ro.zerotohero.model.EmployeeEntity;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Transactional
	public List<EmployeeEntity> findAll(){
		return employeeDao.findAll();
	}
	
	@Transactional
	public void save(EmployeeEntity employee){
		employeeDao.save(employee);
	}
	
	@Transactional
	public EmployeeEntity findById(int employeeId){
		return employeeDao.findById(employeeId);
	}
	
	@Transactional
	public void delete(EmployeeEntity employee){
		employeeDao.delete(employee);
	}
}
