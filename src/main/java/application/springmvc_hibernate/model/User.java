package application.springmvc_hibernate.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "users")
public class User {
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
