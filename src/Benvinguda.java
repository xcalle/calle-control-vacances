import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Benvinguda extends JFrame {
    public static final int AMPLADA = 575;
    public static final int ALSSADA = 400;
    public static final String TITOL_FINESTRA = "Benvingut";

    private JTextField jtfNomUsuari;
    private JTextField  jtfCognomEntrat;
    private JButton jbAccedir;
    private JLabel jlEtiquetaNomUsuari;
    private JLabel jltitol;
    private ImageIcon iiIcona;
    private JLabel jlLogo;
    private JLabel jlTitolApp;
    private JLabel jlNomEmpresa;
    private JLabel jlEtiquetaCognomUsuari;
    private JComboBox<String> jcdbdepertament;
    private JLabel jlEtiquetaDepertament;
    private JRadioButton radio1, radio2, radio3;
    private ButtonGroup bg;
    private JLabel jlEntiguitat;


    public Benvinguda() throws IOException {
        // Configuració de la finestra (títol, mida, etc.).
        setTitle(TITOL_FINESTRA);
        setSize(AMPLADA, ALSSADA);  // Defineix l'amplada i l'alçada de la finestra.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Quan es tanca la finestra, es tanca el programa.
        setLocationRelativeTo(null);  // Centra la finestra a la pantalla.
        // Desactivar el layout per defecte i utilitzar null layout
        setLayout(null);

        JLabel jlEtiquetaLogo=new JLabel();
        try {
            BufferedImage biImatgeLogo= ImageIO.read(new File("resources/logo.png"));
            ImageIcon iiIcona = new ImageIcon(biImatgeLogo);
            //JFrame jfMarc = new JFrame();
            jlEtiquetaLogo.setIcon(iiIcona);
            jlEtiquetaLogo.setBounds(0,-40,1000,150);
        } catch (IOException e){
            System.out.println(e.getMessage());
            System.exit(1);
        }





        // Crear els components gràfics (camp de text i botó).
        jlEtiquetaNomUsuari = new JLabel("nom:");
        jtfNomUsuari = new JTextField(20);
        jlEtiquetaCognomUsuari = new JLabel("cognom:");
        jtfCognomEntrat = new JTextField(20);
        jcdbdepertament = new JComboBox<String>();
        jcdbdepertament .addItem("Logistica");
        jcdbdepertament.addItem("Gerencia");
        jcdbdepertament.addItem("atencion al cliente");
        jlEtiquetaDepertament = new JLabel("Depertament");
        radio1=new JRadioButton("1 any");
        radio2=new JRadioButton("800*600");
        radio3=new JRadioButton("1024*768");




        jbAccedir = new JButton("Procesar");

        // Establir la posició i mida de cada component manualment amb coordenades
        jlEtiquetaNomUsuari.setBounds(200, 50, 50, 30);
        jtfNomUsuari.setBounds(250, 50, 150, 30);  // (x, y, width, height)
        jlEtiquetaCognomUsuari.setBounds(200,90,50,30);
        jtfCognomEntrat.setBounds(250,90,150,30);
        jcdbdepertament.setBounds(250,130,150,30);
        jlEtiquetaDepertament.setBounds(165,130,100,30);
        jbAccedir.setBounds(250, 270, 100, 30);
        radio1.setBounds(250,170,100,30);//
        radio2.setBounds(250,195,100,30);
        radio3.setBounds(250,220,100,30);

        // Per afegir els components a un panell (panell és una àrea que conté altres components).
        add(jlEtiquetaNomUsuari);
        add(jtfNomUsuari);
        add(jlEtiquetaCognomUsuari);
        add(jtfCognomEntrat);
        add(jbAccedir);
        add(jcdbdepertament);
        add(jlEtiquetaLogo);
        add(jlEtiquetaDepertament);
        add(jbAccedir);
        add(radio1);
        add(radio2);
        add(radio3);

        // Per afegir funcionalitat al botó: què passa quan l'usuari fa clic?
        jbAccedir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtenir el text que ha introduït l'usuari al camp de text.
                String entradaNomUsuari = jtfNomUsuari.getText();
                if (!entradaNomUsuari.isEmpty()) {
                    // Si l'usuari ha introduït un nom, obrir la finestra "Resultat" amb aquest nom.
                    new Resultat(entradaNomUsuari);
                } else {
                    // Si el camp de text és buit, mostrar un missatge d'error.
                    JOptionPane.showMessageDialog(Benvinguda.this,
                            "Si us plau, cal que introdueixis una cadena.");
                }
            }
        });

        // Mostrar la finestra.
        setVisible(true);
    }
}