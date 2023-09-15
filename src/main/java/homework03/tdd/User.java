package homework03.tdd;

public class User {

    String name;
    String password;

    boolean isAuthenticate = false;

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;


    }

    public User(String name, String password) {
        this.name= name;
        this.password=  password;
    }

    //3.6.
    public boolean authentication(String userName, String userPassword) {
        if (name.equals(userName) && password.equals(userPassword)) {
            return isAuthenticate=true;
        } else {
            return isAuthenticate=false;
        }
    }



}