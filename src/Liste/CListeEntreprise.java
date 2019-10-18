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

    public int insererEntreprise(CEntreprise numero) {
        if (numero != null) {
            this.listeEntreprise.add(numero);
            return 1;
        }
        return -1;
    }
    
    public int supprimerEntreprise(CEntreprise numero) {
        if (numero != null) {
            this.listeEntreprise.remove(numero);
            return 1;
        }
        return -1;
    }
    
    public void afficherActiviteCompl() {
        for (int i = 0; i < this.listeEntreprise.size(); i++) {
            System.out.println(this.getListeEntreprise().get(i).getId());
            System.out.println(this.getListeEntreprise().get(i).getNom());
            System.out.println(this.getListeEntreprise().get(i).getAdresse());
            System.out.println(this.getListeEntreprise().get(i).getVille());
            System.out.println(this.getListeEntreprise().get(i).getDateRelance());
            System.out.println(this.getListeEntreprise().get(i).getRelanceEffectuee());
        }
    }
    
}
