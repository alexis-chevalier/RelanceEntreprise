package Metier;

import Entites.CMailGmail;

/**
 *
 * @author Alexis
 */
public class CMetierMail {

    CMailGmail mail = new CMailGmail();

    public void envoieMail(String texte,String sujet) {
        mail.sendMail(texte,sujet);
    }

}
