package application.springmvc_hibernate.service;

import application.springmvc_hibernate.dao.UserDao;
import application.springmvc_hibernate.dao.UserDaoImpl;
import application.springmvc_hibernate.model.User;

import java.util.List;

public class UserServiceImpl implements UserService{
    private UserDao userDao = new UserDaoImpl();

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }
}
