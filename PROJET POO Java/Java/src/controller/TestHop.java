/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.Recherche;
import modele.Reporting;
import modele.Update;
import vue.Fenetre;

/**
 *
 * @author Albert
 */
public class TestHop {
    private static Connexion local;
    private static Recherche rech;
    private static Update maj;
    private static Fenetre fen;
    private static Reporting rep;

    public static void main(String args[]) {
        try {
            local = new Connexion("projet","root","");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(TestHop.class.getName()).log(Level.SEVERE, null, ex);
        }
        rech = new Recherche(local);
        maj = new Update(local);
        rep = new Reporting(local);
        fen = new Fenetre(rech,maj,rep);
        fen.affiche();
    }
}
