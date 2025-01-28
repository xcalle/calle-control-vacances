import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.io.FileWriter;
import java.io.BufferedWriter;

public class Arxius {



//Java program illustrating use of write(int arg) method


        public static void exmepleEscriure(String nomFitxer, String textAEscriure)
        {
            //initializing FileWriter
            FileWriter geek_file;
            try
            {

                // Initializing BufferedWriter
                BufferedWriter geekwrite = new BufferedWriter( new FileWriter(nomFitxer));
                System.out.println("Buffered Writer start writing :)");

                geekwrite.write(textAEscriure);



                // Closing BufferWriter to end operation
                geekwrite.close();
                System.out.println("Written successfully");
            }
            catch (IOException except)
            {
                except.printStackTrace();
            }

        }


    private static void mostraFilesFitxerCSV(String rutaFitxer) throws IOException {
        BufferedReader canalLlegir = new BufferedReader(new FileReader(rutaFitxer));
        String filaLlegida;
        filaLlegida = canalLlegir.readLine();
        // Atès que la funció readLine() torna null
        // quan en llegir obté un caràcter EOF (EndOfFile)
        // podem dir que si després de la primera lectura
        // filaLlegida == null, el fitxer és buit!
        if(filaLlegida == null){
            System.out.println("El fitxer és buit!");
        }
        // Atès que la funció readLine() torna null
        // quan en llegir obté un caràcter EOF (EndOfFile)
        // si la primera lectura no és null
        // (filaLlegida!=null) significa que hem llegit
        // una fila del fitxer.
        while (filaLlegida!= null) {
            // Mostrem per consola el contingut
            // de la fila llegida.
            System.out.println(filaLlegida);
            // Cal tornar a llegir el fitxer
            // per obtenir la següent fila.
            filaLlegida = canalLlegir.readLine();
        }
        canalLlegir.close();
    }

    public static void main(String[] args) {
        // Obtenim la ruta del fitxer a llegir
        String nomFitxer = "resources/nomsDepartaments.csv";
        String nomFitxer2 = "resources/control.csv";


        Arxius.exmepleEscriure(nomFitxer2, "hola");


//        try {
//            mostraFilesFitxerCSV(nomFitxer);
//        } catch (IOException e) {
//            System.out.println("ERROR a l'hora de llegir el fitxer!");
//            throw new RuntimeException(e);
//        }
    }
}
