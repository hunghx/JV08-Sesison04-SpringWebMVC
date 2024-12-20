package ra.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    // edit
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        Todo todoEdit = todoService.findById(id);
        if(todoEdit != null){
            model.addAttribute("todo", todoEdit);
            return "edit-todo";
        }else {
            throw new RuntimeException("Id not found");
        }
    }
    @PostMapping("/update")
    public String editSubmit(@ModelAttribute Todo todo){ // annh xạ 1 đối tượng
        todoService.save(todo);
        return "redirect:/todo/list";
    }
    // sửa và xoa

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        todoService.deleteById(id);
        return "redirect:/todo/list";
    }
}
