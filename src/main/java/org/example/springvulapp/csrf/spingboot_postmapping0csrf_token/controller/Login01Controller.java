package org.example.springvulapp.csrf.spingboot_postmapping0csrf_token.controller;

import jakarta.servlet.http.HttpSession;
import org.example.springvulapp.csrf.spingboot_postmapping0csrf_token.model.User;
import org.example.springvulapp.csrf.spingboot_postmapping0csrf_token.dao.UserDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller
@RequestMapping("/csrf/")
public class Login01Controller {

    @GetMapping("/login01")
    public String login01(Model model) {
        return "login";
    }
    @PostMapping("/login01")
    public String login01(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session) throws SQLException {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        UserDAO userDAO = new UserDAO();
        boolean check = userDAO.checkLogin(user);
        if (check) {
            session.setAttribute("user", user);
            model.addAttribute("message", "Đăng nhập thành công!");
            model.addAttribute("username", user.getUsername());
            return "dashboard";
        } else {
            model.addAttribute("message", "Sai username hoặc password!");
            return "login";
        }
    }
    @GetMapping("/logout01")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/csrf/login01";
    }
}
