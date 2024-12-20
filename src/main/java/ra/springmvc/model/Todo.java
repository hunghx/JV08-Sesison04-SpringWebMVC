package ra.springmvc.model;

public class Todo {
    private Integer id;
    private String title;
    private String details;
    private Boolean status;

    public Todo() {
    }

    public Todo(Integer id, String title, String details, Boolean status) {
        this.id = id;
        this.title = title;
        this.details = details;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
