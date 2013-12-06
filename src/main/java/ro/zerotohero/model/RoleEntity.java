package ro.zerotohero.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class RoleEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private int roleId;
	private String name;
	private String authority;
	private List<EmployeeEntity> employeeList = new ArrayList<EmployeeEntity>();
	
	public RoleEntity() {
	}

	public RoleEntity(String name) {
		this.name = name;
	}

	@Column(name = "NAME", unique = true, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "AUTHORITY", unique = false, nullable = false)
	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Id
	@GeneratedValue ( strategy = GenerationType.SEQUENCE, generator = "ROLE_SEQ")
	@SequenceGenerator ( name = "ROLE_SEQ", sequenceName = "ROLE_SEQ", allocationSize = 1)
	@Column(name = "ROLE_ID", unique = true, nullable = false)
	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	@ManyToMany(mappedBy="roleList", fetch=FetchType.EAGER)
	public List<EmployeeEntity> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<EmployeeEntity> employeeList) {
		this.employeeList = employeeList;
	}

}
