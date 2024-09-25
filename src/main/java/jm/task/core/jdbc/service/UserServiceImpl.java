package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDao userDaoHibernate = new UserDaoHibernateImpl();
    public void createUsersTable() {
        userDaoHibernate.createUsersTable();
    }

    public void dropUsersTable() {
        userDaoHibernate.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            userDaoHibernate.saveUser(name, lastName, age);
            System.out.println("User с именем – " + name + " добавлен в базу данных");
        } catch (Exception e) {
        }
    }

    public void removeUserById(long id) {
        try {
            userDaoHibernate.removeUserById(id);
            System.out.println("User с ID — " + id + " удален из базы данных");
        } catch (Exception e) {
        }
    }

    public List<User> getAllUsers() {
        return userDaoHibernate.getAllUsers();
    }

    public void cleanUsersTable() {
        userDaoHibernate.cleanUsersTable();

    }
}
