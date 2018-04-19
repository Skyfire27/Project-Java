/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import modele.Recherche;
import vue.Fenetre;

/**
 *
 * @author Albert
 */
public class TestHop {
    private static Recherche rech = new Recherche();
    private static Fenetre fen = new Fenetre(rech);

    public static void main(String args[]) {
        
        fen.affiche();
    }
}
