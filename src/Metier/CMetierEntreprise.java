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

    /**
     * Récupère la liste des entreprises depuis la base de données.
     * @return une liste de Centreprise.
     */
    public ArrayList<CEntreprise> RecupererListeEntreprise() {
        CBDD bdd = new CBDD(new CParametresStockageBDD("parametresBdd.properties"));
        CTableEntreprise tableEntreprise = new CTableEntreprise();
        tableEntreprise.setBdd(bdd);
        ArrayList<CEntreprise> liste = tableEntreprise.lireEntreprises();
        return liste;
    }

    /**
     * Insère une entreprise dans la base de données.
     * @param entreprise une CEntreprise.
     */
    public void InsererEntreprise(CEntreprise entreprise) {
        CBDD bdd = new CBDD(new CParametresStockageBDD("parametresBdd.properties"));
        CTableEntreprise tableEntreprise = new CTableEntreprise();
        tableEntreprise.setBdd(bdd);
        tableEntreprise.insererEntreprise(entreprise);
    }

    /**
     * Supprime une entreprise grâce à son nom.
     * @param nomEntreprise Le nom de l'entreprise sous forme d'une chaîne de caractères.
     */
    public void SupprimerEntreprise(String nomEntreprise) {
        CBDD bdd = new CBDD(new CParametresStockageBDD("parametresBdd.properties"));
        CTableEntreprise tableEntreprise = new CTableEntreprise();
        tableEntreprise.setBdd(bdd);
        tableEntreprise.supprimerEntreprise(nomEntreprise);
    }

    /**
     * Calcule la date de relance.
     * @param date Date du jour.
     * @param nbAjouter Nombre de jours à ajouter à la date.
     * @return La date de relance (String).
     */
    public String calculDateRelance(String date, int nbAjouter) {
        CTableEntreprise tableEntreprise = new CTableEntreprise();
        String dateRelance = tableEntreprise.calculDateRelance(date, nbAjouter);
        return dateRelance;
    }

    /**
     * Modifie l'entreprise donnée en paramètres.
     * @param entreprise une CEntreprise.
     */
    public void ModifierEntreprise(CEntreprise entreprise) {
        CBDD bdd = new CBDD(new CParametresStockageBDD("parametresBdd.properties"));
        CTableEntreprise tableEntreprise = new CTableEntreprise();
        tableEntreprise.setBdd(bdd);
        tableEntreprise.modifierEntreprise(entreprise);
    }

    /**
     * Renvoie les entreprises à relancées sinon null.
     * @return Les entreprises à relancées sous la forme d'une ArrayList.
     */
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
        return listeARelancer;
    }

}
