/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import controller.Connexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Albert
 */
public class Recherche {

    private Connexion local;
    private String requete;
    private ArrayList<String> liste;

    /**
     * Constructeur par défaut
     */
    public Recherche() {
        try {
            local = new Connexion("projet", "root", "");
            requete = "";
            liste = null;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Recherche.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Constructeur surchargé par local
     * @param local variable de type Connexion
     */
    public Recherche(Connexion local) {
        this.local = local;
        requete = "";
        liste = null;
    }
    
    /**
     * Accesseur pour modifier la valeur de liste en privé
     * @param liste 
     */
    public void setListe(ArrayList<String> liste) {
        this.liste = liste;
    }
    
    /**
     * Methode qui va executer la requete vers la bdd, pour récuperer un ArrayList liste
     * @param requete variable de type String
     * @return variable de type ArrayList<String>
     */
    public ArrayList<String> executerRequete(String requete) {
        try {
            liste = local.remplirChampsRequete(requete);
            this.setListe(liste);
                
        } catch (SQLException ex) {
            Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
        }
        return liste;
    }
    
    /**
     * Methode qui vérifie les saisies de l'utilisateur et créer la requête approprié
     * @param table variable de type String
     * @param data variable de type String
     * @param demande variable de type String
     * @return requete variable de type String
     */
    public String verifier(String table, String data, String demande) {        
            if (("".equals(demande))&&("".equals(data))){
                requete = "select * from " + table;
            } else if ("".equals(demande)){
                requete = "select "+data+" from " + table;
            } else if ("".equals(data)){
                requete = "select * from " + table;
            } else
            {
                requete = "select " + data + " from " + table+ " where "+data+" = "+"'"+demande+"'";
            }
            return requete;
    }

}
