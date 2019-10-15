/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
