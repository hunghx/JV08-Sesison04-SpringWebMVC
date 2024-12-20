package ra.springmvc.repositoryimpl;

import org.springframework.stereotype.Repository;
import ra.springmvc.model.Todo;
import ra.springmvc.repository.ITodoRepository;
import ra.springmvc.util.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository // thanhf phaanf keets noois toi csdl
public class TodoRepositoryImpl implements ITodoRepository {
    @Override
    public void addTodo(Todo todo) {

        // mở kết nối
        Connection conn = ConnectionDB.getConnection();
        // truy vấn csdl
        try {
            PreparedStatement stmt = conn.prepareStatement("insert into Todos(title, details) values (?,?)");
            stmt.setString(1, todo.getTitle());
            stmt.setString(2, todo.getDetails());
              stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            // đóng kết nối
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public List<Todo> findAll() {
        List<Todo> list= new ArrayList<>();
        // mở kết nối
        Connection conn = ConnectionDB.getConnection();
        // truy vấn csdl
        try {
            PreparedStatement stmt = conn.prepareStatement("select * from Todos");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                Todo todo = new Todo();
                todo.setId(rs.getInt("id"));
                todo.setTitle(rs.getString("title"));
                todo.setDetails(rs.getString("details"));
                todo.setStatus(rs.getBoolean("status"));
                list.add(todo);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            // đóng kết nối
            ConnectionDB.closeConnection(conn);
        }
        return list;
    }

    @Override
    public Todo findById(Integer id) {
        // mở kết nối
        Connection conn = ConnectionDB.getConnection();
        // truy vấn csdl
        try {
            PreparedStatement stmt = conn.prepareStatement("select * from Todos where id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                Todo todo = new Todo();
                todo.setId(rs.getInt("id"));
                todo.setTitle(rs.getString("title"));
                todo.setDetails(rs.getString("details"));
                todo.setStatus(rs.getBoolean("status"));
               return todo;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            // đóng kết nối
            ConnectionDB.closeConnection(conn);
        }
        return null;
    }

    @Override
    public void updateTodo(Todo todo) {
        Connection conn = ConnectionDB.getConnection();
        // truy vấn csdl
        try {
            PreparedStatement stmt = conn.prepareStatement("update Todos set title= ?, details= ? , status = ? where id = ?");
            stmt.setString(1, todo.getTitle());
            stmt.setString(2, todo.getDetails());
            stmt.setBoolean(3, todo.getStatus());
            stmt.setInt(4, todo.getId());
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            // đóng kết nối
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public void deleteById(Integer id) {
        Connection conn = ConnectionDB.getConnection();
        // truy vấn csdl
        try {
            PreparedStatement stmt = conn.prepareStatement("delete  from todos where  id = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            // đóng kết nối
            ConnectionDB.closeConnection(conn);
        }
    }
}
