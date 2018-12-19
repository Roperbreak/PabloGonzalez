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

import es.gonzalez.AcademyBoxIt.model.Code;
import es.gonzalez.AcademyBoxIt.model.User;
import es.gonzalez.AcademyBoxIt.model.UserType;
import es.gonzalez.AcademyBoxIt.service.CodeSvc;
import es.gonzalez.AcademyBoxIt.service.CourseSvc;
import es.gonzalez.AcademyBoxIt.service.UserSvc;
import es.gonzalez.AcademyBoxIt.service.UserTypeSvc;

@SessionAttributes({ "sessionUser" })
@Controller
@RequestMapping(value = "/teacherpanel")
public class TeacherController {

	@Autowired
	private UserSvc uSvc;
	@Autowired
	private CourseSvc courseSvc;
	@Autowired
	private UserTypeSvc usertypeSvc;
	@Autowired
	private CodeSvc cSvc;
	

	@InitBinder
	private void initBinder(WebDataBinder binder) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	// Admin views
	@RequestMapping(method = RequestMethod.GET)
	public String viewTeacherPanel(Model model) {
		return "teacher/panel";

	}

	@RequestMapping(value = "/options", method = RequestMethod.GET)
	public String view(Model model) {
		UserType type = new UserType();
		try {
			model.addAttribute("userlist", uSvc.listUsers(type));

		} catch (Exception ex) {
			model.addAttribute("exception", ex);
		}

		return "teacher/alumnlist";
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
		return "teacher/edit";
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
		return "teacher/edit";
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
	
	@RequestMapping(value = "/code", method = RequestMethod.GET)
	public String view(@ModelAttribute Code code, @RequestParam int id, Model model) {
		
		try {

			model.addAttribute("int", id);
			model.addAttribute("user", uSvc.findById(id));
			
			
			
			
			
		} catch (Exception ex) {
			model.addAttribute("exception", ex);
		}

		return "teacher/codelist";
	}

	// Teacher Post requests

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
	@RequestMapping(value = "/markcode", method = RequestMethod.POST)
	public String markuser(@Valid Code code, BindingResult result, @RequestParam int id, Model model) {
		double marks=code.getMarks();
		
		try {
			
			Code resultcode = cSvc.findById(id);
			cSvc.markCode(resultcode, marks);
			String markmsg ="Code was succesfully marked (" + marks + ")";
			model.addAttribute("marked", markmsg);

			
			
			
		} catch (Exception ex) {
			model.addAttribute("exception", ex);

		}
		return view(model);
	}

}
