package mainentry;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

/**
 * @author  Seeker
 * @date 2018/1/26
 */
public class LoginController {
    @FXML
    public Label loginMessage;
    public TextField userNameTextField;
    public PasswordField userPasswordTextField;
    public Button userLogin;
    public Button userRegister;
    public void clickToLogin(ActionEvent actionEvent){
        String fetchPasswordSalted="SELECT * FROM "
                +"`math_problem_users` WHERE userName='"
                +userNameTextField.getText()+"'";
        DatabaseUtility databaseUtility = DatabaseUtility.getDatabaseUtility();
        ResultSet resultSet=null;
        String saltedPassword=null;
        try {
            resultSet = databaseUtility.doQuery(fetchPasswordSalted);
            if(resultSet.next()) {
                saltedPassword=resultSet
                        .getString("userPasswordSalted");
            } else {
                loginMessage.setText("Unknown error. Or...\n"
                        + "wanna register first?");
                return;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        /*Connection connection=null;
        Statement statement=null;
        String saltedPassword=null;
        ResultSet resultSet;
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,
                    USER,
                    PASSWORD_SALTED);
            statement = connection.createStatement();
            resultSet=statement.executeQuery(fetchPasswordSalted);
           if(resultSet.next()) {
               saltedPassword=resultSet
                       .getString("userPasswordSalted");
           } else {
               loginMessage.setText("Unknown error. Or...\n"
                       + "wanna register first?");
               return;
           }
        }
        catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        } finally {
            try{
                if(statement!=null){
                    statement.close();
                }
            } catch (SQLException | NullPointerException ex) {
                ex.printStackTrace();
            }
        }*/
        boolean passwordCorrect = BCrypt.checkpw(
                userPasswordTextField.getText(),
                saltedPassword);
        if(passwordCorrect) {
            loginMessage.setTextFill((Color.color(0,0,0)));
            loginMessage.setText("Welcome, "
                    +userNameTextField.getText()
                    +"!");
            //open something new
        } else {
            loginMessage.setTextFill(Color.color(1,0.2,0.1));
            loginMessage.setText("Wrong password!");
        }
    }

    public void clickToRegister(ActionEvent actionEvent) {
        Stage primaryStage=new Stage();
        FXMLLoader fxmlLoader=new FXMLLoader();
        Pane root=null;
        try {
            root = fxmlLoader.load(getClass().getResource("RegisterController.fxml").openStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Scene scene=new Scene(root);
        primaryStage.setTitle("Registration");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
