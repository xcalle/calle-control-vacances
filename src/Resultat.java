import javax.swing.*;
import java.io.*;
import java.time.LocalTime;

import eines.Eines;  // Importar la classe Eines del paquet eines.

// Aquesta classe representa la finestra que mostra la salutació personalitzada.
public class Resultat extends JFrame {
    private void guardarConsulta(String rutaFitxer, String nom, String cognom, String departament, int antiguitat, String dies){
        try
        {
            BufferedWriter canalEscriure = new BufferedWriter(new FileWriter(rutaFitxer,true));
            canalEscriure.write(nom+","+cognom+","+departament+","+antiguitat+","+dies+"\r\n");
            canalEscriure.close();
        }
        catch (IOException except)
        {
            except.printStackTrace();
        }

    }
    public Resultat(String entradaNomUsuari, String entradaCognomUsuari, String departament, int entradaAntiguitat, String[] departaments, String[][] diesVacancesFitxer){
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
        String dies = "";
        String[][] diesVacances = diesVacancesFitxer;





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
        guardarConsulta("resources/consulta.csv", entradaNomUsuari, entradaCognomUsuari, departament, entradaAntiguitat, dies);


        saludo.setBounds(20, 20, 300, 30);
        vacances.setBounds(20, 40, 200, 30);
        add(saludo);
        add(vacances);
        // Mostrar la finestra.
        setVisible(true);
    }
}

