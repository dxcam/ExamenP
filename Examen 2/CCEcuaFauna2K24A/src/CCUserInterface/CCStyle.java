package CCUserInterface;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public abstract class CCStyle {
    /* 
    public static final Color COLOR_FONT = new Color(0, 100, 50); //(218, 8, 40)
    public static final Color COLOR_FONT_LIGHT = new Color(0, 100, 100);
    public static final Color COLOR_CURSOR = Color.black;
    public static final Color COLOR_BORDER = Color.lightGray;
    public static final Font  FONT         = new Font("JetBrains Mono", Font.PLAIN, 14);
    public static final Font  FONT_BOLD    = new Font("JetBrains Mono", Font.BOLD | Font.PLAIN, 14);
    public static final Font  FONT_SMALL   = new Font("JetBrains Mono", Font.PLAIN| Font.PLAIN, 10);

    public static final int ALIGNMENT_LEFT  = SwingConstants.LEFT;
    public static final int ALIGNMENT_RIGHT = SwingConstants.RIGHT;
    public static final int ALIGNMENT_CENTER= SwingConstants.CENTER;

    public static final Cursor CURSOR_HAND    = new Cursor(Cursor.HAND_CURSOR);
    public static final Cursor CURSOR_DEFAULT = new Cursor(Cursor.DEFAULT_CURSOR);

    //public static final URL URL_MAIN  = CCStyle.class.getResource("/UserInterface/Resource/Img/IABot.png");
    //public static final URL URL_LOGO  = CCStyle.class.getResource("/UserInterface/Resource/Img/Logo.png");
    public static final URL URL_SPLASH= CCStyle.class.getResource("/CCUserInterface/CCResource/CCSplash.png");

    public static final CompoundBorder createBorderRect(){
        return BorderFactory.createCompoundBorder(  new LineBorder(Color.lightGray),
                                                    new EmptyBorder(5, 5, 5, 5));
    }

    public static final void showMsg(String msg){
        JOptionPane.showMessageDialog(null, msg, "😏 IABot", JOptionPane.INFORMATION_MESSAGE);
    }
    public static final void showMsgError(String msg){
        JOptionPane.showMessageDialog(null, msg, "💀 IABot", JOptionPane.OK_OPTION);
    }
    public static final boolean showConfirmYesNo(String msg){
        return (JOptionPane.showConfirmDialog(null, msg, "😞 IABot", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
    }
    */

    // Colores personalizados
    public static final Color COLOR_FONT = new Color(0, 0, 0);
    public static final Color COLOR_FONT_LIGHT = new Color(0, 100, 100);
    public static final Color COLOR_CURSOR = Color.black;
    public static final Color COLOR_BORDER = Color.lightGray;
   

    // Fuentes personalizadas
    public static final Font FONT = new Font("Calibri", Font.PLAIN, 14);
    public static final Font FONT_BOLD = new Font("Candara", Font.BOLD, 16);
    public static final Font FONT_SMALL = new Font("Arial", Font.PLAIN, 12);

    // Alineación
    public static final int ALIGNMENT_LEFT = SwingConstants.LEFT;
    public static final int ALIGNMENT_RIGHT = SwingConstants.RIGHT;
    public static final int ALIGNMENT_CENTER = SwingConstants.CENTER;

    // Cursores personalizados
    public static final Cursor CURSOR_HAND = new Cursor(Cursor.HAND_CURSOR);
    public static final Cursor CURSOR_DEFAULT = new Cursor(Cursor.DEFAULT_CURSOR);

    public static final URL URL_SPLASH= CCStyle.class.getResource("/CCUserInterface/CCResource/CCSplash.png");
    public static final URL URL_LOGO  = CCStyle.class.getResource("/CCUserInterface/CCResource/CCLogo.png");

    //Métodos para crear bordes personalizados
    public static final CompoundBorder createBorderRect() {
        return BorderFactory.createCompoundBorder(
            new LineBorder(COLOR_BORDER),
            new EmptyBorder(5, 5, 5, 5)
        );
    }
}
