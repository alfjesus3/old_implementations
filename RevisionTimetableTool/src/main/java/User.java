public class User {
    private String name, userName,password;

    public User(String name, String userName, String password){
        this.name = name;
        this.userName = userName;
        this.password = password;
    }

    public String getName(){
        return this.name;
    }

    public void setUserName(String userName1){
        this.userName = userName1;
    }

    public void setPassword(String pass1){
        this.password = pass1;
    }
}
