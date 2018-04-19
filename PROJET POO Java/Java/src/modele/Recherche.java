/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import controller.Connexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Albert
 */
public class Recherche {

    private Connexion local;
    private boolean valider;
    private String saisie;
    private String requete;
    private ResultSet rSet;
    private int nombre;

    public Recherche() {
        try {
            local = new Connexion("projet", "root", "");
            valider = false;
            saisie = "";
            nombre = 0;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Recherche.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Recherche(String database, String username, String mdp) {
        try {
            local = new Connexion(database, username, mdp);
            valider = false;
            saisie = "";
            nombre = 0;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Recherche.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void existance(String table, String data, String demande) {
        try {

            requete = "select "+data+" from " + table;
            rSet = local.getStmt().executeQuery(requete);
            while (rSet.next()) {
                String champs = rSet.getString(1);
                if (champs == null ? demande == null : champs.equals(demande)){ 
                    valider = true;         
                } 
            }
            if (valider == true){
                 System.out.println("Le "+ table+ " au " + data + " de " + demande+ " existe");
            }else{
                 System.out.println("Le "+ table+ " au " + data + " de " + demande+ " n'existe pas"); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(Recherche.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
