/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Article;
import Service.ServiceCommandeClient;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ListeArticlesController implements Initializable {
                ObservableList<Article> data = FXCollections.observableArrayList();

    private Service.ServiceCommandeClient sc;
    @FXML
    private TableColumn<Article, String> ref;
    @FXML
    private TableColumn<Article, Integer> code;
    @FXML
    private TableColumn<Article, String> designation;
    @FXML
    private TableColumn<Article, Float> prix;
    @FXML
    private TableColumn<Article, Integer> seuilmax;
    @FXML
    private TableColumn<Article, Integer> seuilmin;
    @FXML
    private TableView<Article> tablearticle;
    
    @FXML
    private AnchorPane bck;
    @FXML
    private Button butadd;
    @FXML
    private Button btnges;
    @FXML
    private TextField txtRech;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sc = new ServiceCommandeClient();
        try {
            afficherArticle();
              txtRech.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                filterArticle((String)oldValue,(String) newValue);
            }

        });
      
                                    afficherArticle();

         
        } catch (SQLException ex) {
        }
        
    
    
        
    }    
    
     
    
    public void filterArticle(String oldValue, String newValue) {
             ObservableList<Article> filteredList2 = FXCollections.observableArrayList();
             

        if (txtRech == null || (newValue.length() < oldValue.length()) || newValue == null) {
            tablearticle.setItems(data);
        } else {
            newValue = newValue.toUpperCase();
            for (Article Article : tablearticle.getItems()) {
                String design = Article.getDesignation();

                if (design.toUpperCase().contains(newValue)) {
                    filteredList2.add(Article);
                }

            }
            tablearticle.setItems(filteredList2);
        }
        
        
    }

    


    
    private void afficherArticle() throws SQLException
    {
        
                ObservableList<Article> data = FXCollections.observableArrayList();

        ref.setCellValueFactory(new PropertyValueFactory<Article, String>("ref_article"));
        code.setCellValueFactory(new PropertyValueFactory<Article, Integer>("code"));
        prix.setCellValueFactory(new PropertyValueFactory<Article, Float>("prix"));
        designation.setCellValueFactory(new PropertyValueFactory<Article, String>("designation"));

        seuilmax.setCellValueFactory(new PropertyValueFactory<Article, Integer>("seuil_max"));
        seuilmin.setCellValueFactory(new PropertyValueFactory<Article, Integer>("seuil_min"));
        
        List <Article> L= sc.readArticle();
        
         for(int i=0 ;i<L.size();i++)
         {
             Article c = new Article(L.get(i).getRef(),L.get(i).getCode() , L.get(i).getDesignation(), L.get(i).getPrix()
                     , L.get(i).getSueil_min(), L.get(i).getSeuil_max());
             data.add(c);
             System.out.println(L.get(i).getRef());
         }
        
        
        tablearticle.setItems(data);
        
    }

    @FXML
    private void ajouterCommandeClient(ActionEvent event) {
         Parent fxml;

        try {

            fxml = FXMLLoader.load(getClass().getResource("CommandeClient.fxml"));
            bck.getChildren().removeAll();
            bck.getChildren().setAll(fxml);

        } catch (IOException ex) {

            
            
            
        }
    }

    @FXML
    private void gerercommandeclient(ActionEvent event) {
        
        
         Parent fxml;

        try {

            fxml = FXMLLoader.load(getClass().getResource("AfficheCommandeClient.fxml"));
            bck.getChildren().removeAll();
            bck.getChildren().setAll(fxml);

        } catch (IOException ex) {

            
            
            
        }
    }

      
//            
//                FilteredList<Article> filteredData = new FilteredList<>(data, b -> true);
//            txtRech.textProperty().addListener((observable, oldValue, newValue) -> {
//                filteredData.setPredicate(article -> {
//
//                    if (newValue == null || newValue.isEmpty()) {
//                        return true;
//                    }
//
//                    String lowerCaseFilter = newValue.toLowerCase();
//
//                    if (article.getDesignation().toLowerCase().indexOf(lowerCaseFilter) != -1) {
//                        return true; // Filter matches first name.
//                    }  else {
//                        return false; // Does not match.
//                    }
//                });
//            });
//
//            SortedList<Article> sortedData = new SortedList<>(filteredData);
//
//            sortedData.comparatorProperty().bind(tablearticle.comparatorProperty());
//
//            tablearticle.setItems(sortedData);
}
