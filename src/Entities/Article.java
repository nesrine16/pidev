/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author user
 */
public class Article {
    private String ref_article;

    public String getRef_article() {
        return ref_article;
    }

    public void setRef_article(String ref_article) {
        this.ref_article = ref_article;
    }

    public int getSeuil_min() {
        return seuil_min;
    }

    public void setSeuil_min(int seuil_min) {
        this.seuil_min = seuil_min;
    }
    private int code;
    private String designation;
    private float prix;
    private int seuil_max;
    private int seuil_min;
    private int id_personne;
    private int id_famille;
    private  Fournisseur frs;

    public Article(String ref_article, int code, String designation, float prix, int seuil_max, int seuil_min) {
        this.ref_article = ref_article;
        this.code = code;
        this.designation = designation;
        this.prix = prix;
        this.seuil_max = seuil_max;
        this.seuil_min = seuil_min;
    }

    
    
    public Fournisseur getFrs() {
        return frs;
    }

    public String getRef() {
        return ref_article;
    }

    public void setRef(String ref_article) {
        this.ref_article = ref_article;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    

    public int getSeuil_max() {
        return seuil_max;
    }

    public void setSeuil_max(int seuil_max) {
        this.seuil_max = seuil_max;
    }

    public int getSueil_min() {
        return seuil_min;
    }

    public void setSueil_min(int sueil_min) {
        this.seuil_min = sueil_min;
    }

    public int getId_personne() {
        return id_personne;
    }

    public void setId_personne(int id_personne) {
        this.id_personne = id_personne;
    }

    public int getId_famille() {
        return id_famille;
    }

    public void setId_famille(int id_famille) {
        this.id_famille = id_famille;
    }

    public Article(String ref_article) {
        this.ref_article = ref_article;
    }

    @Override
    public String toString() {
        return "Article{" + "ref_article=" + ref_article + ", code=" + code + ", designation=" + designation + ", prix=" + prix + ", seuil_max=" + seuil_max + ", seuil_min=" + seuil_min + ", id_personne=" + id_personne + ", id_famille=" + id_famille + ", frs=" + frs + '}';
    }
    
    
    
            
    
}

