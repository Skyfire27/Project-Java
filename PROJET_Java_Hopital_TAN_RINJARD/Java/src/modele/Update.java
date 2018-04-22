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
public class Update {

    private Connexion local; //Variable nécessaire pour obtenir une connexion avec la bdd
    private String requeteMaj;

    /**
     * Constructeur par défaut
     */
    public Update() {
        try {
            local = new Connexion("projet", "root", "");
            requeteMaj = "";
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Recherche.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Constructeur surchargé par local 
     * @param local variable de type Connexion
     */
    public Update(Connexion local) {
        this.local = local;
        requeteMaj = "";
    }


    /**
     * Methode qui va executer la mise a jour de la base de donnée avec la requete saisie
     * @param requete variable de typeString
     */
    public void executerRequete(String requete) {
        System.out.println(requete);
        try {
            local.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Methode qui va transformer les données récupérer en une requête de modification selon la demande
     * @param donnee variable de type ArrayList de String
     * @return requeteMaj variable de type String
     */
    public String modifier(ArrayList<String> donnee) {
        if (null != donnee.get(0)) {
            switch (donnee.get(0)) {
                case "chambre":
                    //requete SQL qui permet de modifier la table
                    requeteMaj = "UPDATE " + donnee.get(0) + " SET code_service = '" + donnee.get(1) + "', surveillant = '" + donnee.get(3) + "', nb_lits = '" + donnee.get(4) +"' WHERE no_chambre = '" + donnee.get(2) + "'";
                    break;
                case "docteur":
                    requeteMaj = "UPDATE " + donnee.get(0) + " SET specialite = '" + donnee.get(2) + "' WHERE numero = '" + donnee.get(1) + "'";
                    break;
                case "employe":
                    requeteMaj = "UPDATE " + donnee.get(0) + " SET nom = '" + donnee.get(2) + "', prenom = '" + donnee.get(3) + "', adresse = '" + donnee.get(4) + "', tel = '" + donnee.get(5) + "' WHERE numero = '" + donnee.get(1) + "'";
                    break;
                case "hospitalisation":
                    requeteMaj = "UPDATE " + donnee.get(0) + " SET code_service = '" + donnee.get(2) + "', no_chambre = '" + donnee.get(3) + "', lit = '" + donnee.get(4) + "' WHERE no_malade = '" + donnee.get(1) + "'";
                    break;
                case "infirmier":
                    requeteMaj = "UPDATE " + donnee.get(0) + " SET code_service = '" + donnee.get(2) + "', rotation = '" + donnee.get(3) + "', salaire = '" + donnee.get(4) + "' WHERE numero = '" + donnee.get(1) + "'";
                    break;
                case "malade":
                    requeteMaj = "UPDATE " + donnee.get(0) + " SET nom = '" + donnee.get(2) + "', prenom = '" + donnee.get(3) + "', adresse = '" + donnee.get(4) + "', tel = '" + donnee.get(5) + "', mutuelle = '" + donnee.get(6) + "' WHERE numero = '" + donnee.get(1) + "'";
                    break;
                case "service":
                    requeteMaj = "UPDATE " + donnee.get(0) + " SET nom = '" + donnee.get(2) + "', batiment = '" + donnee.get(3) + "', directeur = '" + donnee.get(4) + "' WHERE code = '" + donnee.get(1) + "'";
                    break;
                case "soigne":
                    requeteMaj = "UPDATE " + donnee.get(0) + " SET no_docteur = '" + donnee.get(1) + "' WHERE no_malade = '" + donnee.get(2) + "'";
                    break;
                default:
                    break;
            }
        }
        return requeteMaj;
    }
    
    /**
     * Methode qui va transformer les données récupérer pour supprimer une ligne contenant une info selon la demande
     * @param donnee variable de type ArrayList de String
     * @return requeteMaj variable de type String
     */
    public String suppression(ArrayList<String> donnee){
        if (null != donnee.get(0)) {
            switch (donnee.get(0)) {
                case "chambre":
                    //requete SQL qui permet de supprimer une ligne de la table (prend le premier element de la table en referance)
                    requeteMaj = "DELETE from " + donnee.get(0) + " WHERE no_chambre = '" + donnee.get(2) + "'";
                    break;
                case "docteur":
                    requeteMaj = "DELETE from " + donnee.get(0) + " WHERE numero = '" + donnee.get(1) + "'";
                    break;
                case "employe":
                    requeteMaj = "DELETE from " + donnee.get(0) + " WHERE numero = '" + donnee.get(1) + "'";
                    break;
                case "hospitalisation":
                    requeteMaj = "DELETE from " + donnee.get(0) + " WHERE no_malade = '" + donnee.get(1) + "'";
                    break;
                case "infirmier":
                    requeteMaj = "DELETE from " + donnee.get(0) + " WHERE numero = '" + donnee.get(1) + "'";
                    break;
                case "malade":
                    requeteMaj = "DELETE from " + donnee.get(0) + " WHERE numero = '" + donnee.get(1) + "'";
                    break;
                case "service":
                    requeteMaj = "DELETE from " + donnee.get(0) + " WHERE code = '" + donnee.get(1) + "'";
                    break;
                case "soigne":
                    requeteMaj = "DELETE from " + donnee.get(0) + " WHERE no_malade = '" + donnee.get(2) + "'";
                    break;
                default:
                    break;
            }
        }
        return requeteMaj;
    }

    /**
     * Methode qui va transformer les données récupérer en une requête de mise a jour selon la demande
     * @param donnee variable de type ArrayList de String
     * @return requeteMaj variable de type String
     */
    public String ajouter(ArrayList<String> donnee) {
        if (null != donnee.get(0)) { //verifier que la saisie est pas null, même si elle est forcement non nulle.
            switch (donnee.get(0)) { //recupère la premier valeur de l'arraylist donnee
                case "chambre":
                    //requete SQL qui permet d'ajouter dans la table
                    requeteMaj = "INSERT INTO " + donnee.get(0) + " (code_service, no_chambre, surveillant, nb_lits) VALUES ('" + donnee.get(1) + "', '" + donnee.get(2) + "', '" + donnee.get(3) +  "', '" + donnee.get(4) +"')";
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
