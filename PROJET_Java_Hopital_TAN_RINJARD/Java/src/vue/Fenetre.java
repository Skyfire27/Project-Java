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
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class Fenetre extends JFrame implements ActionListener
{
    private JPanel pan, pan2, pan3;//fenêtre de visualisation de l'interface d'origine
    private JLabel lab, lab2, lab3,lab4,lab5,lab6;//instancie la texte
    // créer les boutons
    private JButton b1,b2,b3,b4,b5; 
    private JButton bv1,bv2,bv21,bv22,bv23,bv24,bv25,bv26,bv27,bv28,bv3;
    private JButton bv211,bv221,bv231,bv241,bv251,bv261,bv271,bv281;
    private JButton bv212,bv222,bv232,bv242,bv252,bv262,bv272,bv282;
    private JComboBox box,box2;
    private JTextField jtf, jtf2, jtf3, jtf4, jtf5, jtf6;
    private String don,don2;
    private String choix1;
    private Recherche rech;
    private Update maj;
    private Reporting rep;
    private ArrayList<String> donnée,affichage;
    
    /**
     * Constructeur de l'affichage
     * @param rech variable de type Recherche
     * @param maj variable de type Update
     * @param rep variable de type Reporting
     */
    
    public Fenetre(Recherche rech, Update maj, Reporting rep){
        this.rech =rech;
        this.maj=maj;
        this.rep = rep;
        //met un titre et une taille au panneau
        setTitle("Hopital d'Albert et Yann");
        setSize(500,600);
        //instancier les panneaux
        pan=new JPanel();
        pan2=new JPanel();
        pan3=new JPanel();
        lab=new JLabel("Database utilisée: 'projet' ");
        //instancier les boutons
        b1=new JButton("Recherche d'information");
        b2=new JButton("Mise à jour");
        b3=new JButton("Reporting");
        b4=new JButton("Quitter");
        b5=new JButton("Précédent");
        bv1=new JButton("Valider");
        bv2=new JButton("Valider");
        bv3=new JButton("Valider");
        bv21=new JButton("Ajouter");
        bv22=new JButton("Ajouter");
        bv23=new JButton("Ajouter");
        bv24=new JButton("Ajouter");
        bv25=new JButton("Ajouter");
        bv26=new JButton("Ajouter");
        bv27=new JButton("Ajouter");
        bv28=new JButton("Ajouter");
        bv211=new JButton("Modifier");
        bv221=new JButton("Modifier");
        bv231=new JButton("Modifier");
        bv241=new JButton("Modifier");
        bv251=new JButton("Modifier");
        bv261=new JButton("Modifier");
        bv271=new JButton("Modifier");
        bv281=new JButton("Modifier");
        bv212=new JButton("Supprimer");
        bv222=new JButton("Supprimer");
        bv232=new JButton("Supprimer");
        bv242=new JButton("Supprimer");
        bv252=new JButton("Supprimer");
        bv262=new JButton("Supprimer");
        bv272=new JButton("Supprimer");
        bv282=new JButton("Supprimer");
        box=new JComboBox();
        box2=new JComboBox();
        //instancier les zones de textes
        jtf=new JTextField();
        jtf2=new JTextField();
        jtf3=new JTextField();
        jtf4=new JTextField();
        jtf5=new JTextField();
        jtf6=new JTextField();
        affichage=new ArrayList();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//quitte le programme lorsque l'utilisateur ferme la fenêtre
    }

    
    
    /**
     * methode pour afficher la fenêtre
     * 
     */
    public void affiche(){
        //permet l'espacement entre les boutons en largeur et hauteur
        FlowLayout fl=new FlowLayout();
        fl.setHgap(100);
        fl.setVgap(50);
        pan.setLayout(fl);//mise en forme de bouton à la suite
        //Création de la taille des boutons, box et texte
        b1.setPreferredSize(new Dimension(200,50));
        b2.setPreferredSize(new Dimension(200,50));
        b3.setPreferredSize(new Dimension(200,50));
        b4.setPreferredSize(new Dimension(100,50));
        b5.setPreferredSize(new Dimension(100,50));
        bv1.setPreferredSize(new Dimension(100,50));
        bv2.setPreferredSize(new Dimension(100,50));
        bv3.setPreferredSize(new Dimension(100,50));
        bv21.setPreferredSize(new Dimension(100,50));
        bv22.setPreferredSize(new Dimension(100,50));
        bv23.setPreferredSize(new Dimension(100,50));
        bv24.setPreferredSize(new Dimension(100,50));
        bv25.setPreferredSize(new Dimension(100,50));
        bv26.setPreferredSize(new Dimension(100,50));
        bv27.setPreferredSize(new Dimension(100,50));
        bv28.setPreferredSize(new Dimension(100,50));
        bv211.setPreferredSize(new Dimension(100,50));
        bv221.setPreferredSize(new Dimension(100,50));
        bv231.setPreferredSize(new Dimension(100,50));
        bv241.setPreferredSize(new Dimension(100,50));
        bv251.setPreferredSize(new Dimension(100,50));
        bv261.setPreferredSize(new Dimension(100,50));
        bv271.setPreferredSize(new Dimension(100,50));
        bv281.setPreferredSize(new Dimension(100,50));
        bv212.setPreferredSize(new Dimension(100,50));
        bv222.setPreferredSize(new Dimension(100,50));
        bv232.setPreferredSize(new Dimension(100,50));
        bv242.setPreferredSize(new Dimension(100,50));
        bv252.setPreferredSize(new Dimension(100,50));
        bv262.setPreferredSize(new Dimension(100,50));
        bv272.setPreferredSize(new Dimension(100,50));
        bv282.setPreferredSize(new Dimension(100,50));
        box.setPreferredSize(new Dimension(200,30));
        box2.setPreferredSize(new Dimension(200,30));
        //initialisation des bouton, panneau et box
        box.addItem("chambre");
        box.addItem("docteur");
        box.addItem("employe");
        box.addItem("hospitalisation");
        box.addItem("infirmier");
        box.addItem("malade");
        box.addItem("service");
        box.addItem("soigne");
        box2.addItem("hospitalisation");
        box2.addItem("docteur");
        box2.addItem("soigne");
        pan.add(lab);
        pan.add(b1);
        pan.add(b2);
        pan.add(b3);
        pan.add(b4);
        //initialisation des listeners
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        bv1.addActionListener(this);
        bv2.addActionListener(this);
        bv3.addActionListener(this);
        bv21.addActionListener(this);
        bv22.addActionListener(this);
        bv23.addActionListener(this);
        bv24.addActionListener(this);
        bv25.addActionListener(this);
        bv26.addActionListener(this);
        bv27.addActionListener(this);
        bv28.addActionListener(this);
        bv211.addActionListener(this);
        bv221.addActionListener(this);
        bv231.addActionListener(this);
        bv241.addActionListener(this);
        bv251.addActionListener(this);
        bv261.addActionListener(this);
        bv271.addActionListener(this);
        bv281.addActionListener(this);
        bv212.addActionListener(this);
        bv222.addActionListener(this);
        bv232.addActionListener(this);
        bv242.addActionListener(this);
        bv252.addActionListener(this);
        bv262.addActionListener(this);
        bv272.addActionListener(this);
        bv282.addActionListener(this);
        add(pan);
        this.setVisible(true);
    }
    
    /**
     * méthode pour les différentes actions faites sur l'interface
     * @param e variable de type ActinEvent
     */
    @Override
    public void actionPerformed (ActionEvent e)
    {
        //mise en place des différents choix pour l'affichage
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
            pan2.add(b5);
            pan2.add(bv1);
            pan2.add(b4);
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
            pan2.add(b5);
            pan2.add(bv2);
            pan2.add(b4);
            add(pan2);
            pan2.setVisible(true);
        }
        else if(e.getSource()==b3){
            pan.setVisible(false);
            FlowLayout fl2=new FlowLayout();
            fl2.setHgap(100);
            fl2.setVgap(20);
            pan2.setLayout(fl2);
            lab=new JLabel("Dans quel table voulez-vous ajoutée?");
            pan2.add(lab);
            pan2.add(box2);           
            pan2.add(b5);
            pan2.add(bv3);
            pan2.add(b4);
            add(pan2);
            this.setVisible(true);
        }
        else if(e.getSource()==b4){
            System.exit(0);
        }
        else if(e.getSource()==b5){
            setSize(500,600);
            pan2.setVisible(false);
            pan3.setVisible(false);
            pan.setVisible(true);
        }
        else if(e.getSource()==bv1){
            FlowLayout fl2=new FlowLayout();
            fl2.setHgap(100);
            fl2.setVgap(20);
            pan3.setLayout(fl2);
            choix1= (String) box.getSelectedItem();
            don=jtf.getText();
            don2=jtf2.getText();
            rech.verifier(choix1,don,don2);
            affichage=rech.executerRequete(rech.verifier(choix1,don,don2));
            Iterator it = affichage.iterator();
            while (it.hasNext()) {
                    lab=new JLabel((String) it.next());
                    pan3.add(lab);
                }
            add(pan3); 
            //permet de faire 2 zones d'affichage
            setSize(3000,600);
            JSplitPane splitPane = new JSplitPane();
            splitPane.setSize(600,500);
            splitPane.setDividerSize(10);
            splitPane.setDividerLocation(500);
            splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
            splitPane.setLeftComponent(pan2);
            splitPane.setRightComponent(pan3);
            getContentPane().add(splitPane); //ajouter le panneau dans la fenetre
            this.setVisible(true);
        }
        else if(e.getSource()==bv21){
            donnée=new ArrayList();
            lab=new JLabel(jtf.getText());
            lab2=new JLabel(jtf2.getText());
            lab3=new JLabel(jtf3.getText());
            lab4=new JLabel(jtf4.getText());
            donnée.add("chambre");
            pan3.add(lab);
            donnée.add(jtf.getText());
            pan3.add(lab2);
            donnée.add(jtf2.getText());
            pan3.add(lab3);
            donnée.add(jtf3.getText());
            pan3.add(lab4);
            donnée.add(jtf4.getText());
            add(pan3);
            maj.executerRequete(maj.ajouter(donnée));
            this.setVisible(true);
        }
        else if(e.getSource()==bv22){
            donnée=new ArrayList();
            lab=new JLabel(jtf.getText());
            lab2=new JLabel(jtf2.getText());
            donnée.add("docteur");
            pan3.add(lab);
            donnée.add(jtf.getText());
            pan3.add(lab2);
            donnée.add(jtf2.getText());
            add(pan3);
            maj.executerRequete(maj.ajouter(donnée));
            this.setVisible(true);
        }
        else if(e.getSource()==bv23){
            donnée=new ArrayList();
            lab=new JLabel(jtf.getText());
            lab2=new JLabel(jtf2.getText());
            lab3=new JLabel(jtf3.getText());
            lab4=new JLabel(jtf4.getText());
            lab5=new JLabel(jtf5.getText());
            donnée.add("employe");
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
            maj.executerRequete(maj.ajouter(donnée));
            this.setVisible(true);
        }
        else if(e.getSource()==bv24){
            donnée=new ArrayList();
            lab=new JLabel(jtf.getText());
            lab2=new JLabel(jtf2.getText());
            lab3=new JLabel(jtf3.getText());
            lab4=new JLabel(jtf4.getText());
            donnée.add("hospitalisation");
            pan3.add(lab);
            donnée.add(jtf.getText());
            pan3.add(lab2);
            donnée.add(jtf2.getText());
            pan3.add(lab3);
            donnée.add(jtf3.getText());
            pan3.add(lab4);
            donnée.add(jtf4.getText());
            add(pan3);
            maj.executerRequete(maj.ajouter(donnée));
            this.setVisible(true);
        }
        else if(e.getSource()==bv25){
            donnée=new ArrayList();
            lab=new JLabel(jtf.getText());
            lab2=new JLabel(jtf2.getText());
            lab3=new JLabel(jtf3.getText());
            lab4=new JLabel(jtf4.getText());
            donnée.add("infirmer");
            pan3.add(lab);
            donnée.add(jtf.getText());
            pan3.add(lab2);
            donnée.add(jtf2.getText());
            pan3.add(lab3);
            donnée.add(jtf3.getText());
            pan3.add(lab4);
            donnée.add(jtf4.getText());
            add(pan3);
            maj.executerRequete(maj.ajouter(donnée));
            this.setVisible(true);
        }
        else if(e.getSource()==bv26){
            donnée=new ArrayList();
            lab=new JLabel(jtf.getText());
            lab2=new JLabel(jtf2.getText());
            lab3=new JLabel(jtf3.getText());
            lab4=new JLabel(jtf4.getText());
            lab5=new JLabel(jtf5.getText());
            lab6=new JLabel(jtf6.getText());
            donnée.add("malade");
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
            maj.executerRequete(maj.ajouter(donnée));
            this.setVisible(true);
        }
        else if(e.getSource()==bv27){
            donnée=new ArrayList();
            lab=new JLabel(jtf.getText());
            lab2=new JLabel(jtf2.getText());
            lab3=new JLabel(jtf3.getText());
            lab4=new JLabel(jtf4.getText());
            donnée.add("service");
            pan3.add(lab);
            donnée.add(jtf.getText());
            pan3.add(lab2);
            donnée.add(jtf2.getText());
            pan3.add(lab3);
            donnée.add(jtf3.getText());
            pan3.add(lab4);
            donnée.add(jtf4.getText());
            add(pan3);
            maj.executerRequete(maj.ajouter(donnée));
            this.setVisible(true);
        }
        else if(e.getSource()==bv28){
            donnée=new ArrayList();
            lab=new JLabel(jtf.getText());
            lab2=new JLabel(jtf2.getText());
            donnée.add("soigne");
            pan3.add(lab);
            donnée.add(jtf.getText());
            pan3.add(lab2);
            donnée.add(jtf2.getText());
            add(pan3);
            donnée.add(jtf3.getText());
            maj.executerRequete(maj.ajouter(donnée));
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
                pan3.add(bv21);
                pan3.add(bv211);
                pan3.add(b4);
                pan3.add(bv212);                
            }
            else if (box.getSelectedItem()=="docteur"){
                lab=new JLabel("Entrez les informations: numero, specialite");
                jtf.setPreferredSize(new Dimension(200,30));
                jtf2.setPreferredSize(new Dimension(200,30));
                pan3.add(lab);
                pan3.add(jtf);
                pan3.add(jtf2);
                pan3.add(bv22);
                pan3.add(bv221);
                pan3.add(b4);
                pan3.add(bv222);                
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
                pan3.add(bv23);
                pan3.add(bv231);
                pan3.add(b4);
                pan3.add(bv232);                
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
                pan3.add(bv24);
                pan3.add(bv241);
                pan3.add(b4);
                pan3.add(bv242);                
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
                pan3.add(bv25);
                pan3.add(bv251);
                pan3.add(b4);
                pan3.add(bv252);                
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
                pan3.add(bv26);
                pan3.add(bv261);
                pan3.add(b4);
                pan3.add(bv262);                
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
                pan3.add(bv27);
                pan3.add(bv271);
                pan3.add(b4);
                pan3.add(bv272);                
            }
            else if (box.getSelectedItem()=="soigne"){
                lab=new JLabel("Entrez les informations: no_docteur, no_malade");
                jtf.setPreferredSize(new Dimension(200,30));
                jtf2.setPreferredSize(new Dimension(200,30));
                pan3.add(lab);
                pan3.add(jtf);
                pan3.add(jtf2);
                pan3.add(bv28);
                pan3.add(bv281);
                pan3.add(b4);
                pan3.add(bv282);                
            }
            pan2.setVisible(false);
            add(pan3);
            this.setVisible(true);

        }
        else if (e.getSource()==bv3){
            if (box2.getSelectedItem()=="hospitalisation"){ 
                //Création des PieChart
                DefaultPieDataset dataset =new DefaultPieDataset();
                dataset.setValue("REA", rep.hospitalisationRep("REA"));
                dataset.setValue("CHG", rep.hospitalisationRep("CHG"));
                dataset.setValue("CAR", rep.hospitalisationRep("CAR"));        
                JFreeChart chart = ChartFactory.createPieChart("Nombre de malade par service", dataset, true, true, false);
                ChartFrame frame = new ChartFrame("Hospitalisation", chart);
                frame.pack();
                frame.setVisible(true);
            }
            else if (box2.getSelectedItem()=="docteur"){             
                DefaultPieDataset dataset =new DefaultPieDataset();
                dataset.setValue("Pneumologue", rep.docteurRep("Pneumologue"));
                dataset.setValue("Traumatologue", rep.docteurRep("Traumatologue"));
                dataset.setValue("Cardiologue", rep.docteurRep("Cardiologue"));
                dataset.setValue("Orthopediste", rep.docteurRep("Orthopediste"));
                dataset.setValue("Radiologue", rep.docteurRep("Radiologue"));
                dataset.setValue("Anesthesiste", rep.docteurRep("Anesthesiste"));
                JFreeChart chart = ChartFactory.createPieChart("Nombre de docteur par service", dataset, true, true, false);
                ChartFrame frame = new ChartFrame("Docteur", chart);
                frame.pack();
                frame.setVisible(true);
            }
            else if (box2.getSelectedItem()=="soigne"){
                DefaultPieDataset dataset =new DefaultPieDataset();
                dataset.setValue("Patient soigné", 43.2); //SELECT * FROM soigne JOIN malade WHERE soigne.no_malade=malade.numero ORDER BY numero
                dataset.setValue("Patient malade", 56.8);
                JFreeChart chart = ChartFactory.createPieChart("Nombre de patient malade et soigné", dataset, true, true, false);
                ChartFrame frame = new ChartFrame("Patient", chart);
                frame.pack();
                frame.setVisible(true);
            }
        }
        else if(e.getSource()==bv211){
            donnée=new ArrayList();
            lab=new JLabel(jtf.getText());
            lab2=new JLabel(jtf2.getText());
            lab3=new JLabel(jtf3.getText());
            lab4=new JLabel(jtf4.getText());
            donnée.add("chambre");
            pan3.add(lab);
            donnée.add(jtf.getText());
            pan3.add(lab2);
            donnée.add(jtf2.getText());
            pan3.add(lab3);
            donnée.add(jtf3.getText());
            pan3.add(lab4);
            donnée.add(jtf4.getText());
            add(pan3);
            maj.executerRequete(maj.modifier(donnée));
            this.setVisible(true);
        }
        else if(e.getSource()==bv221){
            donnée=new ArrayList();
            lab=new JLabel(jtf.getText());
            lab2=new JLabel(jtf2.getText());
            donnée.add("docteur");
            pan3.add(lab);
            donnée.add(jtf.getText());
            pan3.add(lab2);
            donnée.add(jtf2.getText());
            add(pan3);
            maj.executerRequete(maj.modifier(donnée));
            this.setVisible(true);
        }
        else if(e.getSource()==bv231){
            donnée=new ArrayList();
            lab=new JLabel(jtf.getText());
            lab2=new JLabel(jtf2.getText());
            lab3=new JLabel(jtf3.getText());
            lab4=new JLabel(jtf4.getText());
            lab5=new JLabel(jtf5.getText());
            donnée.add("employe");
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
            maj.executerRequete(maj.modifier(donnée));
            this.setVisible(true);
        }
        else if(e.getSource()==bv241){
            donnée=new ArrayList();
            lab=new JLabel(jtf.getText());
            lab2=new JLabel(jtf2.getText());
            lab3=new JLabel(jtf3.getText());
            lab4=new JLabel(jtf4.getText());
            donnée.add("hospitalisation");
            pan3.add(lab);
            donnée.add(jtf.getText());
            pan3.add(lab2);
            donnée.add(jtf2.getText());
            pan3.add(lab3);
            donnée.add(jtf3.getText());
            pan3.add(lab4);
            donnée.add(jtf4.getText());
            add(pan3);
            maj.executerRequete(maj.modifier(donnée));
            this.setVisible(true);
        }
        else if(e.getSource()==bv251){
            donnée=new ArrayList();
            lab=new JLabel(jtf.getText());
            lab2=new JLabel(jtf2.getText());
            lab3=new JLabel(jtf3.getText());
            lab4=new JLabel(jtf4.getText());
            donnée.add("infirmer");
            pan3.add(lab);
            donnée.add(jtf.getText());
            pan3.add(lab2);
            donnée.add(jtf2.getText());
            pan3.add(lab3);
            donnée.add(jtf3.getText());
            pan3.add(lab4);
            donnée.add(jtf4.getText());
            add(pan3);
            maj.executerRequete(maj.modifier(donnée));
            this.setVisible(true);
        }
        else if(e.getSource()==bv261){
            donnée=new ArrayList();
            lab=new JLabel(jtf.getText());
            lab2=new JLabel(jtf2.getText());
            lab3=new JLabel(jtf3.getText());
            lab4=new JLabel(jtf4.getText());
            lab5=new JLabel(jtf5.getText());
            lab6=new JLabel(jtf6.getText());
            donnée.add("malade");
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
            maj.executerRequete(maj.modifier(donnée));
            this.setVisible(true);
        }
        else if(e.getSource()==bv271){
            donnée=new ArrayList();
            lab=new JLabel(jtf.getText());
            lab2=new JLabel(jtf2.getText());
            lab3=new JLabel(jtf3.getText());
            lab4=new JLabel(jtf4.getText());
            donnée.add("service");
            pan3.add(lab);
            donnée.add(jtf.getText());
            pan3.add(lab2);
            donnée.add(jtf2.getText());
            pan3.add(lab3);
            donnée.add(jtf3.getText());
            pan3.add(lab4);
            donnée.add(jtf4.getText());
            add(pan3);
            maj.executerRequete(maj.modifier(donnée));
            this.setVisible(true);
        }
        else if(e.getSource()==bv281){
            donnée=new ArrayList();
            lab=new JLabel(jtf.getText());
            lab2=new JLabel(jtf2.getText());
            donnée.add("soigne");
            pan3.add(lab);
            donnée.add(jtf.getText());
            pan3.add(lab2);
            donnée.add(jtf2.getText());
            add(pan3);
            donnée.add(jtf3.getText());
            maj.executerRequete(maj.modifier(donnée));
            this.setVisible(true);
        }
        else if(e.getSource()==bv212){
            donnée=new ArrayList();
            lab=new JLabel(jtf.getText());
            lab2=new JLabel(jtf2.getText());
            lab3=new JLabel(jtf3.getText());
            lab4=new JLabel(jtf4.getText());
            donnée.add("chambre");
            pan3.add(lab);
            donnée.add(jtf.getText());
            pan3.add(lab2);
            donnée.add(jtf2.getText());
            pan3.add(lab3);
            donnée.add(jtf3.getText());
            pan3.add(lab4);
            donnée.add(jtf4.getText());
            add(pan3);
            maj.executerRequete(maj.suppression(donnée));
            this.setVisible(true);
        }
        else if(e.getSource()==bv222){
            donnée=new ArrayList();
            lab=new JLabel(jtf.getText());
            lab2=new JLabel(jtf2.getText());
            donnée.add("docteur");
            pan3.add(lab);
            donnée.add(jtf.getText());
            pan3.add(lab2);
            donnée.add(jtf2.getText());
            add(pan3);
            maj.executerRequete(maj.suppression(donnée));
            this.setVisible(true);
        }
        else if(e.getSource()==bv232){
            donnée=new ArrayList();
            lab=new JLabel(jtf.getText());
            lab2=new JLabel(jtf2.getText());
            lab3=new JLabel(jtf3.getText());
            lab4=new JLabel(jtf4.getText());
            lab5=new JLabel(jtf5.getText());
            donnée.add("employe");
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
            maj.executerRequete(maj.suppression(donnée));
            this.setVisible(true);
        }
        else if(e.getSource()==bv242){
            donnée=new ArrayList();
            lab=new JLabel(jtf.getText());
            lab2=new JLabel(jtf2.getText());
            lab3=new JLabel(jtf3.getText());
            lab4=new JLabel(jtf4.getText());
            donnée.add("hospitalisation");
            pan3.add(lab);
            donnée.add(jtf.getText());
            pan3.add(lab2);
            donnée.add(jtf2.getText());
            pan3.add(lab3);
            donnée.add(jtf3.getText());
            pan3.add(lab4);
            donnée.add(jtf4.getText());
            add(pan3);
            maj.executerRequete(maj.suppression(donnée));
            this.setVisible(true);
        }
        else if(e.getSource()==bv252){
            donnée=new ArrayList();
            lab=new JLabel(jtf.getText());
            lab2=new JLabel(jtf2.getText());
            lab3=new JLabel(jtf3.getText());
            lab4=new JLabel(jtf4.getText());
            donnée.add("infirmer");
            pan3.add(lab);
            donnée.add(jtf.getText());
            pan3.add(lab2);
            donnée.add(jtf2.getText());
            pan3.add(lab3);
            donnée.add(jtf3.getText());
            pan3.add(lab4);
            donnée.add(jtf4.getText());
            add(pan3);
            maj.executerRequete(maj.suppression(donnée));
            this.setVisible(true);
        }
        else if(e.getSource()==bv262){
            donnée=new ArrayList();
            lab=new JLabel(jtf.getText());
            lab2=new JLabel(jtf2.getText());
            lab3=new JLabel(jtf3.getText());
            lab4=new JLabel(jtf4.getText());
            lab5=new JLabel(jtf5.getText());
            lab6=new JLabel(jtf6.getText());
            donnée.add("malade");
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
            maj.executerRequete(maj.suppression(donnée));
            this.setVisible(true);
        }
        else if(e.getSource()==bv272){
            donnée=new ArrayList();
            lab=new JLabel(jtf.getText());
            lab2=new JLabel(jtf2.getText());
            lab3=new JLabel(jtf3.getText());
            lab4=new JLabel(jtf4.getText());
            donnée.add("service");
            pan3.add(lab);
            donnée.add(jtf.getText());
            pan3.add(lab2);
            donnée.add(jtf2.getText());
            pan3.add(lab3);
            donnée.add(jtf3.getText());
            pan3.add(lab4);
            donnée.add(jtf4.getText());
            add(pan3);
            maj.executerRequete(maj.suppression(donnée));
            this.setVisible(true);
        }
        else if(e.getSource()==bv282){
            donnée=new ArrayList();
            lab=new JLabel(jtf.getText());
            lab2=new JLabel(jtf2.getText());
            donnée.add("soigne");
            pan3.add(lab);
            donnée.add(jtf.getText());
            pan3.add(lab2);
            donnée.add(jtf2.getText());
            add(pan3);
            donnée.add(jtf3.getText());
            maj.executerRequete(maj.suppression(donnée));
            this.setVisible(true);
        }
    }
}
