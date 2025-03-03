package org.example.springvulapp.sqlinjection.jdbc_preparedstatement_sink.controller;

import org.example.springvulapp.sqlinjection.jdbc_preparedstatement_sink.dao.UserDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.example.springvulapp.sqlinjection.jdbc_preparedstatement_sink.model.*;

import java.sql.SQLException;
import java.util.List;


@Controller
@RequestMapping("/SQLi")
public class SearchUser02Controller {
    @GetMapping("/search02")
    public String searchPage(Model model) {
        // Truyền đối tượng rỗng vào để người dùng có thể nhập tên
        model.addAttribute("userSearch", new User());
        model.addAttribute("searchPath", "search02");
        return "search";
    }
    @PostMapping("/search02")
    public String findByName(@ModelAttribute("userSearch") User user, Model model) throws SQLException {
        // Truyền đối tượng rỗng vào để người dùng có thể nhập tên
        model.addAttribute("userSearch", new User());
        // Tìm kiếm người dùng theo tên an toàn
        UserDAO userDAO = new UserDAO();
        List<User> users = userDAO.findByUsername(user);
        // Trả về kết quả tìm kiếm vào view
        model.addAttribute("users", users);
        model.addAttribute("searchPath", "search02");
        return "search";
    }
}
