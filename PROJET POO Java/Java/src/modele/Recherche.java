/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import controller.Connexion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Albert
 */
public class Recherche {

    private Connexion local;
    private String requete;


    public Recherche() {
        try {
            local = new Connexion("projet", "root", "");
            requete = "";
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Recherche.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Recherche(String database, String username, String mdp) {
        try {
            local = new Connexion(database, username, mdp);
            requete = "";
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Recherche.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Recherche(Connexion local) {
        this.local = local;
        requete = "";
    }
    
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
