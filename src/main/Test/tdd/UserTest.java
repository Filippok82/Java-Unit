package tdd;

import homework03.tdd.User;
import homework03.tdd.UserRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    

    @Test
    void userCreation(){
        User user = new User("name", "qwerty");

        assertTrue(user.authentication("name", "qwerty"));
    }

    @Test
    void userCreationFailName(){
        User user = new User("name", "qwerty");

        assertFalse(user.authentication("login", "qwerty"));
    }
    @Test
    void userCreationFailPassword(){
        User user = new User("name", "qwerty");

        assertFalse(user.authentication("name", "12345"));
    }
    @Test
    void userCreationFailAll(){
        User user = new User("name", "qwerty");


        assertFalse(user.authentication("54321", "12345"));
    }


    @Test
    void userAddRepository(){
        User user = new User("name", "qwerty");
        user.authentication("name", "qwerty");
        UserRepository userAdd = new UserRepository();
        userAdd.addUser(user);


        assertTrue(userAdd.findByName("name"));
    }
    @Test
    void userAddRepositoryFalse(){
        User user = new User("name", "qwerty");
        user.authentication("12345", "qwerty");
        UserRepository userAdd = new UserRepository();
        userAdd.addUser(user);


        assertFalse(userAdd.findByName("12345"));
    }
}
