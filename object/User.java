package mainentry.object;

/**
 * @author Seeker
 * @date 2018/1/30
 */
public class User {
    private String userName;
    private String userPasswordSalted;
    private int userPermission;
    private int userGender;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPasswordSalted() {
        return userPasswordSalted;
    }

    public void setUserPasswordSalted(String userPasswordSalted) {
        this.userPasswordSalted = userPasswordSalted;
    }

    public int getUserPermission() {
        return userPermission;
    }

    public void setUserPermission(int userPermission) {
        this.userPermission = userPermission;
    }

    public int getUserGender() {
        return userGender;
    }

    public void setUserGender(int userGender) {
        this.userGender = userGender;
    }
}
