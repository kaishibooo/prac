package prac.security.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import prac.security.model.User;
import prac.security.service.UserService;
import prac.security.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

	@Autowired
	private UserService userService ;

	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto(){
		return new UserRegistrationDto();
	}

	@GetMapping
	public String showRegistrationFrom(Model model){
		return "registration" ;
	}

	@PostMapping
	public String registrationUserAccunt(@ModelAttribute("user") @Valid UserRegistrationDto userDto,
			BindingResult result){

		User existing = userService.findByEmail(userDto.getEmail());
		if(existing != null){
			result.rejectValue("email", null, "There is already an account registered with that email");
		}

		if(result.hasErrors()){
			return "registration" ;
		}

		userService.save(userDto);
		return "redirect:/registration?success" ;

	}

}
