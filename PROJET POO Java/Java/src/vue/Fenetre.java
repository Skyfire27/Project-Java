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

import org.jfree.chart.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class Fenetre extends JFrame implements ActionListener
{
    private JPanel pan, pan2, pan3;//fenêtre de visualisation de l'interface d'origine
    private JLabel lab, lab2, lab3,lab4,lab5,lab6;//instancie la texte
    // instancie les boutons
    private JButton b1,b2,b3,b4; 
//    private JButton b5;
    private JButton bv1,bv2,bv21,bv22,bv23,bv24,bv25,bv26,bv27,bv28;
    private JComboBox box;
    private JTextField jtf, jtf2, jtf3, jtf4, jtf5, jtf6;
    private String don,don2;
    private String choix1;
    private Recherche rech;
    private Update maj;
    private ArrayList<String> donnée;
    
    public Fenetre(Recherche rech, Update maj){
        this.rech =rech;
        this.maj=maj;
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
//        b5=new JButton("Précédent"); test bouton précédent
        bv1=new JButton("Valider");
        bv2=new JButton("Valider");
        bv21=new JButton("Valider");
        bv22=new JButton("Valider");
        bv23=new JButton("Valider");
        bv24=new JButton("Valider");
        bv25=new JButton("Valider");
        bv26=new JButton("Valider");
        bv27=new JButton("Valider");
        bv28=new JButton("Valider");
        box=new JComboBox();
        jtf=new JTextField();
        jtf2=new JTextField();
        jtf3=new JTextField();
        jtf4=new JTextField();
        jtf5=new JTextField();
        jtf6=new JTextField();
        donnée=new ArrayList();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//quitte le programme lorsque l'utilisateur ferme la fenêtre
    }

    
    
    /**
     * methode pour afficher la fenêtre
     * 
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
        bv1.setPreferredSize(new Dimension(100,50));
        bv2.setPreferredSize(new Dimension(100,50));
        bv21.setPreferredSize(new Dimension(100,50));
        bv22.setPreferredSize(new Dimension(100,50));
        bv23.setPreferredSize(new Dimension(100,50));
        bv24.setPreferredSize(new Dimension(100,50));
        bv25.setPreferredSize(new Dimension(100,50));
        bv26.setPreferredSize(new Dimension(100,50));
        bv27.setPreferredSize(new Dimension(100,50));
        bv28.setPreferredSize(new Dimension(100,50));
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
        bv1.addActionListener(this);
        bv2.addActionListener(this);
        bv21.addActionListener(this);
        bv22.addActionListener(this);
        bv23.addActionListener(this);
        bv24.addActionListener(this);
        bv25.addActionListener(this);
        bv26.addActionListener(this);
        bv27.addActionListener(this);
        bv28.addActionListener(this);
        add(pan);
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed (ActionEvent e)
    {
        if(e.getSource()==b1){
            pan.setVisible(false);
            lab=new JLabel("Quel table voulez-vous?");
            lab2=new JLabel("Que chercher vous? ( * : table entière)");
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
            pan2.add(bv1);
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
            lab2=new JLabel("Quel information voulez-vous ajoutée?");
            lab3=new JLabel("Entrez l'information");
            jtf.setPreferredSize(new Dimension(200,30));
            pan2.add(lab);
            pan2.add(box);
            pan2.add(lab2);
            pan2.add(lab3);
            pan2.add(jtf);

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
            DefaultPieDataset dataset =new DefaultPieDataset();
            dataset.setValue("Category 1", 43.2);
            dataset.setValue("Category 2", 27.9);
            dataset.setValue("Category 3", 79.5);
            JFreeChart chart = ChartFactory.createPieChart("Sample Pie Chart", dataset, true, true, false);
            ChartFrame frame = new ChartFrame("First", chart);
            frame.pack();
            frame.setVisible(true);
            pan2.setLayout(fl2);
            pan2.add(b4);
            add(pan2);
            this.setVisible(true);
        }
        else if(e.getSource()==b4){
            System.exit(0);
        }
//        else if(e.getSource()==b5){
//            pan2.setVisible(false);
//            add(pan);
//            pan.setVisible(true);
//        }
        else if(e.getSource()==bv1){
            choix1= (String) box.getSelectedItem();
            don=jtf.getText();
            don2=jtf2.getText();
            System.out.println(rech.verifier(choix1,don,don2));

        }
        else if(e.getSource()==bv21){
            lab=new JLabel(jtf.getText());
            lab2=new JLabel(jtf2.getText());
            lab3=new JLabel(jtf3.getText());
            lab4=new JLabel(jtf4.getText());
            pan3.add(lab);
            donnée.add(jtf.getText());
            pan3.add(lab2);
            donnée.add(jtf2.getText());
            pan3.add(lab3);
            donnée.add(jtf3.getText());
            pan3.add(lab4);
            donnée.add(jtf4.getText());
            add(pan3);
            maj.modifier(donnée);
            this.setVisible(true);
        }
        else if(e.getSource()==bv22){
            lab=new JLabel(jtf.getText());
            lab2=new JLabel(jtf2.getText());
            pan3.add(lab);
            donnée.add(jtf.getText());
            pan3.add(lab2);
            donnée.add(jtf2.getText());
            add(pan3);
            maj.modifier(donnée);
            this.setVisible(true);
        }
        else if(e.getSource()==bv23){
            lab=new JLabel(jtf.getText());
            lab2=new JLabel(jtf2.getText());
            lab3=new JLabel(jtf3.getText());
            lab4=new JLabel(jtf4.getText());
            lab5=new JLabel(jtf5.getText());
            pan3.add(lab);
            donnée.add(jtf.getText());
            pan3.add(lab2);
            donnée.add(jtf2.getText());
            pan3.add(lab3);
            donnée.add(jtf3.getText());
            pan3.add(lab4);
            donnée.add(jtf4.getText());
            pan3.add(lab5);
            donnée.add(jtf5.getText());
            add(pan3);
            maj.modifier(donnée);
            this.setVisible(true);
        }
        else if(e.getSource()==bv24){
            lab=new JLabel(jtf.getText());
            lab2=new JLabel(jtf2.getText());
            lab3=new JLabel(jtf3.getText());
            lab4=new JLabel(jtf4.getText());
            pan3.add(lab);
            donnée.add(jtf.getText());
            pan3.add(lab2);
            donnée.add(jtf2.getText());
            pan3.add(lab3);
            donnée.add(jtf3.getText());
            pan3.add(lab4);
            donnée.add(jtf4.getText());
            add(pan3);
            maj.modifier(donnée);
            this.setVisible(true);
        }
        else if(e.getSource()==bv25){
            lab=new JLabel(jtf.getText());
            lab2=new JLabel(jtf2.getText());
            lab3=new JLabel(jtf3.getText());
            lab4=new JLabel(jtf4.getText());
            pan3.add(lab);
            donnée.add(jtf.getText());
            pan3.add(lab2);
            donnée.add(jtf2.getText());
            pan3.add(lab3);
            donnée.add(jtf3.getText());
            pan3.add(lab4);
            donnée.add(jtf4.getText());
            add(pan3);
            maj.modifier(donnée);
            this.setVisible(true);
        }
        else if(e.getSource()==bv26){
            System.out.println(jtf.getText());
            System.out.println(jtf2.getText());
            System.out.println(jtf3.getText());
            System.out.println(jtf4.getText());
            System.out.println(jtf5.getText());
            System.out.println(jtf6.getText());
            lab=new JLabel(jtf.getText());
            lab2=new JLabel(jtf2.getText());
            lab3=new JLabel(jtf3.getText());
            lab4=new JLabel(jtf4.getText());
            lab5=new JLabel(jtf5.getText());
            lab6=new JLabel(jtf6.getText());
            pan3.add(lab);
            donnée.add(jtf.getText());
            pan3.add(lab2);
            donnée.add(jtf2.getText());
            pan3.add(lab3);
            donnée.add(jtf3.getText());
            pan3.add(lab4);
            donnée.add(jtf4.getText());
            pan3.add(lab5);
            donnée.add(jtf5.getText());
            pan3.add(lab6);
            donnée.add(jtf6.getText());
            add(pan3);
            maj.modifier(donnée);
            this.setVisible(true);
        }
        else if(e.getSource()==bv27){
            System.out.println(jtf.getText());
            System.out.println(jtf2.getText());
            System.out.println(jtf3.getText());
            System.out.println(jtf4.getText());
            lab=new JLabel(jtf.getText());
            lab2=new JLabel(jtf2.getText());
            lab3=new JLabel(jtf3.getText());
            lab4=new JLabel(jtf4.getText());
            pan3.add(lab);
            donnée.add(jtf.getText());
            pan3.add(lab2);
            donnée.add(jtf2.getText());
            pan3.add(lab3);
            donnée.add(jtf3.getText());
            pan3.add(lab4);
            donnée.add(jtf4.getText());
            add(pan3);
            maj.modifier(donnée);
            this.setVisible(true);
        }
        else if(e.getSource()==bv28){
            System.out.println(jtf.getText());
            System.out.println(jtf2.getText());
            lab=new JLabel(jtf.getText());
            lab2=new JLabel(jtf2.getText());
            pan3.add(lab);
            donnée.add(jtf.getText());
            pan3.add(lab2);
            donnée.add(jtf2.getText());
            add(pan3);
            donnée.add(jtf3.getText());
            maj.modifier(donnée);
            this.setVisible(true);
        }
        else if(e.getSource()==bv2){
            FlowLayout fl2=new FlowLayout();
            fl2.setHgap(100);
            fl2.setVgap(20);
            pan3.setLayout(fl2);
            if (box.getSelectedItem()=="chambre"){
                lab=new JLabel("Entrez les informations: code_service, no_chambre, surveillant, nb_lits");
                jtf.setPreferredSize(new Dimension(200,30));
                jtf2.setPreferredSize(new Dimension(200,30));
                jtf3.setPreferredSize(new Dimension(200,30));
                jtf4.setPreferredSize(new Dimension(200,30));
                pan3.add(lab);
                pan3.add(jtf);
                pan3.add(jtf2);
                pan3.add(jtf3);
                pan3.add(jtf4);
                pan3.add(b4);
                pan3.add(bv21);
            }
            else if (box.getSelectedItem()=="docteur"){
                lab=new JLabel("Entrez les informations: numero, specialite");
                jtf.setPreferredSize(new Dimension(200,30));
                jtf2.setPreferredSize(new Dimension(200,30));
                pan3.add(lab);
                pan3.add(jtf);
                pan3.add(jtf2);
                pan3.add(b4);
                pan3.add(bv22);
            }
            else if (box.getSelectedItem()=="employe"){
                lab=new JLabel("Entrez les informations: numero, nom, prenom, adresse, tel");
                jtf.setPreferredSize(new Dimension(200,30));
                jtf2.setPreferredSize(new Dimension(200,30));
                jtf3.setPreferredSize(new Dimension(200,30));
                jtf4.setPreferredSize(new Dimension(200,30));
                jtf5.setPreferredSize(new Dimension(200,30));
                pan3.add(lab);
                pan3.add(jtf);
                pan3.add(jtf2);
                pan3.add(jtf3);
                pan3.add(jtf4);
                pan3.add(jtf5);
                pan3.add(b4);
                pan3.add(bv23);
            }
            else if (box.getSelectedItem()=="hospitalisation"){
                lab=new JLabel("Entrez les informations: no_malade, code_service no_chambre, lit");
                jtf.setPreferredSize(new Dimension(200,30));
                jtf2.setPreferredSize(new Dimension(200,30));
                jtf3.setPreferredSize(new Dimension(200,30));
                jtf4.setPreferredSize(new Dimension(200,30));
                pan3.add(lab);
                pan3.add(jtf);
                pan3.add(jtf2);
                pan3.add(jtf3);
                pan3.add(jtf4);
                pan3.add(b4);
                pan3.add(bv24);
            }
            else if (box.getSelectedItem()=="infirmier"){
                lab=new JLabel("Entrez les informations: numero, code_service, rotation, salaire");
                jtf.setPreferredSize(new Dimension(200,30));
                jtf2.setPreferredSize(new Dimension(200,30));
                jtf3.setPreferredSize(new Dimension(200,30));
                jtf4.setPreferredSize(new Dimension(200,30));
                pan3.add(lab);
                pan3.add(jtf);
                pan3.add(jtf2);
                pan3.add(jtf3);
                pan3.add(jtf4);
                pan3.add(b4);
                pan3.add(bv25);
            }
            else if (box.getSelectedItem()=="malade"){
                lab=new JLabel("Entrez les informations: numero, nom, prenom, adresse, tel, mutuelle");
                jtf.setPreferredSize(new Dimension(200,30));
                jtf2.setPreferredSize(new Dimension(200,30));
                jtf3.setPreferredSize(new Dimension(200,30));
                jtf4.setPreferredSize(new Dimension(200,30));
                jtf5.setPreferredSize(new Dimension(200,30));
                jtf6.setPreferredSize(new Dimension(200,30));
                pan3.add(lab);
                pan3.add(jtf);
                pan3.add(jtf2);
                pan3.add(jtf3);
                pan3.add(jtf4);
                pan3.add(jtf5);
                pan3.add(jtf6);
                pan3.add(b4);
                pan3.add(bv26);
            }
            else if (box.getSelectedItem()=="service"){
                lab=new JLabel("Entrez les informations: code, nom, batiment, directeur");
                jtf.setPreferredSize(new Dimension(200,30));
                jtf2.setPreferredSize(new Dimension(200,30));
                jtf3.setPreferredSize(new Dimension(200,30));
                jtf4.setPreferredSize(new Dimension(200,30));
                pan3.add(lab);
                pan3.add(jtf);
                pan3.add(jtf2);
                pan3.add(jtf3);
                pan3.add(jtf4);
                pan3.add(b4);
                pan3.add(bv27);
            }
            else if (box.getSelectedItem()=="soigne"){
                lab=new JLabel("Entrez les informations: no_docteur, no_malade");
                jtf.setPreferredSize(new Dimension(200,30));
                jtf2.setPreferredSize(new Dimension(200,30));
                pan3.add(lab);
                pan3.add(jtf);
                pan3.add(jtf2);
                pan3.add(b4);
                pan3.add(bv28);
            }
            pan2.setVisible(false);
            add(pan3);
            this.setVisible(true);

        }
    }
}
