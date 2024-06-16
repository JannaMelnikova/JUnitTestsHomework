package org.example;

public class UserService {
    private User [] users;



    public UserService(int size) {
        this.users = new User[size];
    }

    public User[] getUsers() {
        return users;
    }

    /**
     * @param user
     * @return boolean
     */
    public boolean addUser (User  user) {
        for (int i = 0; i < users.length; i++) {
            if (users[i]==null) {
                users[i]=user;
                return true;
            }
        }
        return false;
    }

    public void clean () {
        for (int i = 0; i <users.length; i++) {
            if (users[i]!=null){
                users[i]=null;
            }
        }

    }
 public int countUser() {
        int count=0;
     for (int i = 0; i <users.length; i++) {
         if (users[i]!=null) {
             count++;
         }
     }
     return count;
 }

 public User getUserId (int id) {
     for (int i = 0; i <users.length; i++) {
         if (users[i]!=null && users[i].getId() == id) {
            return users[i];
         }
     }
     return null;
 }

 public User getUserByIndex (int index) {
        return users[index];
 }

 public boolean checkUser(int id) {
     for (int i = 0; i <users.length; i++) {
         if (users[i]!=null && users[i].getId() == id) {
             return true;
         }
     }
     return false;
 }

 }



