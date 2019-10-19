package Entites;

/**
 *
 * @author Alexis
 */
public class CEntreprise {

    private int id;
    private String nom;
    private String adresse;
    private String ville;
    private String dateRelance;
    private boolean relanceEffectuee;

    public CEntreprise(int id, String nom, String adresse, String ville, String dateRelance, boolean relanceEffectuee) {
        this.setId(id);
        this.setNom(nom);
        this.setAdresse(adresse);
        this.setVille(ville);
        this.setDateRelance(dateRelance);
        this.setRelanceEffectuee(relanceEffectuee);
    }
    
    public CEntreprise(String nom, String adresse, String ville, String dateRelance, boolean relanceEffectuee) {
        this.setId(id);
        this.setNom(nom);
        this.setAdresse(adresse);
        this.setVille(ville);
        this.setDateRelance(dateRelance);
        this.setRelanceEffectuee(relanceEffectuee);
    }

    public String getDateRelance() {
        return dateRelance;
    }

    public void setDateRelance(String dateRelance) {
        this.dateRelance = dateRelance;
    }

    public boolean getRelanceEffectuee() {
        return relanceEffectuee;
    }

    public void setRelanceEffectuee(boolean relanceEffectuee) {
        this.relanceEffectuee = relanceEffectuee;
    }

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the value of ville
     *
     * @return the value of ville
     */
    public String getVille() {
        return ville;
    }

    /**
     * Set the value of ville
     *
     * @param Ville new value of ville
     */
    public void setVille(String Ville) {
        this.ville = Ville;
    }

    /**
     * Get the value of adresse
     *
     * @return the value of adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Set the value of adresse
     *
     * @param Adresse new value of adresse
     */
    public void setAdresse(String Adresse) {
        this.adresse = Adresse;
    }

    /**
     * Get the value of nom
     *
     * @return the value of nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Set the value of nom
     *
     * @param Nom new value of nom
     */
    public void setNom(String Nom) {
        this.nom = Nom;
    }

}
