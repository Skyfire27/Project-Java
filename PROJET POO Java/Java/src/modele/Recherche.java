/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;
import controller.Connexion;
import java.sql.SQLException;
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
    private int nombre;
    
    public Recherche(){
        try {
            local =new Connexion("projet", "root", "");
            valider = false;
            saisie = "";
            nombre = 0;
                    } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Recherche.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Recherche(String database, String username, String mdp){
        try {
            local =new Connexion(database, username, mdp);
            valider = false;
            saisie = "";
            nombre = 0;
                    } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Recherche.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Saisie(String demande){
        Scanner sc= new Scanner(System.in);
        
        
    }
    
}
