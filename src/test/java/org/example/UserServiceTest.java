package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserServiceTest {
    UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService(15);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addUser() {
        User user1 = new User(1,"gosha",1991211);
        User user2 = new User(2,"gossa",1997211);

        userService.addUser(user1);
        userService.addUser(user2);

        User [] users = new User[15];
        users[0] = user1;
        users[1] = user2;

        Assertions.assertArrayEquals(users, userService.getUsers());

    }

    @Test
    void deleteById() {
        User user1 = new User(0,"Тестовый",1234567);
        User user2 = new User(1,"Testov",1234567);

        //userService.clean()[0]=user1;
        //userService.clean()[1]=user2;

        //Assertions.assertTrue(user1, userService.clean(0));
        //Assertions.assertFalse(user2, userService.clean(1));
        userService.clean();
       Assertions.assertNull(userService.getUsers()[0]);
       Assertions.assertNull(userService.getUsers()[1]);

    }

    @Test
    void countUser() {
        User user1 = new User(1,"lesha",198121);
        User user2 = new User(2,"roza",179722);
        User user3 = new User(3,"sofia",169723);
        User user4 = new User(4,"kirill",159724);
        User user5 = new User(5,"rodion",149725);

        userService.addUser(user1);
        userService.addUser(user2);
        userService.addUser(user3);
        userService.addUser(user4);
        userService.addUser(user5);

        User [] users = new User[15];
        users[0] = user1;
        users[1] = user2;
        users[2] = user3;
        users[3] = user4;
        users[4] = user5;

        Assertions.assertArrayEquals(users, userService.getUsers());
    }


    @Test
    void getUserId() {
        User user1 = new User(11,"gosha",1991211);
        User user2 = new User(22,"gossa",1997211);

        userService.getUsers()[0] = user1;
        userService.getUsers()[7] = user2;

        Assertions.assertEquals(user1,userService.getUserId(11));
        Assertions.assertEquals(user2,userService.getUserId(22));
        Assertions.assertNull(userService.getUserId(29));

    }

   @Test
    void getUserByIndex() {
        User user1 = new User(2,"gosha",1991211);
        User user2 = new User(3,"gossa",1997211);
        User user3 = new User(5,"rossa",1997211);
        User user4 = new User(7,"lesha",1997211);

        userService.getUsers()[0] = user1;
        userService.getUsers()[1] = user2;
        userService.getUsers()[2] = user3;
        userService.getUsers()[3] = user4;

        Assertions.assertEquals(user3,userService.getUserByIndex(2));
    }

    @ParameterizedTest
    @ValueSource(ints = {11,22,24,25})
    void checkUser(int id) {
        User user1 = new User(11,"gosha",1991211);
        User user2 = new User(22,"gossa",1997211);
        User user3 = new User(24,"rossa",1997211);
        User user4 = new User(25,"lesha",1997211);

        userService.getUsers()[0] = user1;
        userService.getUsers()[7] = user2;
        userService.getUsers()[2] = user3;
        userService.getUsers()[14] = user4;

        Assertions.assertTrue(userService.checkUser(id));
        Assertions.assertFalse(userService.checkUser(13));
    }
}