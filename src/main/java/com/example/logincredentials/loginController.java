package com.example.logincredentials;


import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;



@Controller
public class loginController {


    @GetMapping("/")
    public String home(Model model) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("John", 20,"BCA"));
        students.add(new Student("Jane", 21,"B-Com"));
        students.add(new Student("Boby", 19,"BBA"));

        model.addAttribute("students", students);

        return "home";
    }

    @GetMapping("/user")
    public  void userData(Model model,@RequestParam String data1 , @RequestParam String data2){

        System.out.println(data1+" "+data2);
        return;

    }

    @GetMapping("/login")
    public String showLoginForm(Model model, @RequestParam(required = false) String error) {
        if (error != null) {
            model.addAttribute("error", "Invalid username or password.");
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }
        else {
            return "redirect:/";
        }
    }


    @GetMapping("/logouts")
    public String handleLogoutRequest(HttpServletRequest request) {

        request.getSession().invalidate();
        return "redirect:/login?logout";
    }


}