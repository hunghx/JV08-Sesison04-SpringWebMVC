package ra.springmvc.repository;

import ra.springmvc.model.Todo;

import java.util.List;

public interface ITodoRepository {
    void addTodo(Todo todo);
    List<Todo> findAll();
    Todo findById(Integer id);
    void updateTodo(Todo todo);
    void deleteById(Integer id);
}
