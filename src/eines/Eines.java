package eines;

import java.time.LocalTime;

public class Eines {
    // Aquesta funció retorna la salutació adequada segons l'hora del dia.
    public static String obtenirSalutacio() {
        LocalTime horaActual = LocalTime.now();  // Obtenim l'hora actual.
        int hora = horaActual.getHour();  // Extraiem l'hora (0-23).

        if (hora >= 6 && hora < 12) {
            return "Bon dia ";  // Entre les 6:00 i les 11:59: "Bon dia".
        } else if (hora >= 12 && hora < 20) {
            return "Bona tarda ";  // Entre les 12:00 i les 19:59: "Bona tarda".
        } else {
            return "Bon nit ";  // Des de les 20:00 fins a les 5:59: "Bon nit".
        }
    }
}