/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.AfficheCommandeClientController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class Test extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            //Parent root = new FXMLLoader().load(getClass().getResource("ListeArticles.fxml"));
           Parent root = new FXMLLoader().load(getClass().getResource("CommandeClient.fxml"));
                     // Parent root = new FXMLLoader().load(getClass().getResource("AfficheCommandeClient.fxml"));


            Scene scene = new Scene(root, 850, 580);

            primaryStage.setTitle("Smart Truck");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
//            Logger.getLogger(AfficheCommandeController.class.getName()).log(Level.SEVERE,null,ex);
            System.out.println(ex.getMessage());
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
