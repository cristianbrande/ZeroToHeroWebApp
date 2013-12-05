package ro.zerotohero.controller.role;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ro.zerotohero.model.RoleEntity;
import ro.zerotohero.service.EmployeeService;
import ro.zerotohero.service.RoleService;

@Controller
@RequestMapping("/admin")
public class RoleController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private RoleService roleService;
	
	
	@RequestMapping(value = "/listRole", method = RequestMethod.GET)
	public String listRole(ModelMap model) {
		List<RoleEntity> roleList = roleService.findAll();
		model.addAttribute("roleList", roleList);
		return "admin/listRole";
	}

	@RequestMapping(value = "/newRole", method = RequestMethod.GET)
	public String newRole(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {

		model.addAttribute("role", new RoleEntity());
		return "admin/newRole";
	}

	@RequestMapping(value = "/saveRole", method = RequestMethod.POST)
	public String saveRole(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {

		RoleEntity role = new RoleEntity();
		String name = request.getParameter("name");
		String authority = request.getParameter("authority");
		
		
		role.setAuthority(authority);
		role.setName(name);
		String roleId = request.getParameter("roleId");
		
		if ((roleId == "") || (roleId == null)) {
			role.setRoleId(0);
		}else{
			role.setRoleId(Integer.valueOf(roleId));
		}
		roleService.save(role);

		List<RoleEntity> roleList = roleService.findAll();
		model.addAttribute("roleList", roleList);
		return "redirect:/admin/listRole";
	}

	@RequestMapping(value = "/editRole/{id}", method = RequestMethod.GET)
	public String editRole(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, @PathVariable("id") int id) {

		model.addAttribute("role", roleService.findById(id));

		return "admin/newRole";
	}
	
	
	

}