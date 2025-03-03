package org.example.springvulapp.csrf.spingboot_postmapping0csrf_token.controller;

import jakarta.servlet.http.HttpSession;
import org.example.springvulapp.csrf.spingboot_postmapping0csrf_token.dao.UserDAO;
import org.example.springvulapp.csrf.spingboot_postmapping0csrf_token.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@Controller
@RequestMapping("/csrf/")
public class UpdateEmail01Controller {
    @PostMapping("/updateemail01")
    public String updateEmail01(@RequestParam("newEmail") String newemail, Model model, HttpSession session) throws SQLException {
        User user = (User) session.getAttribute("user");
        UserDAO userDAO = new UserDAO();
        String message = userDAO.updateEmail(user, newemail);
        model.addAttribute("messageUpdateEmail", message);
        model.addAttribute("username", user.getUsername());
        return "dashboard";

    }
}
