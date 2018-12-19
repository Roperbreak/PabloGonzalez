package es.gonzalez.AcademyBoxIt.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import es.gonzalez.AcademyBoxIt.model.Code;
import es.gonzalez.AcademyBoxIt.model.User;
import es.gonzalez.AcademyBoxIt.service.CodeSvc;
import es.gonzalez.AcademyBoxIt.service.UserSvc;

@SessionAttributes({ "sessionUser" })
@Controller
public class CodeController {

	@Autowired
	private CodeSvc cSvc;
	@InitBinder
	private void initBinder(WebDataBinder binder) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = "/newtask", method = RequestMethod.GET)
	public String task(@ModelAttribute Code code, Model model) {
		return "alumn/task";

	}

	@RequestMapping(value = "/newtask", method = RequestMethod.POST)
	public String task(@ModelAttribute("sessionUser") User user, @RequestParam String content, Model model) {
		Code code = new Code();
		try {

			code.setContent(content);

			cSvc.sendCode(code, user);

		} catch (Exception ex) {
			model.addAttribute("exception", ex);
		}

		return "home";

	}
}