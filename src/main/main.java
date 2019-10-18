/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Entites.CEntreprise;
import Entites.CSystemTray;
import Frame.JFrameMain;
import Metier.CMetierEntreprise;
import Metier.CMetierMail;
import Metier.CMetierNotification;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

/**
 *
 * @author Alexis
 */
public class main {

    CMetierEntreprise metierEntreprise = new CMetierEntreprise();
    CMetierMail metierMail = new CMetierMail();
    CMetierNotification metierNotification = new CMetierNotification();

    //Vérifie les dates de relance, si la date de relance est la date actuelle alors un mail est envoyé et une notification est affichée.
    public void regarderDate() {
        boolean notification = false;
        try (InputStream input = new FileInputStream("parametres.properties")) {
            Properties prop = new Properties();

            prop.load(input);

            notification = Boolean.parseBoolean(prop.getProperty("notification"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        if (notification) {
            ArrayList<CEntreprise> listeEntreprise = metierEntreprise.RecupererListeEntreprise();
            Long millis = System.currentTimeMillis();
            Date date = new Date(millis);
            String dateAujourdhui = new SimpleDateFormat("dd/MM/yyyy").format(date);
            for (int i = 0; i < listeEntreprise.size(); i++) {
                if (listeEntreprise.get(i).getDateRelance().equals(dateAujourdhui)) {
                    if (listeEntreprise.get(i).getRelanceEffectuee() == false) {
                        metierNotification.afficherNotification("Relance", "Relance pour l'entreprise " + listeEntreprise.get(i).getNom());
                        metierMail.envoieMail("Faire la relance pour l'entreprise " + listeEntreprise.get(i).getNom() + " située à "
                                + listeEntreprise.get(i).getVille() + " aujourd'hui ("
                                + dateAujourdhui + ") !", "Relance "
                                + listeEntreprise.get(i).getNom());
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        main Main = new main();
        Main.regarderDate();
        JFrameMain frame = new JFrameMain();
        CSystemTray tray = new CSystemTray();
    }

}
