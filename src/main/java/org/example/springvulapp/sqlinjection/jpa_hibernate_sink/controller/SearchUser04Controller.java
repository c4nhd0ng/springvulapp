package org.example.springvulapp.sqlinjection.jpa_hibernate_sink.controller;

import org.example.springvulapp.sqlinjection.jpa_hibernate_sink.dao.UserDAO;
import org.example.springvulapp.sqlinjection.jpa_hibernate_sink.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/SQLi")
public class SearchUser04Controller {
    @GetMapping("/search04")
    public String searchPage(Model model) {
        // Truyền đối tượng rỗng vào để người dùng có thể nhập tên
        model.addAttribute("userSearch", new User());
        model.addAttribute("searchPath", "search01");
        return "search";
    }

    @PostMapping("/search04")
    public String findByName(@ModelAttribute("userSearch") User user, Model model) {
        UserDAO userDAO = new UserDAO();
        List<User> users = userDAO.findByUsernameJPQL(user);
        model.addAttribute("users", users);
        model.addAttribute("searchPath", "search02");
        return "search";

    }
}
