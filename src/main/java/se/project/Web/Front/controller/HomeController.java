package se.project.Web.Front.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import se.project.Web.Front.dto.SignupDto;
import se.project.Web.Front.service.StudentService;

@Controller
public class HomeController {

    @Autowired
    private StudentService service;
    @RequestMapping("/")
    public String getHomePage(Model model) {
        model.addAttribute("greeting", "Welcome");
        return "home";
    }

    @GetMapping("/check")
    public String getCheckPage(Model model) {
        return "check";
    }

    @PostMapping("/check")
    public String getResult(Model model, String studentId) {
        return "redirect:/check/id/"+studentId;
    }

    @GetMapping("/check/id/{studentId}")
    public String getStudentsByID(Model model, @PathVariable String studentId) {
        model.addAttribute("students", service.getScoreById(studentId));
        return "students-check";
    }
}
