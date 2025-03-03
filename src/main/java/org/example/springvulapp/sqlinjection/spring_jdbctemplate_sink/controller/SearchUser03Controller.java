package org.example.springvulapp.sqlinjection.spring_jdbctemplate_sink.controller;



import org.example.springvulapp.sqlinjection.jdbc_statement_sink.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/SQLi")
public class SearchUser03Controller {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @GetMapping("/search03")
    public String searchPage(Model model) {
        // Truyền đối tượng rỗng vào để người dùng có thể nhập tên
        model.addAttribute("userSearch", new User());
        model.addAttribute("searchPath", "search03");
        return "search";
    }
    @PostMapping("/search03")
    public String findByName(@ModelAttribute("userSearch") User user, Model model) {
        String sql = "SELECT * FROM users WHERE username = '" + user.getUsername() + "'";
        List<Map<String, Object>> users = jdbcTemplate.queryForList(sql);

        // Trả về kết quả tìm kiếm vào view
        model.addAttribute("users", users);
        model.addAttribute("searchPath", "search03");
        return "search";

    }
}