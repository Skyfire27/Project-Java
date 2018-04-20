/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import controller.Connexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Albert
 */
public class Update {
   
    private Connexion local;
    private boolean valider;
    private String requeteMaj;
    private ResultSet rSet;
    
    
    public Update(){
        try {
            local = new Connexion("projet", "root", "");
            valider = false;
            requeteMaj = "";
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Recherche.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Update(Connexion local){
        this.local=local;
        valider = false;
        requeteMaj = "";
    }
    
    public void modifier(String requeteMaj){
        try {
            local.executeUpdate(requeteMaj);
        } catch (SQLException ex) {
            Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }
}
