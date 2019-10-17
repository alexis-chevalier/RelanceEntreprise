package Entites;

import java.awt.*;
import java.awt.TrayIcon.MessageType;

//source: https://stackoverflow.com/questions/34490218/how-to-make-a-windows-notification-in-java
public class CNotification {

    public void displayTray(String titre, String texte) throws AWTException {
        //Obtain only one instance of the SystemTray object
        SystemTray tray = SystemTray.getSystemTray();

        //If the icon is a file
        Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
        //Alternative (if the icon is on the classpath):
        //Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon.png"));

        TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
        //Let the system resize the image if needed
        trayIcon.setImageAutoSize(true);
        //Set tooltip text for the tray icon
        trayIcon.setToolTip("System tray icon demo");
        tray.add(trayIcon);

        trayIcon.displayMessage(texte, titre, MessageType.INFO);
    }

    /*public static void main(String[] args) throws AWTException {
        if (SystemTray.isSupported()) {
            String titre = "test titre";
            String texte = "test texte";
            CNotification td = new CNotification();
            td.displayTray(titre, texte);
        } else {
            System.err.println("System tray not supported!");
        }
    }*/

}
