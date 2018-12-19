package es.gonzalez.AcademyBoxIt.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import es.gonzalez.AcademyBoxIt.model.User;
import es.gonzalez.AcademyBoxIt.model.UserType;
import es.gonzalez.AcademyBoxIt.service.CourseSvc;
import es.gonzalez.AcademyBoxIt.service.UserSvc;
import es.gonzalez.AcademyBoxIt.service.UserTypeSvc;

@SessionAttributes({ "sessionUser" })
@Controller
@RequestMapping(value = "/adminpanel")
public class AdminController {

	@Autowired
	private UserSvc uSvc;
	@Autowired
	private CourseSvc courseSvc;
	@Autowired
	private UserTypeSvc usertypeSvc;

	@InitBinder
	private void initBinder(WebDataBinder binder) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	// Admin views
	@RequestMapping(method = RequestMethod.GET)
	public String viewAdminPanel(Model model) {
		return "admin/panel";

	}

	@RequestMapping(value = "/options", method = RequestMethod.GET)
	public String viewbyType(@RequestParam int id, Model model) {
		UserType type = new UserType();
		String uri = null;
		try {
			if (id == 1) {
				uri = "admin/alumnslist";
			} else if (id == 2) {
				uri = "admin/teacherslist";
			}

			type.setIdtype(id);
			model.addAttribute("typelist", uSvc.listUsers(type));

		} catch (Exception ex) {
			model.addAttribute("exception", ex);
		}
		if (uri != null) {
			return uri;
		} else {
			return "admin/panel";
		}

	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editById(@ModelAttribute User user, @RequestParam int id, Model model) {

		try {

			if (user.getId() != null) {
				model.addAttribute("editmode", true);
				model.addAttribute("user", uSvc.findById(id));
			}
			model.addAttribute("courselist", courseSvc.showTypes());
			model.addAttribute("typelist", usertypeSvc.showTypes());

		} catch (Exception ex) {
			model.addAttribute("exception", ex);

		}
		return "admin/edit";
	}

	@RequestMapping(value = "/newuser", method = RequestMethod.GET)
	public String editById(@ModelAttribute User user, Model model) {

		try {

			model.addAttribute("user", new User());
			model.addAttribute("courselist", courseSvc.showTypes());
			model.addAttribute("typelist", usertypeSvc.showTypes());

		} catch (Exception ex) {
			model.addAttribute("exception", ex);

		}
		return "admin/edit";
	}

	@RequestMapping(value = "/drop", method = RequestMethod.GET)
	public String dropbyId(@ModelAttribute User user, @RequestParam int id, Model model) {
		User res = null;

		try {

			res = uSvc.findById(id);
			uSvc.deleteUser(res);
			String delete = res.getName() + " was succesfully moved to the trash";
			model.addAttribute("delete", delete);

		} catch (Exception ex) {
			model.addAttribute("exception", ex);

		}

		return editById(new User(), model);

	}

	// Admin Post requests

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateUser(@Valid User user, BindingResult result, Model model) {

		try {

			if (uSvc.findById(user.getId()) != null) {
				uSvc.updateUser(user);

			} else {
				uSvc.saveUser(user);

			}
		} catch (Exception ex) {
			model.addAttribute("exception", ex);

		}
		return editById(new User(), model);
	}

}