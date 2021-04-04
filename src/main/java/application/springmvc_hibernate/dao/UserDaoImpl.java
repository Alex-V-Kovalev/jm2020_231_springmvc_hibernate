package application.springmvc_hibernate.dao;

import application.springmvc_hibernate.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    private final EntityManagerFactory entityManagerFactory;

    @Autowired
    public UserDaoImpl(LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {
        this.entityManagerFactory = entityManagerFactoryBean.getNativeEntityManagerFactory();
    }

    private void commitTransactionAndCloaseEntityManager(EntityManager entityManager) {
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private EntityManager getEntityManagerAndStartTransaction() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        return entityManager;
    }

    @Override
    public void create(User user) {
        EntityManager entityManager = getEntityManagerAndStartTransaction();
        entityManager.persist(user);
        commitTransactionAndCloaseEntityManager(entityManager);
    }

    @Override
    public void update(User user) {
        EntityManager entityManager = getEntityManagerAndStartTransaction();
        entityManager.merge(user);
        commitTransactionAndCloaseEntityManager(entityManager);
    }

    @Transactional
    @Override
    public void delete(User user) {
        EntityManager entityManager = getEntityManagerAndStartTransaction();
        entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
        commitTransactionAndCloaseEntityManager(entityManager);
    }

    @Override
    public List<User> getAllUsers() {
        EntityManager entityManager = getEntityManagerAndStartTransaction();
        List<User> result = entityManager.createQuery("from User order by id", User.class).getResultList();
        commitTransactionAndCloaseEntityManager(entityManager);
        return result;
    }

    @Override
    public User getUserById(long id) {
        EntityManager entityManager = getEntityManagerAndStartTransaction();
        User user = entityManager.find(User.class, id);
        commitTransactionAndCloaseEntityManager(entityManager);
        return user;
    }
}
