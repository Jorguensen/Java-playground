package org.academiadecodigo.hackathon.allchildrenmatter;

import org.academiadecodigo.hackathon.allchildrenmatter.persistence.User;
import org.academiadecodigo.hackathon.allchildrenmatter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDTOToUser implements Converter<UserDTO,User> {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User convert(UserDTO userDTO) {
        if (userService.get(userDTO.getUsername()) != null) {
            return userService.get(userDTO.getUsername());
        }
        User user = new User();

        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setLastPage("redirect:/string");

        return user;
    }
}
