import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
//import javax.swing.UIManager;
//import javax.swing.UnsupportedLookAndFeelException;

import CCUserInterface.CCForm.CCSplashScreenForm;
//import DataAccess.CCHormigaDAO;
import DataAccess.DTO.CCCatalogoDTO;
import DataAccess.DTO.CCHormigaDTO;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    public static void main(String[] args) throws Exception {

        //CCSplashScreenForm.show();

         // Crear la ventana principal
         JFrame frame = new JFrame("Login");
         frame.setSize(300, 150);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setLayout(null);
 
         // Centrar la ventana en la pantalla
         frame.setLocationRelativeTo(null);
 
         // Crear los componentes
         JLabel userLabel = new JLabel("Usuario:");
         userLabel.setBounds(10, 10, 80, 25);
         frame.add(userLabel);
 
         JTextField userText = new JTextField();
         userText.setBounds(100, 10, 165, 25);
         frame.add(userText);
 
         JLabel passwordLabel = new JLabel("Contraseña:");
         passwordLabel.setBounds(10, 40, 80, 25);
         frame.add(passwordLabel);
 
         JPasswordField passwordText = new JPasswordField();
         passwordText.setBounds(100, 40, 165, 25);
         frame.add(passwordText);
 
         JButton loginButton = new JButton("Login");
         loginButton.setBounds(10, 80, 255, 25);
         frame.add(loginButton);
 
         // Agregar la acción al botón
         loginButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 String username = userText.getText();
                 String password = new String(passwordText.getPassword());
 
                 // Encriptar la contraseña
                 String encryptedPassword = encryptPassword(password);
 
                 
                // Verificar credenciales
                if (verifyCredentials(username, encryptedPassword)) {
                    JOptionPane.showMessageDialog(frame, "Login exitoso!");
                    frame.dispose(); // Cerrar la ventana

                    // Mostrar el menú
                    //SwingUtilities.invokeLater(PMEcuaFauna2K24A::new);
                } else {
                    JOptionPane.showMessageDialog(frame, "Credenciales incorrectas.");
                }
            }
        });

         // Mostrar la ventana
         frame.setVisible(true);
     }
 
     // Método para encriptar la contraseña
     private static String encryptPassword(String password) {
         try {
             MessageDigest md = MessageDigest.getInstance("SHA-256");
             byte[] hash = md.digest(password.getBytes());
             StringBuilder sb = new StringBuilder();
             for (byte b : hash) {
                 sb.append(String.format("%02x", b));
             }
             return sb.toString();
         } catch (NoSuchAlgorithmException e) {
             e.printStackTrace();
             return null;
         }
     }
 
     // Método para verificar las credenciales (ejemplo básico)
     private static boolean verifyCredentials(String username, String encryptedPassword) {
         // Aquí deberías conectar con una base de datos o un archivo para verificar las credenciales.
         // Este es solo un ejemplo con credenciales fijas para demostración.
         String correctUsername = "Camila";
         String correctPassword = encryptPassword("abcd");
 
         return username.equals(correctUsername) && encryptedPassword.equals(correctPassword);
     }
       
        //FlatLightLaf.setup();
        //try {
        //    UIManager.setLookAndFeel(new FlatLightLaf());
        //} catch (UnsupportedLookAndFeelException e) {
        //    e.printStackTrace();
        //}

        /*try {
            XXHormigaDAO hoorDAO  = new XXHormigaDAO();
            for (XXHormigaDTO hormiga : hoorDAO.readAll()) {
                System.out.println(hormiga);
            }
        } catch (Exception e) {
            System.err.println("Error al leer las hormigas: " + e.getMessage());
            e.printStackTrace();
        }*/
}

