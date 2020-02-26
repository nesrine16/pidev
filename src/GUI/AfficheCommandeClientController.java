/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Commande;
import Entities.CommandeUtilisateur;
import Service.ServiceCommandeClient;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AfficheCommandeClientController implements Initializable {

    @FXML
    private TableView<CommandeUtilisateur> tableCommande;
    @FXML
    private TableColumn<CommandeUtilisateur, Integer> cellNum;
    
    @FXML
    private TableColumn<CommandeUtilisateur, String> cellRef;
    @FXML
    private TableColumn<CommandeUtilisateur, Integer> cellQte;
    @FXML
    private TableColumn<CommandeUtilisateur, java.sql.Date> cellDateC;
    @FXML
    private TableColumn<CommandeUtilisateur, Float> cellTotal;
     ObservableList<CommandeUtilisateur> obliste = FXCollections.observableArrayList();
    ServiceCommandeClient s = new ServiceCommandeClient();
    @FXML
    private TableColumn<CommandeUtilisateur, java.sql.Date> cellDateL;
    
    @FXML
    private TextField txtRecherche;
   
    @FXML
    private TableColumn<CommandeUtilisateur, String> cellType;

    @FXML
    private Button btnupdate;

    @FXML
    private Button btndelete;
    @FXML
    private Button back2;
    @FXML
    private AnchorPane bck;
     @FXML
    private void modifierCommande(ActionEvent event) {
         
        
    }
    
    @FXML
    void supprimerCommande(ActionEvent event) throws SQLException {
        CommandeUtilisateur u = tableCommande.getSelectionModel().getSelectedItem();
        if(u!=null)
        {
            s.DeleteCommande(u.getId_commande());
            afficherTableau();
        }
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            afficherTableau();
        } catch (SQLException ex) {
            Logger.getLogger(AfficheCommandeClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*setCellValueFromTableToTextField();
        txtRecherche.textProperty().addListener(new ChangeListener() {
           @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {

            }

        });*/

        // TODO
        /*setCellValueFromTableToTextField();
        txtRecherche.textProperty().addListener(new ChangeListener() {
           @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {

            }

        });*/

        // TODO
    }

public void afficherTableau() throws SQLException {
     obliste.clear();
      List<CommandeUtilisateur> lcf = s.afficherCommande();
      
      obliste.setAll(lcf);
      
       cellNum.setCellValueFactory(new PropertyValueFactory<>("num_commande"));
       cellRef.setCellValueFactory(new PropertyValueFactory<>("ref_article"));

      cellQte.setCellValueFactory(new PropertyValueFactory<>("qte"));


      cellDateC.setCellValueFactory(new PropertyValueFactory<>("date_commande"));


      cellTotal.setCellValueFactory(new PropertyValueFactory<>("montant"));
       cellDateL.setCellValueFactory(new PropertyValueFactory<>("date_livraison"));
       cellType.setCellValueFactory(new PropertyValueFactory<>("type"));

      tableCommande.setItems(obliste);
   }    
 
 /* public void setCellValueFromTableToTextField() {
        tableCommande.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                CommandeUtilisateur cm = tableCommande.getItems().get(tableCommande.getSelectionModel().getSelectedIndex());
                txtNum.setText(cm.getNum_commande());
                txtNum.setEditable(false);
                txtNum.setStyle("-fx-text-inner-color: grey;");
            txtRef.setText(cm.getRef_article());
                txtRef.setEditable(false);
                txtRef.setStyle("-fx-text-inner-color: grey;");

                txtDate.setText(String.valueOf(cm.getDate_commande()));
                 txtDateL.setText(String.valueOf(cm.getDate_livraison()));


              

                txttotal.setText(String.valueOf(cm.getMontant()));

                txtQte.setText(String.valueOf(cm.getQte()));
                txtQte.setEditable(false);
                txtQte.setStyle("-fx-text-inner-color: grey;");


            }
        });
    }*/

    @FXML
    private void retourr(ActionEvent event) {
         Parent fxml;

        try {

            fxml = FXMLLoader.load(getClass().getResource("ListeArticles.fxml"));
            bck.getChildren().removeAll();
            bck.getChildren().setAll(fxml);

        } catch (IOException ex) {

            
            
            
        }
    }

   /* @FXML
    private void cherchercommande(ActionEvent event) {
         CommandeUtilisateur u = tableCommande.getSelectionModel().getSelectedItem();
        if(u!=null)
        {
            s.;
            afficherTableau();
        }
        
        
    }*/

   
  
  
  
  
   
}    
            
