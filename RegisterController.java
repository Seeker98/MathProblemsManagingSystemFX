package mainentry;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.*;

import static mainentry.MySqlDatabaseConstants.*;

/**
 * @author  Seeker
 * @date 2018/1/26
 * Logics for user registration.
 */
public class RegisterController {
    @FXML
    public Label registerFlagSuggestion;
    public TextField userNameAsWish;
    public PasswordField userPasswordAsWish;
    public Button clickToCheckAndRegister;
    public CheckBox isMale;
    public CheckBox isFemale;
    public CheckBox analysis;
    public CheckBox algebra;
    public CheckBox geometry;
    /**
     * user name and password can only contain:
     * Numbers
     * Alphabet letters
     * Underlines
     *
     * @param string
     * user name / Password
     */
    private boolean checkUserNameValidity(String string){
        return string.matches("[\\w]{2,16}$");
    }
    private boolean checkPasswordValidity(String string){
        return string.matches("[\\w]{8,16}$");
    }
    /**
     * Only one of the boxes can be selected.
     * None or both will be rejected.
     * Using exclusive or
     */
    private boolean checkGenderValidity(boolean b1, boolean b2){
        return b1^b2;
    }
    /**
     * boolean registerAllowedFlag consists of:
     * Password format is correct
     * user name format is correct
     * Only one in Male/Female is selected
     * Speciality is allowed to leave blank.
     *
     * The SQL query command: String sql, consists of the following parts:
     * user's name @line 2 of String sql
     * user's password (salted with BCrypt) @line 3 of String sql
     * user's permission (default Visitor, shown as 1) @line 4 of String sql
     * user's gender @line 5 of String sql
     * user's speciality @line 6 of String sql
     * user's attempt and solved count (default 0,0) @line 7 of String sql
     */
    public void clickToCheckAndRegister(ActionEvent actionEvent){
        boolean registerAllowedFlag=
                checkPasswordValidity(userPasswordAsWish.getText())
                &&checkUserNameValidity(userNameAsWish.getText())
                &&checkGenderValidity(isMale.isSelected(),isFemale.isSelected());
        if(registerAllowedFlag){
            String gender=isMale.isSelected()?"Male":"Female";
            String saltedPassword=BCrypt.hashpw(userPasswordAsWish.getText(),
                    BCrypt.gensalt());
            String speciality=(analysis.isSelected()?"1":"")
                    +(algebra.isSelected()?"2":"")
                    +(geometry.isSelected()?"3":"");
            String userNameSearch="SELECT * FROM `math_problem_users`"
                    +"WHERE userName='"
                    +userNameAsWish.getText()+"'";
            String addNewUser="INSERT INTO `math_problem_users` VALUES ( '"
                    +userNameAsWish.getText()+"', '"
                    +saltedPassword+"', '"
                    +"1"+"', '"
                    +gender+"', '"
                    +speciality+"', '"
                    +"0"+"', '"+"0"+"');";
            DatabaseUtility databaseUtility=DatabaseUtility.getDatabaseUtility();
            try {
                if (!databaseUtility.doQuery(userNameSearch).next()) {
                    databaseUtility.doUpdate(addNewUser);
                } else {
                    registerFlagSuggestion.setText("An error occured.\n"
                            + "Maybe another user name?");
                    return;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            databaseUtility.close();
            /*Connection connection=null;
            Statement statement=null;
            try {
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DB_URL,
                        USER,
                        PASSWORD);
                statement = connection.createStatement();
                if(!statement.executeQuery(userNameSearch).next()){
                    statement.executeUpdate(addNewUser);
                } else {
                    registerFlagSuggestion.setText("An error occured.\n"
                            +"Maybe another user name?");
                    return;
                }
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            } finally {
                try{
                    if(statement!=null){
                        statement.close();
                    }
                } catch (SQLException | NullPointerException ex) {
                    ex.printStackTrace();
                }
            }*/
            registerFlagSuggestion.setText("Successfully registered!\n"
                    +"You are now a \'Visitor\'!");
        } else {
            registerFlagSuggestion.setText("Unsuccessful attempt.\n"
                    +"Invalid username/password?\n"
                    +"Or ticked both/none of the genders?");
        }
    }
}
