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
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author Alexis
 */
public class main {

    CMetierEntreprise metierEntreprise = new CMetierEntreprise();
    CMetierMail metierMail = new CMetierMail();

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
            ArrayList<CEntreprise> listeEntreprise = metierEntreprise.EntrepriseARelancer();
            for (int i = 0; i < listeEntreprise.size(); i++) {
                metierMail.envoieMail("Faire la relance pour l'entreprise " + listeEntreprise.get(i).getNom() + " située à "
                        + listeEntreprise.get(i).getVille() + " aujourd'hui  !", "Relance "
                        + listeEntreprise.get(i).getNom());
            }
        }
    }

    public static void main(String[] args) {
        main Main = new main();
        JFrameMain frame = new JFrameMain();
        CSystemTray tray = new CSystemTray();
        frame.setVisible(true);
        Main.regarderDate();
    }

}
