package org.academiadecodigo.hackathon.allchildrenmatter.persistence.dao;

import org.academiadecodigo.hackathon.allchildrenmatter.persistence.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserDAO {

    @PersistenceContext
    private EntityManager em;

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public User findByUsername(String username) {
        return em.find(User.class, username);
    }

    public User saveOrUpdate(User user) {
        return em.merge(user);
    }



}
