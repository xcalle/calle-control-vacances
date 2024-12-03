import javax.swing.*;
import java.time.LocalTime;

import eines.Eines;  // Importar la classe Eines del paquet eines.

// Aquesta classe representa la finestra que mostra la salutació personalitzada.
public class Resultat extends JFrame {

    public Resultat(String entradaNomUsuari, String entradaCognomUsuari, String departament, int entradaAntiguitat, String[] departaments) {
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
        int[][] diesVacances = {
                {6, 14, 20},
                {7, 15, 22},
                {10, 20, 30}
        };


        // Crear el missatge amb la salutació correcta i el nom de l'usuari.
        saludo = new JLabel(salutacio + entradaNomUsuari + " " + entradaCognomUsuari);

        for (int i = 0; i < departaments.length; i++) {
            if (departament == departaments[i]){
                for (int j = 0; j < diesVacances[i].length; j++) {
                    if (entradaAntiguitat == j+1){
                        dies = diesVacances[i][j];
                    }
                }

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


