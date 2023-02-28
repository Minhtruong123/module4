package com.example.service;

import com.example.model.Login;
import com.example.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService{
    private static List<User> users;
    static {
        users = new ArrayList<>();
        User user1 = new User();
        user1.setAge(20);
        user1.setAccount("truong");
        user1.setName("Truong");
        user1.setEmail("duongminhtruong1234@gmail.com");
        user1.setPassword("123456");
        users.add(user1);

        User user2 = new User();
        user1.setAge(20);
        user1.setAccount("trang");
        user1.setName("Trang");
        user1.setEmail("nvpTrang@gmail.com");
        user1.setPassword("123456");
        users.add(user2);
    }
    @Override
    public User checkLogin(Login login) {
        for (User u:users){
            if (u.getAccount().equals(login.getAccount()) && u.getPassword().equals(login.getPassword())){
                return u;
            }
        }
        return null;
    }
}
