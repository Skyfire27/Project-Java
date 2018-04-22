/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import controller.Connexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Albert
 */
public class Reporting {

    private Connexion local;
    private String requeteRep, requete;
    private ArrayList<String> liste, listeb;
    private double chiffre, chiffre2, total;
    private ResultSet rset, rsetb;
    private Statement stmt;

    public Reporting() {
        try {
            local = new Connexion("projet", "root", "");
            requeteRep = "";
            requete = "";
            rset = null;
            stmt = local.getStmt();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Recherche.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Reporting(String database, String username, String mdp) {
        try {
            local = new Connexion(database, username, mdp);
            requeteRep = "";
            rset = null;
            stmt = local.getStmt();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Recherche.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Reporting(Connexion local) {
        this.local = local;
        requeteRep = "";
        requete = "";
        rset = null;
        rsetb =null;
        chiffre = chiffre2 = total = 0;
        stmt = local.getStmt();
    }

    public double hospitalisationRep(String demande) {
        requeteRep = "SELECT COUNT(*) FROM hospitalisation WHERE code_service = '" + demande + "'";
        requete = "SELECT COUNT(*) FROM hospitalisation";
        try {
            liste = local.remplirChampsRequete(requeteRep);
            listeb = local.remplirChampsRequete(requete);
            String elem = liste.get(0).substring(0,(liste.get(0).length()>=1)? liste.get(0).length()-1 : 0);
            String elem2 = listeb.get(0).substring(0,(listeb.get(0).length()>=1)? listeb.get(0).length()-1 : 0);
            chiffre = Integer.parseInt(elem);
            chiffre2 = Integer.parseInt(elem2);
            total = chiffre/chiffre2;
        } catch (SQLException ex) {
            Logger.getLogger(Reporting.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total*100;
    }
    
    public double docteurRep(String demande) {
        requeteRep = "SELECT COUNT(*) FROM docteur WHERE specialite = '" + demande + "'";
        requete = "SELECT COUNT(*) FROM docteur";
        try {
            liste = local.remplirChampsRequete(requeteRep);
            listeb = local.remplirChampsRequete(requete);
            String elem = liste.get(0).substring(0,(liste.get(0).length()>=1)? liste.get(0).length()-1 : 0);
            String elem2 = listeb.get(0).substring(0,(listeb.get(0).length()>=1)? listeb.get(0).length()-1 : 0);
            chiffre = Integer.parseInt(elem);
            chiffre2 = Integer.parseInt(elem2);
            total = chiffre/chiffre2;
        } catch (SQLException ex) {
            Logger.getLogger(Reporting.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total*100;
    }
    public double docteurRep() {
        requete = "SELECT COUNT(*) FROM docteur WHERE specialite = 'Anesthesiste'";
        try {
            liste = local.remplirChampsRequete(requete);
            String elem = liste.get(0).substring(0,(liste.get(0).length()>=1)? liste.get(0).length()-1 : 0);
            chiffre = Integer.parseInt(elem);
        } catch (SQLException ex) {
            Logger.getLogger(Reporting.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total*100;
    }

}
