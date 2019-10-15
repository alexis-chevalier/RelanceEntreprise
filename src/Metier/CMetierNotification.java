/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import Entites.CNotification;
import java.awt.AWTException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexis
 */
public class CMetierNotification {

    CNotification notification = new CNotification();

    public void afficherNotification(String titre, String texte) {
        try {
            notification.displayTray(titre, texte);
        } catch (AWTException ex) {
            Logger.getLogger(CMetierNotification.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
