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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Albert
 */
public class Recherche {

    private Connexion local;
    private boolean valider;
    private String requete;
    private ResultSet rSet;

    public Recherche() {
        try {
            local = new Connexion("projet", "root", "");
            valider = false;
            requete = "";
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Recherche.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Recherche(Connexion local) {
        this.local = local;
        valider = false;
        requete = "";
    }

    public Recherche(String database, String username, String mdp) {
        try {
            local = new Connexion(database, username, mdp);
            valider = false;
            requete = "";
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Recherche.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String existance(String table, String data, String demande) {
        try {
            valider = false;
            requete = "select " + data + " from " + table;
            rSet = local.getStmt().executeQuery(requete);
            while (rSet.next()) {
                String champs = rSet.getString(1);
                if (champs == null ? demande == null : champs.equals(demande)) {
                    valider = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Recherche.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (valider == true) {
            return "Le " + table + " au " + data + " de " + demande + " existe";
        }
        return "Le " + table + " au " + data + " de " + demande + " n'existe pas";
    }

    public void verifier(String table, String data, String demande) {
        try {
            requete = "select " + data + " from " + table;
            ArrayList<String> liste = local.remplirChampsRequete(requete);
            Iterator it = liste.iterator();
            if ("".equals(demande)) {
                System.out.println("Affichage de toute la colonne " + data);
                while (it.hasNext()) {
                    System.out.println(it.next());
                }
            } else {
                this.existance(table, data, demande);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Recherche.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
