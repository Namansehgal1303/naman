package login;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField id;

    @FXML
    private TextField pass;

    @FXML
    void dosignup(MouseEvent event) throws IOException {
    	
    	
    }
    @FXML
    void enter(ActionEvent event) throws IOException {
    	javafx.scene.Parent root=FXMLLoader.load(getClass().getResource("/profitloss/plView.fxml")); 
		//OR
		//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("marks/card/MarksCard.fxml")); 
		javafx.scene.Scene scene = new javafx.scene.Scene(root);
		javafx.stage.Stage stage=new javafx.stage.Stage();
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void dosubmit(ActionEvent event) {
    	try {
    		con=MysqlConnection.getConnection();
    		java.sql.PreparedStatement pst;
    		pst=con.prepareStatement("insert into login values(?,?)");
    		pst.setString(1,id.getText());
    		pst.setString(2,pass.getText());
    		System.out.println("submitted!");
    		pst.executeUpdate();

    	}
    	catch(Exception e) {
    		
    	}

    }
    java.sql.Connection con;
    
    

    @FXML
    void initialize() {
        assert id != null : "fx:id=\"id\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert pass != null : "fx:id=\"pass\" was not injected: check your FXML file 'LoginView.fxml'.";
        con=MysqlConnection.getConnection();
    }
}
