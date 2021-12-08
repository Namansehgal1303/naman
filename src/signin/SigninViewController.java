package signin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import login.MysqlConnection;

public class SigninViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField name;

    @FXML
    private TextField gender;

    @FXML
    private TextField pan;

    @FXML
    private TextField aad;


    @FXML
    private TextField mail;

    @FXML
    private TextField mob;

    @FXML
    void submit(ActionEvent event) {
    	try {
    		con=MysqlConnection.getConnection();
    		java.sql.PreparedStatement pst;
    		pst=con.prepareStatement("insert into signup values(?,?,?,?,?,?)");
    		pst.setString(1,name.getText());
    		pst.setString(2,gender.getText());
    		pst.setString(3,pan.getText());
    		pst.setString(4,aad.getText());
    		pst.setString(5,mail.getText());
    		pst.setString(6,mob.getText());
    		System.out.println("submitted!");
    		pst.executeUpdate();

    	}
    	catch(Exception e) {
    		
    	}
    }
    java.sql.Connection con;
    @FXML
    void initialize() {
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'SigninView.fxml'.";
        assert gender != null : "fx:id=\"gender\" was not injected: check your FXML file 'SigninView.fxml'.";
        assert pan != null : "fx:id=\"pan\" was not injected: check your FXML file 'SigninView.fxml'.";
        //assert dat != null : "fx:id=\"date\" was not injected: check your FXML file 'SigninView.fxml'.";
        assert mail != null : "fx:id=\"mail\" was not injected: check your FXML file 'SigninView.fxml'.";
        assert mob != null : "fx:id=\"mob\" was not injected: check your FXML file 'SigninView.fxml'.";

    }
}
