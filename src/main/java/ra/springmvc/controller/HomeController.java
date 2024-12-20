package ra.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // đây là thanh phần controller : là 1 bean
public class HomeController {
    // 1 phương thức trả về trang home
    @RequestMapping // khơp vs localhost 8080
    public String home(){
        return "home";
    }
}
