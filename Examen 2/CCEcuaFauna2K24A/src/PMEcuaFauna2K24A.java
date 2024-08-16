/*import javax.swing.*;
import java.awt.*;
import CCUserInterface.CCStyle;

public class PMEcuaFauna2K24A extends JFrame {

    public PMEcuaFauna2K24A() {

        private CCHormigaDAO hormigaDAO;

    
        hormigaDAO = new CCHormigaDAO();
        // Configuración básica de la ventana
        setTitle("EcuaFauna 2K24A");
        setSize(550, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel para los datos del estudiante
        JPanel studentPanel = new JPanel(new GridLayout(2, 2, 5, 5)); 
        JPanel subPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        subPanel.setBorder(CCStyle.createBorderRect());  // Usar el borde personalizado
        subPanel.setBackground(new Color(220, 220, 220));

        // Agregar margen alrededor del panel para separar los componentes de los bordes
        studentPanel.setBorder(BorderFactory.createCompoundBorder(
            studentPanel.getBorder(), 
            BorderFactory.createEmptyBorder(30, 30, 10, 30)
        ));
        
        JLabel lblCedula = new JLabel("Cédula:");
        JTextField txtCedula = new JTextField("175271169 - 5");
        lblCedula.setFont(CCStyle.FONT_BOLD);  // Usar la fuente personalizada
        lblCedula.setForeground(CCStyle.COLOR_FONT);  // Cambiar el color de la fuente
        txtCedula.setFont(CCStyle.FONT);
        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField("Camila Daniela Caicedo Alcivar");
        lblNombre.setFont(CCStyle.FONT_BOLD);
        lblNombre.setForeground(CCStyle.COLOR_FONT);
        txtNombre.setFont(CCStyle.FONT);

        subPanel.add(lblCedula);
        subPanel.add(txtCedula);
        subPanel.add(lblNombre);
        subPanel.add(txtNombre);
        studentPanel.add(subPanel);

        // Panel para la sección central que contendrá el logo, botón, hormiguero virtual, y opciones de alimentación
        JPanel centralPanel = new JPanel();
        centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.Y_AXIS));

        // Panel para la sección del logo y el botón de crear hormiga
        JPanel logoAndButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        //logoAndButtonPanel.setBorder(BorderFactory.createTitledBorder("Sección de Experimentos"));
   
        // Logo
        JLabel lblLogo = new JLabel(new ImageIcon(CCStyle.URL_LOGO)); // Reemplaza con la ruta del logo
        logoAndButtonPanel.add(lblLogo);
   
        // Botón de crear hormiga
        JButton btnCrearHormiga = new JButton("Crear Hormiga Larva");

        btnCrearHormiga.setFont(CCStyle.FONT_BOLD);
        btnCrearHormiga.setForeground(CCStyle.COLOR_FONT);
        btnCrearHormiga.setCursor(CCStyle.CURSOR_HAND);  // Cambiar el cursor al pasar por encima del botón
        logoAndButtonPanel.add(btnCrearHormiga);
        
        // Añadir el panel del logo y botón al panel central
        centralPanel.add(logoAndButtonPanel);
   
        // Panel Hormiguero Virtual
        JPanel antPanel = new JPanel(new GridLayout(3, 2));
        antPanel.setBorder(BorderFactory.createTitledBorder("Hormiguero Virtual"));
   
        JLabel lblTipoHormiga = new JLabel("Tipo de Hormiga:");
        lblTipoHormiga.setFont(CCStyle.FONT_BOLD);
        lblTipoHormiga.setForeground(CCStyle.COLOR_FONT);
   
        JTextField txtTipoHormiga = new JTextField(20);
        txtTipoHormiga.setFont(CCStyle.FONT);
   
        JLabel lblSexo = new JLabel("Sexo:");
        lblSexo.setFont(CCStyle.FONT_BOLD);
        lblSexo.setForeground(CCStyle.COLOR_FONT);
   
        JTextField txtSexo = new JTextField(20);
        txtSexo.setFont(CCStyle.FONT);
   
        JLabel lblProvincia = new JLabel("Provincia:");
        lblProvincia.setFont(CCStyle.FONT_BOLD);
        lblProvincia.setForeground(CCStyle.COLOR_FONT);
   
        JTextField txtProvincia = new JTextField(20);
        txtProvincia.setFont(CCStyle.FONT);
   
        antPanel.add(lblTipoHormiga);
        antPanel.add(txtTipoHormiga);
        antPanel.add(lblSexo);
        antPanel.add(txtSexo);
        antPanel.add(lblProvincia);
        antPanel.add(txtProvincia);
        
        // Añadir el panel del hormiguero virtual al panel central
        centralPanel.add(antPanel);
   
        // Panel para las opciones de alimentación
        JPanel foodPanel = new JPanel(new GridLayout(2, 2));
        foodPanel.setBorder(BorderFactory.createTitledBorder("Opciones de Alimentación"));
   
        JLabel lblGenoAlimento = new JLabel("GenoAlimento:");
        lblGenoAlimento.setFont(CCStyle.FONT_BOLD);
        lblGenoAlimento.setForeground(CCStyle.COLOR_FONT);
   
        JComboBox<String> comboGenoAlimento = new JComboBox<>(new String[] {"X", "XX", "XY"});
        comboGenoAlimento.setFont(CCStyle.FONT);
   
        JLabel lblIngestaNativa = new JLabel("Ingesta Nativa:");
        lblIngestaNativa.setFont(CCStyle.FONT_BOLD);
        lblIngestaNativa.setForeground(CCStyle.COLOR_FONT);
   
        JComboBox<String> comboIngestaNativa = new JComboBox<>(new String[] {"Carnívoro", "Herbívoro", "Omnívoro", "Insectívoro"});
        comboIngestaNativa.setFont(CCStyle.FONT);
   
        foodPanel.add(lblGenoAlimento);
        foodPanel.add(comboGenoAlimento);
        foodPanel.add(lblIngestaNativa);
        foodPanel.add(comboIngestaNativa);
        
        // Añadir el panel de alimentación al panel central
        centralPanel.add(foodPanel);
   
        // Panel para botones de eliminar y guardar
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setFont(CCStyle.FONT_BOLD);
        btnEliminar.setForeground(CCStyle.COLOR_FONT);
        buttonPanel.add(btnEliminar);
   
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(CCStyle.FONT_BOLD);
        btnGuardar.setForeground(CCStyle.COLOR_FONT);
        buttonPanel.add(btnGuardar);
        
        // Agregar los paneles a la ventana
        add(studentPanel, BorderLayout.NORTH);
        add(centralPanel, BorderLayout.CENTER);  // Añadir el panel central al centro
        add(buttonPanel, BorderLayout.SOUTH);


        private void setupListeners() {
        btnCrearHormiga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipoHormiga = txtTipoHormiga.getText();
                String sexo = txtSexo.getText();
                String provincia = txtProvincia.getText();
                String genoAlimento = comboGenoAlimento.getSelectedItem().toString();
                String ingestaNativa = comboIngestaNativa.getSelectedItem().toString();

                hormigaDAO.crearHormiga(tipoHormiga, sexo, provincia, genoAlimento, ingestaNativa);
            }
        });

        btnAlimentarHormiga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idHormiga = Integer.parseInt(txtIdHormiga.getText());
                String alimento = comboAlimento.getSelectedItem().toString();

                hormigaDAO.alimentarHormiga(idHormiga, alimento);
            }
        });
    }

    // Métodos adicionales para configurar la GUI y otras funcionalidades
}
   
        // Mostrar la ventana
        setVisible(true);
    }
}
*/
/* 
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import CCUserInterface.CCStyle;

public class PMEcuaFauna2K24A extends JFrame {

    // Declara CCHormigaDAO como una variable de instancia de la clase
    private CCHormigaDAO hormigaDAO;

    // Componentes de la interfaz
    private JTextField txtTipoHormiga;
    private JTextField txtSexo;
    private JTextField txtProvincia;
    private JComboBox<String> comboGenoAlimento;
    private JComboBox<String> comboIngestaNativa;

    public PMEcuaFauna2K24A() {
        // Inicializar CCHormigaDAO
        CChormigaDAO = new CCHormigaDAO();

        // Configuración básica de la ventana
        setTitle("EcuaFauna 2K24A");
        setSize(550, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel para los datos del estudiante
        JPanel studentPanel = new JPanel(new GridLayout(2, 2, 5, 5)); 
        JPanel subPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        subPanel.setBorder(CCStyle.createBorderRect());  // Usar el borde personalizado
        subPanel.setBackground(new Color(220, 220, 220));

        // Agregar margen alrededor del panel para separar los componentes de los bordes
        studentPanel.setBorder(BorderFactory.createCompoundBorder(
            studentPanel.getBorder(), 
            BorderFactory.createEmptyBorder(30, 30, 10, 30)
        ));
        
        JLabel lblCedula = new JLabel("Cédula:");
        JTextField txtCedula = new JTextField("175271169 - 5");
        lblCedula.setFont(CCStyle.FONT_BOLD);  // Usar la fuente personalizada
        lblCedula.setForeground(CCStyle.COLOR_FONT);  // Cambiar el color de la fuente
        txtCedula.setFont(CCStyle.FONT);
        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField("Camila Daniela Caicedo Alcivar");
        lblNombre.setFont(CCStyle.FONT_BOLD);
        lblNombre.setForeground(CCStyle.COLOR_FONT);
        txtNombre.setFont(CCStyle.FONT);

        subPanel.add(lblCedula);
        subPanel.add(txtCedula);
        subPanel.add(lblNombre);
        subPanel.add(txtNombre);
        studentPanel.add(subPanel);

        // Panel para la sección central que contendrá el logo, botón, hormiguero virtual, y opciones de alimentación
        JPanel centralPanel = new JPanel();
        centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.Y_AXIS));

        // Panel para la sección del logo y el botón de crear hormiga
        JPanel logoAndButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
   
        // Logo
        JLabel lblLogo = new JLabel(new ImageIcon(CCStyle.URL_LOGO)); // Reemplaza con la ruta del logo
        logoAndButtonPanel.add(lblLogo);
   
        // Botón de crear hormiga
        JButton btnCrearHormiga = new JButton("Crear Hormiga Larva");
        btnCrearHormiga.setFont(CCStyle.FONT_BOLD);
        btnCrearHormiga.setForeground(CCStyle.COLOR_FONT);
        btnCrearHormiga.setCursor(CCStyle.CURSOR_HAND);  // Cambiar el cursor al pasar por encima del botón
        logoAndButtonPanel.add(btnCrearHormiga);
        
        // Añadir el panel del logo y botón al panel central
        centralPanel.add(logoAndButtonPanel);
   
        // Panel Hormiguero Virtual
        JPanel antPanel = new JPanel(new GridLayout(3, 2));
        antPanel.setBorder(BorderFactory.createTitledBorder("Hormiguero Virtual"));
   
        JLabel lblTipoHormiga = new JLabel("Tipo de Hormiga:");
        lblTipoHormiga.setFont(CCStyle.FONT_BOLD);
        lblTipoHormiga.setForeground(CCStyle.COLOR_FONT);
   
        txtTipoHormiga = new JTextField(20);
        txtTipoHormiga.setFont(CCStyle.FONT);
   
        JLabel lblSexo = new JLabel("Sexo:");
        lblSexo.setFont(CCStyle.FONT_BOLD);
        lblSexo.setForeground(CCStyle.COLOR_FONT);
   
        txtSexo = new JTextField(20);
        txtSexo.setFont(CCStyle.FONT);
   
        JLabel lblProvincia = new JLabel("Provincia:");
        lblProvincia.setFont(CCStyle.FONT_BOLD);
        lblProvincia.setForeground(CCStyle.COLOR_FONT);
   
        txtProvincia = new JTextField(20);
        txtProvincia.setFont(CCStyle.FONT);
   
        antPanel.add(lblTipoHormiga);
        antPanel.add(txtTipoHormiga);
        antPanel.add(lblSexo);
        antPanel.add(txtSexo);
        antPanel.add(lblProvincia);
        antPanel.add(txtProvincia);
        
        // Añadir el panel del hormiguero virtual al panel central
        centralPanel.add(antPanel);
   
        // Panel para las opciones de alimentación
        JPanel foodPanel = new JPanel(new GridLayout(2, 2));
        foodPanel.setBorder(BorderFactory.createTitledBorder("Opciones de Alimentación"));
   
        JLabel lblGenoAlimento = new JLabel("GenoAlimento:");
        lblGenoAlimento.setFont(CCStyle.FONT_BOLD);
        lblGenoAlimento.setForeground(CCStyle.COLOR_FONT);
   
        comboGenoAlimento = new JComboBox<>(new String[] {"X", "XX", "XY"});
        comboGenoAlimento.setFont(CCStyle.FONT);
   
        JLabel lblIngestaNativa = new JLabel("Ingesta Nativa:");
        lblIngestaNativa.setFont(CCStyle.FONT_BOLD);
        lblIngestaNativa.setForeground(CCStyle.COLOR_FONT);
   
        comboIngestaNativa = new JComboBox<>(new String[] {"Carnívoro", "Herbívoro", "Omnívoro", "Insectívoro"});
        comboIngestaNativa.setFont(CCStyle.FONT);
   
        foodPanel.add(lblGenoAlimento);
        foodPanel.add(comboGenoAlimento);
        foodPanel.add(lblIngestaNativa);
        foodPanel.add(comboIngestaNativa);
        
        // Añadir el panel de alimentación al panel central
        centralPanel.add(foodPanel);
   
        // Panel para botones de eliminar y guardar
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setFont(CCStyle.FONT_BOLD);
        btnEliminar.setForeground(CCStyle.COLOR_FONT);
        buttonPanel.add(btnEliminar);
   
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(CCStyle.FONT_BOLD);
        btnGuardar.setForeground(CCStyle.COLOR_FONT);
        buttonPanel.add(btnGuardar);
        
        // Agregar los paneles a la ventana
        add(studentPanel, BorderLayout.NORTH);
        add(centralPanel, BorderLayout.CENTER);  // Añadir el panel central al centro
        add(buttonPanel, BorderLayout.SOUTH);

        // Configurar los listeners
        setupListeners(btnCrearHormiga);

        // Mostrar la ventana
        setVisible(true);
    }

    private void setupListeners(JButton btnCrearHormiga) {
        btnCrearHormiga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipoHormiga = txtTipoHormiga.getText();
                String sexo = txtSexo.getText();
                String provincia = txtProvincia.getText();
                String genoAlimento = comboGenoAlimento.getSelectedItem().toString();
                String ingestaNativa = comboIngestaNativa.getSelectedItem().toString();

                CChormigaDAO.crearHormiga(tipoHormiga, sexo, provincia, genoAlimento, ingestaNativa);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PMEcuaFauna2K24A());
    }
}
*/
/* 
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import DataAccess.CCHormigaDAO;


public class PMEcuaFauna2K24A extends JFrame {

    private CCHormigaDAO hormigaDAO;
    private JTextField txtTipoHormiga, txtSexo, txtProvincia;
    private JComboBox<String> comboGenoAlimento, comboIngestaNativa;
    private JButton btnCrearHormiga;

    public PMEcuaFauna2K24A() {
        hormigaDAO = new CCHormigaDAO();

        // Configuración básica de la ventana
        setTitle("EcuaFauna 2K24A");
        setSize(550, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel para los datos del estudiante
        JPanel studentPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        JPanel subPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        subPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));  // Usar un borde básico
        subPanel.setBackground(new Color(220, 220, 220));

        // Agregar margen alrededor del panel para separar los componentes de los bordes
        studentPanel.setBorder(BorderFactory.createCompoundBorder(
            studentPanel.getBorder(), 
            BorderFactory.createEmptyBorder(30, 30, 10, 30)
        ));
        
        JLabel lblCedula = new JLabel("Cédula:");
        JTextField txtCedula = new JTextField("175271169 - 5");
        lblCedula.setFont(new Font("Arial", Font.BOLD, 12));  // Usar una fuente básica
        lblCedula.setForeground(Color.BLACK);  // Cambiar el color de la fuente
        txtCedula.setFont(new Font("Arial", Font.PLAIN, 12));
        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField("Camila Daniela Caicedo Alcivar");
        lblNombre.setFont(new Font("Arial", Font.BOLD, 12));
        lblNombre.setForeground(Color.BLACK);
        txtNombre.setFont(new Font("Arial", Font.PLAIN, 12));

        subPanel.add(lblCedula);
        subPanel.add(txtCedula);
        subPanel.add(lblNombre);
        subPanel.add(txtNombre);
        studentPanel.add(subPanel);

        // Panel para la sección central que contendrá el logo, botón, hormiguero virtual, y opciones de alimentación
        JPanel centralPanel = new JPanel();
        centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.Y_AXIS));

        // Panel para la sección del logo y el botón de crear hormiga
        JPanel logoAndButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
   
        // Logo
        JLabel lblLogo = new JLabel(new ImageIcon("path/to/logo.png")); // Reemplaza con la ruta del logo
        logoAndButtonPanel.add(lblLogo);
   
        // Botón de crear hormiga
        btnCrearHormiga = new JButton("Crear Hormiga Larva");
        btnCrearHormiga.setFont(new Font("Arial", Font.BOLD, 12));
        btnCrearHormiga.setForeground(Color.BLACK);
        btnCrearHormiga.setCursor(new Cursor(Cursor.HAND_CURSOR));  // Cambiar el cursor al pasar por encima del botón
        logoAndButtonPanel.add(btnCrearHormiga);
        
        // Añadir el panel del logo y botón al panel central
        centralPanel.add(logoAndButtonPanel);
   
        // Panel Hormiguero Virtual
        JPanel antPanel = new JPanel(new GridLayout(3, 2));
        antPanel.setBorder(BorderFactory.createTitledBorder("Hormiguero Virtual"));
   
        JLabel lblTipoHormiga = new JLabel("Tipo de Hormiga:");
        lblTipoHormiga.setFont(new Font("Arial", Font.BOLD, 12));
        lblTipoHormiga.setForeground(Color.BLACK);
   
        txtTipoHormiga = new JTextField(20);
        txtTipoHormiga.setFont(new Font("Arial", Font.PLAIN, 12));
   
        JLabel lblSexo = new JLabel("Sexo:");
        lblSexo.setFont(new Font("Arial", Font.BOLD, 12));
        lblSexo.setForeground(Color.BLACK);
   
        txtSexo = new JTextField(20);
        txtSexo.setFont(new Font("Arial", Font.PLAIN, 12));
   
        JLabel lblProvincia = new JLabel("Provincia:");
        lblProvincia.setFont(new Font("Arial", Font.BOLD, 12));
        lblProvincia.setForeground(Color.BLACK);
   
        txtProvincia = new JTextField(20);
        txtProvincia.setFont(new Font("Arial", Font.PLAIN, 12));
   
        antPanel.add(lblTipoHormiga);
        antPanel.add(txtTipoHormiga);
        antPanel.add(lblSexo);
        antPanel.add(txtSexo);
        antPanel.add(lblProvincia);
        antPanel.add(txtProvincia);
        
        // Añadir el panel del hormiguero virtual al panel central
        centralPanel.add(antPanel);
   
        // Panel para las opciones de alimentación
        JPanel foodPanel = new JPanel(new GridLayout(2, 2));
        foodPanel.setBorder(BorderFactory.createTitledBorder("Opciones de Alimentación"));
   
        JLabel lblGenoAlimento = new JLabel("GenoAlimento:");
        lblGenoAlimento.setFont(new Font("Arial", Font.BOLD, 12));
        lblGenoAlimento.setForeground(Color.BLACK);
   
        comboGenoAlimento = new JComboBox<>(new String[] {"X", "XX", "XY"});
        comboGenoAlimento.setFont(new Font("Arial", Font.PLAIN, 12));
   
        JLabel lblIngestaNativa = new JLabel("Ingesta Nativa:");
        lblIngestaNativa.setFont(new Font("Arial", Font.BOLD, 12));
        lblIngestaNativa.setForeground(Color.BLACK);
   
        comboIngestaNativa = new JComboBox<>(new String[] {"Carnívoro", "Herbívoro", "Omnívoro", "Insectívoro"});
        comboIngestaNativa.setFont(new Font("Arial", Font.PLAIN, 12));
   
        foodPanel.add(lblGenoAlimento);
        foodPanel.add(comboGenoAlimento);
        foodPanel.add(lblIngestaNativa);
        foodPanel.add(comboIngestaNativa);
        
        // Añadir el panel de alimentación al panel central
        centralPanel.add(foodPanel);
   
        // Panel para botones de eliminar y guardar
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setFont(new Font("Arial", Font.BOLD, 12));
        btnEliminar.setForeground(Color.BLACK);
        buttonPanel.add(btnEliminar);
   
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(new Font("Arial", Font.BOLD, 12));
        btnGuardar.setForeground(Color.BLACK);
        buttonPanel.add(btnGuardar);
        
        // Agregar los paneles a la ventana
        add(studentPanel, BorderLayout.NORTH);
        add(centralPanel, BorderLayout.CENTER);  // Añadir el panel central al centro
        add(buttonPanel, BorderLayout.SOUTH);

        // Configurar listeners
        setupListeners();

        // Mostrar la ventana
        setVisible(true);
    }

    // Métodos adicionales para configurar la GUI y otras funcionalidades
    private void setupListeners() {
        btnCrearHormiga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipoHormiga = txtTipoHormiga.getText();
                String sexo = txtSexo.getText();
                String provincia = txtProvincia.getText();
                String genoAlimento = comboGenoAlimento.getSelectedItem().toString();
                String ingestaNativa = comboIngestaNativa.getSelectedItem().toString();

                hormigaDAO.crearHormiga(tipoHormiga, sexo, provincia, genoAlimento, ingestaNativa);
            }
        });

        // Agregar más listeners para los demás botones si es necesario
    }

    public static void main(String[] args) {
        new PMEcuaFauna2K24A();
    }
}*/
