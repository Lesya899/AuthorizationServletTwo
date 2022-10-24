

//создаем класс Профиль пользователя

public class UserProfile {
    private String user;
    private String password;

    public UserProfile(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}

