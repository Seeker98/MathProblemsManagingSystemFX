package mainentry.object;

/**
 * @author Seeker
 * @date 2018/1/30
 */
public class Administrator extends User {
    private static final int userPermission = 3;
    @Override
    public int getUserPermission() {
        return Administrator.userPermission;
    }
}
