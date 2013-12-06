package ro.zerotohero.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ro.zerotohero.model.EmployeeEntity;

@Repository
public class EmployeeDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<EmployeeEntity> findAll(){
		Session session = sessionFactory.getCurrentSession();
		List<EmployeeEntity> employeeList = session.createQuery("from EmployeeEntity").list();
		return employeeList;
	}
	
	@Transactional
	public void save(EmployeeEntity employee){
		Session session = sessionFactory.getCurrentSession();
		EmployeeEntity dbemployee = findById(employee.getEmployeeId());
		
		if (dbemployee != null){
			dbemployee.setFirstName(employee.getFirstName());
			dbemployee.setLastName(employee.getLastName());
			dbemployee.setEmail(employee.getEmail());
			dbemployee.setPassword(employee.getPassword());
			session.update(dbemployee);
		}else{
			session.save(employee);
		}
	}
	
	@Transactional
	public EmployeeEntity findById( int employeeId){
		Session session = sessionFactory.getCurrentSession();
		EmployeeEntity employee = (EmployeeEntity) session.createQuery("from EmployeeEntity where employeeId = :id").setParameter("id", employeeId).uniqueResult();
		return employee;
	}
	
	
	@Transactional
	public void delete(EmployeeEntity employee){
		Session session = sessionFactory.getCurrentSession();
		EmployeeEntity dbemployee = findById(employee.getEmployeeId());
		session.delete(dbemployee);
	}
}
