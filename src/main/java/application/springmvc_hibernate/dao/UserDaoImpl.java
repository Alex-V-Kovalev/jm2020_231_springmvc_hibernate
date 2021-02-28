package application.springmvc_hibernate.dao;

import application.springmvc_hibernate.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserDaoImpl implements UserDao {
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private static Map<Long, User> users = new HashMap<>();

    static {
        User user;
        user = new User((long) AUTO_ID.getAndIncrement(), "Ivan", "Petrov", 27);
        users.put(user.getId(), user);
        user = new User((long) AUTO_ID.getAndIncrement(), "Stepan", "Sidorov", 29);
        users.put(user.getId(), user);
        user = new User((long) AUTO_ID.getAndIncrement(), "Саша", "Иванов", 30);
        users.put(user.getId(), user);
        user = new User((long) AUTO_ID.getAndIncrement(), "Вася", "Филимонов", 45);
        users.put(user.getId(), user);
        user = new User((long) AUTO_ID.getAndIncrement(), "John", "McClane", 34);
        users.put(user.getId(), user);
        user = new User((long) AUTO_ID.getAndIncrement(), "Федя", "Степанов", 22);
        users.put(user.getId(), user);
        user = new User((long) AUTO_ID.getAndIncrement(), "Улукбек", "Закиров", 64);
        users.put(user.getId(), user);
    }

    @Override
    public void create(User user) {
        user.setId((long) AUTO_ID.getAndIncrement());
        update(user);
    }

    @Override
    public void update(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public void delete(User user) {
        users.remove(user.getId());
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    @Override
    public User getUserById(long id) {
        return users.get(id);
    }
}
