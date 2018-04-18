/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.Recherche;

import vue.Fenetre;

/**
 *
 * @author Albert
 */
public class TestHop {

    private static Fenetre fen = new Fenetre();

    public static void main(String args[]) {
        try {
            Connexion local = new Connexion("projet", "root", "");
            ArrayList<String> liste = local.remplirChampsTable("malade");
            ArrayList<String> listebis = local.remplirChampsRequete("select * from malade");
            Iterator<String> it = liste.iterator();
            Iterator<String> its = listebis.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
            while (its.hasNext()) {
                System.out.println(its.next());
            }
            Recherche rech = new Recherche();
            rech.saisie();            

        } catch (SQLException ex) {
            Logger.getLogger(TestHop.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestHop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fen.affiche();
    }
}
