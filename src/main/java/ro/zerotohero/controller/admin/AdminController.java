package ro.zerotohero.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ro.zerotohero.model.EmployeeEntity;
import ro.zerotohero.model.RoleEntity;
import ro.zerotohero.service.EmployeeService;
import ro.zerotohero.service.RoleService;


@Controller
@RequestMapping("/admin")
public class AdminController {

	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap model) {
		model.addAttribute("message", "Application Index Admin");
		return "admin/index";
	}

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private RoleService roleService;
	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(ModelMap model) {
		List<EmployeeEntity> employeeList = employeeService.findAll();
		model.addAttribute("employeeList", employeeList);
		return "admin/list";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newEmployee(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {

		model.addAttribute("employee", new EmployeeEntity());
		return "admin/newRole";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {

		EmployeeEntity employee = new EmployeeEntity();
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String roleId = request.getParameter("roleId");
		String employeeId = request.getParameter("employeeId");
		
		employee.setFirstName(firstName);
		employee.setFirstName(lastName);
		employee.setFirstName(email);
		employee.setPassword(password);
		
		if ((employeeId == "") || (employeeId == null)) {
			employee.setEmployeeId(0);
		}else{
			employee.setEmployeeId(Integer.valueOf(employeeId));
		}
		
		if (roleId == "" || roleId==null){
			roleId = employee.getRoleList().get(0).getRoleId()+"";
		}
		
		RoleEntity role = roleService.findById(Integer.valueOf(roleId));
		employee.getRoleList().add(role);
		role.getEmployeeList().add(employee);
		employeeService.save(employee);
		
		List<EmployeeEntity> employeeList = employeeService.findAll();
		model.addAttribute("employeeList", employeeList);
		return "redirect:/admin/list";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, @PathVariable("id") int id) {

		model.addAttribute("employee", employeeService.findById(id));

		return "admin/new";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, @PathVariable("id") int id) {

		employeeService.delete(employeeService.findById(id));
		List<EmployeeEntity> employeeList = employeeService.findAll();
		model.addAttribute("employeeList", employeeList);

		return "redirect:/admin/list";
	}
	
	
}