// Aquesta és la classe principal que inicia el programa.
public class Main {
    public static void main(String[] args) {
        // Aquest bloc de codi s'executa dins del fil gràfic de Swing (interfície gràfica).
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Crea una instància de la classe Benvinguda, que obre la primera finestra.
                new Benvinguda();
            }
        });
    }
}
