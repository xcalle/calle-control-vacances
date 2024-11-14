import javax.swing.*;
import java.time.LocalTime;

import eines.Eines;  // Importar la classe Eines del paquet eines.

// Aquesta classe representa la finestra que mostra la salutació personalitzada.
public class Resultat extends JFrame {

    public Resultat(String entradaNomUsuari, String entradaCognomUsuari, String departament, int entradaAntiguitat) {
        // Configuració de la finestra
        setTitle("Resultat");
        setSize(300, 150);  // Defineix l'amplada i l'alçada de la finestra.
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Tanca només aquesta finestra, no tot el programa.
        setLocationRelativeTo(null);  // Centra la finestra a la pantalla.
        setLayout(null);
        // Obtenir la salutació correcta utilitzant el mètode de la classe Eines
        String salutacio = Eines.obtenirSalutacio();
        JLabel saludo;
        JLabel vacances;
        int dies = 0;


        // Crear el missatge amb la salutació correcta i el nom de l'usuari.
        saludo = new JLabel(salutacio + entradaNomUsuari + " " + entradaCognomUsuari);

        if (departament == "Atencion al cliente") {
            if (entradaAntiguitat == 1) {
                dies = 6;
            } else if (entradaAntiguitat == 2) {
                dies = 14;
            } else if (entradaAntiguitat == 3) {
                dies = 20;
            }
        } else if (departament == "Logistica") {
            if (entradaAntiguitat == 1) {
                dies = 10;
            } else if (entradaAntiguitat == 2) {
                dies = 20;
            } else if (entradaAntiguitat == 3) {
                dies = 20;

            }
        } else if (departament == "Gerencia") {
            if (entradaAntiguitat == 1) {
                dies = 10;
            } else if (entradaAntiguitat == 2) {
                dies = 20;
            } else if (entradaAntiguitat == 3) {
                dies = 20;
            }
        }
        vacances = new JLabel("Et pertanyen " + dies + " dies de vacances");

        saludo.setBounds(20, 20, 300, 30);
        vacances.setBounds(20, 40, 200, 30);
        add(saludo);
        add(vacances);
        // Mostrar la finestra.
        setVisible(true);
    }
}


