package Metier;

import Entites.CEntreprise;
import Table.CTableEntreprise;
import bdd.CBDD;
import bdd.CParametresStockageBDD;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

    public void ModifierEntreprise(CEntreprise entreprise) {
        CBDD bdd = new CBDD(new CParametresStockageBDD("parametresBdd.properties"));
        CTableEntreprise tableEntreprise = new CTableEntreprise();
        tableEntreprise.setBdd(bdd);
        tableEntreprise.modifierEntreprise(entreprise);
    }

    public ArrayList<CEntreprise> EntrepriseARelancer() {
        CBDD bdd = new CBDD(new CParametresStockageBDD("parametresBdd.properties"));
        CTableEntreprise tableEntreprise = new CTableEntreprise();
        tableEntreprise.setBdd(bdd);
        ArrayList<CEntreprise> liste = tableEntreprise.lireEntreprises();
        ArrayList<CEntreprise> listeARelancer = new ArrayList<CEntreprise>();
        Long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        String dateAujourdhui = new SimpleDateFormat("dd/MM/yyyy").format(date);
        for (int i = 0; i < liste.size(); i++) {
            if (liste.get(i).getDateRelance().equals(dateAujourdhui)) {
                if (liste.get(i).getRelanceEffectuee() == false) {
                    System.out.println(liste.get(i).getNom());
                    listeARelancer.add(liste.get(i));
                }
            }
        }
        if (listeARelancer.isEmpty()) {
            listeARelancer = null;
        }
        //System.out.println(listeARelancer.size());
        return listeARelancer;
    }

}
