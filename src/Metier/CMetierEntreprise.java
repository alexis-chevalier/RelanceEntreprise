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

    public void SupprimerEntreprise(String nomEntreprise) {
        CBDD bdd = new CBDD(new CParametresStockageBDD("parametresBdd.properties"));
        CTableEntreprise tableEntreprise = new CTableEntreprise();
        tableEntreprise.setBdd(bdd);
        tableEntreprise.supprimerEntreprise(nomEntreprise);
    }

    public String calculDateRelance(String date, int nbAjouter) {
        CTableEntreprise tableEntreprise = new CTableEntreprise();
        String dateRelance = tableEntreprise.calculDateRelance(date, nbAjouter);
        return dateRelance;
    }
    
    public void ModifierEntreprise(CEntreprise entreprise){
        CBDD bdd = new CBDD(new CParametresStockageBDD("parametresBdd.properties"));
        CTableEntreprise tableEntreprise = new CTableEntreprise();
        tableEntreprise.setBdd(bdd);
        tableEntreprise.modifierEntreprise(entreprise);
    }

}
