package application;
import java.io.File;

import java.io.FileNotFoundException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.NoSuchPaddingException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main {

	public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, FileNotFoundException, InvalidKeySpecException {
		
	
      File plaintext = new File("plain.txt");
      File encrypted = new File("decrypted.txt");
      File decrypted = new File("encrypted.txt");


		
      String modeOperator = "ECB";
      String key = "12345678";

      DESAlgorithm encrypt = DESEncrypt.getInstance(
    	  plaintext,
          encrypted,
          key,
          modeOperator
        );
      try {
          encrypt.encrypt();
          System.out.println("Encryption completed ");
      }catch(Exception e ) {
        System.out.println("Error in main method:  "  + e.getMessage());

      }
      		
      
      DESAlgorithm decrypt = DESDecrypt.getInstance(
    		  encrypted,
              decrypted,
              key,
              modeOperator
            );
      	
      try {
          decrypt.decrypt();
          System.out.println("Decryption completed ");
      }catch(Exception e ) {
        System.out.println("Error in main method:  "  + e.getMessage());

      }
	}	
}