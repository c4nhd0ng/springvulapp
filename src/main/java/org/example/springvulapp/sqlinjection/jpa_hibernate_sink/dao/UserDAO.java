package org.example.springvulapp.sqlinjection.jpa_hibernate_sink.dao;

import org.example.springvulapp.sqlinjection.jpa_hibernate_sink.model.User;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDAO {
    @Autowired
    EntityManager em;
    public List<User> findByUsernameJPQL(User user) {

        String jpql = "SELECT u FROM User u WHERE u.username = '" + user.getUsername() + "'";
        return em.createQuery(jpql, User.class)
                .getResultList();
    }
}
