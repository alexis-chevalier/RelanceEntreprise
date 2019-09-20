/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import Entites.CEntreprise;
import Table.CTableEntreprise;
import bdd.CBDD;
import bdd.CParametresStockageBDD;
import java.util.ArrayList;

/**
 *
 * @author Alexis
 */
public class CMetierEntreprise {

    public ArrayList<CEntreprise> RecupererListeEntreprise() {
        CBDD bdd = new CBDD(new CParametresStockageBDD("parametresBdd.properties"));
        CTableEntreprise tableEntreprise = new CTableEntreprise();
        tableEntreprise.setBdd(bdd);
        ArrayList<CEntreprise> liste = tableEntreprise.lireEntreprises();
        return liste;
    }

    public void InsererEntreprise(CEntreprise entreprise) {
        CBDD bdd = new CBDD(new CParametresStockageBDD("parametresBdd.properties"));
        CTableEntreprise tableEntreprise = new CTableEntreprise();
        tableEntreprise.setBdd(bdd);
        tableEntreprise.insererEntreprise(entreprise);
    }
    
    public void SupprimerEntreprise(String nomEntreprise){
        CBDD bdd = new CBDD(new CParametresStockageBDD("parametresBdd.properties"));
        CTableEntreprise tableEntreprise = new CTableEntreprise();
        tableEntreprise.setBdd(bdd);
        tableEntreprise.supprimerEntreprise(nomEntreprise);
    }
    

    public static void main(String[] args) {
        CMetierEntreprise metier = new CMetierEntreprise();
        CEntreprise entreprise = new CEntreprise("abcd","adresse","ville","01/01/2005",false);
        metier.InsererEntreprise(entreprise);
    }
    
}
