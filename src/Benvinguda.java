import javax.swing.*;
import java.awt.event.*;

// Aquesta classe representa la finestra de "Benvinguda" on l'usuari pot introduir el seu nom.
public class Benvinguda extends JFrame {
    public static final int AMPLADA = 475;
    public static final int ALSSADA = 200;
    public static final String TITOL_FINESTRA = "Benvinguda";
    private JTextField jtfNomUsuari;    // Camp de text on l'usuari escriurà el seu nom.
    private JButton jbEnviar;           // Botó per enviar la informació.
    private JLabel jlEtiquetaNomUsuari; // Etiqueta per mostrar el text que cal entrar al camp.

    public Benvinguda() {
        // Configuració de la finestra (títol, mida, etc.).
        setTitle(TITOL_FINESTRA);
        setSize(AMPLADA, ALSSADA);  // Defineix l'amplada i l'alçada de la finestra.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Quan es tanca la finestra, es tanca el programa.
        setLocationRelativeTo(null);  // Centra la finestra a la pantalla.
        // Desactivar el layout per defecte i utilitzar null layout
        setLayout(null);

        // Crear els components gràfics (camp de text i botó).
        jlEtiquetaNomUsuari = new JLabel("Introdueix el teu nom:");
        jtfNomUsuari = new JTextField(20);
        jbEnviar = new JButton("Enviar");

        // Establir la posició i mida de cada component manualment amb coordenades
        jlEtiquetaNomUsuari.setBounds(50, 50, 200, 30);
        jtfNomUsuari.setBounds(250, 50, 150, 30);  // (x, y, width, height)
        jbEnviar.setBounds(150, 100, 100, 30);    // Posició i mida del botó

        // Per afegir els components a un panell (panell és una àrea que conté altres components).
        add(jlEtiquetaNomUsuari);
        add(jtfNomUsuari);
        add(jbEnviar);

        // Per afegir funcionalitat al botó: què passa quan l'usuari fa clic?
        jbEnviar.addActionListener(new ActionListener() {
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