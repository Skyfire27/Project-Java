/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import controller.Connexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Albert
 */
public class Update {

    private Connexion local;
    private String requeteMaj;
    private ArrayList<String> donnee;
    private ArrayList<String> liste;

    public Update() {
        try {
            local = new Connexion("projet", "root", "");
            requeteMaj = "";
            donnee = null;
            liste = null;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Recherche.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Update(Connexion local) {
        this.local = local;
        requeteMaj = "";
        donnee = null;
        liste = null;
    }

    public void setListe(ArrayList<String> liste) {
        this.liste = liste;
    }

    public void setDonnee(ArrayList<String> donnee) {
        this.donnee = donnee;
    }

    public ArrayList<String> executerRequete(String requete) {
        try {
            liste = local.remplirChampsRequete(requete);
            this.setListe(liste);
            local.executeUpdate(requete);

        } catch (SQLException ex) {
            Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
        }
        return liste;
    }

    public String modifier(ArrayList<String> donnee) {
        if (null != donnee.get(0)) {
            switch (donnee.get(0)) {
                case "chambre":
                    requeteMaj = "UPDATE " + donnee.get(0) + " SET code_service = '" + donnee.get(1) + "', no_chambre = '" + donnee.get(2) + "', surveillant = '" + donnee.get(3) + "' WHERE condition";
                    break;
                case "docteur":
                    requeteMaj = "UPDATE " + donnee.get(0) + " SET numero = '" + donnee.get(1) + "', specialite = '" + donnee.get(2) + "' WHERE condition";
                    break;
                case "employe":
                    requeteMaj = "UPDATE " + donnee.get(0) + " SET numero = '" + donnee.get(1) + "', nom = '" + donnee.get(2) + "', prenom = '" + donnee.get(3) + "', adresse = '" + donnee.get(4) + "', tel = '" + donnee.get(5) + "' WHERE condition";
                    break;
                case "hospitalisation":
                    requeteMaj = "UPDATE " + donnee.get(0) + " SET no_malade = '" + donnee.get(1) + "', code_service = '" + donnee.get(2) + "', no_chambre = '" + donnee.get(3) + "', lit = '" + donnee.get(4) + "' WHERE condition";
                    break;
                case "infirmier":
                    requeteMaj = "UPDATE " + donnee.get(0) + " SET numero = '" + donnee.get(1) + "', code_service = '" + donnee.get(2) + "', rotation = '" + donnee.get(3) + "', salaire = '" + donnee.get(4) + "' WHERE condition";
                    break;
                case "malade":
                    requeteMaj = "UPDATE " + donnee.get(0) + " SET numero = '" + donnee.get(1) + "', nom = '" + donnee.get(2) + "', prenom = '" + donnee.get(3) + "', adresse = '" + donnee.get(4) + "', tel = '" + donnee.get(5) + "', mutuelle = '" + donnee.get(6) + "' WHERE condition";
                    break;
                case "service":
                    requeteMaj = "UPDATE " + donnee.get(0) + " SET code = '" + donnee.get(1) + "', nom = '" + donnee.get(2) + "', batiment = '" + donnee.get(3) + "', directeur = '" + donnee.get(4) + "' WHERE condition";
                    break;
                case "soigne":
                    requeteMaj = "UPDATE " + donnee.get(0) + " SET no_docteur = '" + donnee.get(1) + "', no_malade = '" + donnee.get(2) + "' WHERE condition";
                    break;
                default:
                    break;
            }
        }
        return requeteMaj;

    }

    public String ajouter(ArrayList<String> donnee) {
        if (null != donnee.get(0)) {
            switch (donnee.get(0)) {
                case "chambre":
                    requeteMaj = "INSERT INTO " + donnee.get(0) + " (code_service, no_chambre, surveillant) VALUES ('" + donnee.get(1) + "', '" + donnee.get(2) + "', '" + donnee.get(3) + "')";
                    break;
                case "docteur":
                    requeteMaj = "INSERT INTO " + donnee.get(0) + " (numero, specialite) VALUES ('" + donnee.get(1) + "', '" + donnee.get(2) + "')";
                    break;
                case "employe":
                    requeteMaj = "INSERT INTO " + donnee.get(0) + " (numero, nom, prenom, adresse, tel) VALUES ('" + donnee.get(1) + "', '" + donnee.get(2) + "', '" + donnee.get(3) + "', '" + donnee.get(4) + "', '" + donnee.get(5) + "')";
                    break;
                case "hospitalisation":
                    requeteMaj = "INSERT INTO " + donnee.get(0) + " (no_malade, code_service, no_chambre, lit) VALUES ('" + donnee.get(1) + "', '" + donnee.get(2) + "', '" + donnee.get(3) + "', '" + donnee.get(4) + "')";
                    break;
                case "infirmier":
                    requeteMaj = "INSERT INTO " + donnee.get(0) + " (numero, code_service, rotation, salaire) VALUES ('" + donnee.get(1) + "', '" + donnee.get(2) + "', '" + donnee.get(3) + "', '" + donnee.get(4) + "')";
                    break;
                case "malade":
                    requeteMaj = "INSERT INTO " + donnee.get(0) + " (numero, nom, prenom, adresse, tel, mutuelle) VALUES ('" + donnee.get(1) + "', '" + donnee.get(2) + "', '" + donnee.get(3) + "', '" + donnee.get(4) + "', '" + donnee.get(5) + "', '" + donnee.get(6) + "')";
                    break;
                case "service":
                    requeteMaj = "INSERT INTO " + donnee.get(0) + " (code, nom, batiment, directeur) VALUES ('" + donnee.get(1) + "', '" + donnee.get(2) + "', '" + donnee.get(3) + "', '" + donnee.get(4) + "')";
                    break;
                case "soigne":
                    requeteMaj = "INSERT INTO " + donnee.get(0) + " (no_docteur, no_malade) VALUES ('" + donnee.get(1) + "', '" + donnee.get(2) + "')";
                    break;
                default:
                    break;
            }
        }
        return requeteMaj;
    }
}
