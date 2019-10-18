package Entites;

import Frame.JFrameAjouter;
import Frame.JFrameMain;
import Frame.JFrameParametres;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CSystemTray {
    //src: https://stackoverflow.com/questions/758083/how-do-i-put-a-java-app-in-the-system-tray

    public CSystemTray() {
        //checking for support
        if (!SystemTray.isSupported()) {
            System.out.println("System tray is not supported !!! ");
            return;
        }
        //get the systemTray of the system
        SystemTray systemTray = SystemTray.getSystemTray();

        //get default toolkit
        //Toolkit toolkit = Toolkit.getDefaultToolkit();
        //get image 
        Image image = Toolkit.getDefaultToolkit().getImage("img/robot.png");
        //Image image = Toolkit.getDefaultToolkit().getImage("src/images/1.gif");
        //source: https://media.giphy.com/media/3oEdv1GbekAakxXO8g/source.gif
        //Image image = Toolkit.getDefaultToolkit().getImage("img/source.gif");

        //popupmenu
        PopupMenu trayPopupMenu = new PopupMenu();

        //1t menuitem for popupmenu
        MenuItem liste = new MenuItem("Liste entreprise");
        liste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new JFrameMain().setVisible(true);
            }
        });
        trayPopupMenu.add(liste);
        
        //1t menuitem for popupmenu
        MenuItem ajouter = new MenuItem("Ajouter entreprise");
        ajouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new JFrameAjouter().setVisible(true);
            }
        });
        trayPopupMenu.add(ajouter);

        MenuItem parametre = new MenuItem("Parametres");
        parametre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new JFrameParametres().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(CSystemTray.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        trayPopupMenu.add(parametre);

        //2nd menuitem of popupmenu
        MenuItem close = new MenuItem("Quitter");
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        trayPopupMenu.add(close);

        //setting tray icon
        TrayIcon trayIcon = new TrayIcon(image, "Relance entreprise", trayPopupMenu);
        //adjust to default size as per system recommendation 
        trayIcon.setImageAutoSize(true);

        try {
            systemTray.add(trayIcon);
        } catch (AWTException awtException) {
            awtException.printStackTrace();
        }
    }

    //start of main method
    public static void main(String[] args) {
        CSystemTray system = new CSystemTray();
    }//end of main

}//end of class
