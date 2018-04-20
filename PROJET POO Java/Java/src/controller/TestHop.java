/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import modele.Recherche;
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
    private static Recherche rech = new Recherche();
    private static Fenetre fen = new Fenetre(rech);

    public static void main(String args[]) {
        DefaultPieDataset dataset =new DefaultPieDataset();
        dataset.setValue("Category 1", 43.2);
        dataset.setValue("Category 2", 27.9);
        dataset.setValue("Category 3", 79.5);
        
        JFreeChart chart;
        chart = ChartFactory.createPieChart("Sample Pie Chart", dataset, true, true, false);
        ChartFrame frame = new ChartFrame("First", chart);
        frame.pack();
//        fen.affiche();
        frame.setVisible(true);
    }
}
