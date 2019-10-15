/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Table;

import Entites.CEntreprise;
import Entites.CRelance;
import Liste.CListeEntreprise;
import bdd.CBDD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Alexis
 */
public class CTableEntreprise {

    protected CBDD bdd;

    public CTableEntreprise() {
    }

    public CBDD getBdd() {
        return bdd;
    }

    public void setBdd(CBDD bdd) {
        this.bdd = bdd;
    }

    public CTableEntreprise(CBDD bdd) {
        this.setBdd(bdd);
    }

    public int insererEntreprise(CEntreprise entreprise) {
        String req = "INSERT INTO `entreprise` (`id`, `Nom`, `Adresse`, `Ville`, `date_relance`,`relance_effectuee`) VALUES (NULL, '" + entreprise.getNom() + "', '" + entreprise.getAdresse() + "', '" + entreprise.getVille() + "', '" + entreprise.getDateRelance() + "', " + entreprise.getRelanceEffectuee() + ")";
        int res = -1;
        if (bdd.connecter() == true) {
            res = bdd.executerRequeteUpdate(req);
            System.out.println("Res = " + res);
            //System.out.println(req);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }

    CEntreprise convertirEntreprise(ResultSet rs) {
        try {
            int id = rs.getInt("id");
            String nom = rs.getString("Nom");
            String adresse = rs.getString("Adresse");
            String ville = rs.getString("Ville");
            String dateRelance = rs.getString("date_relance");
            boolean relanceEffectuee = rs.getBoolean("relance_effectuee");
            return new CEntreprise(id, nom, adresse, ville, dateRelance, relanceEffectuee);
        } catch (SQLException ex) {
            Logger.getLogger(CEntreprise.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<CEntreprise> lireEntreprises() {
        if (bdd.connecter() == true) {
            ArrayList<CEntreprise> listeEntreprise = new ArrayList();
            ResultSet rs = bdd.executerRequeteQuery("SELECT * FROM `entreprise`;");
            try {
                while (rs.next()) {
                    CEntreprise entreprise = convertirEntreprise(rs);
                    listeEntreprise.add(entreprise);
                }
            } catch (SQLException ex) {
            }
            bdd.deconnecter();
            return listeEntreprise;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }

    public void supprimerEntreprise(String nomEntreprise) {
        if (bdd.connecter() == true) {
            bdd.executerRequeteUpdate("DELETE FROM `entreprise` WHERE Nom='" + nomEntreprise + "';");
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
    }

    public String calculDateRelance(String date, int nbJourAjouter) {
        String dateRelance = "";
        Date date1 = new Date(System.currentTimeMillis());
        try {
            date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        } catch (ParseException ex) {
            //A mettre
            System.out.println("La date du jour a été utilisée.");
        }
        if (nbJourAjouter < 1) {
            nbJourAjouter = 7;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date1);
        c.add(Calendar.DATE, nbJourAjouter);
        date1 = c.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        dateRelance = sdf.format(date1);
        System.out.println(dateRelance);
        return dateRelance;
    }

    public void modifierEntreprise(CEntreprise entreprise) {
        String req = "UPDATE `entreprise` SET Adresse='" + entreprise.getAdresse()
                + "',Ville='" + entreprise.getVille()
                + "',date_relance='" + entreprise.getDateRelance()
                + "',relance_effectuee=" + entreprise.getRelanceEffectuee()
                + " WHERE Nom='" + entreprise.getNom() + "';";
        if (bdd.connecter()) {
            bdd.executerRequeteUpdate(req);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
    }

}
