package org.academiadecodigo.hackathon.allchildrenmatter;

import org.academiadecodigo.hackathon.allchildrenmatter.persistence.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDTO implements Converter<User, UserDTO> {

    @Override
    public UserDTO convert(User user) {

        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());

        return userDTO;
    }
}
