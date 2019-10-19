package Liste;

import Entites.CEntreprise;
import java.util.ArrayList;

/**
 *
 * @author Alexis
 */
public class CListeEntreprise {
    
    public ArrayList<CEntreprise> listeEntreprise = new ArrayList();
    
    public ArrayList<CEntreprise> getListeEntreprise() {
        return listeEntreprise;
    }

    public void setListeEntreprise(ArrayList<CEntreprise> listeEntreprise) {
        this.listeEntreprise = listeEntreprise;
    }

    /**
     * Insère l'entreprise donnée en paramètre dans la liste.
     * @param entreprise une entreprise CEntreprise.
     * @return -1 s'il y a une erreur.
     */
    public int insererEntreprise(CEntreprise entreprise) {
        if (entreprise != null) {
            this.listeEntreprise.add(entreprise);
            return 1;
        }
        return -1;
    }
    
    /**
     * Supprime l'entreprise de la liste
     * @param entreprise une entreprise CEntreprise.
     * @return -1 s'il y a une erreur
     */
    public int supprimerEntreprise(CEntreprise entreprise) {
        if (entreprise != null) {
            this.listeEntreprise.remove(entreprise);
            return 1;
        }
        return -1;
    }
    
    /**
     * 
     */
    /*public void afficherActiviteCompl() {
        for (int i = 0; i < this.listeEntreprise.size(); i++) {
            System.out.println(this.getListeEntreprise().get(i).getId());
            System.out.println(this.getListeEntreprise().get(i).getNom());
            System.out.println(this.getListeEntreprise().get(i).getAdresse());
            System.out.println(this.getListeEntreprise().get(i).getVille());
            System.out.println(this.getListeEntreprise().get(i).getDateRelance());
            System.out.println(this.getListeEntreprise().get(i).getRelanceEffectuee());
        }
    }*/
    
}
