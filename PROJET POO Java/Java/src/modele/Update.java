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
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Albert
 */
public class Update {
   
    private Connexion local;
    private boolean valider;
    private String requeteMaj;
    private ResultSet rSet;
    private ArrayList<String> donnee;
    
    
    public Update(){
        try {
            local = new Connexion("projet", "root", "");
            valider = false;
            requeteMaj = "";
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Recherche.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Update(Connexion local){
        this.local=local;
        valider = false;
        requeteMaj = "";
    }
    
    public void modifier(ArrayList<String> donnee){
        if (null != donnee.get(0))switch (donnee.get(0)) {
            case "chambre":
                requeteMaj = "UPDATE "+donnee.get(0)+" SET code_service = '"+donnee.get(1)+"', no_chambre = '"+donnee.get(2)+"', surveillant = '"+donnee.get(3)+"' WHERE condition";
                break;
            case "docteur":
                requeteMaj = "UPDATE "+donnee.get(0)+" SET numero = '"+donnee.get(1)+"', specialite = '"+donnee.get(2)+"' WHERE condition";
                break;
            case "employe":
                requeteMaj = "UPDATE "+donnee.get(0)+" SET numero = '"+donnee.get(1)+"', nom = '"+donnee.get(2)+"', prenom = '"+donnee.get(3)+"', adresse = '"+donnee.get(4)+"', tel = '"+donnee.get(5)+"' WHERE condition";
                break;
            case "hospitalisation":
                requeteMaj = "UPDATE "+donnee.get(0)+" SET no_malade = '"+donnee.get(1)+"', code_service = '"+donnee.get(2)+"', no_chambre = '"+donnee.get(3)+"', lit = '"+donnee.get(4)+"' WHERE condition";
                break;
            case "infirmier":
                requeteMaj = "UPDATE "+donnee.get(0)+" SET numero = '"+donnee.get(1)+"', code_service = '"+donnee.get(2)+"', rotation = '"+donnee.get(3)+"', salaire = '"+donnee.get(4)+"' WHERE condition";
                break;
            case "malade":
                requeteMaj = "UPDATE "+donnee.get(0)+" SET numero = '"+donnee.get(1)+"', nom = '"+donnee.get(2)+"', prenom = '"+donnee.get(3)+"', adresse = '"+donnee.get(4)+"', tel = '"+donnee.get(5)+"', mutuelle = '"+donnee.get(6)+"' WHERE condition";
                break;
            case "service":
                requeteMaj = "UPDATE "+donnee.get(0)+" SET code = '"+donnee.get(1)+"', nom = '"+donnee.get(2)+"', batiment = '"+donnee.get(3)+"', directeur = '"+donnee.get(4)+"' WHERE condition";
                break;
            case "soigne":
                requeteMaj = "UPDATE "+donnee.get(0)+" SET no_docteur = '"+donnee.get(1)+"', no_malade = '"+donnee.get(2)+"' WHERE condition";
                break;
            default:
                break;
        }
            
        for (int i=0; i<donnee.size();i++)
        {
            donnee.get(i);
        }
        requeteMaj = "UPDATE table SET colonne_1 = 'valeur 1', colonne_2 = 'valeur 2', colonne_3 = 'valeur 3' WHERE condition";
       
    }
}
