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
import java.util.logging.Level;
import java.util.logging.Logger;
<<<<<<< HEAD
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
=======
import vue.Fenetre;
>>>>>>> Interface.Java

/**
 *
 * @author Albert
 */
public class TestHop {
<<<<<<< HEAD
   

    public static void main(String args[]) {
        
            try {
                Connexion local = new Connexion("projet", "root", "");
            } catch (SQLException ex) {
                Logger.getLogger(TestHop.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TestHop.class.getName()).log(Level.SEVERE, null, ex);
            }
            
=======
    private static Fenetre fen=new Fenetre();
    public static void main(String args[]){
        try {
            Connexion local = new Connexion("projet","root","");
        } catch (SQLException ex) {
            Logger.getLogger(TestHop.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestHop.class.getName()).log(Level.SEVERE, null, ex);
        }
        fen.affiche();
>>>>>>> Interface.Java
    }
}
