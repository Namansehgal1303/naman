package profitloss;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import login.MysqlConnection;

public class plViewController {
WebEngine webEngine=null;
static String getPrice=null;
static int buyer;
static int seller;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private TextField ploss;
    @FXML
    private TextField txtsell;

    @FXML
    private TextField txtbuy;
    @FXML
    private Label name;

    @FXML
    private Label price;

    @FXML
    private Label quantity;

    @FXML
    private TextField stockname;

    @FXML
    private WebView webview;
    
    @FXML
    void BUY(ActionEvent event) {
    	int curr_price=Integer.parseInt(getPrice);
    	buyer=Integer.parseInt(txtbuy.getText());
   int   ans1=Math.abs(buyer-curr_price);
    	if(buyer>curr_price) {
    		ploss.setText("-"+ans1+"");
    	}
    	else
    	ploss.setText(ans1+"");
    }

    @FXML
    void enter(ActionEvent event) {
    	System.out.println("done");
    }
    @FXML
    void SELL(ActionEvent event) {
    	buyer=Integer.parseInt(txtbuy.getText());
    	seller=Integer.parseInt(txtsell.getText());
    	int ans2=Math.abs(buyer-seller);
    	if(seller>buyer) {
    	ploss.setText("+"+ans2+"");}
    	else {
    		ploss.setText("-"+ans2+"");
    	}
    }
    
    @FXML
    void go(ActionEvent event) {
    	String getter=stockname.getText();
    	webEngine.load("https://www1.nseindia.com/live_market/dynaContent/live_watch/equities_stock_watch.htm");
    	try {
    		con=MysqlConnection.getConnection();
    		java.sql.PreparedStatement pst;
    		pst=con.prepareStatement("select * from diary where name=?");
    		pst.setString(1,stockname.getText());
    		System.out.println(stockname.getText());
    		ResultSet rset=pst.executeQuery();
    		System.out.println(stockname.getText());
    		boolean count=false;
    		while(rset.next()) {
    			System.out.println("naman bc");
    			count=true;
    			String getname=rset.getString("name");
    			String getquantity=rset.getString("quantity");
    		    getPrice=rset.getString("price");
    			System.out.println("name: "+getname+" , quantity: "+getquantity+" , price:  "+getPrice);
    			name.setText(getname);
    			quantity.setText(getquantity);
    			price.setText(getPrice);
    			
    		}
    		
    	}catch(Exception e) {
			
		}
    }

   
    java.sql.Connection con;
    @FXML
    void initialize() {
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'plView.fxml'.";
        assert price != null : "fx:id=\"price\" was not injected: check your FXML file 'plView.fxml'.";
        assert quantity != null : "fx:id=\"quantity\" was not injected: check your FXML file 'plView.fxml'.";
        assert stockname != null : "fx:id=\"stockname\" was not injected: check your FXML file 'plView.fxml'.";
        assert webview != null : "fx:id=\"webview\" was not injected: check your FXML file 'plView.fxml'.";
        webEngine=webview.getEngine();
       

    }
}
