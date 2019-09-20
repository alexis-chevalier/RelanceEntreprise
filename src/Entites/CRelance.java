package Entites;

/**
 *
 * @author Alexis
 */
public class CRelance {

    private int id;
    private String date;
    private boolean statut;

    public CRelance(int id) {
        this.id = id;
    }

    public CRelance(int id, String date, boolean statut) {
        this.id = id;
        this.date = date;
        this.statut = statut;
    }

    /**
     * Get the value of statut
     *
     * @return the value of statut
     */
    public boolean getStatut() {
        return statut;
    }

    /**
     * Set the value of statut
     *
     * @param statut new value of statut
     */
    public void setStatut(boolean statut) {
        this.statut = statut;
    }

    /**
     * Get the value of date
     *
     * @return the value of date
     */
    public String getDate() {
        return date;
    }

    /**
     * Set the value of date
     *
     * @param date new value of date
     */
    public void setDate(String date) {
        this.date = date;
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

}
