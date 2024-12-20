package ra.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ra.springmvc.model.Todo;
import ra.springmvc.service.ITodoService;

import java.util.List;

@Controller
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    private ITodoService todoService;
    @GetMapping("/list") // mặc định là method do get
    public String list(Model model) {
        List<Todo> list = todoService.findAll();
        model.addAttribute("todos",list);
        return "list";
    }

    @GetMapping("/add")
    public String add(){
        return "add-todo";
    }

    @PostMapping("/add")
    public String addSubmit(@RequestParam("title") String title, @RequestParam("details") String details){
        // nhâ thông tin từ form
        Todo todo = new Todo();
        todo.setTitle(title);
        todo.setDetails(details);
        todoService.save(todo);
        // sendredirect
        return "redirect:/todo/list"; // chuyển tới đường dẫn /todo/list
    }

    // sửa và xoa
}
