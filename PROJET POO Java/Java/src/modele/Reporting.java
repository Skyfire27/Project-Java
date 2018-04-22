/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import controller.Connexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Albert
 */
public class Reporting {
    //attributs
    private Connexion local;
    private String requeteRep, requete; //variable pour stocker les requetes
    private ArrayList<String> liste, listeb; //Arraylist pour stocker les valeurs de l'execution de la requete
    private double chiffre, chiffre2, total;

    /**
     * Constructeur par défaut
     */
    public Reporting() {
        try {
            local = new Connexion("projet", "root", "");
            requeteRep = "";
            requete = "";
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Recherche.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Constructeur surchargé par local
     * @param local variable de type Connexion
     */
    public Reporting(Connexion local) {
        this.local = local;
        requeteRep = "";
        requete = "";
        chiffre = chiffre2 = total = 0;
    }

    /**
     * Methode pour récuperer un pourcentage selon le service d'hospitalisation
     * @param demande variable de type String
     * @return total variable de type double
     */
    public double hospitalisationRep(String demande) {
        //requete pour compter le nombre de service dont le nom est "demande"
        requeteRep = "SELECT COUNT(*) FROM hospitalisation WHERE code_service = '" + demande + "'";
        requete = "SELECT COUNT(*) FROM hospitalisation";
        try {
            liste = local.remplirChampsRequete(requeteRep); //recupérer dans liste la valeur de la requeteRep
            listeb = local.remplirChampsRequete(requete); //recupérer dans liste la valeur de la requete
            //transforme le String contenu dans liste en concatenant, en prenant soin de retirer le dernier charactère de liste (,).
            String elem = liste.get(0).substring(0,(liste.get(0).length()>=1)? liste.get(0).length()-1 : 0); 
            String elem2 = listeb.get(0).substring(0,(listeb.get(0).length()>=1)? listeb.get(0).length()-1 : 0);
            //convertir le string en une valeur int
            chiffre = Integer.parseInt(elem);
            chiffre2 = Integer.parseInt(elem2);
            total = (chiffre/chiffre2)*100;
        } catch (SQLException ex) {
            Logger.getLogger(Reporting.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }
    
    /**
     * Methode pour récuperer un pourcentage des docteurs selon leurs specialités
     * @param demande variable de type String
     * @return total variable de type double
     */
    public double docteurRep(String demande) {
        requeteRep = "SELECT COUNT(*) FROM docteur WHERE specialite = '" + demande + "'";
        requete = "SELECT COUNT(*) FROM docteur";
        try {
            liste = local.remplirChampsRequete(requeteRep);
            listeb = local.remplirChampsRequete(requete);
            //transforme le String contenu dans liste en concatenant, en prenant soin de retirer le dernier charactère de liste (,).
            String elem = liste.get(0).substring(0,(liste.get(0).length()>=1)? liste.get(0).length()-1 : 0);
            String elem2 = listeb.get(0).substring(0,(listeb.get(0).length()>=1)? listeb.get(0).length()-1 : 0);
            //convertir le string en une valeur int
            chiffre = Integer.parseInt(elem);
            chiffre2 = Integer.parseInt(elem2);
            total = (chiffre/chiffre2)*100;
        } catch (SQLException ex) {
            Logger.getLogger(Reporting.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

}
