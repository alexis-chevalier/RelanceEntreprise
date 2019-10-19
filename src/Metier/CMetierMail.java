package Metier;

import Entites.CMailGmail;

/**
 *
 * @author Alexis
 */
public class CMetierMail {

    CMailGmail mail = new CMailGmail();

    /**
     * Permet d'envoyé un mail.
     * @param texte
     * @param sujet 
     */
    public void envoieMail(String texte,String sujet) {
        mail.sendMail(texte,sujet);
    }

}
