package application.springmvc_hibernate.service;

import application.springmvc_hibernate.model.User;

import java.util.List;

public interface UserService {
    void create(User user);

    void update(User user);

    void delete(User user);

    List<User> getAllUsers();

    User getUserById(long id);
}
