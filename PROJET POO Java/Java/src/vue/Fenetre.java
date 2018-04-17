/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

/**
 *
 * @author Albert
 */
import javax.swing.*;
import java.awt.*;
import modele.*;
import java.util.*;
import java.io.*;

public class Fenetre extends JFrame
{
    private JPanel pan;//fenêtre de visualisation de l'interface d'origine
    
    public Fenetre(){
        setTitle("Hopital d'Albert et Yann");
        setSize(600,500);
        pan=new JPanel();//instancier le panneau
    }
    
    public void affiche(){
        pan.setLayout(new FlowLayout());//mise en forme de bouton à la suite
        this.setVisible(true);
    }
}
