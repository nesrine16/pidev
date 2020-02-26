/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;


import java.text.SimpleDateFormat;
import java.util.Date;


public class CommandeUtilisateur {
    
    private int id_commande;
    private String num_commande,ref_article,type;
    private int qte;
    private Date date_commande,date_livraison;

    public CommandeUtilisateur(String num_commande, String ref_article, String type, int qte, Date date_commande, Date date_livraison, float montant) {
        this.num_commande = num_commande;
        this.ref_article = ref_article;
        this.type = type;
        this.qte = qte;
        this.date_commande = date_commande;
        this.date_livraison = date_livraison;
        this.montant = montant;
    }
    

    public CommandeUtilisateur(int id_commande, String num_commande, String ref_article, int qte, Date date_commande, Date date_livraison, float montant) {
        this.id_commande = id_commande;
        this.num_commande = num_commande;
        this.ref_article = ref_article;
        this.qte = qte;
        this.date_commande = date_commande;
        this.date_livraison = date_livraison;
        this.montant = montant;
    }
    

    public CommandeUtilisateur(int id_commande, String num_commande, String ref_article, String type, int qte, Date date_commande, Date date_livraison, float montant) {
        this.id_commande = id_commande;
        this.num_commande = num_commande;
        this.ref_article = ref_article;
        this.type = type;
        this.qte = qte;
        this.date_commande = date_commande;
        this.date_livraison = date_livraison;
        this.montant = montant;
    }

    public CommandeUtilisateur(String num_commande, String ref_article, int qte, float montant, Date date_commande, Date date_livraison) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public CommandeUtilisateur(Integer id_commande, String num_commande, String ref_article, int qte, String type, java.sql.Date sqlDate, float montant, java.sql.Date date_livraison) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public CommandeUtilisateur(String num_commande, String ref_article, int qte, float montant, Date date_commande, Date date_livraison, String type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }
    
    

    public Date getDate_livraison() {
        return date_livraison;
    }

    public void setDate_livraison(Date date_livraison) {
        this.date_livraison = date_livraison;
    }
    private float montant;

    public String getNum_commande() {
        return num_commande;
    }

    public void setNum_commande(String num_commande) {
        this.num_commande = num_commande;
    }

    public String getRef_article() {
        return ref_article;
    }

    public void setRef_article(String ref_article) {
        this.ref_article = ref_article;
    }

    public String getType() {
        return type;
    }

    public void setType(String nom_ste) {
        this.type = nom_ste;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public Date getDate_commande() {
        return date_commande;
    }

    public void setDate_commande(Date date_commande) {
        this.date_commande = date_commande;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public CommandeUtilisateur(String num_commande, String ref_article, int qte, String type, Date date_commande, float montant, Date date_livraison) {
        this.num_commande = num_commande;
        this.ref_article = ref_article;
        this.type = type;
        this.qte = qte;
        this.date_commande = date_commande;
        this.montant = montant;
        this.date_livraison = date_livraison;

    }
    
    
    
    
    
    

                
}
