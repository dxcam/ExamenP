package CCUserInterface.CCForm;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import CCUserInterface.CCStyle;

import java.awt.BorderLayout;

public class CCSplashScreenForm {
    private static JFrame       frmSplash;
    private static JProgressBar prbLoaging;
    private static ImageIcon    icoImagen ;
    private static JLabel       lblSplash ;

    public static void show() {
        icoImagen  = new ImageIcon(CCStyle.URL_SPLASH);
        lblSplash  = new JLabel(icoImagen);
        prbLoaging = new JProgressBar(0, 100);

        prbLoaging.setStringPainted(true);
        
        frmSplash = new JFrame();
        frmSplash.setUndecorated(true);
        frmSplash.getContentPane().add(lblSplash, BorderLayout.CENTER);
        frmSplash.add(prbLoaging, BorderLayout.SOUTH);
        frmSplash.setSize(icoImagen.getIconWidth(), icoImagen.getIconHeight());
        frmSplash.setLocationRelativeTo(null); // Centrar en la pantalla

        frmSplash.setVisible(true);
        for (int i = 0; i <= 100; i++) {
            try {
                Thread.sleep(30); // Espera por 50 milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            prbLoaging.setValue(i);
        }
        frmSplash.setVisible(false);
    }
}



