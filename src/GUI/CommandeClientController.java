package GUI;

import Entities.Article;
import Entities.Commande;
import Entities.CommandeUtilisateur;
import Entities.LigneCommande;
import Entities.Utilisateur;
import Service.ServiceCommandeClient;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.util.converter.IntegerStringConverter;

public class CommandeClientController implements Initializable {

    @FXML
    private TextField txtNum;

    ServiceCommandeClient s ;

    final ObservableList<String> options = FXCollections.observableArrayList();
    final ObservableList<String> optionsArticle = FXCollections.observableArrayList();

    ObservableList<LigneCommande> oblist = FXCollections.observableArrayList();
    ObservableList<CommandeUtilisateur> obliste = FXCollections.observableArrayList();
    @FXML
    private TableView<LigneCommande> tableArticle;
    @FXML
    private TableColumn<LigneCommande, Integer> cellNum;
    @FXML
    private TableColumn<LigneCommande, String> cellReference;
    @FXML
    private TableColumn<LigneCommande, Integer> cellQuantite;
    @FXML
    private ComboBox<Article> comboRef;

    private static final String DATE_PATTERN = "dd/MM/yyyy";
    private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat(
            DATE_PATTERN);
    @FXML
    private DatePicker dateCommande;
    @FXML
    private DatePicker date;
    @FXML
    private TextField txtQte;
    @FXML
    private TextField typeCommande;
    @FXML
    private Button btnAjouter;
    @FXML
    private Button retour;
    @FXML
    private AnchorPane bck;
  
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       ServiceCommandeClient s= new ServiceCommandeClient();
        try {
            initRefArticle((ArrayList<Article>) s.readArticle());
        } catch (SQLException ex) {
        }
        
    }

    @FXML
    private void AjouterCommande(ActionEvent event) throws SQLException {

        {
            btnAjouter.setDisable(false);
            Utilisateur u = new Utilisateur();
            u.setId(1);

            Commande c = new  Commande(9,txtNum.getText(),Date.valueOf(dateCommande.getValue()),
                    typeCommande.getText(),Date.valueOf(date.getValue()));
            
            s.ajouterCommande(c);

//            for (LigneCommande LigneCommande : tableArticle.getItems()) {
//                Article A = new Article(LigneCommande.getRef_article());
//                LigneCommande lc = new LigneCommande(LigneCommande.getQte(), A, c);
//                s.ajouterLigneCommande(lc);
//
//            }

        }

    }
    

   private void initRefArticle(ArrayList<Article> data)
    {
        comboRef.getItems().addAll(data);
        comboRef.setCellFactory((ListView<Article> param) -> {
            return new ListCell<Article>(){
                @Override
                protected void updateItem(Article item, boolean empty) {
                    super.updateItem(item, empty);
                    if(item!=null)
                        setText(item.getRef());
                }
            };
        });
    }

    @FXML
    private void back(ActionEvent event) {
        
          Parent fxml;

        try {

            fxml = FXMLLoader.load(getClass().getResource("ListeArticles.fxml"));
            bck.getChildren().removeAll();
            bck.getChildren().setAll(fxml);

        } catch (IOException ex) {

            
            
            
        }
    }
   
   
   
   
    
   

   

}
