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
import modele.Update;
import vue.Fenetre;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Albert
 */
public class TestHop {
    private static Connexion local;
    private static Recherche rech;
    private static Update maj;
    private static Fenetre fen;

    public static void main(String args[]) {
<<<<<<< HEAD

       
        try {
            local = new Connexion("projet","root","");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(TestHop.class.getName()).log(Level.SEVERE, null, ex);
        }
        rech = new Recherche(local);
        maj = new Update(local);
        fen = new Fenetre(rech,maj);
     
=======
>>>>>>> 27711917f1f7fc4aeb3d0384ccd26855ebf39123
        DefaultPieDataset dataset =new DefaultPieDataset();
        dataset.setValue("Category 1", 43.2);
        dataset.setValue("Category 2", 27.9);
        dataset.setValue("Category 3", 79.5);
        
        JFreeChart chart;
        chart = ChartFactory.createPieChart("Sample Pie Chrt", dataset, true, true, false);
        ChartFrame frame = new ChartFrame("First", chart);
        frame.pack();
//        fen.affiche();
        frame.setVisible(true);
    }
}
