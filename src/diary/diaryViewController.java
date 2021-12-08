package diary;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import login.MysqlConnection;

public class diaryViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField stockname;

    @FXML
    private TextField stockquantity;

    @FXML
    private TextField stockprice;

    @FXML
    void doSubmit(ActionEvent event) {
    	System.out.println("hellooo");
    	try {
    		con=MysqlConnection.getConnection();
    		java.sql.PreparedStatement pst;
    		pst=con.prepareStatement("insert into diary values(?,?,?)");
    		pst.setString(1,stockname.getText());
    		pst.setString(2,stockquantity.getText());
    		pst.setString(3, stockprice.getText());
    		System.out.println("submitted!");
    		pst.executeUpdate();

    	}
    	catch(Exception e) {
    		
    	}
    }
    java.sql.Connection con;
    
    @FXML
    void initialize() {
        assert stockname != null : "fx:id=\"stockname\" was not injected: check your FXML file 'diaryView.fxml'.";
        assert stockquantity != null : "fx:id=\"stockquantity\" was not injected: check your FXML file 'diaryView.fxml'.";
        assert stockprice != null : "fx:id=\"stockprice\" was not injected: check your FXML file 'diaryView.fxml'.";

    }
}
