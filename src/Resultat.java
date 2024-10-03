import javax.swing.*;
import java.time.LocalTime;

import eines.Eines;  // Importar la classe Eines del paquet eines.

// Aquesta classe representa la finestra que mostra la salutació personalitzada.
public class Resultat extends JFrame {

    public Resultat(String text) {
        // Configuració de la finestra
        setTitle("Resultat");
        setSize(300, 150);  // Defineix l'amplada i l'alçada de la finestra.
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Tanca només aquesta finestra, no tot el programa.
        setLocationRelativeTo(null);  // Centra la finestra a la pantalla.

        // Obtenir la salutació correcta utilitzant el mètode de la classe Eines
        String salutacio = Eines.obtenirSalutacio();

        // Crear el missatge amb la salutació correcta i el nom de l'usuari.
        JLabel label = new JLabel(salutacio + text, SwingConstants.CENTER);  // Col·locar el text centrat.

        // Per afegir el missatge a la finestra.
        add(label);

        // Mostrar la finestra.
        setVisible(true);
    }
}
