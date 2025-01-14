import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Benvinguda extends JFrame {
    public static final int AMPLADA = 575;
    public static final int ALSSADA = 400;
    public static final String TITOL_FINESTRA = "Benvingut";

    private String[][] diesVacances;
    private JTextField jtfNomUsuari;
    private JTextField jtfCognomEntrat;
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
    private String[] nomsDepartaments = {"Logistica", "Gerencia", "Atencion al cliente"};

    private static int comptarLinies(String rutaFitxer) throws IOException {
        BufferedReader canalLlegir = new BufferedReader(new FileReader(rutaFitxer));
        String filaLlegida;
        int lineaLlegida = 0;

        filaLlegida = canalLlegir.readLine();
        if (filaLlegida == null) {
            System.out.println("El fitxer és buit!");
        }
        while (filaLlegida != null) {
            lineaLlegida++;
            filaLlegida = canalLlegir.readLine();
        }
        return lineaLlegida;
    }

    private static String[] llegirFitxerCSV(String rutaFitxer) throws IOException {
        BufferedReader canalLlegir = new BufferedReader(new FileReader(rutaFitxer));
        String filaLlegida;
        int midaVector = comptarLinies(rutaFitxer);
        int liniaLlegida = 0;
        String[] filaTallada;
        String[] departaments = new String[midaVector];
        filaLlegida = canalLlegir.readLine();
        // Atès que la funció readLine() torna null
        // quan en llegir obté un caràcter EOF (EndOfFile)
        // podem dir que si després de la primera lectura
        // filaLlegida == null, el fitxer és buit!
        if (filaLlegida == null) {
            System.out.println("El fitxer és buit!");
        }
        // Atès que la funció readLine() torna null
        // quan en llegir obté un caràcter EOF (EndOfFile)
        // si la primera lectura no és null
        // (filaLlegida!=null) significa que hem llegit
        // una fila del fitxer.
        while (filaLlegida != null) {
            filaTallada = filaLlegida.split(",");
            // Mostrem per consola el contingut
            // de la fila llegida.
            departaments[liniaLlegida] = filaTallada[0];
            liniaLlegida++;
            // Cal tornar a llegir el fitxer
            // per obtenir la següent fila.
            filaLlegida = canalLlegir.readLine();
        }
        return departaments;
    }


    private static String[][] llegirFitxerCSV2(String rutaFitxer) throws IOException {
        int midaVector = comptarLinies(rutaFitxer);
        BufferedReader canalLlegir = new BufferedReader(new FileReader(rutaFitxer));
        String filaLlegida;
        String[] filaTallada;
        int lineaLlegida = 0;
        String[][] diesVacances = new String[midaVector][3];
        filaLlegida = canalLlegir.readLine();
        // Atès que la funció readLine() torna null
        // quan en llegir obté un caràcter EOF (EndOfFile)
        // podem dir que si després de la primera lectura
        // filaLlegida == null, el fitxer és buit!
        if (filaLlegida == null) {
            System.out.println("El fitxer és buit!");
        }
        // Atès que la funció readLine() torna null
        // quan en llegir obté un caràcter EOF (EndOfFile)
        // si la primera lectura no és null
        // (filaLlegida!=null) significa que hem llegit
        // una fila del fitxer.
        while (filaLlegida != null) {
            // Mostrem per consola el contingut
            // de la fila llegida.
            filaTallada = filaLlegida.split(",");

            diesVacances[lineaLlegida][0] = filaTallada[1];
            diesVacances[lineaLlegida][1] = filaTallada[2];
            diesVacances[lineaLlegida][2] = filaTallada[3];
            lineaLlegida++;
            // Cal tornar a llegir el fitxer
            // per obtenir la següent fila.
            filaLlegida = canalLlegir.readLine();
        }
        return diesVacances;
    }






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
        nomsDepartaments = llegirFitxerCSV("resources/nomsDepartaments.csv");
        diesVacances = llegirFitxerCSV2("resources/nomsDepartaments.csv");


        jcdbdepertament = new JComboBox<String>(nomsDepartaments);
//        jcdbdepertament .addItem("Logistica");
//        jcdbdepertament.addItem("Gerencia");
//        jcdbdepertament.addItem("atencion al cliente");
        jlEtiquetaDepertament = new JLabel("Depertament");
        bg = new ButtonGroup();
        radio1=new JRadioButton("1 any");
        radio2=new JRadioButton("2 anys-6 anys");
        radio3=new JRadioButton("7 anys o +");






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
        bg.add(radio1);
        bg.add(radio2);
        bg.add(radio3);
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
                // System.out.println("a");
                String entradaNomUsuari = jtfNomUsuari.getText();
                String entradaCognomUsuari = jtfCognomEntrat.getText();
                String entradaDepetament = jcdbdepertament.getSelectedItem().toString();

                int entradaAntiguitat;
                if (radio1.isSelected()){
                    entradaAntiguitat = 1;
                } else if (radio2.isSelected()) {
                    entradaAntiguitat = 2;
                } else if (radio3.isSelected()){
                    entradaAntiguitat = 3;
                } else {
                    entradaAntiguitat = 0;
                }


                if (!entradaNomUsuari.isEmpty() && !entradaCognomUsuari.isEmpty() && entradaAntiguitat != 0){
                    // Si l'usuari ha introduït un nom, obrir la finestra "Resultat" amb aquest nom.
                    new Resultat(entradaNomUsuari, entradaCognomUsuari, entradaDepetament, entradaAntiguitat, nomsDepartaments, diesVacances);
                } else {
                    // Si el camp de text és buit, mostrar un missatge d'error.
                    JOptionPane.showMessageDialog(Benvinguda.this,
                            "Si us plau, cal que introdueixis tots els camps");
                }
            }
        });

        // Mostrar la finestra.
        setVisible(true);
    }
}