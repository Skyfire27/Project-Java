/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

/**
 *
 * @author Albert_Yann
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modele.*;
import java.util.*;
import java.io.*;

public class Fenetre extends JFrame implements ActionListener
{
    private JPanel pan, pan2, pan3;//fenêtre de visualisation de l'interface d'origine
    private JLabel lab;//instancie la texte
    private JLabel lab2;
    private JLabel lab3;
    // instancie les boutons
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;
//    private JButton b5;
    private JButton bv, bv2;
    private JComboBox box;
    private JTextField jtf, jtf2;
    private String don,don2;
    private String choix1;
    private Recherche rech;
    
    public Fenetre(Recherche rech){
        this.rech =rech;
        setTitle("Hopital d'Albert et Yann");
        setSize(500,600);
        pan=new JPanel();//instancier le panneau
        pan2=new JPanel();//instancier le deuxième panneau
        pan3=new JPanel();
        lab=new JLabel("Database utilisée: 'projet' ");
        b1=new JButton("Recherche d'information");
        b2=new JButton("Mise à jour");
        b3=new JButton("Reporting");
        b4=new JButton("Quitter");
//        b5=new JButton("Précédent"); test pour le bouton précédent
        bv=new JButton("Valider");
        bv2=new JButton("Valider");
        box=new JComboBox();
        jtf=new JTextField();
        jtf2=new JTextField();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//quitte le programme lorsque l'utilisateur ferme la fenêtre
    }
    
    
    /**
     * methode pour afficher la fenêtre
     * 
     * @param rech
     */
    public void affiche(){
        FlowLayout fl=new FlowLayout();
        fl.setHgap(100);
        fl.setVgap(50);
        pan.setLayout(fl);//mise en forme de bouton à la suite
        //
        b1.setPreferredSize(new Dimension(200,50));
        b2.setPreferredSize(new Dimension(200,50));
        b3.setPreferredSize(new Dimension(200,50));
        b4.setPreferredSize(new Dimension(100,50));
//        b5.setPreferredSize(new Dimension(100,50));
        bv.setPreferredSize(new Dimension(100,50));
        bv2.setPreferredSize(new Dimension(100,50));
        box.setPreferredSize(new Dimension(200,30));
        box.addItem("chambre");
        box.addItem("docteur");
        box.addItem("employe");
        box.addItem("hospitalisation");
        box.addItem("infirmier");
        box.addItem("malade");
        box.addItem("service");
        box.addItem("soigne");  
        pan.add(lab);
        pan.add(b1);
        pan.add(b2);
        pan.add(b3);
        pan.add(b4);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
//        b5.addActionListener(this);
        bv.addActionListener(this);
        bv2.addActionListener(this);
        add(pan);
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed (ActionEvent e)
    {
        if(e.getSource()==b1){
            pan.setVisible(false);
            lab=new JLabel("Quel table voulez-vous?");
            lab2=new JLabel("Que chercher vous?");
            jtf.setPreferredSize(new Dimension(200,30));
            lab3=new JLabel("Saisissez l'information recherchée");
            jtf2.setPreferredSize(new Dimension(200,30));
            FlowLayout fl2=new FlowLayout();
            fl2.setHgap(100);
            fl2.setVgap(20);
            pan2.setLayout(fl2);
            pan2.add(lab);
            pan2.add(box);
            pan2.add(lab2);
            pan2.add(jtf);
            pan2.add(lab3);
            pan2.add(jtf2);
            pan2.add(b4);
//            pan2.add(b5);
            pan2.add(bv);
            add(pan2);
            this.setVisible(true);
        }
        else if(e.getSource()==b2){
            pan.setVisible(false);
            FlowLayout fl2=new FlowLayout();
            fl2.setHgap(100);
            fl2.setVgap(20);
            pan2.setLayout(fl2);
            lab=new JLabel("Dans quel table voulez-vous ajoutée?");
            pan2.add(lab);
            pan2.add(box);
            pan2.add(b4);
            pan2.add(bv2);
            add(pan2);
            pan2.setVisible(true);
        }
        else if(e.getSource()==b3){
            pan.setVisible(false);
            FlowLayout fl2=new FlowLayout();
            fl2.setHgap(100);
            fl2.setVgap(20);
            pan2.setLayout(fl2);
            pan2.add(b4);
            add(pan2);
            this.setVisible(true);
        }
        else if(e.getSource()==b4){
            System.exit(0);
        }
//        else if(e.getSource()==b5){
//            pan.setVisible(true);
//            pan2.setVisible(false);
//        }
        else if(e.getSource()==bv){
            choix1= (String) box.getSelectedItem();
            don=jtf.getText();
            don2=jtf2.getText();
            rech.existance(choix1,don, don2);
        }
        else if(e.getSource()==bv2){
            pan2.setVisible(false);
            add(pan3);
            this.setVisible(true);
        }
    }
}
