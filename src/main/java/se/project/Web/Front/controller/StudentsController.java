package se.project.Web.Front.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import se.project.Web.Front.dto.StudentDto;
import se.project.Web.Front.service.StudentService;

import javax.validation.Valid;
import java.util.UUID;

@Controller
@RequestMapping("/student")
public class StudentsController {
    @Autowired
    private StudentService service;

    @GetMapping
    public String getStudents(Model model) {
        model.addAttribute("students", service.getStudent());
        return "students";
    }

    @GetMapping("/add")
    public String getStudentForm(StudentDto studentDto) {
        return "student-add";
    }

    @PostMapping("/add")
    public String addStudent(@Valid StudentDto studentDto, BindingResult result,
                          Model model) {
        if (result.hasErrors())
            return "student-add";

        service.addStudent(studentDto);
        return "redirect:/student";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable UUID id, Model model) {
        service.deleteStudent(id);
        return "redirect:/student";
    }

    @GetMapping("/update/{id}")
    public String getUpdateForm(@PathVariable UUID id, Model model, StudentDto studentDto) {
        model.addAttribute("studentDto",service.getStudentById(id));
        return "student-edit";
    }

    @PostMapping("/update/{id}")
    public String updateStudent(@Valid StudentDto studentDto,BindingResult result ,Model model) {
        service.updateStudent(studentDto);
        return "redirect:/student";
    }
}
