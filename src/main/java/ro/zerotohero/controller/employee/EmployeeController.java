package ro.zerotohero.controller.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ro.zerotohero.model.EmployeeEntity;
import ro.zerotohero.service.EmployeeService;


@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/listRole", method = RequestMethod.GET)
	public String listRole(ModelMap model) {
		List<EmployeeEntity> roleList = employeeService.findAll();
		model.addAttribute("roleList", roleList);
		return "employee/listRole";
	}
}