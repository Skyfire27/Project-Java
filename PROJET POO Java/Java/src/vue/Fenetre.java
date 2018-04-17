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
    private JLabel lab;//instancie la texte
    // instancie les boutons
    private JButton b1;
    private JButton b2;
    private JButton b3;
    
    public Fenetre(){
        setTitle("Hopital d'Albert et Yann");
        setSize(600,500);
        pan=new JPanel();//instancier le panneau
        lab=new JLabel("projet");
        b1=new JButton("test");
        b2=new JButton("test");
        b3=new JButton("test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//quitte le programme lorsque l'utilisateur ferme la fenêtre
    }
    
    public void affiche(){
        pan.setLayout(new FlowLayout());//mise en forme de bouton à la suite
        pan.add(lab);
        pan.add(b1);
        pan.add(b2);
        pan.add(b3);
        add(pan);
        this.setVisible(true);
    }
}
