package es.gonzalez.AcademyBoxIt.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
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
import org.springframework.web.bind.support.SessionStatus;

import es.gonzalez.AcademyBoxIt.model.Doubt;
import es.gonzalez.AcademyBoxIt.model.User;
import es.gonzalez.AcademyBoxIt.model.UserType;
import es.gonzalez.AcademyBoxIt.service.CourseSvc;
import es.gonzalez.AcademyBoxIt.service.DoubtSvc;
import es.gonzalez.AcademyBoxIt.service.UserSvc;

@SessionAttributes({ "sessionUser" })
@Controller
public class UserController {

	private static final String ATT_ERROR = "error de autenticación";
	private static final String SUCCESS = "home";


	@Autowired
	private UserSvc uSvc;
	@Autowired
	private DoubtSvc dSvc;
	@Autowired 
	private CourseSvc cSvc;

	@InitBinder
	private void initBinder(WebDataBinder binder) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	// VISTAS DEL USUARIO
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String viewLogin(@ModelAttribute User user, Model model) {
		return "login";
	}
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String viewregister(@ModelAttribute User user, Model model) {
		try {
			model.addAttribute("courselist", cSvc.showTypes());
		} catch(Exception ex) {
			model.addAttribute("loginfail", ATT_ERROR);
			return "register";
		}
		
		return "register";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String viewHome(@ModelAttribute User user, Model model) {
		return "home";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(@ModelAttribute User user, Model model, SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "login";
	}

	// POSTS DEL USUARIO
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String view(@Valid User user, BindingResult result, Model model) {

		try {
			if (result.getFieldError("dni") != null || result.getFieldError("clave") != null) {
				return "login";
			} else {
				user = uSvc.login(user.getDni(), user.getPassword());
				if (user == null) {
					result.reject("mal");
					return "login";
				} else {

					model.addAttribute("sessionUser", user);

					return viewHome(user,model);
				}

			}
		} catch (Exception ex) {
			model.addAttribute("loginfail", ATT_ERROR);
			return "login";
		}
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@Valid User user, BindingResult result, Model model) {
       
		try {
			if (result.getFieldError("dni") != null || result.getFieldError("password") != null|| result.getFieldError("email") != null||
					result.getFieldError("course") != null	|| result.getFieldError("name") != null) {
				return "register";
			} else {
				
				uSvc.saveUser(user);
		
					return viewLogin(user,model);
				}

			
		} catch (Exception ex) {
			model.addAttribute("loginfail", ATT_ERROR);
			return "error";
		}
	}

	@RequestMapping(value = "/sendoubt", method = RequestMethod.POST)
	public String doubt(@ModelAttribute("sessionUser") User user, @RequestParam String doubt, Model model) {

		try {

			Doubt d = new Doubt();
			d.setContent(doubt);
			dSvc.saveDoubt(d, user);

			return viewHome(user, model);

		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return "error";
		}
	}

}
