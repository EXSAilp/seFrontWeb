package se.project.Web.Front.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import se.project.Web.Front.dto.SignupDto;
import se.project.Web.Front.service.UserService;

import javax.validation.Valid;

@Controller
public class SignupController {
    @Autowired
    private UserService signupService;

    @GetMapping("/signup")
    public String getSignupPage(SignupDto user) {
        return "signup";
    }

    @PostMapping("/signup")
    public String signupUser(@Valid SignupDto user, BindingResult result, Model model) {
        if(result.hasErrors())
            return "signup";
        if (signupService.isUsernameAvailable(user.getUsername())) {
            signupService.createUser(user);
            model.addAttribute("signupSuccess", true);
        } else {
            model.addAttribute("signupError", "Username not available");
        }
        model.addAttribute("signupDto", new SignupDto());
        return "signup";
    }
}
