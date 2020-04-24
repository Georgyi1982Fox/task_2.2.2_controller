package web.dao;

import org.hibernate.Session;
import web.dao.UserDAO;
import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.SessionFactory;
import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;
@Repository
public class UserHibernateDAO implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> listAllUsers() throws SQLException {
        List<User> listUser = (List<User>) sessionFactory.getCurrentSession().createQuery("SELECT u FROM User u").list();
        return listUser;
    }

    @Override
    public void addUser(User user) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Override
    public void updateUser(User user) throws SQLException {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void deleteUser(Long id) throws SQLException {
        User deleteUser = (User)sessionFactory.getCurrentSession().createQuery("  select u FROM  User u WHERE u.id=:id")
        .setParameter("id",id)
                .uniqueResult();
        sessionFactory.getCurrentSession().delete(deleteUser);
    }

    @Override
    public User getUserById(Long id) throws SQLException {
        User user = (User)sessionFactory.getCurrentSession().createQuery("Select u From User u where u.id=:id")
                .setParameter("id",id)
                .uniqueResult();
        User userGetById = new User(user.getId(), user.getName(),user.getEmail());
        return userGetById;
    }

    @Override
    public boolean validate(String name, String password) {
        User user = (User) sessionFactory.getCurrentSession().createQuery("SELECT u FROM User u  WHERE u.name=:name")
                .setParameter("name", name)
                .setParameter("password",password)
                .uniqueResult();
        if (user != null) {
            return true;
        } else
            return false;
    }
}


















