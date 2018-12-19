package es.gonzalez.AcademyBoxIt.controller.ajax;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import es.gonzalez.AcademyBoxIt.model.User;
import es.gonzalez.AcademyBoxIt.service.UserSvc;



@Controller
@RequestMapping(value = "/ajax")
public class UsuarioAjaxController {



	private static final String SUCCESS = "forward:/admin/alumnslist";


	@Autowired
	private UserSvc svc;


	@RequestMapping(value = "/drop", method = RequestMethod.GET)
	public String borrar(@RequestParam int id, Model model) {
		try {
			User user = new User();
			user.setId(id);

			// Borrar actual
			svc.deleteUser(user);

			// Refrescar la lista
			model.addAttribute("typelist", svc.listUsers(null));

			// Devolver la lista actualizada (JSP)
			return SUCCESS;
		} catch (Exception e) {
			return null;
		}
	}


}
