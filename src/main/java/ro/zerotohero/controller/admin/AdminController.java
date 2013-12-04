package ro.zerotohero.controller.admin;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ro.zerotohero.model.AdminEntity;


@Controller
@RequestMapping("/admin")
public class AdminController {

	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap model) {

		ArrayList<AdminEntity> adminList = new ArrayList<AdminEntity>();
		
		for (int i =0; i< 3; i++){
			AdminEntity admin = new AdminEntity();
			admin.setEmail("mail" + i);
			admin.setFirstName("first" + i);
			admin.setLastName("last" + i);
			admin.setPassword("pass" + i);

			adminList.add(admin);
		}
		
		model.addAttribute("message", "Application Index Admin");
		model.addAttribute("adminList", adminList);
		return "admin/index";
	}

}