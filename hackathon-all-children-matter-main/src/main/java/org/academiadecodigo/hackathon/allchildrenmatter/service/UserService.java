package org.academiadecodigo.hackathon.allchildrenmatter.service;

import org.academiadecodigo.hackathon.allchildrenmatter.UserDTO;
import org.academiadecodigo.hackathon.allchildrenmatter.persistence.User;
import org.academiadecodigo.hackathon.allchildrenmatter.persistence.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private UserDAO userDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User get(String username) {
        return userDAO.findByUsername(username);
    }

    @Transactional
    public User save(User user) {
        return userDAO.saveOrUpdate(user);
    }

    @Transactional
    public boolean authenticateUser(UserDTO userDTO) {
        if(get(userDTO.getUsername()) != null) {
            if (userDTO.getPassword().equals(get(userDTO.getUsername()).getPassword())) {
                return true;

            }
            return false;
        }
        return true;

    }


}
