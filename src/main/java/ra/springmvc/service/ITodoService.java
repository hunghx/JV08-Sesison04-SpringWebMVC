package ra.springmvc.service;

import ra.springmvc.model.Todo;

import java.util.List;

public interface ITodoService {
    // TODO: Implement methods for CRUD operations
    List<Todo> findAll();
    Todo findById(Integer id);
    void save(Todo todo); // chưc nang sua và them moi
    void deleteById(Integer id);
}
