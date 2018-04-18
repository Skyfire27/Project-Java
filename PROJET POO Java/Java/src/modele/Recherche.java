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

    public void saisie() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Dans quel table voulez vous recherchez");
            saisie = sc.nextLine();
            System.out.println("Que rechercher vous ?");
            String demande = sc.nextLine();
            requete = "select "+demande+" from " + saisie;
            rSet = local.getStmt().executeQuery(requete);
            System.out.println("Quoi en particulier ?");
            String query = sc.nextLine();
            while (rSet.next()) {
                String champs = rSet.getString(1);
                if (champs == null ? query == null : champs.equals(query)){ 
                    valider = true;         
                } 
            }
            if (valider == true){
                 System.out.println("Le "+ saisie+ " au " + demande + " de " + query+ " existe");
            }else{
                 System.out.println("Le "+ saisie+ " au " + demande + " de " + query+ " n'existe pas"); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(Recherche.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
