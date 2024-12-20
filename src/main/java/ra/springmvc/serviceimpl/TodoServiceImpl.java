package ra.springmvc.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.springmvc.model.Todo;
import ra.springmvc.repository.ITodoRepository;
import ra.springmvc.service.ITodoService;

import java.util.Collections;
import java.util.List;
@Service
public class TodoServiceImpl  implements ITodoService {
    @Autowired
    private ITodoRepository todoRepository;
    @Override
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    @Override
    public Todo findById(Integer id) {
        // logic xử : up ảnh, gửi maill, biến dổi  dữ liệu
        return todoRepository.findById(id);
    }

    @Override
    public void save(Todo todo) {
        if(todo.getId() == null){
            // them moi
            todoRepository.addTodo(todo);
        }else {
            // cap nhật
            todoRepository.updateTodo(todo);
        }
    }

    @Override
    public void deleteById(Integer id) {
        todoRepository.deleteById(id);
    }
}
