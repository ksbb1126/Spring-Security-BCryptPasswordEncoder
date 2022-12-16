package controller;

import dao.UserDao;
import domain.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
public class HomeController {

    @Autowired
    private UserDao userDao;

    @GetMapping(value = "/")
    public String main() {
        return "/";
    }

    @GetMapping(value = "/signUp")
    public String signUp() {
        return "signUp";
    }

    @PostMapping(value = "/signUp")
    public String doSignUp(@ModelAttribute UserDto userDto) throws SQLException {
        userDao.insert(userDto);
        return "redirect:/";
    }

    @PostMapping(value = "/login")
    public String login(@ModelAttribute UserDto userDto, HttpSession session) throws SQLException {
        String inputPassword = userDto.getPassword();
        String dbPassword = userDao.findPassword(userDto.getId());
        String message = null;
        if(dbPassword != null) {
            boolean result = userDao.isMatches(inputPassword, dbPassword);
            if(result) {
                session.setAttribute("id", userDto.getId());
                message = "로그인 성공";
            }else {
                message = "비밀번호가 일치하지 않습니다.";
            }
        }else {
            message = "존재하지 않는 사용자입니다.";
        }
        session.setAttribute("message", message);

        return "result";
    }

    @GetMapping(value = "/result")
    public String result() {
        return "result";
    }

}
