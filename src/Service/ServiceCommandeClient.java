/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

/**
 *
 * @author user
 */
import Entities.Article;
import Entities.Commande;
import Entities.CommandeUtilisateur;
import Entities.LigneCommande;
import Utils.DataBase;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aa
 */
public class ServiceCommandeClient {

    private Connection con;
    private Statement ste;

    public ServiceCommandeClient() {
        con = DataBase.getInstance().getConnection();

    }

    public void ajouterCommande(Commande c) throws SQLException {
//
//        String requeteInsert = "INSERT INTO `Commande` (`num_commande`, `date_commande`, `montant`, `type`, `date_livraison`,id) VALUES (?,?,?,?,?,?);";
//         PreparedStatement statement;
//        try {
//            statement = con.prepareStatement(requeteInsert);
//
//            statement.setString(1,c.getNum_commande());
//            statement.setDate(2, (Date) c.getDate_commande());
//            statement.setFloat(3, c.getMontant());
//            statement.setString(4, c.getType());
//            statement.setDate(5, (Date) c.getDate_livraison());
//            statement.setInt(6, c.getU().getId());
//            
//            System.out.println("modification valider");
//            int rowsUpdated = statement.executeUpdate();
//        } catch (SQLException ex) {
//            System.out.println("echec");
//
//        }

        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `commande` (`id_commande`,`num_commande`,`date_commande`,`type`,`date_livraison`) VALUES ( '" + c.getId_commande()+ "','" + c.getNum_commande() + "', '" + c.getDate_commande()
                +  "', '" + c.getType() + "', '"  + c.getDate_livraison() + "');";
        ste.executeUpdate(requeteInsert);

    }

    public String last_num() throws SQLException {
        String nom = "";
        ste = con.createStatement();
        String req = "  SELECT num_commande from Commande ORDER BY num_commande LIMIT 1";
        PreparedStatement ps = con.prepareStatement(req);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            nom = rs.getString("num_commande");
        }
        return nom;

    }

    public void ajouterLigneCommande(LigneCommande lc) throws SQLException {
        ste = con.createStatement();
        String requete = "INSERT INTO `SmartTruck`.`LigneCommande` (`qte`, `ref_article`, `id_commande`) VALUES ('" + lc.getQte() + "', '" + lc.getArticle().getRef() + "', '" + lc.getCmd().getId_commande() + "');";
        ste.executeUpdate(requete);
    }

    public void modifierCommande(Date date, float total, String num, Date date1) throws SQLException {
        ste = con.createStatement();

        String req = "UPDATE Commande " + "SET date_commande='" + date + "',montant='" + total + "' ,date_livraison='" + date1 + "'" + "WHERE num_commande='" + num + "'";

        ste.executeUpdate(req);

    }

    public void DeleteCommande(int id) throws SQLException {
        ste = con.createStatement();
        String req = "DELETE FROM LigneCommande WHERE id_commande='" + id + "'";

        ste.executeUpdate(req);
    }

    public String getDesignation(String ref) throws SQLException {
        String nom = "";
        ste = con.createStatement();
        String req = "select designation from Article where Article.ref_article='" + ref + "'";

        ResultSet rs = ste.executeQuery(req);
        while (rs.next()) {
            nom = rs.getString("designation");
        }

        return nom;

    }

    public List<CommandeUtilisateur> afficherCommande() throws SQLException {
        List<CommandeUtilisateur> cf = new ArrayList<>();

        ste = con.createStatement();
        String requete = " SELECT * from commande c inner join lignecommande l on"
                + " l.id_commande=c.id_commande inner join article a on a.ref_article=l.ref_article group by c.id_commande ";

        ResultSet rs = ste.executeQuery(requete);
        while (rs.next()) {
            try {
                Integer id_commande = rs.getInt("id_commande");

                String num_commande = rs.getString("num_commande");
                String ref_article = rs.getString("ref_article");
                int qte = rs.getInt("qte");
                String type = rs.getString("type");

                String date_commande = rs.getString("date_commande");
                java.util.Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date_commande);
                java.sql.Date sqlDate = new java.sql.Date(date1.getTime());

                float montant = rs.getFloat("montant");

                String date_livraison = rs.getString("date_livraison");
                java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(date_livraison);
                java.sql.Date sqlDate1 = new java.sql.Date(date.getTime());

                CommandeUtilisateur c = new CommandeUtilisateur(id_commande, num_commande, ref_article, type, qte, date1, date, montant);
                cf.add(c);
            } catch (ParseException ex) {
            }
        }
        return cf;
    }

    /*public ArrayList<Article> getAllArticles( ) throws SQLException
    {       
       
        ArrayList<Article> articles = new ArrayList<>();

        String req = "select * from Article " ;
         PreparedStatement ps = con.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
              String r=(rs.getString("ref_article"));
              Article a = new Article(rs.getString("ref_article"),rs.getInt("code"),rs.getString("designation"),rs.getFloat("prix"), rs.getInt("seuil_max"),rs.getInt("seuil_min"));
              articles.add(a);

            }
            return articles;
    }*/
    public void ajouter(Article t) throws SQLException {

        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `article` (`ref_article`, `code`, `designation`,`prix`,`seuil_max`,`seuil_min`) VALUES (?,?,?,?,?,?);";
        ste.executeUpdate(requeteInsert);

    }

    public List<Article> readArticle() throws SQLException {
        List<Article> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from article");
        while (rs.next()) {
            String ref = rs.getString("ref_article");
            int code = rs.getInt("code");
            String designation = rs.getString("designation");
            Float prix = rs.getFloat("prix");
            int seuil_max = rs.getInt("seuil_max");
            int seuil_min = rs.getInt("seuil_min");

            Article c = new Article(ref, code, designation, prix, seuil_max, seuil_min);
            arr.add(c);
            System.out.println(c);
        }
        return arr;
    }

}
