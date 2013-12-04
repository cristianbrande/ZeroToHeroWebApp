package ro.zerotohero.controller.employee;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ro.zerotohero.model.EmployeeEntity;


@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap model) {
		
		ArrayList<EmployeeEntity> employeeList = new ArrayList<EmployeeEntity>();
		
		for (int i =0; i< 3; i++){
			EmployeeEntity employee = new EmployeeEntity();
			employee.setEmail("mail" + i);
			employee.setFirstName("first" + i);
			employee.setLastName("last" + i);
			employee.setPassword("pass" + i);

			employeeList.add(employee);
		}
				
		model.addAttribute("message", "Application Index Employee");
		model.addAttribute("employeeList", employeeList);
		return "employee/index";
	}

}