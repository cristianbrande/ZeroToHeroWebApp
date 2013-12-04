package ro.zerotohero.controller.role;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ro.zerotohero.model.RoleEntity;


@Controller
@RequestMapping("/role")
public class RoleController {

	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap model) {

		ArrayList<RoleEntity> roleList = new ArrayList<RoleEntity>();
		
		for (int i = 0; i < 10; i++){
			roleList.add(new RoleEntity("role_nr_" + i ,"" + i));
		}
		
		model.addAttribute("message", "Application Index Role");
		model.addAttribute("roleList", roleList);
		
		return "role/index";
	}

}